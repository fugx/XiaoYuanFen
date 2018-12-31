package com.theaty.xiaoyuan.ui.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.xiaoyuan.Play;
import com.theaty.xiaoyuan.model.xiaoyuan.Sign;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import foundation.glide.GlideUtil;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Yecal on 2018/7/11.3
 * 课程列表适配器
 */

public class PlayAdapter extends BaseQuickAdapter<Play, BaseViewHolder> {

    private Context context;

    public PlayAdapter(Context context, int layoutResId, @Nullable ArrayList<Play> data) {
        super(layoutResId, data);
        this.context = context;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }

    private ItemClickListener listener;

    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final Play item) {

        ImageView imageView = (ImageView) helper.getView(R.id.ig_img);
        if (item.getPhoto() == "") {
            imageView.setVisibility(View.GONE);
        } else {
            GlideUtil.getInstance().loadImage(mContext, imageView, item.getPhoto(), R.mipmap.bg1, R.mipmap.bg1, new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 20, 0,
                    RoundedCornersTransformation.CornerType.ALL));
        }
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_content, item.getIntroduction());
        helper.setText(R.id.tv_time, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.parseLong(item.getTime().toString()) * 1000));
        helper.setText(R.id.tv_area, item.getArea());
        helper.setText(R.id.tv_fee, item.getFee().toString());
    }
}
