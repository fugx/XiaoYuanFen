package com.theaty.xiaoyuan.model.xiaoyuan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.theaty.xiaoyuan.debug.DebugUtil;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.adapter.ThtGosn;
import com.theaty.xiaoyuan.system.DatasStore;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;

import foundation.log.LogUtils;
import payment.wxpay.WXPayInfo;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Yecal on 2018/12/12.
 */
@Entity
public class PaymentModel extends BaseModel {
    /**
     * 支付索引id' ,
     */
    @Id
    public int payment_id;
    /**
     * 支付索引id' ,
     */
    public int order_id;
    /**
     * 支付代码名称' ,
     */
    public String payment_code;
    /**
     * 支付名称' ,
     */
    public String payment_name;
    /**
     * 支付接口配置信息' ,
     */
    public String payment_config;
    /**
     * 接口状态0禁用1启用' ,
     */
    public int payment_state;
    /**
     * 订单信息' ,
     */
    public String order_info;
    /**
     * 支付签名' ,
     */
    public String sign;


    //初始化默认值
    public PaymentModel() {
        payment_id = 0;//支付索引id' ,
        order_id = 0;//支付索引id' ,
        payment_code = "";//支付代码名称' ,
        payment_name = "";//支付名称' ,
        payment_config = "";//支付接口配置信息' ,
        payment_state = 0;//接口状态0禁用1启用' ,
        order_info = "";//订单信息' ,
        sign = "";//支付签名' ,
    }


    @Generated(hash = 930608869)
    public PaymentModel(int payment_id, int order_id, String payment_code, String payment_name, String payment_config, int payment_state, String order_info,
            String sign) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.payment_code = payment_code;
        this.payment_name = payment_name;
        this.payment_config = payment_config;
        this.payment_state = payment_state;
        this.order_info = order_info;
        this.sign = sign;
    }


    public int getPayment_id() {
        return this.payment_id;
    }


    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }


    public int getOrder_id() {
        return this.order_id;
    }


    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }


    public String getPayment_code() {
        return this.payment_code;
    }


    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }


    public String getPayment_name() {
        return this.payment_name;
    }


    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }


    public String getPayment_config() {
        return this.payment_config;
    }


    public void setPayment_config(String payment_config) {
        this.payment_config = payment_config;
    }


    public int getPayment_state() {
        return this.payment_state;
    }


    public void setPayment_state(int payment_state) {
        this.payment_state = payment_state;
    }


    public String getOrder_info() {
        return this.order_info;
    }


    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }


    public String getSign() {
        return this.sign;
    }


    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 可用支付参数列表
     *
     * @param key
     * @param bib
     */
//    public void payment_list(String key, final BaseModel.BaseModelIB bib) {
//        String url = buildGetUrl("MemberPayment", "payment_list");// 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError:" + "payment_list 参数bib为null");// 回调不能为空
//
//        BIBStart(bib);// 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) {// 成功
//                    ArrayList<PaymentModel> gm = (new Gson()).fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<PaymentModel>>() {
//                    }.getType());
//                    BIBSucessful(bib, gm);
//                } else {// 失败
//                    BIBFailed(bib, rm);// 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时"));// 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }

    /**
     * 微信统一下单
     *
     * @param key
     * @param body           商品描述
     * @param pay_sn         支付编号
     * @param order_sn       订单编号(立即支付时传空)
     * @param api_pay_amount 应付金额
     * @param bib
     */
//    public void wxunifiedorder(String key, String body, String pay_sn, String order_sn, int api_pay_amount, final BaseModel.BaseModelIB bib) {
//        String url = buildGetUrl("MemberPayment", "wxunifiedorder");// 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError:" + "wxunifiedorder 参数bib为null");// 回调不能为空
//
//        BIBStart(bib);// 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("body", body);
//        params.addBodyParameter("pay_sn", pay_sn);
//        params.addBodyParameter("order_sn", order_sn);
//        params.addBodyParameter("api_pay_amount", String.valueOf(api_pay_amount));
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) {// 成功
//                    WXPayInfo gm = ThtGosn.genGson().fromJson(rm.getJsonDatas(), WXPayInfo.class);
//                    BIBSucessful(bib, gm);
//                } else {// 失败
//                    BIBFailed(bib, rm);// 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时"));// 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }


    /**
     * 生成支付签名
     *
     * @param key
     * @param order_info 商品描述
     * @param bib
     */
//    public void create_sign(String key, String order_info, final BaseModel.BaseModelIB bib) {
//        String url = buildGetUrl("MemberPayment", "create_sign");// 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError:" + "create_sign 参数bib为null");// 回调不能为空
//
//        BIBStart(bib);// 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("order_info", order_info);
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) {// 成功
//                    PaymentModel paymentModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), PaymentModel.class);
//                    BIBSucessful(bib, paymentModel);
//                } else {// 失败
//                    BIBFailed(bib, rm);// 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时"));// 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }

    /**
     * 显示实物订单支付信息
     *
     * @param key key值
     * @param bib
     */
//    public void showpay(String key, String pay_sn, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberPayment", "showpay"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "showpay"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("pay_sn", pay_sn);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    OrderGoodsModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), OrderGoodsModel.class);
//                    BIBSucessful(bib, orderModels);
//                } else {// 失败
//                    BIBFailed(bib, rm); // 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }

    /**
     * 预约课程下单
     *
     * @param key  key值
     * @param goods_id  商品ID多个逗号
     * @param relation_goods_id  聊天课程
     * @param chat_topic  聊天话题
     * @param payment_code  支付方式
     * @param bib
     */
//    public void order_add(String key, String goods_id, String relation_goods_id,String chat_topic,final String payment_code, final BaseModel.BaseModelIB bib) {
//        String url = buildGetUrl("MemberIndex", "order_add");// 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError:" + "pd_recharge_add_pay 参数bib为null");// 回调不能为空
//
//        BIBStart(bib);// 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("goods_id", goods_id);
//        params.addBodyParameter("relation_goods_id", relation_goods_id);
//        params.addBodyParameter("chat_topic", chat_topic);
//        params.addBodyParameter("payment_code", payment_code);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) {// 成功
//                    if(payment_code.equals("alipay")){
//                        PaymentModel paymentModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), PaymentModel.class);
//                        BIBSucessful(bib, paymentModel);
//                    }else{
//                        WXPayInfo gm = ThtGosn.genGson().fromJson(rm.getJsonDatas(), WXPayInfo.class);
//                        BIBSucessful(bib, gm);
//                    }
//                } else {// 失败
//                    BIBFailed(bib, rm);// 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时"));// 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }

    /**
     * 取消订单
     *
     * @param key  key值
     * @param order_id  订单ID
     * @param bib
     */
//    public void order_cancel(String key, String order_id, final BaseModel.BaseModelIB bib) {
//        String url = buildGetUrl("MemberOrder", "order_cancel");// 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError:" + "pd_recharge_add_pay 参数bib为null");// 回调不能为空
//
//        BIBStart(bib);// 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("order_id", order_id);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    BIBSucessful(bib, rm.getStringDatas());
//                } else {// 失败
//                    BIBFailed(bib, rm); // 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时"));// 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }

    /**
     * 充值
     *
     * @param key key值
     * @param vip_id 充值ID
     * @param pdr_payment_code 支付方式
     * @param bib
     */
//    public void member_addvip(String key,String vip_id,final String pdr_payment_code, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberVip", "member_addvip"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("vip_id", vip_id);
//        params.addBodyParameter("pdr_payment_code", pdr_payment_code);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    if(pdr_payment_code.equals("alipay")){
//                        PaymentModel paymentModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), PaymentModel.class);
//                        BIBSucessful(bib, paymentModel);
//                    }else{
//                        WXPayInfo gm = ThtGosn.genGson().fromJson(rm.getJsonDatas(), WXPayInfo.class);
//                        BIBSucessful(bib, gm);
//                    }
//                } else {// 失败
//                    BIBFailed(bib, rm); // 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
}