package com.theaty.xiaoyuan.ui.lucky.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.ui.mine.utils.ListDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import foundation.base.activity.BaseActivity;

/**
 * Created by fu on 2018/12/18.
 */

public class CreateGoodsActivity extends BaseActivity {

    @BindView(R.id.tv_release)
    TextView release;
    @BindView(R.id.ll_time)
    LinearLayout time;
    @BindView(R.id.tv_day)
    TextView day;
//    @BindView(R.id.ll_area)
//    LinearLayout area;
    @BindView(R.id.tv_area)
    EditText areaDetial;
    @BindView(R.id.ll_type)
    LinearLayout type;
    @BindView(R.id.tv_type)
    TextView typeDetial;
    @BindView(R.id.tv_url)
    EditText url;
    @BindView(R.id.et_content)
    EditText comtent;
    @BindView(R.id.tv_input)
    TextView input;

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_create_goods);
    }

    public static void into(Context context) {
        Intent starter = new Intent(context, CreateGoodsActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }

    private TimePickerView timePickerView;

    @OnClick({R.id.iv_back, R.id.tv_release, R.id.ll_time, R.id.ll_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_release:

                break;
            case R.id.ll_time:
                //时间选择器
                if (timePickerView != null) {
                    timePickerView.show();
                } else {
                    showTimePicker();
                    timePickerView.show();
                }
                break;
            case R.id.ll_type:
                showGenderDialog();
                break;
            default:
                break;
        }
    }

    void showTimePicker() {
        Calendar defaultDate = Calendar.getInstance();
        defaultDate.set(2018, 1, 1);
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2018, 1, 1);
        endDate.set(2020, 1, 1);

        timePickerView = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                String formTime = getTime(date);
                day.setText(formTime);
            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                })
                .setDate(defaultDate)//设置默认选择时间
                .setRangDate(startDate, endDate)//设置起始终止时间
                .setType(new boolean[]{true, true, true, false, false, false})//设置年月日时分秒的控制
                .setSubmitColor(getResources().getColor(R.color.primary_color))//设置确认按钮的颜色
                .setCancelColor(getResources().getColor(R.color.color_333333))
                .setContentTextSize(20)//滚动文字的大小
                .isDialog(true)
                .build();

        Dialog mDialog = timePickerView.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            timePickerView.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
        }
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(date);
    }

    private ListDialog genderDialog;

    void showGenderDialog() {
        if (genderDialog == null) {
            genderDialog = new ListDialog.Builder(this).setTitle("活动分类")
                    .addAction(new ListDialog.ListDialogAction("活动分类2", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            typeDetial.setText("1");
                        }
                    })).addAction(new ListDialog.ListDialogAction("活动分类2", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            typeDetial.setText("2");
                        }
                    })).addAction(new ListDialog.ListDialogAction("活动分类3", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            typeDetial.setText("3");
                        }
                    })).create();
        }
        genderDialog.show();
    }
}
