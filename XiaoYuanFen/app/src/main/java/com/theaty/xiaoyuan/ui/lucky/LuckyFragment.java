package com.theaty.xiaoyuan.ui.lucky;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.ui.MainActivity;

import foundation.base.fragment.BaseFragment;
/**
 * 课程页面
 */
public class LuckyFragment extends BaseFragment {
  
    private MainActivity mainActivity;
    private boolean first = true;//第一次进入页面判断网络变化不加载fragment页面数据

    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.fragment_lucky);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        getData("1");
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public void getData(String type) {

    }

    private void initView() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    private ChangeListener changeListener;

    public interface ChangeListener {
        void changeIndex();
    }

    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null && networkInfo.isAvailable()){
                if(first){
                    first = false;
                } else {

                }
            }
        }
    }
}
