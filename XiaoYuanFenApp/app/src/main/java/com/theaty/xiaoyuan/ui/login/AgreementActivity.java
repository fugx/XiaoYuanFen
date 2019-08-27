package com.theaty.xiaoyuan.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.theaty.xiaoyuan.R;

import butterknife.BindView;
import butterknife.OnClick;
import foundation.base.activity.BaseActivity;

/**
 * Created by Yecal on 2018/7/13.
 */

public class AgreementActivity extends BaseActivity {

    @BindView(R.id.agreement)
    TextView agreement;

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_agreement);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        agreement.setText("");
    }

    @OnClick({R.id.xy_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xy_back:
                finish();
                break;
        }
    }
}
