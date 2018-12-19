package com.theaty.xiaoyuan.ui.lucky.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

//import com.theaty.xiaoyuan.ui.lucky.adapter.HistoryAdapter;
//import com.theaty.xiaoyuan.ui.lucky.adapter.SearchAdapter;

import com.theaty.xiaoyuan.R;

import foundation.base.activity.BaseActivity;
//import foundation.util.Constant;


/**
 * Created by Yecal on 2018/7/26.
 * 搜索页面
 */

public class SearchActivity extends BaseActivity {

//    @BindView(R.id.et_search_content)
//    EditText content;
//    @BindView(R.id.rl_search_history)
//    RelativeLayout history;
//    @BindView(R.id.ll_search_result)
//    RelativeLayout result;
//    @BindView(R.id.rg_order)
//    RadioGroup order;
//    @BindView(R.id.rv_search_history)
//    RecyclerView searchHistory;
//    @BindView(R.id.vp_search_result)
//    ViewPager search_vp;
//
//    private ArrayList<String> histories = new ArrayList<>();
//    private HistoryAdapter historyAdapter;
//    private SearchAdapter searchAdapter;
//    public String signIds = "";
//    public String type = "";
//
    @Override
    protected View onCreateContentView() {
        return inflateContentView(R.layout.activity_search);
    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        initRecyclerView();
//        initListener();
//        getHotHistory();
//
//        signIds = intent.getStringExtra("ids");
//        type = intent.getStringExtra("type");
//        if(!(TextUtils.isEmpty(signIds))){
//            if (type.equals("基础课程")) {
//                doSearch("",0);
////                search_vp.setCurrentItem(0);
//
//            } else if (type.equals("拓展课程")) {
//                doSearch("",1);
////                search_vp.setCurrentItem(1);
//
//            } else if (type.equals("教师")) {
//                doSearch("",2);
////                search_vp.setCurrentItem(2);
//            }
//
//            result.setFocusable(true);
//            result.setFocusableInTouchMode(true);
//            result.requestFocus();
//            result.requestFocusFromTouch();
//        }
//    }
//
//    private void initRecyclerView() {
//        //搜索历史
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        searchHistory.setLayoutManager(linearLayoutManager);
//        historyAdapter = new HistoryAdapter(this,R.layout.item_history, histories);
//        searchHistory.setAdapter(historyAdapter);
//        historyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                String searchContent = ((TextView) view.findViewById(R.id.tv_content)).getText().toString().trim();
//                doSearch(searchContent,0);
//            }
//        });
//    }
//
//    private void initListener() {
//        order.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                RadioButton rb = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
//
//                if (rb.getText().toString().equals("基础课程")) {
//                    search_vp.setCurrentItem(0);
//
//                } else if (rb.getText().toString().equals("拓展课程")) {
//                    search_vp.setCurrentItem(1);
//
//                } else if (rb.getText().toString().equals("教师")) {
//                    search_vp.setCurrentItem(2);
//                }
//            }
//        });
//        search_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                ((RadioButton) order.getChildAt(position)).setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        content.setOnEditorActionListener(new TextView.OnEditorActionListener() {//点击软件盘搜索按钮执行
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_SEARCH)) {
//                    String searchText = content.getText().toString();
//                    goSearch(searchText,0);
//                    return true;
//                }
//                return false;
//            }
//        });
//    }
//
//    public static void start(Context context, String search) {
//        Intent starter = new Intent(context, SearchActivity.class);
//        starter.putExtra("search", search);
//        context.startActivity(starter);
//    }
//
    public static void into(Context context) {
        Intent starter = new Intent(context, SearchActivity.class);
        context.startActivity(starter);
    }
//
//    @OnClick({R.id.ig_search_back, R.id.ig_search_clean, R.id.ig_search_image})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.ig_search_back:
//               finish();
//                break;
//            case R.id.ig_search_clean:
//                if (history.getVisibility() == GONE) {
//                    result.setVisibility(GONE);
//                    history.setVisibility(View.VISIBLE);
//                    content.setText("");
//                    historyAdapter.notifyDataSetChanged();
//                } else {
//                    content.setText("");
//                }
//                break;
//            case R.id.ig_search_image:
//                String searchText = content.getText().toString();
//                goSearch(searchText,0);
//                break;
//        }
//    }
//
//    /**
//     * 获取历史
//     */
//    public void getHotHistory() {
//        ArrayList<String> history = DatasStore.getGoodsSearchHistory();
//        if (history.size() <= 0) {
//            searchHistory.setVisibility(GONE);
//        } else {
//            searchHistory.setVisibility(View.VISIBLE);
//            histories.clear();
//            histories.addAll(history);
//            Collections.reverse(histories);//倒序
//        }
//    }
//
//    private void goSearch(String searchText, int type) {
//        if (TextUtils.isEmpty(searchText)) {
//            ToastUtil.showToast("请输入内容");
//        } else {
//            //保存新搜索的历史
//            saveHistory(searchText);
//            doSearch(searchText,type);
//            //更新历史
//            getHotHistory();
//        }
//    }
//
//    private void doSearch(String searchText, int type) {
//        Constant.search_key = searchText;
//        ((RadioButton) order.getChildAt(type)).setChecked(true);
//        content.setText(searchText);
//        content.setSelection(searchText.length());
//
//        // 点击搜索执行此方法
//        List<String> list = new ArrayList<>();
//        list.add("基础课程");
//        list.add("拓展课程");
//        list.add("教师");
//        searchAdapter = new SearchAdapter(getSupportFragmentManager(), list);
//        search_vp.setAdapter(searchAdapter);
//        search_vp.setCurrentItem(type);
//        result.setVisibility(View.VISIBLE);
//        history.setVisibility(GONE);
//
//        hideSoftInput();
//    }
//
//    private void saveHistory(String searchStr) {
//        for (int i = 0; i < histories.size(); i++) {
//            if (searchStr.equals(histories.get(i))) {
//                DatasStore.removeGoodsSearcHistory(searchStr);
//            }
//        }
//        DatasStore.saveGoodsSearchHistory(searchStr);
//    }
//
//    /**
//     * 隐藏软键盘
//     */
//    void hideSoftInput() {
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        if (imm != null) {
//            imm.hideSoftInputFromWindow(content.getWindowToken(), 0);
//        }
//    }
}
