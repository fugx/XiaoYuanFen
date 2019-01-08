package com.theaty.xiaoyuan.ui.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.xiaoyuan.Play;

import java.text.SimpleDateFormat;
import java.util.List;

import foundation.glide.GlideUtil;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Yecal on 2018/7/16.
 * 动画列表适配器
 */

public class OutdoorAdapter extends BaseQuickAdapter<Play,BaseViewHolder> {

    private Context mContext;

    public interface ShowPopWidow {
        void show(Play item);
    }

    public OutdoorAdapter(Context context, int layoutResId, @Nullable List<Play> data) {
        super(layoutResId, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final Play item) {
        ImageView imageView = (ImageView) helper.getView(R.id.ig_img);
        GlideUtil.getInstance().loadImage(mContext, imageView, item.getPhoto(), R.mipmap.bg2, R.mipmap.bg2, new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 10, 10,
                RoundedCornersTransformation.CornerType.ALL));
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_time, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.parseLong(item.getTime().toString()) * 1000));
    }
}
