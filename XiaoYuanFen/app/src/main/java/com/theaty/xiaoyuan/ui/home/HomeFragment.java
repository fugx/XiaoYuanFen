package com.theaty.xiaoyuan.ui.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.db.utils.PlayDaoOpe;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.GoodsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;
import com.theaty.xiaoyuan.model.xiaoyuan.Play;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;
import com.theaty.xiaoyuan.ui.home.activity.PlayDetailActivity;
import com.theaty.xiaoyuan.ui.home.activity.PlayListActivity;
import com.theaty.xiaoyuan.ui.home.adapter.CityPlayAdapter;
import com.theaty.xiaoyuan.ui.home.adapter.MeetingAdapter;
import com.theaty.xiaoyuan.ui.home.adapter.OutdoorAdapter;
import com.theaty.xiaoyuan.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import foundation.base.activity.BaseWebViewActivity;
import foundation.base.fragment.BaseFragment;
import foundation.toast.ToastUtil;
import foundation.widget.swiperefresh.SuperSwipeRefreshLayout;

/**
 * Created by li on 2017/2/26.
 * 主页面
 */

public class HomeFragment extends BaseFragment {

    View rootView;
    Unbinder unbinder;

//    @BindView(R.id.tv_message_num)
//    TextView tvMessageNum;
    @BindView(R.id.tv_outdoor)
    TextView name1;
    @BindView(R.id.tv_city_play)
    TextView name2;
    @BindView(R.id.tv_tryst)
    TextView name3;
    @BindView(R.id.rview_outdoor)
    RecyclerView outdoorRecycleView;
    @BindView(R.id.rview_city_play)
    RecyclerView cityPlayRecycleView;
    @BindView(R.id.rview_tryst)
    RecyclerView teacherRecycleView;
    @BindView(R.id.super_swipe_view)
    SuperSwipeRefreshLayout superSwipeView;

    @BindView(R.id.banner_guide_content)
    BGABanner mContentBanner;

    private ArrayList<Play> advModels = new ArrayList<>();
    private ArrayList<Play> outdoors = new ArrayList<>();
    private ArrayList<Play> cityPlays  = new ArrayList<>();
    private ArrayList<Play> trysts  = new ArrayList<>();

    private MainActivity activity;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    private OutdoorAdapter outdoorAdapter;
    private CityPlayAdapter cityPlayAdapter;
    private MeetingAdapter meetingAdapter;

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.home_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        activity = (MainActivity) getActivity();

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
//        activity.registerReceiver(networkChangeReceiver,intentFilter);

        superSwipeView.setVisibility(View.VISIBLE);

        getData();
        initView();
        initSwipeView();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void initView() {
        /*
         * 户外-游山玩水
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        outdoorRecycleView.setLayoutManager(layoutManager);
        outdoorAdapter = new OutdoorAdapter(activity,R.layout.item_play1, outdoors);
        outdoorRecycleView.setAdapter(outdoorAdapter);

        outdoorAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Play play1 = outdoorAdapter.getData().get(position);
                Intent intent = new Intent(getContext(), PlayDetailActivity.class);
                intent.putExtra("play", play1.getPlayId());
                startActivity(intent);
            }
        });
        outdoorAdapter.setEmptyView(initEmptyView("无户外活动"));

        /*
         * 市区-吃喝玩乐
         */
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        cityPlayRecycleView.setLayoutManager(layoutManager1);
        cityPlayAdapter = new CityPlayAdapter(getActivity(),R.layout.item_play1, cityPlays);
        cityPlayRecycleView.setAdapter(cityPlayAdapter);
        cityPlayAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Play play2 = cityPlayAdapter.getData().get(position);
                Intent intent = new Intent(getContext(), PlayDetailActivity.class);
                intent.putExtra("play", play2.getPlayId());
                startActivity(intent);
            }
        });
        cityPlayAdapter.setEmptyView(initEmptyView("无市区活动"));

        /*
         * 缘分-秘密约会
         */
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        teacherRecycleView.setLayoutManager(layoutManager2);
        meetingAdapter = new MeetingAdapter(getActivity(),R.layout.item_meeting, trysts);
        teacherRecycleView.setAdapter(meetingAdapter);
        meetingAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Play play3 = meetingAdapter.getData().get(position);
                Intent intent = new Intent(getContext(), PlayDetailActivity.class);
                intent.putExtra("play", play3.getPlayId());
                startActivity(intent);
            }
        });
        meetingAdapter.setEmptyView(initEmptyView("无约会"));
    }

    public void getData() {
        //广告推广类型
        advModels.clear();
        advModels.addAll(PlayDaoOpe.queryForTypeId(activity,0L));
        List<String> imageData = new ArrayList<>();
        List<String> word = new ArrayList<>();
        for(Play adv:advModels){
            imageData.add(adv.getPhoto());
            word.add("");
        }

        if (advModels.size() == 0) {
            mContentBanner.setVisibility(View.GONE);
        }else{
            mContentBanner.setVisibility(View.VISIBLE);
        }
        mContentBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(getContext())
                        .load(model)
                        .placeholder(R.drawable.test1)
                        .error(R.drawable.test1)
                        .centerCrop()
                        .dontAnimate()
                        .into(itemView);
            }
        });
        mContentBanner.setData(imageData, word);

        mContentBanner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
                Play adv = advModels.get(position);
                BaseWebViewActivity.loadUrl(getContext(), adv.getUrl(), adv.getTitle());
            }
        });

        outdoors.clear();
        outdoors.addAll(PlayDaoOpe.queryForTypeId(activity,1L));
        cityPlays.clear();
        cityPlays.addAll(PlayDaoOpe.queryForTypeId(activity,2L));
        trysts.clear();
        trysts.addAll(PlayDaoOpe.queryForTypeId(activity,3L));
        //调用首页接口，获取首页数据
//        new MemberModel().first_page(level, new BaseModel.BaseModelIB() {
//            @Override
//            public void StartOp() {
//            }
//
//            @Override
//            public void successful(Object o) {
//                MemberModel member = (MemberModel) o;
//                advModels.addAll(member.getAdvModel());
//                //测试数据
//                List<String> imageData = new ArrayList<>();
//                List<String> word = new ArrayList<>();
//
//                for(AdvModel adv:member.getAdvModel()){
//                    imageData.add(adv.adv_image);
//                    word.add("");
//                }
//
//                if (advModels.size() == 0) {
//                    mContentBanner.setVisibility(View.GONE);
//                }else{
//                    mContentBanner.setVisibility(View.VISIBLE);
//                }
//                mContentBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
//                    @Override
//                    public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
//                        Glide.with(getContext())
//                                .load(model)
//                                .placeholder(R.mipmap.bg_jifen)
//                                .error(R.mipmap.bg_jifen)
//                                .centerCrop()
//                                .dontAnimate()
//                                .into(itemView);
//                    }
//                });
//                mContentBanner.setData(imageData, word);
//
//                mContentBanner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
//                    @Override
//                    public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
//                        AdvModel advModel = advModels.get(position);
////                        Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
//                        BaseWebViewActivity.loadUrl(getContext(), advModel.adv_url_or_goodsid, advModel.adv_title);
//                    }
//                });
//
//                videoLists.clear();
//                animationLists.clear();
//                teacherLists.clear();
//
//                name1.setText(member.getVideo().getVideoName());
//                name2.setText(member.getCartoon().getCartoonName());
//                name3.setText(member.getTeacher().getTeacherName());
//
//                videoLists.addAll(member.getVideo().getGoodsList());
//                animationLists.addAll(member.getCartoon().getGoodsList());
//                teacherLists.addAll(member.getTeacher().getTeacherList());
//
//                animationAdapter.notifyDataSetChanged();
//                videoAdapter.notifyDataSetChanged();
//                teacherAdapter.notifyDataSetChanged();
//
//                if (superSwipeView != null) {
//                    superSwipeView.setRefreshing(false);
//                }
//            }
//
//            @Override
//            public void failed(ResultsModel resultsModel) {
//                superSwipeView.setRefreshing(false);
//                if (!resultsModel.getErrorMsg().equals("请登录")) {
//                    ToastUtil.showToastbottom(resultsModel.getErrorMsg());
//                }
//            }
//        });

    }

    @OnClick({R.id.tv_outdoor_more,R.id.tv_city_more,R.id.tv_tryst_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_outdoor_more:
//                if (DatasStore.isLogin()) {
                    Intent intent1 = new Intent(getContext(), PlayListActivity.class);
                    intent1.putExtra("type",1L);
                    getContext().startActivity(intent1);
//                } else {
//                    LoginActivity.into(getContext());
//                }
                break;

            case R.id.tv_city_more:
//                if (DatasStore.isLogin()) {
                    Intent intent2 = new Intent(getContext(), PlayListActivity.class);
                    intent2.putExtra("type",2L);
                    getContext().startActivity(intent2);
//                } else {
//                    LoginActivity.into(getContext());
//                }
                break;

            case R.id.tv_tryst_more:
//                if(fragment.orderRg==null){
                    Intent intent3 = new Intent(getContext(), PlayListActivity.class);
                    intent3.putExtra("type",3L);
                    getContext().startActivity(intent3);
//                }else{
//                    ((RadioButton)fragment.orderRg.getChildAt(1)).setChecked(true);
//                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        activity.unregisterReceiver(networkChangeReceiver);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    private void initSwipeView() {
//        superSwipeView.setColorSchemeColors(getResources().getColor(R.color.primary_color));
//        superSwipeView.setDirection(SuperSwipeRefreshLayout.Direction.TOP);
//        superSwipeView.setOnRefreshListener(new SuperSwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh(SuperSwipeRefreshLayout.Direction direction) {
//                getData();
//            }
//        });
    }

    /**
     * 空布局
     */
    private View initEmptyView(String messge) {
        View emptyView = this.inflateContentView(R.layout.empty_layout_small);
        ImageView emptyImg = (ImageView) emptyView.findViewById(R.id.empty_iv);
        emptyImg.setImageResource(R.mipmap.icon_empty);
        TextView emptyTv = (TextView) emptyView.findViewById(R.id.empty_tv);
        emptyTv.setText(messge);
        return emptyView;
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            if(networkInfo!=null && networkInfo.isAvailable()){
//                getData();
//            }
        }
    }
}
