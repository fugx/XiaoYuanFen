package com.theaty.xiaoyuan;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import foundation.base.activity.BaseActivity;
import foundation.log.LogUtils;
import foundation.toast.ToastUtil;

/**
 * Created by Administrator on 2017/3/9.
 */

public class UmengShareUtils {

    // 请将下面代码复制到调用UmengShareUtils的Activity中
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//		UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//	}

    private BaseActivity mActivity;
    private ShareAction mShare;

    public UmengShareUtils(BaseActivity activity) {
        mActivity = activity;
        mShare = new ShareAction(activity);
    }


    private void shareUrl(String title, String text, String url) {
        LogUtils.d("***", "url: " + url);
        if (TextUtils.isEmpty(url)) {
            ToastUtil.showToast("获取分享地址失败, 请稍后重试");
            return;
        }

        mShare.setDisplayList(
                SHARE_MEDIA.SINA,
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.TENCENT)
                .withMedia(new UMWeb(url, title, text, new UMImage(mActivity, R.mipmap.ic_launcher)))
                .setCallback(umShareListener)
                .open();
    }

    private void shareUrl2(String title, String text, final String url) {
        LogUtils.d("***", "url: " + url);
        if (TextUtils.isEmpty(url)) {
            ToastUtil.showToast("获取分享地址失败, 请稍后重试");
            return;
        }

        mShare.setDisplayList(
                SHARE_MEDIA.SINA,
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.TENCENT)
                .withMedia(new UMWeb(url, title, text, new UMImage(mActivity, R.mipmap.ic_launcher)))
                .setCallback(new UMShareListener() {

                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        //ShareActivity.into(mActivity,url);
                        ToastUtil.showToast("已分享");
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        ToastUtil.showToast("分享错误: " + throwable.getMessage());
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                        ToastUtil.showToast("取消分享");
                    }
                }).open();
    }

    public static void shareUrl(Activity activity, String title, String text, String url,String thumbUrl, UMShareListener umShareListener) {
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(activity, "获取分享地址失败, 请稍后重试", Toast.LENGTH_SHORT).show();
            return;
        }
        UMImage umImage;
        if( TextUtils.isEmpty(thumbUrl)){
            umImage = new UMImage(activity,R.mipmap.ic_launcher);
        }else {
             umImage = new UMImage(activity, thumbUrl);
        }
        ShareAction shareAction = new ShareAction(activity);
        shareAction.setDisplayList(
                SHARE_MEDIA.SINA,
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE)
                .withMedia(new UMWeb(url, title, TextUtils.isEmpty(text)?title:text,umImage)) //判断是主要防止微博分享内容为空时分享失败
                .setCallback(umShareListener)
                .open();
    }


    private UMShareListener umShareListener = new UMShareListener() {

        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            ToastUtil.showToast("已分享");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            ToastUtil.showToast("分享错误: " + throwable.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            ToastUtil.showToast("取消分享");
        }
    };

}
