package com.theaty.xiaoyuan.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;
import foundation.base.activity.BaseActivity;
import foundation.base.activity.BaseWebViewActivity;
import foundation.toast.ToastUtil;
import foundation.util.PhoneUtils;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.zc_back)
    LinearLayout back;
    @BindView(R.id.zc_back2)
    LinearLayout back2;
    @BindView(R.id.zc_login_phone)
    EditText loginPhone;
    @BindView(R.id.zc_login_password)
    EditText loginPassword;
    @BindView(R.id.zc_confirm_password)
    EditText confirmPassword;
    @BindView(R.id.zc_check_code)
    EditText checkCode;
    @BindView(R.id.zc_code)
    LinearLayout zcCode;
    @BindView(R.id.agreement)
    LinearLayout agreement;
    @BindView(R.id.zc_get_code)
    TextView getCode;
    @BindView(R.id.agreement_button)
    LinearLayout agreementButton;
    @BindView(R.id.zc_next)
    Button next;
    @BindView(R.id.zc_done)
    Button done;
    @BindView(R.id.select_button)
    ImageView select;

//    private String verifyCode;
    private boolean readAgreement = false;
    private CountDownTimer timer;
    private boolean isAgreementProtocol = true;//默认同意协议

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_register);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 验证输入的密码是否合格 数字字母非空符号 6-16
     *
     * @param pass
     * @return
     */
    boolean verifyPassWord(String pass) {
        String reg = "[^\\u4e00-\\u9fa5\\s]{6,16}";
        //String reg = "^[\\d\\w][^\\s]{5,16}$";
        return pass.matches(reg);
    }

    public static void into(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }


    @OnClick({R.id.zc_back,R.id.zc_back2,R.id.zc_get_code,R.id.agreement_button,R.id.zc_agreement,R.id.zc_next,R.id.zc_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zc_back:
                finish();
                break;

            case R.id.zc_get_code:
                if (PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                    getVerificationCode();
                    getCode.setClickable(false);
                    checkCode.requestFocus();
                    checkCode.setFocusable(true);
                } else if (TextUtils.isEmpty(loginPhone.getText().toString().trim())) {
                    ToastUtil.showToast("手机号不能为空");
                    return;
                } else {
                    ToastUtil.showToast("手机号格式错误");
                    return;
                }
                break;

            case R.id.agreement_button:
                if(readAgreement){
                    select.setVisibility(View.GONE);
                    readAgreement = false;
                }else{
                    select.setVisibility(View.VISIBLE);
                    readAgreement = true;
                }
                break;

            case R.id.zc_next:
                if (TextUtils.isEmpty(loginPhone.getText().toString().trim()) || TextUtils.isEmpty(checkCode.getText().toString().trim())) {
                    ToastUtil.showToast("手机号、验证码不能为空");
                    return;
                } else if (!PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                    ToastUtil.showToast("请输入正确手机号");
                    return;
                } else {
                    if(!readAgreement){
                        ToastUtil.showToast("请先阅读并同意注册协议");
                        return;
                    }
                    checkVerifyCode();
                }
                break;

            case R.id.zc_back2:
                loginPassword.setText("");
                loginPassword.setVisibility(View.GONE);
                confirmPassword.setText("");
                confirmPassword.setVisibility(View.GONE);
                loginPhone.setVisibility(View.VISIBLE);
                zcCode.setVisibility(View.VISIBLE);
                agreement.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                done.setVisibility(View.GONE);
                break;

            case R.id.zc_done:
                String pass = loginPassword.getText().toString().trim();

                if (!verifyPassWord(pass)) {
                        ToastUtil.showToast("密码格式不符");
                        return;
                    }
                if(!isAgreementProtocol){
                        ToastUtil.showToast("请先阅读并同意协议");
                        return;
                    }
//                    register();
                break;
            case R.id.zc_agreement:
                BaseWebViewActivity.loadUrl(this, "http://47.94.2.34/mobile/UserHelp/regist_rule", "注册协议");
                break;
        }
    }

    /**
     * 注册
     */
//    private void register() {
//        new MemberModel().register(loginPhone.getText().toString().trim(), loginPassword.getText().toString().trim(),confirmPassword.getText().toString().trim(), checkCode.getText().toString(), new BaseModel.BaseModelIB() {
//            @Override
//            public void StartOp() {
//                showLoading();
//            }
//
//            @Override
//            public void successful(Object o) {
//                hideLoading();
//                DatasStore.saveUserPhone(loginPhone.getText().toString().trim());
//                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
//                finish();
//            }
//
//            @Override
//            public void failed(ResultsModel resultsModel) {
//                hideLoading();
//                ToastUtil.showToast(resultsModel.getErrorMsg());
//            }
//        });
//    }

    void checkVerifyCode() {
        new MemberModel().checkIdentify(loginPhone.getText().toString().trim(), checkCode.getText().toString().trim(), new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {
                showLoading();
            }

            @Override
            public void successful(Object o) {
                hideLoading();
                loginPassword.setVisibility(View.VISIBLE);
                confirmPassword.setVisibility(View.VISIBLE);
                back.setVisibility(View.GONE);
                loginPhone.setVisibility(View.GONE);
                zcCode.setVisibility(View.GONE);
                agreement.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                done.setVisibility(View.VISIBLE);
                back2.setVisibility(View.VISIBLE);
                loginPassword.requestFocus();
                loginPassword.setFocusable(true);
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
        new MemberModel().registidentifycode(loginPhone.getText().toString().trim(), new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {
                showLoading();
            }

            @Override
            public void successful(Object o) {
                getCode.setClickable(false);
                getCode.setText("60s");
                hideLoading();
//                verifyCode = (String) o;
                ToastUtil.showToast("发送成功");
                //完成验证码请求，验证码按钮控件开始计时
                timer = new TimeCount(60000, 1000);
                timer.start();// 开始计时
                hideLoading();
                checkCode.requestFocus();
                checkCode.setFocusable(true);
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
