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
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.GoodsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.MainActivity;
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
    RecyclerView videoRecycleView;
    @BindView(R.id.rview_city_play)
    RecyclerView animationRecycleView;
    @BindView(R.id.rview_tryst)
    RecyclerView teacherRecycleView;
    @BindView(R.id.super_swipe_view)
    SuperSwipeRefreshLayout superSwipeView;

    @BindView(R.id.banner_guide_content)
    BGABanner mContentBanner;

    private ArrayList<GoodsModel> outdoors = new ArrayList<>();
    private ArrayList<GoodsModel> cityPlays  = new ArrayList<>();
    private ArrayList<GoodsModel> trysts  = new ArrayList<>();

    private MainActivity activity;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

//    AnimationAdapter animationAdapter;
//    VideoAdapter videoAdapter;

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.home_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        activity = (MainActivity)getActivity();

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
//        activity.registerReceiver(networkChangeReceiver,intentFilter);
//
//        superSwipeView.setVisibility(View.VISIBLE);

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
         * 拓展课程
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        videoRecycleView.setLayoutManager(layoutManager);
//        videoAdapter = new VideoAdapter(getActivity(),R.layout.item_video, videoLists);
//        videoRecycleView.setAdapter(videoAdapter);
//
//        videoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                GoodsModel good = videoAdapter.getData().get(position);
//                activity.course = good;
//                Intent intent = new Intent(getContext(), VideoDetailActivity.class);
//                intent.putExtra("good", good);
//                startActivity(intent);
//            }
//        });
//        videoAdapter.setEmptyView(initEmptyView("无推荐课程"));

        /*
         * 基础课程
         */
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
//        animationRecycleView.setLayoutManager(layoutManager1);
//        animationAdapter = new AnimationAdapter(getActivity(),R.layout.item_animation, animationLists);
//        animationRecycleView.setAdapter(animationAdapter);
//        animationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                GoodsModel good = animationAdapter.getData().get(position);
//                activity.course = good;
//                Intent intent = new Intent(getContext(), AnimationDetailActivity.class);
//                intent.putExtra("good", good);
//                startActivity(intent);
//            }
//        });
//        animationAdapter.setEmptyView(initEmptyView("无推荐课程"));

        /*
         * 外教一对一
         */
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
//        teacherRecycleView.setLayoutManager(layoutManager2);
//        teacherAdapter = new GoodTeacherAdapter(getActivity(),R.layout.item_good_teacher, teacherLists);
//        teacherRecycleView.setAdapter(teacherAdapter);
//        teacherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                MemberModel member = teacherAdapter.getData().get(position);
//                Intent intent = new Intent(getContext(), TeacherDetailActivity.class);
//                intent.putExtra("member", member);
//                startActivity(intent);
//            }
//        });
//        teacherAdapter.setEmptyView(initEmptyView("无推荐教师"));
    }

    public void getData() {
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

//    CourseFragment fragment ;
//
//    @OnClick({R.id.ig_sign_up,R.id.ig_message,R.id.tv_video_more,R.id.tv_animation_more,R.id.tv_teacher_more})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.ig_sign_up:
//                if (DatasStore.isLogin()) {
//                    SignUpActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.ig_message:
//                if (DatasStore.isLogin()) {
//                    MessageActivity.into(getContext());
//                } else {
//                    LoginActivity.into(getContext());
//                }
//                break;
//
//            case R.id.tv_video_more:
//                activity.enableTabItem(1);
//                activity.selectPage(1);
//                //activity选中的fragment
//                fragment = (CourseFragment) activity.targetFragment;
//                if(fragment.orderRg==null){
//                    turnTo(1);
//                }else{
//                    ((RadioButton)fragment.orderRg.getChildAt(1)).setChecked(true);
//                }
//                break;
//
//            case R.id.tv_animation_more:
//                activity.enableTabItem(1);
//                activity.selectPage(1);
//                fragment = (CourseFragment) activity.targetFragment;
//                if(fragment.orderRg==null){
//                    turnTo(0);
//                }else{
//                    ((RadioButton)fragment.orderRg.getChildAt(0)).setChecked(true);
//                }
//                break;
//
//            case R.id.tv_teacher_more:
//                activity.enableTabItem(1);
//                activity.selectPage(1);
//                fragment = (CourseFragment) activity.targetFragment;
//                if(fragment.orderRg==null){
//                    turnTo(2);
//                }else{
//                    ((RadioButton)fragment.orderRg.getChildAt(2)).setChecked(true);
//                }
//                break;
//        }
//    }

    //跳转至
//    private void turnTo(final int n){
//        fragment.setChangeListener(new CourseFragment.ChangeListener() {
//            @Override
//            public void changeIndex() {
//                ((RadioButton)fragment.orderRg.getChildAt(n)).setChecked(true);
//            }
//        });
//    }

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
