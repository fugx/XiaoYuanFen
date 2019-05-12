package com.theaty.xiaoyuan.debug;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.system.AppContext;
import com.theaty.xiaoyuan.system.DatasStore;

import java.util.Timer;
import java.util.TimerTask;

import foundation.toast.ToastUtil;
import foundation.util.AppUtils;
import foundation.util.ScreenUtils;

public class DebugService extends Service {

    private WindowManager windowManager;
    private ViewGroup mControlWindow;
    private Timer mTimer;
    private android.os.Handler mHandler;
    private WindowManager.LayoutParams layoutParams;
    private ImageButton imageButton;
    float oldX, oldY,moveX,moveY;
    float finalX, finalY;

    public DebugService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler = new android.os.Handler(Looper.getMainLooper());
        if (mTimer == null) {
            mTimer = new Timer();
            mTimer.scheduleAtFixedRate(new RefreshControlWindow(), 0, 1000);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void addWindow() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        if (mControlWindow == null) {

            mControlWindow = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.debug_window, new FrameLayout(this));
            imageButton = (ImageButton) mControlWindow.findViewById(R.id.design_image);
            if (DatasStore.getDebugState() == 1) {
                imageButton.setSelected(true);
            } else {
                imageButton.setSelected(false);
            }
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (DatasStore.getDebugState() == 1) {
                        DatasStore.saveDebugState(2);
                        ToastUtil.showToast("debug关闭" + DatasStore.getDebugState());
                        mControlWindow.findViewById(R.id.design_image).setSelected(false);
                    } else {
                        DatasStore.saveDebugState(1);
                        ToastUtil.showToast("debug开启" + DatasStore.getDebugState());
                        mControlWindow.findViewById(R.id.design_image).setSelected(true);
                    }

                }
            });

            initLayoutParam();

            mControlWindow.setLayoutParams(layoutParams);
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    windowManager.addView(mControlWindow, layoutParams);
                }
            });

            imageButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            oldX = motionEvent.getRawX();
                            oldY = motionEvent.getRawY();
                            moveX = motionEvent.getRawX();
                            moveY = motionEvent.getRawY();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            //每次移动的距离
                            float distanceX = motionEvent.getRawX() - oldX;
                            float distanceY = motionEvent.getRawY() - oldY;

                            //控件将要移动到的位置,先计算一下,不在ofFloat()方法中再计算是因为要防止控件移动到容器之外.
                            float nextX = view.getX() + distanceX;
                            float nextY = view.getY() + distanceY;

                            doMoveUpdateView(nextX,nextY);
                            //移动完之后记录当前坐标
                            oldX = motionEvent.getRawX();
                            oldY = motionEvent.getRawY();

                            break;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:

                            int tempDX = (int) (motionEvent.getRawX() - moveX);
                            int tempDY = (int) (motionEvent.getRawY() - moveY);


                            if (Math.abs(tempDX) < 6 && Math.abs(tempDY) < 6) {
                                return false;// 距离较小，当作click事件来处理
                            }
                            return true;
                    }
                    return false;
                }
            });
        }
    }

    private void doMoveUpdateView(float nextX, float nextY) {
        finalX = finalX +nextX;//记录下最终位置，下次移动距离直接加上
        finalY = finalY +nextY;
        layoutParams.x = (int) (finalX);
        layoutParams.y = (int) (finalY);
        mControlWindow.post(new Runnable() {
            @Override
            public void run() {
                windowManager.updateViewLayout(mControlWindow, layoutParams);
            }
        });
    }


    private void initLayoutParam() {
        layoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4以下toast类型无法获取交互事件，7.1.1以上toast类型会崩溃

            if (Build.VERSION.SDK_INT > 24) {
                layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            } else {
                layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            }
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }

        layoutParams.format = PixelFormat.RGBA_8888;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        //layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        layoutParams.x = ScreenUtils.getScreenWidth(AppContext.getInstance()) - ScreenUtils.dip2px(8);
        layoutParams.y = ScreenUtils.getScreenHeight(AppContext.getInstance()) / 2;
      
        finalX = layoutParams.x;
        finalY = layoutParams.y;
    }

    private void removeWindow() {
        if (mControlWindow != null) {
            windowManager.removeView(mControlWindow);
            mControlWindow = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mTimer!=null){
            mTimer.cancel();
            mTimer = null;
        }
        removeWindow();
    }

    private class RefreshControlWindow extends TimerTask {
        @Override
        public void run() {
            if (!AppUtils.isApplicationInBackground(getApplicationContext())) {
                addWindow();
            } else {
                removeWindow();
            }
        }
    }
}

