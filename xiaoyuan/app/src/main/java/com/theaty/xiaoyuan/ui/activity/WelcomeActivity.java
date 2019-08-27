package com.theaty.xiaoyuan.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.theaty.xiaoyuan.ui.utils.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import foundation.base.activity.BaseActivity;
import foundation.permissions.EasyPermissions;
import foundation.toast.ToastUtil;

/**
 * Created by Yecal on 2019/4/18.
 *  欢迎页面
 */

public class WelcomeActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    @BindView(R.id.pager)
    ViewPager mPager;
    @BindView(R.id.indicator)
    CircleIndicator mIndicator;

    private int[] imageIds = {R.drawable.splash,R.drawable.splash,R.drawable.splash};
    private List<ImageView> imageViews = new ArrayList<>();
    private static final int MAIN_PERMISSIONS = 99;

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

    @Override
    protected void checkPermissions() {
        // 暂不需要
//        if (!EasyPermissions.hasPermissions(mContext, Manifest.permission_group.STORAGE, Manifest.permission_group.CONTACTS, Manifest.permission_group.CAMERA)) {
//            EasyPermissions.requestPermissions(mContext, getString(R.string.storage_contact_camera), R.string.dialog_positive, R.string.dialog_negative, MAIN_PERMISSIONS,
//                    Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE,
//                    Manifest.permission.CAMERA);
//        }
    }

    private void initView() {
//        mPager = findViewById(R.id.pager);
//        mIndicator = findViewById(R.id.indicator);
        for (int id : imageIds) {
            ImageView imageView = new ImageView(this);

            Glide.with(this).load(id).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
        }

        WelcomePagerAdapter mAdaper = new WelcomePagerAdapter(imageViews);
        mPager.setAdapter(mAdaper);
        mPager.setOffscreenPageLimit(2);
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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, mContext);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        ToastUtil.showToast("缺少权限："+perms.get(0));
    }
}
