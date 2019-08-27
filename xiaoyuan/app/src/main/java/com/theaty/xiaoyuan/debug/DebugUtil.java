package com.theaty.xiaoyuan.debug;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.lidroid.xutils.http.client.HttpRequest;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.system.AppContext;
import com.theaty.xiaoyuan.system.DatasStore;

import app.AppManager;
import foundation.toast.ToastUtil;

/**
 * Created by Administrator on 2017/9/17.
 */

public class DebugUtil {

    public static final int isShowBottn = 2;//1.显示2.不显示
    public static HttpRequest.HttpMethod method1;
    public static String params1 ="";
    public static String url1 ="";
    public static WindowManager windowManager = null;
    public static WindowManager.LayoutParams windowManagerParams = null;
    public static FloatView floatView = null;
    private static String debugInfo = "";
    private static DebugUtil debugUtil;
    private DebugUtil(){}

    static {
        windowManager = (WindowManager) AppContext.getInstance().getSystemService(Context.WINDOW_SERVICE);
        // 设置LayoutParams(全局变量）相关参数
        windowManagerParams = (AppContext.getInstance()).getWindowParams();

        windowManagerParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 设置window type
        windowManagerParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        // 设置Window flag
        windowManagerParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
    }


    public static DebugUtil getIntance(){
        if (debugUtil == null) {
            debugUtil = new DebugUtil();
        }

        return debugUtil;

    }


    //拼接json
    public void getInfo(String resultString,int isshow) {

//        DebugModel.getInstance().url = url1;
//        DebugModel.getInstance().paras = params1;
//        DebugModel.getInstance().result = resultString;
//        DebugModel debugModel =  DebugModel.getInstance();
//        debugInfo = (ThtGosn.genGson()).toJson(DebugModel.getInstance());

        debugInfo = "{\"url\":\"" + url1 + "\",\"paras\":" + params1+ ",\"result\":" + resultString+"}";
       // ToastUtil.showToast(DatasStore.getDebugState()+"");
        showWebDebugInfo(isshow,debugInfo);
    }

    public  void showWebDebugInfo(int isShow,String data) {
        final Debugdialog debugdialog = new Debugdialog(AppManager.getAppManager().currentActivity(),data);
        if (DatasStore.getDebugState() == 1) {

            debugdialog.setNoOnclickListener(new Debugdialog.onNoOnclickListener() {
                @Override
                public void onNoClick() {
                    debugdialog.dismiss();
                }
            });
            debugdialog.show();
        } else {
            debugdialog.dismiss();
        }

    }
    public FloatView  createView() {
//        floatView =  FloatView.getIntance();

        floatView.setImageResource(R.mipmap.ic_launcher); // 这里简单的用自带的icon来做演示
        // 获取WindowManager
  /*
		 * 注意，flag的值可以为：
		 * 下面的flags属性的效果形同“锁定”。
		 * 悬浮窗不可触摸，不接受任何事件,同时不影响后面的事件响应。
		 * LayoutParams.FLAG_NOT_TOUCH_MODAL 不影响后面的事件
		 * LayoutParams.FLAG_NOT_FOCUSABLE  不可聚焦
		 * LayoutParams.FLAG_NOT_TOUCHABLE 不可触摸
		 */
        // 调整悬浮窗口至左上角，便于调整坐标
        windowManagerParams.gravity = Gravity.LEFT | Gravity.TOP;
        // 以屏幕左上角为原点，设置x、y初始值
        windowManagerParams.x = 0;
        windowManagerParams.y = 0;
        // 设置悬浮窗口长宽数据
        windowManagerParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        windowManagerParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 显示myFloatView图像
        windowManager.addView(floatView, windowManagerParams);
        floatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( DatasStore.getDebugState()==1) {
                    DatasStore.saveDebugState(2);
                    ToastUtil.showToast("debug关闭"+ DatasStore.getDebugState());
                }else {
                    DatasStore.saveDebugState(1);
                    ToastUtil.showToast("debug开启"+ DatasStore.getDebugState());
                }


            }
        });
        return floatView;
    }


//    /**
//     * 利用MD5进行加密
//     * 　　* @param str  待加密的字符串
//     * 　　* @return  加密后的字符串
//     * 　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
//     * 　　 * @throws UnsupportedEncodingException
//     */
//    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
////确定计算方法
//        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        BASE64Encoder base64en = new BASE64Encoder();
////加密后的字符串
//        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
//        return newstr;
//    }

}
