package com.theaty.xiaoyuan.ui.lucky.acftivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.theaty.xiaoyuan.R;

import foundation.base.activity.BaseActivity;

/**
 * Created by fu on 2018/12/18.
 */

public class CreateGoodsActivity extends BaseActivity {

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_search);
    }

    public static void into(Context context) {
        Intent starter = new Intent(context, CreateGoodsActivity.class);
        context.startActivity(starter);
    }
}
