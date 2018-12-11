package com.theaty.xiaoyuan.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.ui.home.HomeFragment;
import com.theaty.xiaoyuan.ui.lucky.LuckyFragment;
import com.theaty.xiaoyuan.ui.mine.MineFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import foundation.base.activity.BaseFragmentActivity;
import foundation.base.fragment.BaseFragment;
import foundation.util.DoubleClickExitUtils;

public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.tabRL0)
    LinearLayout tabRL0;
    @BindView(R.id.tabRL1)
    LinearLayout tabRL1;
    @BindView(R.id.tabRL2)
    LinearLayout tabRL2;
    @BindView(R.id.contentFL)
    FrameLayout contentFL;

    @BindView(R.id.iv_0)
    ImageView iv_0;
    @BindView(R.id.iv_1)
    ImageView iv_1;
    @BindView(R.id.iv_2)
    ImageView iv_2;

    @BindView(R.id.bottomLl)
    LinearLayout bottomLl;

    public ArrayList<Class<? extends BaseFragment>> fragments;
    private DoubleClickExitUtils duClickExitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duClickExitHelper = new DoubleClickExitUtils(this);
    }

    @Override
    protected int containerViewId() {
        return R.id.contentFL;
    }

    @Override
    protected ArrayList<Class<? extends BaseFragment>> fragmentClasses() {
        fragments = new ArrayList<>();
        fragments.add(HomeFragment.class);
        fragments.add(LuckyFragment.class);
        fragments.add(MineFragment.class);

        return fragments;
    }

    public static void into(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    public void enableTabItem(int position) {
        if (0 > position || 3 < position)
            return;

        iv_0.setEnabled(false);
        iv_1.setEnabled(false);
        iv_2.setEnabled(false);

        switch (position) {
            case 0:

                iv_0.setEnabled(true);
                iv_0.setImageResource(R.mipmap.icon_home);
                iv_1.setImageResource(R.mipmap.icon_course1);
                iv_2.setImageResource(R.mipmap.icon_me1);
//                StatusUtil.setSystemStatus(this, true, false);
                break;

            case 1:
                iv_1.setEnabled(true);
                iv_0.setImageResource(R.mipmap.icon_home1);
                iv_1.setImageResource(R.mipmap.icon_course);
                iv_2.setImageResource(R.mipmap.icon_me1);
//                StatusUtil.setSystemStatus(this, true, true);
                break;

            case 2:
                iv_2.setEnabled(true);
                iv_0.setImageResource(R.mipmap.icon_home1);
                iv_1.setImageResource(R.mipmap.icon_course1);
                iv_2.setImageResource(R.mipmap.icon_me);
//                StatusUtil.setSystemStatus(this, true, true);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return duClickExitHelper.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.tabRL0, R.id.tabRL1, R.id.tabRL2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tabRL0:
                enableTabItem(0);
                selectPage(0);
                break;

            case R.id.tabRL1:
                enableTabItem(1);
                selectPage(1);
                break;

            case R.id.tabRL2:
                enableTabItem(2);
                selectPage(2);
                break;
        }
    }
}
