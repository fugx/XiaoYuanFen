package com.theaty.xiaoyuan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.donkingliang.labels.LabelsView;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.UmengShareUtils;
import com.theaty.xiaoyuan.dao.PlayDao;
import com.theaty.xiaoyuan.db.utils.PlayDaoOpe;
import com.theaty.xiaoyuan.model.xiaoyuan.Member;
import com.theaty.xiaoyuan.model.xiaoyuan.Play;
import com.theaty.xiaoyuan.model.xiaoyuan.Sign;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import foundation.base.activity.BaseActivity;
import foundation.base.activity.BaseWebViewActivity;
import foundation.glide.GlideUtil;
import foundation.toast.ToastUtil;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Yecal on 2018/12/24.
 */

public class PlayDetailActivity extends BaseActivity {

    @BindView(R.id.ig_img)
    ImageView img;
    @BindView(R.id.iv_wei_img)
    ImageView wei_img;
    @BindView(R.id.iv_group_img)
    ImageView group_img;
    @BindView(R.id.tv_time)
    TextView play_time;
    @BindView(R.id.tv_publish)
    TextView publish;
    @BindView(R.id.tv_fee)
    TextView fee;
    @BindView(R.id.tv_hot)
    TextView hot;
    @BindView(R.id.tv_play_detail)
    TextView play_detail;
    @BindView(R.id.tv_notice_content)
    TextView notice_content;
    @BindView(R.id.lv_sign_list)
    LabelsView labelsView;

    private ArrayList<String> signModels = new ArrayList<>();
    public Play play;

    public static void into(Context context) {
        Intent intent = new Intent(context, PlayDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_play_detail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Long playId = (Long)getIntent().getLongExtra("play",1L);
        List<Play> plays = PlayDaoOpe.queryForId(this,playId);
        if(playId!=null && plays.size()>0){
            play = plays.get(0);
        }

//        getData(String.valueOf(goodsModel.goods_id));
//        initView();
        initData();
    }

    private void initData(){
        GlideUtil.getInstance().loadImage(mContext, img, play.getUrl(), R.mipmap.bg2, R.mipmap.bg2, new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 10, 0,
                RoundedCornersTransformation.CornerType.ALL));
        //TODO 待添加字段
        GlideUtil.getInstance().loadImage(mContext, wei_img, play.getUrl(), R.mipmap.logo, R.mipmap.logo, new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 2, 0,
                RoundedCornersTransformation.CornerType.ALL));
        //TODO 待添加字段
        GlideUtil.getInstance().loadImage(mContext, group_img, play.getUrl(), R.mipmap.logo, R.mipmap.logo, new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 2, 0,
                RoundedCornersTransformation.CornerType.ALL));
//        play_time.setText("");
        play_time.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.parseLong(play.getTime().toString()) * 1000));
        Member member = play.getMember();
        publish.setText(member.getName());//getmember  待修改
        fee.setText(play.getFee().toString() + "元");
        hot.setText(play.getNum());
        play_detail.setText(play.getIntroduction());
        //TODO 待添加字段:注意事项
        notice_content.setText(play.getIntroduction());

        if(play.getSigns().size()>0){
            signModels.clear();
            for(Sign sign:play.getSigns()){
                signModels.add(sign.getName());
            }
            labelsView.setLabels(signModels);
            labelsView.setVisibility(View.VISIBLE);
        } else {
            labelsView.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.ig_icon_back,R.id.ig_img,R.id.tv_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ig_icon_back:
                finish();
                break;

            case R.id.ig_img:
                BaseWebViewActivity.loadUrl(this, play.getUrl(), "");
                break;

            case R.id.tv_sign_up:
                BaseWebViewActivity.loadUrl(this, play.getUrl(), "");
                break;
        }
    }

    private void shareNews(String url) {
        UmengShareUtils.shareUrl(this, play.getName(), play.getTitle(), url, play.getUrl(), new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
            }

            @Override
            public void onResult(SHARE_MEDIA share_media) {
                ToastUtil.showToastbottom("分享成功");
            }

            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                ToastUtil.showToastbottom("分享失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {
            }
        });
    }
}
