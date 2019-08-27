package com.theaty.xiaoyuan.ui.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.model.xiaoyuan.Play;
import com.theaty.xiaoyuan.model.xiaoyuan.Sign;

import java.util.ArrayList;

import foundation.glide.GlideUtil;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Yecal on 2018/7/11.3
 * 课程列表适配器
 */

public class MeetingAdapter extends BaseQuickAdapter<Play, BaseViewHolder> {

    private Context context;

    public MeetingAdapter(Context context, int layoutResId, @Nullable ArrayList<Play> data) {
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
        ArrayList<Sign> signModels = new ArrayList<>();
        if(item.getSigns().size()>2){
            signModels.add(item.getSigns().get(0));
            signModels.add(item.getSigns().get(1));
            signModels.add(item.getSigns().get(2));
        } else {
            signModels.addAll(item.getSigns());
        }

        ImageView imageView = (ImageView) helper.getView(R.id.ig_img);
        if (item.getPhoto() == "") {
            imageView.setVisibility(View.GONE);
        } else {
            GlideUtil.getInstance().loadImage(mContext, imageView, item.getPhoto(), R.mipmap.bg1, R.mipmap.bg1, new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 10, 0,
                    RoundedCornersTransformation.CornerType.ALL));
        }
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_area, item.getArea());
        helper.setText(R.id.tv_fee, item.getFee().toString());

//        RecyclerView courseSign = helper.getView(R.id.rv_course_sign);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        courseSign.setLayoutManager(layoutManager);
//        SignAdapter signAdapter = new SignAdapter(R.layout.item_sign, signModels);
//        courseSign.setAdapter(signAdapter);
    }
}
