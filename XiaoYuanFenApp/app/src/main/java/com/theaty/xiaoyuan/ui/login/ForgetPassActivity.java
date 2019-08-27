package com.theaty.xiaoyuan.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;

import butterknife.BindView;
import butterknife.OnClick;
import foundation.base.activity.BaseActivity;
import foundation.toast.ToastUtil;
import foundation.util.PhoneUtils;

public class ForgetPassActivity extends BaseActivity {

    @BindView(R.id.rs_back)
    LinearLayout back;
    @BindView(R.id.rs_back2)
    LinearLayout back2;
    @BindView(R.id.reset_password)
    LinearLayout resetPassword;
    @BindView(R.id.rs_code)
    LinearLayout rsCode;
    @BindView(R.id.rs_login_phone)
    EditText loginPhone;
    @BindView(R.id.rs_login_password)
    EditText loginPassword;
    @BindView(R.id.confirm_password)
    EditText confirmPassword;
    @BindView(R.id.rs_check_code)
    TextView checkCode;
    @BindView(R.id.rs_get_code)
    TextView getCode;
    @BindView(R.id.rs_next)
    Button next;
    @BindView(R.id.rs_done)
    Button done;

//    private String verifyCode;
    private TimeCount timeCount;

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_forget_pass);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        edInputPass.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});

    }

    public static void into(Context context, String title) {
        Intent intent = new Intent(context, ForgetPassActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @OnClick({R.id.rs_get_code, R.id.rs_next, R.id.rs_done,R.id.rs_back,R.id.rs_back2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rs_back:
                finish();
                break;

            case R.id.rs_get_code:
                if (TextUtils.isEmpty(loginPhone.getText().toString().trim()) || !PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                    ToastUtil.showToast("请输入正确的手机号");
                    return;
                }
                getCode.setClickable(false);
                getVerificationCode();
                checkCode.requestFocus();
                checkCode.setFocusable(true);
                break;

            case R.id.rs_next:
                if (TextUtils.isEmpty(loginPhone.getText().toString().trim()) || !PhoneUtils.isMobileNO(loginPhone.getText().toString().trim())) {
                    ToastUtil.showToast("请输入正确的手机号格式不符");
                    return;
                }
                if (TextUtils.isEmpty(checkCode.getText().toString().trim()) || checkCode.getText().toString().length() != 6) {
                    ToastUtil.showToast("请输入正确的验证码");
                    return;
                }
                checkCode();
                break;

            case R.id.rs_back2:
                loginPassword.setVisibility(View.GONE);
                confirmPassword.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);
                loginPhone.setVisibility(View.VISIBLE);
                rsCode.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                done.setVisibility(View.GONE);
                back2.setVisibility(View.GONE);
                break;

            case R.id.rs_done:
                if (verifyPassWord(loginPassword.getText().toString().trim())&&verifyPassWord(confirmPassword.getText().toString().trim())) {
                    modifyPassword();
                } else {
                    ToastUtil.showToast("密码格式不符");
                    return;
                }
                break;
        }
    }

    private void checkCode() {
        new MemberModel().checkIdentify(loginPhone.getText().toString().trim(), checkCode.getText().toString().trim(), new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {
                showLoading();
            }

            @Override
            public void successful(Object o) {
                hideLoading();
                loginPassword.setText("");
                confirmPassword.setText("");
                loginPassword.setVisibility(View.VISIBLE);
                confirmPassword.setVisibility(View.VISIBLE);
                back.setVisibility(View.GONE);
                loginPhone.setVisibility(View.GONE);
                rsCode.setVisibility(View.GONE);
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


    void modifyPassword() {
        new MemberModel().modify_pwd(loginPhone.getText().toString().trim(), checkCode.getText().toString().trim(), loginPassword.getText().toString().trim(),confirmPassword.getText().toString().trim(), new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {
                showLoading();
            }

            @Override
            public void successful(Object o) {
                ToastUtil.showToast((String) o);
                hideLoading();
                finish();
            }

            @Override
            public void failed(ResultsModel resultsModel) {
                hideLoading();
                ToastUtil.showToast(resultsModel.getErrorMsg());
            }
        });
    }

    /**
     * 获取验证码
     */
    public void getVerificationCode() {
        new MemberModel().forgetidentifycode(loginPhone.getText().toString().trim(), new BaseModel.BaseModelIB() {
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
