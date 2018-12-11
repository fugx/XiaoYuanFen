package com.theaty.xiaoyuan.ui.welcome;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;
import com.theaty.xiaoyuan.ui.welcome.widget.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import foundation.base.activity.BaseActivity;

public class WelcomeActivity extends BaseActivity {
	@BindView(R.id.pager)
    ViewPager mPager;
	@BindView(R.id.indicator)
	CircleIndicator mIndicator;

	private int[] imageIds = {R.mipmap.logo, R.mipmap.logo, R.mipmap.logo};
	private List<ImageView> imageViews = new ArrayList<>();

	@Override
	protected View onCreateContentView() {
		return inflateContentView(R.layout.activity_welcome);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
		initView();
	}

	private void initView() {
		for (int id : imageIds) {
			ImageView imageView = new ImageView(this);
			Glide.with(this).load(id).into(imageView);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageViews.add(imageView);
		}

		WelcomePagerAdapter mAdaper = new WelcomePagerAdapter(imageViews);
		mPager.setAdapter(mAdaper);
		mIndicator.setViewPager(mPager);
	}

	private class WelcomePagerAdapter extends PagerAdapter {
		List<ImageView> imageViews;

		public WelcomePagerAdapter(List<ImageView> imageViews) {
			this.imageViews = imageViews;
		}

		@Override
		public int getCount() {
			if (imageViews != null) return imageViews.size();
			return 0;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView imageView = imageViews.get(position);
			if (position == getCount() - 1) {
				imageView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						DatasStore.setFirstLaunch(false);
						startActivity(new Intent(mContext, MainActivity.class));
						finish();
					}
				});
			}
			container.addView(imageView);
			return imageView;
		}
	}


}
