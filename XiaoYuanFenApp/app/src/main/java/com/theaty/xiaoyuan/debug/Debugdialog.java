package com.theaty.xiaoyuan.debug;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.blankj.utilcode.utils.NetworkUtils;
import com.theaty.xiaoyuan.R;

import org.apache.http.util.EncodingUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lixiangyi on 2017/8/21.
 */

public class Debugdialog extends AlertDialog {


    @BindView(R.id.webView_debug)
    WebView webViewDebug;
    @BindView(R.id.title_debug)
    TextView titleDebug;
    @BindView(R.id.dismiss)
    TextView dismiss;
    private TextView no;//取消按钮
    private String data1;
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;
    private ArrayList<String> mData = new ArrayList<>();
    private Activity context;

    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        public void onYesClick(String time, int istoday);
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(onYesOnclickListener onYesOnclickListener) {

        this.yesOnclickListener = onYesOnclickListener;
    }

    public Debugdialog(Context context1, String data) {
        super(context1, R.style.ActionSheetDialogStyle);
        this.context = (Activity) context1;//原代码如果不是继承自BaseActivity的就报错，所以转换为Activity
        this.data1 = data;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        //按空白处不能取消动画
        webViewDebug = (WebView) findViewById(R.id.webView_debug);
//        no  = (TextView)findViewById(R.id.dismiss) ;
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                noOnclickListener.onNoClick();
//            }
//        });
        ButterKnife.bind(this);

        setCanceledOnTouchOutside(true);
        initData();

        initView();
        //初始化界面数据
    }


    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //启用支持javascript
        WebSettings webSettings = webViewDebug.getSettings();
        webSettings.setJavaScriptEnabled(true);//支持javaScript
        webSettings.setDefaultTextEncodingName("utf-8");//设置网页默认编码
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH); //提高渲染的优先级
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);//支持缩放
        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        if (NetworkUtils.isConnected()) {
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
        }

        webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true);   //开启 database storage API 功能
        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        //LogUtils.eMax("Debug 原始数据", data1 + "\n\n");
        String json = "key=" + Base64.encodeToString(data1.getBytes(), Base64.DEFAULT);
        json = json.replaceAll("\\+", "%2B");//替换+号为%2b,否则后台base64字符串的加号为空格，导致无法显示
        //LogUtils.eMax("Debug 加密数据", json.split("=")[1] + "\n\n");
       // LogUtils.eMax("Debug 解密数据", new String(Base64.decode(json.split("=")[1], Base64.DEFAULT)) + "\n\n");
        webViewDebug.postUrl("http://59.110.61.138/Home/Goods/jsonformat", EncodingUtils.getBytes(json, "BASE64"));

    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    @OnClick({R.id.title_debug, R.id.dismiss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_debug:
                break;
            case R.id.dismiss:
                noOnclickListener.onNoClick();
                break;
        }
    }

    public void setNoOnclickListener(onNoOnclickListener onNoOnclickListener) {
        this.noOnclickListener = onNoOnclickListener;
    }


}

