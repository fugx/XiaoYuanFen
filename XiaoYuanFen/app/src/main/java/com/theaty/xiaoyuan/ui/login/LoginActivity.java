package com.theaty.xiaoyuan.ui.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;

import app.AppManager;
import butterknife.BindView;
import butterknife.OnClick;
import foundation.LoadingHandler;
import foundation.base.activity.BaseActivity;
import foundation.toast.ToastUtil;
import foundation.util.PhoneUtils;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.back_login)
    LinearLayout back;
    @BindView(R.id.code)
    LinearLayout code;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.check_code)
    TextView checkCode;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.mobile_login)
    TextView mobileLogin;
    @BindView(R.id.get_code)
    TextView getCode;

    private boolean codeLogin = false;
    private LoadingHandler loadingHandler;
//    private String verifyCode;
    private TimeCount timeCount;

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.setStatusBarColor(this, Color.WHITE);
        loadingHandler = new LoadingHandler(this);

        AppManager.getAppManager().addActivity(this);
        AppManager.getAppManager().addMemory(this);
    }


    @OnClick({R.id.register, R.id.forget_password, R.id.login, R.id.back_login,R.id.get_code,R.id.mobile_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:
                RegisterActivity.into(this);
                break;

            case R.id.forget_password:
                ForgetPassActivity.into(this,"忘记密码");
                break;

            case R.id.login:
                if(codeLogin){
                    if (TextUtils.isEmpty(loginPhone.getText().toString().trim()) || TextUtils.isEmpty(checkCode.getText().toString().trim())) {
                        ToastUtil.showToast("手机号、验证码不能为空");
                        return;
                    } else if (!PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                        ToastUtil.showToast("请输入正确手机号");
                        return;
                    } else {
                        checkCodeAndLogin();
                    }
                }else{
                    if (TextUtils.isEmpty(loginPhone.getText().toString().trim()) || TextUtils.isEmpty(loginPassword.getText().toString().trim())) {
                        ToastUtil.showToast("手机号、密码不能为空");
                        return;
                    } else if (!PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                        ToastUtil.showToast("请输入正确手机号");
                        return;
                    } else {
                        postLoginData();
                    }
                }
                break;

            case R.id.get_code:
                if (TextUtils.isEmpty(loginPhone.getText().toString().trim()) ){
                    ToastUtil.showToast("手机号不能为空");
                    return;
                }else if( !PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                    ToastUtil.showToast("手机号格式不符");
                    return;
                }
                getCode.setClickable(false);
                getVerificationCode();
                checkCode.requestFocus();
                checkCode.setFocusable(true);
                break;

            case R.id.mobile_login:
                codeLogin = true;
                loginPhone.setText("");
                loginPassword.setText("");
                back.setVisibility(View.VISIBLE);
                code.setVisibility(View.VISIBLE);
                loginText.setVisibility(View.GONE);
                loginPassword.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                forgetPassword.setVisibility(View.GONE);
                mobileLogin.setVisibility(View.GONE);
                break;

            case R.id.back_login:
                codeLogin = false;
                loginPhone.setText("");
                checkCode.setText("");
                back.setVisibility(View.GONE);
                code.setVisibility(View.GONE);
                loginText.setVisibility(View.VISIBLE);
                loginPassword.setVisibility(View.VISIBLE);
                register.setVisibility(View.VISIBLE);
                forgetPassword.setVisibility(View.VISIBLE);
                mobileLogin.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void postLoginData() {
        new MemberModel().Login(loginPhone.getText().toString().trim(), loginPassword.getText().toString().trim(),"1", new BaseModel.BaseModelIB() {
                @Override
                public void StartOp() {
                    loadingHandler.showLoading();
                }

                @Override
                public void successful(Object o) {
                    loadingHandler.hideLoading();
                    DatasStore.saveUserPhone(loginPhone.getText().toString().trim());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }

                @Override
                public void failed(ResultsModel resultsModel) {
                    ToastUtil.showToast(resultsModel.getErrorMsg());
                    loadingHandler.hideLoading();
                }
            });
    }

    private void checkCodeAndLogin() {
        new MemberModel().index_phone(loginPhone.getText().toString().trim(),checkCode.getText().toString().trim(), "1", new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {
                showLoading();
            }

            @Override
            public void successful(Object o) {
                hideLoading();
                DatasStore.saveUserPhone(loginPhone.getText().toString().trim());
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void failed(ResultsModel resultsModel) {
                ToastUtil.showToast(resultsModel.getErrorMsg());
                hideLoading();
            }
        });
    }

    /**
     * 获取验证码
     */
    public void getVerificationCode() {
        new MemberModel().identifycode(loginPhone.getText().toString().trim(), new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {
                showLoading();
            }

            @Override
            public void successful(Object o) {
                getCode.setText("60s");
                hideLoading();
//                verifyCode = (String) o;
                ToastUtil.showToast("发送成功");
                //完成验证码请求，验证码按钮控件开始计时
                timeCount = new TimeCount(60000, 1000);
                timeCount.start();// 开始计时
            }

            @Override
            public void failed(ResultsModel resultsModel) {
                ToastUtil.showToast(resultsModel.getErrorMsg());
                hideLoading();
                getCode.setClickable(true);
                getCode.setText("获取验证码");
            }
        });
    }

    public static void into(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }

    public class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {// 计时完毕
            getCode.setText("获取验证码");
            getCode.setClickable(true);
            getCode.setBackground(getResources().getDrawable(R.drawable.button_sure_bg_half_circle));
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程
            getCode.setClickable(false);//防止重复点击
            getCode.setText(millisUntilFinished / 1000 + "s");
            getCode.setBackground(getResources().getDrawable(R.drawable.button_sure_bg_half_circle));
        }
    }
}
