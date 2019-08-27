package com.theaty.xiaoyuan.debug;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.theaty.xiaoyuan.model.adapter.ThtGosn;
import com.theaty.xiaoyuan.system.DatasStore;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

import java.util.List;


/**
 * Created by Administrator on 2017/9/17.
 */

public class HttpUtilNew extends HttpUtils {
    private boolean DebugSigame_flag=false;
    public HttpUtilNew(int connTimeout) {
        //悬浮按钮类.init(this);  application  contenxt
        super(connTimeout);

    }


    @Override
    public <T> HttpHandler<T> send(HttpRequest.HttpMethod method, String url, RequestParams params, RequestCallBack<T> callBack) {

            if (DatasStore.getDebugState()==1) {
                DebugUtil.method1 = method ;
             HttpEntity ss =  params.getEntity();
              List<NameValuePair> ss2 =   params.getQueryStringParams() ;
                if (params!=null&& params.getEntity()!=null) {
                    DebugUtil.params1=  (ThtGosn.genGson()).toJson( (ThtGosn.genGson()).fromJson ( (ThtGosn.genGson()).toJson( params.getEntity()), DebugModel.class).params );
                }
                DebugUtil.url1 = url;

        }


        return super.send(method, url, params, callBack);
    }
}
