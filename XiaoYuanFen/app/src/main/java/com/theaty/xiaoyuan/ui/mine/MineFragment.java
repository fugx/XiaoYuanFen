package com.theaty.xiaoyuan.ui.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import foundation.base.fragment.BaseFragment;
import foundation.glide.GlideUtil;
import foundation.toast.ToastUtil;

/**
 * Created by track on 2017/2/26.
 * 我的信息页面
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.center_my_avater)
    ImageView centerMyAvater;
    @BindView(R.id.my_name)
    TextView name;
    @BindView(R.id.my_gender)
    TextView gender;
    @BindView(R.id.my_age)
    TextView age;
//    @BindView(R.id.go_my_center)
//    ImageView goMyCenter;
//    @BindView(R.id.ig_message)
//    ImageView igMessage;
//    @BindView(R.id.tv_message_num)
//    TextView tvMessageNum;
//    @BindView(R.id.tv_vip_type)
//    TextView vipType;
//
//    Unbinder unbinder;
//    @BindView(R.id.scroll_view)
//    ScrollView scrollView;

    private MainActivity mainActivity;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
//        mainActivity.registerReceiver(networkChangeReceiver,intentFilter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mine_fragment, container, false);
//        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    private void judgeLogin() {
        if (DatasStore.isLogin()) {
            MemberModel model = DatasStore.getCurMember();
            name.setText(model.member_nick == null ? model.member_name : model.member_nick);
            gender.setText(model.member_sex == 1 ? "男" : "女");
            if (model.member_birthday.equals("")) {
                age.setText("");
            } else {
                age.setText(getAge(model.member_birthday) + "岁");
            }
//            GlideUtil.getInstance().loadCircleImage(getContext(), centerMyAvater, model.member_avatar,R.mipmap.not_login_avatar,R.mipmap.not_login_avatar);
            //每次获取，防止在其他手机上修改后本机不会同步更新资料
            getHead();
        } else {
            GlideUtil.getInstance().loadCircleImage(getContext(), centerMyAvater, R.mipmap.not_login_avatar);
            gender.setText("登录后可享受更多服务");
            age.setText("");
            name.setText("登录/注册");
        }
    }

    private void getHead() {
//        new MemberModel().member_info(DatasStore.getCurMember().key, new BaseModel.BaseModelIB() {
//            @Override
//            public void StartOp() {
//            }
//
//            @Override
//            public void successful(Object o) {
//                MemberModel model = (MemberModel) o;
//                try {
//
//                    if (!model.member_avatar.equals("")) {
//                        GlideUtil.getInstance().loadCircleImage(getContext(), centerMyAvater, model.member_avatar, R.mipmap.not_login_avatar, R.mipmap.not_login_avatar);
//                    }
//                    if (!model.member_nick.equals("")) {
//                        name.setText(model.member_nick == null ? model.member_name : model.member_nick);
//                    }
//                    gender.setText(model.member_sex == 1 ? "男" : "女");
//                    if (model.member_isvip == 1 && model.member_end > 0) {
//                        vipType.setText("有效期至：" +
//                                new SimpleDateFormat("yyyy.MM.dd").format(new Date(Long.valueOf(model.member_end) * 1000L)));
//                    } else {
//                        vipType.setText("普通用户");
//                    }
//                    if (model.member_birthday.equals("")) {
//                        age.setText("");
//                    } else {
//                        age.setText(getAge(model.member_birthday) + "岁");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void failed(ResultsModel resultsModel) {
//                if (!resultsModel.getErrorMsg().equals("请登录")) {
//                    ToastUtil.showToastbottom(resultsModel.getErrorMsg());
//                }
//            }
//        });
    }

    @Override
    public void onResume() {
        super.onResume();

        //查询通知消息
        getMessage();
        judgeLogin();
    }

    private String getAge(String birthday) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(new Date(Long.valueOf(birthday) * 1000L))) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(new Date(Long.valueOf(birthday) * 1000L));

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            } else {
                age--;
            }
        }
        return String.valueOf(age);
    }

    private void getMessage() {
//        new MemberModel().new_message(new BaseModel.BaseModelIB() {
//            @Override
//            public void StartOp() {
//            }
//
//            @Override
//            public void successful(Object o) {
//                try {
//                    if (Integer.valueOf((String) o) > 99) {
//                        o = 99 + "";
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                if (!"0".equals((String) o)) {
//                    tvMessageNum.setText((String) o);
//                    tvMessageNum.setVisibility(View.VISIBLE);
//                } else {
//                    tvMessageNum.setText("0");
//                    tvMessageNum.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void failed(ResultsModel resultsModel) {
//                tvMessageNum.setText("0");
//                tvMessageNum.setVisibility(View.GONE);
//            }
//        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

//    @OnClick({R.id.ig_message, R.id.my_info, R.id.go_my_center, R.id.my_collect, R.id.my_focus_on, R.id.sign_up_day, R.id.my_members, R.id.set_up, R.id.questions})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.my_info:
//                if (DatasStore.isLogin()) {
//                    MyInfoActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.go_my_center:
//                if (DatasStore.isLogin()) {
//                    MyInfoActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.my_collect:
//                if (DatasStore.isLogin()) {
//                    CollectActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.my_focus_on:
//                if (DatasStore.isLogin()) {
//                    FocusActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.sign_up_day:
//                if (DatasStore.isLogin()) {
//                    SignUpActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.my_members:
//                if (DatasStore.isLogin()) {
//                    MyMemberActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.set_up:
//                if (DatasStore.isLogin()) {
//                    SettingActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.questions:
//                if (DatasStore.isLogin()) {
//                    QuestionActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.ig_message:
//                if (DatasStore.isLogin()) {
//                    MessageActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mainActivity.unregisterReceiver(networkChangeReceiver);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            if(networkInfo!=null && networkInfo.isAvailable()){
//                getMessage();
//                judgeLogin();
//            }
        }
    }
}
