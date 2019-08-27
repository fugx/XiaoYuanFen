package com.theaty.umengshare;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

import java.io.File;

/**
 * 使用本页面方法之前请在主项目的AppContext中设置分享分享平台的appKey
 */
public class UmengShare {

    // 分享的页面有qq和微博的话需要添加此方法，只能添加在Activity中
    //	@Override
    //	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //		super.onActivityResult(requestCode, resultCode, data);
    //		UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    //
    //	}

    /**
     * 分享无图片链接
     */
//	public static void shareUrl(Activity activity, String title, String url) {
//		new ShareAction(activity).withText(title).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
//				SHARE_MEDIA.QZONE, SHARE_MEDIA.TENCENT, SHARE_MEDIA.EMAIL, SHARE_MEDIA.SMS).withTargetUrl(url).open();
//	}

    /**
     * 分享有图片链接
     */
//	public static void shareUrlWithImage(Activity activity, String title, String image, String url) {
//		new ShareAction(activity).withText(title).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
//				SHARE_MEDIA.QZONE, SHARE_MEDIA.TENCENT, SHARE_MEDIA.EMAIL, SHARE_MEDIA.SMS).withMedia(new UMImage(activity, image)).withTargetUrl(url).open();
//	}


    /**
     * 分享音频及其缩略图片
     *
     * @param activity
     * @param musicName 音乐名称
     * @param musicUrl  音乐url
     * @param thumbUrl  音乐封面图
     * @param listener  回调监听
     */
    public static void shareMusicAndImg(Activity activity, String musicName, String musicUrl, String thumbUrl, UMShareListener listener) {
        UMusic uMusic = new UMusic(musicUrl);
        uMusic.setTitle(musicName);
        uMusic.setThumb(new UMImage(activity, thumbUrl));
        uMusic.setmTargetUrl("");
        uMusic.setDescription("一起听听吧");

        new ShareAction(activity).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
                SHARE_MEDIA.QZONE).withMedia(uMusic).setCallback(listener).open();
    }

    /**
     * 分享视频及其缩略图
     *
     * @param activity
     * @param videoName 视频名称
     * @param videoUrl  视频地址
     * @param thumbUrl  缩略图地址
     * @param listener
     */
    public static void shareVideoAndImg(Activity activity, String videoName,String videoDesc, String videoUrl, String thumbUrl, UMShareListener listener) {
        UMVideo umVideo = new UMVideo(videoUrl);
        umVideo.setTitle(videoName);
        umVideo.setThumb(new UMImage(activity, thumbUrl));
        umVideo.setDescription(videoDesc);

        new ShareAction(activity).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
                SHARE_MEDIA.QZONE).withMedia(umVideo).setCallback(listener).open();
    }


    public static void shareImageOnly(Activity activity, File file, UMShareListener listener) {
        new ShareAction(activity).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
                SHARE_MEDIA.QZONE, SHARE_MEDIA.TENCENT, SHARE_MEDIA.EMAIL, SHARE_MEDIA.SMS).withMedia(new UMImage(activity, file)).setCallback(listener).open();
    }

    public static void shareByOnePlatform(Activity activity, SHARE_MEDIA platform, File image, UMShareListener listener) {
        new ShareAction(activity).setPlatform(platform).withMedia(new UMImage(activity, image)).setCallback(listener).share();
    }
}
