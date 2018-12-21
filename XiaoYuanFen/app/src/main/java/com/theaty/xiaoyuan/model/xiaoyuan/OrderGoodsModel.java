package com.theaty.xiaoyuan.model.xiaoyuan;

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

import foundation.log.LogUtils;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Theaty
 * Created by Yecal on 2018/12/12.
 */
@Entity
public class OrderGoodsModel extends BaseModel {
    /**
     * 订单商品表索引id' ,
     */
    @Id
    public int rec_id;
    /**
     * 订单id' ,
     */
    public int order_id;
    /**
     * 商品id' ,
     */
    public int goods_id;
    /**
     * 商品名称' ,
     */
    public String goods_name;
    /**
     * 商品价格' ,
     */
    public Double goods_price;
    /**
     * 商品数量' ,
     */
    public int goods_num;
    /**
     * 商品图片' ,
     */
    public String goods_image;
    /**
     * 商品实际成交价' ,
     */
    public Double goods_pay_price;
    /**
     * 店铺id' ,
     */
    public int store_id;
    /**
     * 买家id' ,
     */
    public int buyer_id;
    /**
     * 1默认2团购商品3限时折扣商品4组合套装5赠品' ,
     */
    public int goods_type;
    /**
     * 促销活动id（团购id/限时折扣id/优惠套装id）与goods_type搭配使用' ,
     */
    public int promotions_id;
    /**
     * 佣金比例' ,
     */
    public int commis_rate;
    /**
     * 商品最底级分类id' ,
     */
    public int gc_id;
    /**
     * 类型（1动画2视频3教师4充值）' ,
     */
    public int order_type;
    /**
     * 聊天课程' ,
     */
    public int relation_goods_id;
    /**
     * 聊天话题' ,
     */
    public String chat_topic;
    /**
     * 用户' ,
     */
//    public MemberModel member_info;
    /**
     * 预约时间' ,
     */
    public String date;
    /**
     * 开始时间' ,
     */
    public int class_time;
    /**
     * 结束时间' ,
     */
    public int class_end;
    /**
     * 订单金额' ,
     */
    public Double order_amount;
    /**
     * 聊天主题' ,
     */
//    public GoodsModel relation_goods;
    /**
     * 商品状态 1结束
     */
    public int order_goods_state;
    /**
     * 是否评价 1已经评价
     */
    public int eva_state;

    //初始化默认值
    public OrderGoodsModel() {
        rec_id = 0;//订单商品表索引id' ,
        order_id = 0;//订单id' ,
        goods_id = 0;//商品id' ,
        goods_name = "";//商品名称' ,
        goods_price = 0.0;//商品价格' ,
        goods_num = 0;//商品数量' ,
        goods_image = "";//商品图片' ,
        goods_pay_price = 0.0;//商品实际成交价' ,
        store_id = 0;//店铺id' ,
        buyer_id = 0;//买家id' ,
        goods_type = 0;//1默认2团购商品3限时折扣商品4组合套装5赠品' ,
        promotions_id = 0;//促销活动id（团购id/限时折扣id/优惠套装id）与goods_type搭配使用' ,
        commis_rate = 0;//佣金比例' ,
        gc_id = 0;//商品最底级分类id' ,
        order_type = 0;//类型（1动画2视频3教师4充值）' ,
        relation_goods_id = 0;//聊天课程' ,
        chat_topic = "";//聊天话题' ,
//        member_info = new MemberModel();//用户信息
//        relation_goods = new GoodsModel();//聊天主题
        date = "";//预约时间
        class_time = 0;//开始时间
        class_end = 0;//结束时间
        order_amount = 0.0;//订单金额
        eva_state = 0;//是否已经评价
    }

    @Generated(hash = 60169185)
    public OrderGoodsModel(int rec_id, int order_id, int goods_id, String goods_name, Double goods_price, int goods_num,
            String goods_image, Double goods_pay_price, int store_id, int buyer_id, int goods_type, int promotions_id,
            int commis_rate, int gc_id, int order_type, int relation_goods_id, String chat_topic, String date, int class_time,
            int class_end, Double order_amount, int order_goods_state, int eva_state) {
        this.rec_id = rec_id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_num = goods_num;
        this.goods_image = goods_image;
        this.goods_pay_price = goods_pay_price;
        this.store_id = store_id;
        this.buyer_id = buyer_id;
        this.goods_type = goods_type;
        this.promotions_id = promotions_id;
        this.commis_rate = commis_rate;
        this.gc_id = gc_id;
        this.order_type = order_type;
        this.relation_goods_id = relation_goods_id;
        this.chat_topic = chat_topic;
        this.date = date;
        this.class_time = class_time;
        this.class_end = class_end;
        this.order_amount = order_amount;
        this.order_goods_state = order_goods_state;
        this.eva_state = eva_state;
    }

    public int getRec_id() {
        return this.rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_price() {
        return this.goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_num() {
        return this.goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_image() {
        return this.goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public Double getGoods_pay_price() {
        return this.goods_pay_price;
    }

    public void setGoods_pay_price(Double goods_pay_price) {
        this.goods_pay_price = goods_pay_price;
    }

    public int getStore_id() {
        return this.store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getBuyer_id() {
        return this.buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getGoods_type() {
        return this.goods_type;
    }

    public void setGoods_type(int goods_type) {
        this.goods_type = goods_type;
    }

    public int getPromotions_id() {
        return this.promotions_id;
    }

    public void setPromotions_id(int promotions_id) {
        this.promotions_id = promotions_id;
    }

    public int getCommis_rate() {
        return this.commis_rate;
    }

    public void setCommis_rate(int commis_rate) {
        this.commis_rate = commis_rate;
    }

    public int getGc_id() {
        return this.gc_id;
    }

    public void setGc_id(int gc_id) {
        this.gc_id = gc_id;
    }

    public int getOrder_type() {
        return this.order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }

    public int getRelation_goods_id() {
        return this.relation_goods_id;
    }

    public void setRelation_goods_id(int relation_goods_id) {
        this.relation_goods_id = relation_goods_id;
    }

    public String getChat_topic() {
        return this.chat_topic;
    }

    public void setChat_topic(String chat_topic) {
        this.chat_topic = chat_topic;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getClass_time() {
        return this.class_time;
    }

    public void setClass_time(int class_time) {
        this.class_time = class_time;
    }

    public int getClass_end() {
        return this.class_end;
    }

    public void setClass_end(int class_end) {
        this.class_end = class_end;
    }

    public Double getOrder_amount() {
        return this.order_amount;
    }

    public void setOrder_amount(Double order_amount) {
        this.order_amount = order_amount;
    }

    public int getOrder_goods_state() {
        return this.order_goods_state;
    }

    public void setOrder_goods_state(int order_goods_state) {
        this.order_goods_state = order_goods_state;
    }

    public int getEva_state() {
        return this.eva_state;
    }

    public void setEva_state(int eva_state) {
        this.eva_state = eva_state;
    }

    /**
     * 课程信息
     * rec_id 课程id
     */
//    public void order_goods_state(String rec_id, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberOrder", "order_goods_state"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "order_goods_state 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//
//        params.addBodyParameter("key", DatasStore.getCurMember().key);
//        params.addBodyParameter("rec_id", rec_id);
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    OrderGoodsModel orderGoodsModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), OrderGoodsModel.class);
//                    BIBSucessful(bib, orderGoodsModel);
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