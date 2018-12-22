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
public class OrderGoodsModel extends BaseModel {
    /**
     * 订单商品表索引id' ,
     */
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

    /**
     * 课程信息
     * rec_id 课程id
     */
    public void order_goods_state(String rec_id, final BaseModelIB bib) {
        String url = buildGetUrl("MemberOrder", "order_goods_state"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "order_goods_state 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("key", DatasStore.getCurMember().key);
        params.addBodyParameter("rec_id", rec_id);

        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    OrderGoodsModel orderGoodsModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), OrderGoodsModel.class);
                    BIBSucessful(bib, orderGoodsModel);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }
}