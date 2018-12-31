package com.theaty.xiaoyuan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.UmengShareUtils;
import com.theaty.xiaoyuan.db.utils.PlayDaoOpe;
import com.theaty.xiaoyuan.model.xiaoyuan.Play;
import com.theaty.xiaoyuan.model.xiaoyuan.Sign;
import com.theaty.xiaoyuan.ui.home.adapter.PlayAdapter;
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
import foundation.widget.recyclerView.swiperefreshlayout.SwipeRefreshLayout;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Yecal on 2018/12/24.
 */

public class PlayListActivity extends BaseActivity {

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.rv_play_list)
    RecyclerView play_list;

    private ArrayList<Play> plays = new ArrayList<>();
    private PlayAdapter playAdapter;
    private int curpage = 1;
    private long type = 1;

    public static void into(Context context) {
        Intent intent = new Intent(context, PlayListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_play_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getLongExtra("type",1L);
        initView();
        getData(1,type);
    }

    private void initView() {
        //课程列表 设置RecyclerView 布局
        play_list.setLayoutManager(new LinearLayoutManager(this));
        playAdapter = new PlayAdapter(this,R.layout.item_play, plays);
        playAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Play play = playAdapter.getData().get(position);
                //点击进入课程详情
                Intent intent = new Intent(PlayListActivity.this, PlayDetialActivity.class);
                intent.putExtra("play", play);
                startActivity(intent);
            }
        });
        play_list.setAdapter(playAdapter);

        playAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                getData(curpage,type);
            }
        }, play_list);
    }

    public void getData(int page,long type) {
        List<Play> list = PlayDaoOpe.queryForTypeId(this,type);
        if (list != null) {
            if (curpage == 1) {
                plays.clear();
                playAdapter.setEnableLoadMore(true);
            }
            plays.addAll(list);
            playAdapter.notifyDataSetChanged();
            curpage++;
            if (list.size() == 0) {
                playAdapter.loadMoreEnd();
            } else {
                playAdapter.loadMoreComplete();
            }
        }
        swipe_layout.setRefreshing(false);
    }

    @OnClick({R.id.ig_icon_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ig_icon_back:
                finish();
                break;
        }
    }

}
