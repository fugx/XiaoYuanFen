package com.theaty.xiaoyuan.ui.welcome;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;

import foundation.base.activity.BaseActivity;


public class SplashActivity extends BaseActivity {

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_splash);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        startWelcome();
    }

    private void startWelcome() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (DatasStore.isFirstLaunch()) {
                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                    finish();
                }else {
                    DatasStore.setFirstUpdate(true);
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                }

        }).start();
    }







}
