package foundation.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.common.library.R;

/**
 * Created   on 2017/3/2.
 */

public class GlideUtil {
    private static GlideUtil mInstance;

    private GlideUtil() {
    }

    public static GlideUtil getInstance() {
        if (mInstance == null) {
            synchronized (GlideUtil.class) {
                if (mInstance == null) {
                    mInstance = new GlideUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 常量
     */
    static class Contants {
        public static final int BLUR_VALUE = 20; //模糊
        public static final int CORNER_RADIUS = 20; //圆角
        public static final float THUMB_SIZE = 0.5f; //0-1之间  10%原图的大小
    }

    /**
     * 常规加载图片
     *
     * @param context
     * @param imageView 图片容器
     * @param imgUrl    图片地址
     * @param isFade    是否需要动画
     */
    public void loadImage(Context context, ImageView imageView,
                          String imgUrl, boolean isFade) {
        if (context == null) {
            return;
        }
        try {
            if (isFade) {
                Glide.with(context)
                        .load(imgUrl)
                        .error(R.mipmap.error)
                        .crossFade()
                        .priority(Priority.NORMAL) //下载的优先级
                        //all:缓存源资源和转换后的资源 none:不作任何磁盘缓存
                        //source:缓存源资源   result：缓存转换后的资源
                        .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                        .into(imageView);
            } else {
                Glide.with(context)
                        .load(imgUrl)
                        .error(R.mipmap.error)
                        .into(imageView);
            }
        } catch (IllegalArgumentException e) {
            Log.e("GlideUtil", "未加载出图片activity就已退出造成异常，You cannot start a load for a destroyed activity");
            e.printStackTrace();
        }
    }

    /**
     * 加载带transformation操作的图片
     *
     * @param context
     * @param imageView
     * @param imgUrl
     * @param transformation
     */
    public void loadImage(Context context, ImageView imageView, String imgUrl, int placeHolder, int errorImg, Transformation transformation) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .placeholder(placeHolder)
                    .error(errorImg)
                    .bitmapTransform(transformation)
                    .crossFade()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 加载图片 带有多个Transformation操作，比如centerCrop和RoundedCornersTransformation
    public void loadImage(Context context, final ImageView imageView, String imgUrl, int placeHolder, int errorImg, Transformation transformation, Transformation transformation1) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .placeholder(placeHolder)
                    .error(errorImg)
                    .bitmapTransform(transformation, transformation1)
                    .crossFade()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载图片 带有多个Transformation操作，比如centerCrop和RoundedCornersTransformation
     *
     * @param context
     * @param imageView
     * @param imgUrl
     * @param errorImg
     * @param transformation
     * @param transformation1
     */
    public void loadImage(Context context, ImageView imageView, String imgUrl, int errorImg, Transformation transformation, Transformation transformation1) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .error(errorImg)
                    .bitmapTransform(transformation, transformation1)
                    .crossFade()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadImage(Context context, ImageView imageView, String imgUrl, int errorImg, Transformation transformation) {
        try {

            Glide.with(context)
                    .load(imgUrl)
                    .error(errorImg)
                    .bitmapTransform(transformation)
                    .crossFade()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载带不带操作的图片
     */
    public void loadImage(Context context, ImageView imageView, String imgUrl, int placeHolder, int errorImg) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .placeholder(placeHolder)
                    .error(errorImg)
                    .crossFade()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载缩略图
     *
     * @param context
     * @param imageView 图片容器
     * @param imgUrl    图片地址
     */
    public void loadThumbnailImage(Context context, ImageView imageView, String imgUrl) {
        try {
            Glide.with(context)
                    .load(imgUrl)
//				.error(R.mipmap.error)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .thumbnail(Contants.THUMB_SIZE)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadThumbnailImage(Context context, ImageView imageView, String imgUrl, int defaultimage) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .error(defaultimage)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .thumbnail(Contants.THUMB_SIZE)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载图片并设置为指定大小
     *
     * @param context
     * @param imageView
     * @param imgUrl
     * @param withSize
     * @param heightSize
     */
    public void loadOverrideImage(Context context, ImageView imageView,
                                  String imgUrl, int withSize, int heightSize) {
        try {
            Glide.with(context)
                    .load(imgUrl)
//				.error(R.mipmap.error)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .override(withSize, heightSize)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadOverrideImage(Context context, ImageView imageView,
                                  String imgUrl, int withSize, int heightSize, int defaultimage) {
        try {
            Glide.with(context)
                    .load(imgUrl)
//				.error(defaultimage)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .override(withSize, heightSize)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 加载圆图
     *
     * @param context
     * @param imageView
     * @param imgUrl
     */
    public void loadCircleImage(Context context, ImageView imageView, String imgUrl, int placeholder, int errorImg) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .placeholder(placeholder)
                    .error(errorImg)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载本地圆图
     */
    public void loadCircleImage(Context context, ImageView imageView, int img) {
        try {
            Glide.with(context)
                    .load(img)
                    .crossFade()
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCircleImage(Context context, ImageView imageView, String imgUrl, int errorImage) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .error(errorImage)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 加载圆角图片
     *
     * @param context
     * @param imageView
     * @param imgUrl
     */
    public void loadCornerImage(Context context, ImageView imageView, String imgUrl) {
        try {
            Glide.with(context)
                    .load(imgUrl)
//				.error(R.mipmap.error)
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .bitmapTransform(
                            new RoundedCornersTransformation(
                                    context, Contants.CORNER_RADIUS, Contants.CORNER_RADIUS))
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 同步加载图片
     *
     * @param context
     * @param imgUrl
     * @param target
     */
    public void loadBitmapSync(Context context, String imgUrl, SimpleTarget<Bitmap> target) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .asBitmap()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .into(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载在线gif
     *
     * @param context
     * @param imageView
     * @param imgUrl
     */
    public void loadGifImage(Context context, ImageView imageView, String imgUrl) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .asGif()
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .error(R.mipmap.error)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载本地资源文件的gif
     *
     * @param context
     * @param imageView
     * @param resId
     */
    public void loadGifImage(Context context, ImageView imageView, int resId) {
        try {
            Glide.with(context)
                    .load(resId)
                    .asGif()
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .error(R.mipmap.error)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 加载gif的缩略图
     *
     * @param context
     * @param imageView
     * @param imgUrl
     */
    public void loadGifThumbnailImage(Context context, ImageView imageView, String imgUrl) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .asGif()
                    .crossFade()
                    .priority(Priority.NORMAL) //下载的优先级
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存策略
                    .error(R.mipmap.error)
                    .thumbnail(Contants.THUMB_SIZE)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复请求，一般在停止滚动的时候
     *
     * @param context
     */
    public void resumeRequests(Context context) {
        Glide.with(context).resumeRequests();
    }

    /**
     * 暂停请求 正在滚动的时候
     *
     * @param context
     */
    public void pauseRequests(Context context) {
        Glide.with(context).pauseRequests();
    }

    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public void clearDiskCache(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(context).clearDiskCache();//清理磁盘缓存 需要在子线程中执行
            }
        }).start();
    }

    /**
     * 清除内存缓存
     *
     * @param context
     */
    public void clearMemory(Context context) {
        Glide.get(context).clearMemory();//清理内存缓存  可以在UI主线程中进行
    }
}
