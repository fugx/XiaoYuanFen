package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.BaseModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Fuguo
 * @desc
 * 活动
 */
@Entity
public class GoodsModel extends BaseModel {
    /**
     * 活动id(sku)' ,
     */
    @Id
    public int goods_id;
    /**
     * 活动公共表id' ,
     */
    public int goods_commonid;
    /**
     * 活动名称（+规格名称）' ,
     */
    public String goods_name;
    /**
     * 活动广告词' ,
     */
    public String goods_jingle;
    /**
     * 活动组织方id' ,
     */
    public int store_id;
    /**
     * 活动组织方名称' ,
     */
    public String store_name;
    /**
     * 活动分类id' ,
     */
    public int gc_id;
    /**
     * 一级分类id' （后台可编辑增改 -- 0：户外；1：市区；2：约会）,
     */
    public int gc_id_1;
    /**
     * 二级分类id'（后台可编辑增改 -- 0：爬山；1：露营；2：玩水；3：徒步；4：休闲；5：滑雪；6：蹦床；7：桌游；8：聚餐 ...） ,
     */
    public int gc_id_2;
    /**
     * 三级分类id' ,TODO 标签集合
     */
    public int gc_id_3;
    /**
     * 品牌id' （活动组织方牌面：领队）,
     */
    public int brand_id;
    /**
     * 活动价格' ,
     */
    public Double goods_price;
    /**
     * 活动促销价格' ,
     */
    public Double goods_promotion_price;
    /**
     * 促销类型 0无促销，1团购，2限时折扣' ,
     */
    public int goods_promotion_type;
    /**
     * 市场价' ,
     */
    public Double goods_marketprice;
    /**
     * 商家编号' ,
     */
    public String goods_serial;
    /**
     * 剩余活动席位' ,
     */
    public int goods_storage_alarm;
    /**
     * 活动点击数量' ,
     */
    public int goods_click;
    /**
     * 销售数量' ,
     */
    public int goods_salenum;
    /**
     * 收藏数量' ,
     */
    public int goods_collect;
    /**
     * 活动规格序列化' ,
     */
    public String goods_spec;
    /**
     * 活动库存' ,
     */
    public int goods_storage;
    /**
     * 活动主图' ,
     */
    public String goods_image;
    /**
     * 活动状态 过期，1正常，10违规（禁售）' ,
     */
    public int goods_state;
    /**
     * 活动审核 1通过，0未通过，10审核中' ,
     */
    public int goods_verify;
    /**
     * 活动添加时间' ,
     */
    public int goods_addtime;
    /**
     * 活动编辑时间' ,
     */
    public int goods_edittime;
    /**
     * 活动地区' ,
     */
    public String goodsClass;
    /**
     * 一级地区id' ,
     */
    public int areaid_1;
    /**
     * 二级地区id' ,
     */
    public int areaid_2;
    /**
     * 活动强度规格id' ,
     */
    public int color_id;
    /**
     * 运费模板id' ,
     */
    public int transport_id;
    /**
     * 保险费 0为免费' ,
     */
    public Double goods_freight;
    /**
     * 是否开具增值税发票 1是，0否' ,
     */
    public int goods_vat;
    /**
     * 活动推荐 1是，0否 默认0' ,
     */
    public int goods_commend;
    /**
     * 店铺分类id 首尾用,隔开' ,
     */
    public String goods_stcids;
    /**
     * 好评星级' ,
     */
    public int evaluation_good_star;
    /**
     * 评价数' ,
     */
    public int evaluation_count;
    /**
     * 是否为虚拟活动 1是，0否' ,
     */
    public int is_virtual;
    /**
     * 虚拟活动有效期' ,
     */
    public int virtual_indate;
    /**
     * 虚拟活动购买上限' ,
     */
    public int virtual_limit;
    /**
     * 是否允许退款， 1是，0否' ,
     */
    public int virtual_invalid_refund;
    /**
     * 是否为f码活动 1是，0否' ,
     */
//    public int is_fcode;
    /**
     * 是否是预约活动 1是，0否' ,
     */
    public int is_appoint;
    /**
     * 是否是预售活动 1是，0否' ,
     */
    public int is_presell;
    /**
     * 是否拥有赠品' ,
     */
    public int have_gift;
    /**
     * 是否为平台自营' ,
     */
    public int is_own_shop;
    /**
     * 类型（1动画2视频3教师4充值）' ,
     */
//    public int goods_type;
    /**
     * 活动开始时间' ,
     */
    public int class_time;
    /**
     * 活动开始时间' ,
     */
    public Date goodTime;
    /**
     * 活动结束时间' ,
     */
    public int class_end;
    /**
     * 视频' ,
     */
    public String video_name;
    /**
     * 音频' ,
     */
    public String audio_name;
    /**
     * 图片' ,
     */
    public String goods_href;
    /**
     * 活动引用url' ,
     */
    public String goods_url;
    /**
     * 分类' ,
     */
//    public String gc_name;
    /**
     * 是否已收藏关注' ,
     */
    public int is_fav;

    /**
     * 标签,
     */
//    private List<AttributeModel> attr_value = new ArrayList<AttributeModel>();

    /**
     * 参加的用户' ,
     */
//    public MemberModel member_info;
//    private List<MemberModel> member_infos = new ArrayList<MemberModel>();
//
//    public List<MemberModel> getMemberModel() {
//        return member_infos;
//    }


    //初始化默认值
    public GoodsModel() {
        goods_id = 0;//活动id(sku)' ,
        goods_commonid = 0;//活动公共表id' ,
        goods_name = "";//活动名称（+规格名称）' ,
        goods_jingle = "";//活动广告词' ,
        store_id = 0;//店铺id' ,
        store_name = "";//店铺名称' ,
        gc_id = 0;//活动分类id' ,
        gc_id_1 = 0;//一级分类id' ,
        gc_id_2 = 0;//二级分类id' ,
        gc_id_3 = 0;//三级分类id' ,
        brand_id = 0;//品牌id' ,
        goods_price = 0.0;//活动价格' ,
        goods_promotion_price = 0.0;//活动促销价格' ,
        goods_promotion_type = 0;//促销类型 0无促销，1团购，2限时折扣' ,
        goods_marketprice = 0.0;//市场价' ,
        goods_serial = "";//商家编号' ,
        goods_storage_alarm = 0;//库存报警值' ,
        goods_click = 0;//活动点击数量' ,
        goods_salenum = 0;//销售数量' ,
        goods_collect = 0;//收藏数量' ,
        goods_spec = "";//活动规格序列化' ,
        goods_storage = 0;//活动库存' ,
        goods_image = "";//活动主图' ,
        goods_state = 0;//活动状态 0下架，1正常，10违规（禁售）' ,
        goods_verify = 0;//活动审核 1通过，0未通过，10审核中' ,
        goods_addtime = 0;//活动添加时间' ,
        goods_edittime = 0;//活动编辑时间' ,
        areaid_1 = 0;//一级地区id' ,
        areaid_2 = 0;//二级地区id' ,
        color_id = 0;//颜色规格id' ,
        transport_id = 0;//运费模板id' ,
        goods_freight = 0.0;//运费 0为免运费' ,
        goods_vat = 0;//是否开具增值税发票 1是，0否' ,
        goods_commend = 0;//活动推荐 1是，0否 默认0' ,
        goods_stcids = "";//店铺分类id 首尾用,隔开' ,
        evaluation_good_star = 0;//好评星级' ,
        evaluation_count = 0;//评价数' ,
        is_virtual = 0;//是否为虚拟活动 1是，0否' ,
        virtual_indate = 0;//虚拟活动有效期' ,
        virtual_limit = 0;//虚拟活动购买上限' ,
        virtual_invalid_refund = 0;//是否允许过期退款， 1是，0否' ,
//        is_fcode = 0;//是否为f码活动 1是，0否' ,
        is_appoint = 0;//是否是预约活动 1是，0否' ,
        is_presell = 0;//是否是预售活动 1是，0否' ,
        have_gift = 0;//是否拥有赠品' ,
        is_own_shop = 0;//是否为平台自营' ,
//        goods_type = 0;//类型（1动画2视频3教师4充值）' ,
        class_time = 0;//课程开始时间' ,
        class_end = 0;//课程结束时间' ,
        video_name = "";//视频' ,
        audio_name = "";//音频' ,
        goods_url = "";//图片' ,
        goods_href = "";//动画url' ,
//        gc_name = "";//' ,
//        member_info = new MemberModel();//教师信息
//        is_fav = 0;//收藏
    }

    @Generated(hash = 1367784358)
    public GoodsModel(int goods_id, int goods_commonid, String goods_name,
            String goods_jingle, int store_id, String store_name, int gc_id,
            int gc_id_1, int gc_id_2, int gc_id_3, int brand_id, Double goods_price,
            Double goods_promotion_price, int goods_promotion_type,
            Double goods_marketprice, String goods_serial, int goods_storage_alarm,
            int goods_click, int goods_salenum, int goods_collect,
            String goods_spec, int goods_storage, String goods_image,
            int goods_state, int goods_verify, int goods_addtime,
            int goods_edittime, String goodsClass, int areaid_1, int areaid_2,
            int color_id, int transport_id, Double goods_freight, int goods_vat,
            int goods_commend, String goods_stcids, int evaluation_good_star,
            int evaluation_count, int is_virtual, int virtual_indate,
            int virtual_limit, int virtual_invalid_refund, int is_appoint,
            int is_presell, int have_gift, int is_own_shop, int class_time,
            Date goodTime, int class_end, String video_name, String audio_name,
            String goods_href, String goods_url, int is_fav) {
        this.goods_id = goods_id;
        this.goods_commonid = goods_commonid;
        this.goods_name = goods_name;
        this.goods_jingle = goods_jingle;
        this.store_id = store_id;
        this.store_name = store_name;
        this.gc_id = gc_id;
        this.gc_id_1 = gc_id_1;
        this.gc_id_2 = gc_id_2;
        this.gc_id_3 = gc_id_3;
        this.brand_id = brand_id;
        this.goods_price = goods_price;
        this.goods_promotion_price = goods_promotion_price;
        this.goods_promotion_type = goods_promotion_type;
        this.goods_marketprice = goods_marketprice;
        this.goods_serial = goods_serial;
        this.goods_storage_alarm = goods_storage_alarm;
        this.goods_click = goods_click;
        this.goods_salenum = goods_salenum;
        this.goods_collect = goods_collect;
        this.goods_spec = goods_spec;
        this.goods_storage = goods_storage;
        this.goods_image = goods_image;
        this.goods_state = goods_state;
        this.goods_verify = goods_verify;
        this.goods_addtime = goods_addtime;
        this.goods_edittime = goods_edittime;
        this.goodsClass = goodsClass;
        this.areaid_1 = areaid_1;
        this.areaid_2 = areaid_2;
        this.color_id = color_id;
        this.transport_id = transport_id;
        this.goods_freight = goods_freight;
        this.goods_vat = goods_vat;
        this.goods_commend = goods_commend;
        this.goods_stcids = goods_stcids;
        this.evaluation_good_star = evaluation_good_star;
        this.evaluation_count = evaluation_count;
        this.is_virtual = is_virtual;
        this.virtual_indate = virtual_indate;
        this.virtual_limit = virtual_limit;
        this.virtual_invalid_refund = virtual_invalid_refund;
        this.is_appoint = is_appoint;
        this.is_presell = is_presell;
        this.have_gift = have_gift;
        this.is_own_shop = is_own_shop;
        this.class_time = class_time;
        this.goodTime = goodTime;
        this.class_end = class_end;
        this.video_name = video_name;
        this.audio_name = audio_name;
        this.goods_href = goods_href;
        this.goods_url = goods_url;
        this.is_fav = is_fav;
    }

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_commonid() {
        return this.goods_commonid;
    }

    public void setGoods_commonid(int goods_commonid) {
        this.goods_commonid = goods_commonid;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_jingle() {
        return this.goods_jingle;
    }

    public void setGoods_jingle(String goods_jingle) {
        this.goods_jingle = goods_jingle;
    }

    public int getStore_id() {
        return this.store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return this.store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getGc_id() {
        return this.gc_id;
    }

    public void setGc_id(int gc_id) {
        this.gc_id = gc_id;
    }

    public int getGc_id_1() {
        return this.gc_id_1;
    }

    public void setGc_id_1(int gc_id_1) {
        this.gc_id_1 = gc_id_1;
    }

    public int getGc_id_2() {
        return this.gc_id_2;
    }

    public void setGc_id_2(int gc_id_2) {
        this.gc_id_2 = gc_id_2;
    }

    public int getGc_id_3() {
        return this.gc_id_3;
    }

    public void setGc_id_3(int gc_id_3) {
        this.gc_id_3 = gc_id_3;
    }

    public int getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Double getGoods_price() {
        return this.goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public Double getGoods_promotion_price() {
        return this.goods_promotion_price;
    }

    public void setGoods_promotion_price(Double goods_promotion_price) {
        this.goods_promotion_price = goods_promotion_price;
    }

    public int getGoods_promotion_type() {
        return this.goods_promotion_type;
    }

    public void setGoods_promotion_type(int goods_promotion_type) {
        this.goods_promotion_type = goods_promotion_type;
    }

    public Double getGoods_marketprice() {
        return this.goods_marketprice;
    }

    public void setGoods_marketprice(Double goods_marketprice) {
        this.goods_marketprice = goods_marketprice;
    }

    public String getGoods_serial() {
        return this.goods_serial;
    }

    public void setGoods_serial(String goods_serial) {
        this.goods_serial = goods_serial;
    }

    public int getGoods_storage_alarm() {
        return this.goods_storage_alarm;
    }

    public void setGoods_storage_alarm(int goods_storage_alarm) {
        this.goods_storage_alarm = goods_storage_alarm;
    }

    public int getGoods_click() {
        return this.goods_click;
    }

    public void setGoods_click(int goods_click) {
        this.goods_click = goods_click;
    }

    public int getGoods_salenum() {
        return this.goods_salenum;
    }

    public void setGoods_salenum(int goods_salenum) {
        this.goods_salenum = goods_salenum;
    }

    public int getGoods_collect() {
        return this.goods_collect;
    }

    public void setGoods_collect(int goods_collect) {
        this.goods_collect = goods_collect;
    }

    public String getGoods_spec() {
        return this.goods_spec;
    }

    public void setGoods_spec(String goods_spec) {
        this.goods_spec = goods_spec;
    }

    public int getGoods_storage() {
        return this.goods_storage;
    }

    public void setGoods_storage(int goods_storage) {
        this.goods_storage = goods_storage;
    }

    public String getGoods_image() {
        return this.goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public int getGoods_state() {
        return this.goods_state;
    }

    public void setGoods_state(int goods_state) {
        this.goods_state = goods_state;
    }

    public int getGoods_verify() {
        return this.goods_verify;
    }

    public void setGoods_verify(int goods_verify) {
        this.goods_verify = goods_verify;
    }

    public int getGoods_addtime() {
        return this.goods_addtime;
    }

    public void setGoods_addtime(int goods_addtime) {
        this.goods_addtime = goods_addtime;
    }

    public int getGoods_edittime() {
        return this.goods_edittime;
    }

    public void setGoods_edittime(int goods_edittime) {
        this.goods_edittime = goods_edittime;
    }

    public int getAreaid_1() {
        return this.areaid_1;
    }

    public void setAreaid_1(int areaid_1) {
        this.areaid_1 = areaid_1;
    }

    public int getAreaid_2() {
        return this.areaid_2;
    }

    public void setAreaid_2(int areaid_2) {
        this.areaid_2 = areaid_2;
    }

    public int getColor_id() {
        return this.color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public int getTransport_id() {
        return this.transport_id;
    }

    public void setTransport_id(int transport_id) {
        this.transport_id = transport_id;
    }

    public Double getGoods_freight() {
        return this.goods_freight;
    }

    public void setGoods_freight(Double goods_freight) {
        this.goods_freight = goods_freight;
    }

    public int getGoods_vat() {
        return this.goods_vat;
    }

    public void setGoods_vat(int goods_vat) {
        this.goods_vat = goods_vat;
    }

    public int getGoods_commend() {
        return this.goods_commend;
    }

    public void setGoods_commend(int goods_commend) {
        this.goods_commend = goods_commend;
    }

    public String getGoods_stcids() {
        return this.goods_stcids;
    }

    public void setGoods_stcids(String goods_stcids) {
        this.goods_stcids = goods_stcids;
    }

    public int getEvaluation_good_star() {
        return this.evaluation_good_star;
    }

    public void setEvaluation_good_star(int evaluation_good_star) {
        this.evaluation_good_star = evaluation_good_star;
    }

    public int getEvaluation_count() {
        return this.evaluation_count;
    }

    public void setEvaluation_count(int evaluation_count) {
        this.evaluation_count = evaluation_count;
    }

    public int getIs_virtual() {
        return this.is_virtual;
    }

    public void setIs_virtual(int is_virtual) {
        this.is_virtual = is_virtual;
    }

    public int getVirtual_indate() {
        return this.virtual_indate;
    }

    public void setVirtual_indate(int virtual_indate) {
        this.virtual_indate = virtual_indate;
    }

    public int getVirtual_limit() {
        return this.virtual_limit;
    }

    public void setVirtual_limit(int virtual_limit) {
        this.virtual_limit = virtual_limit;
    }

    public int getVirtual_invalid_refund() {
        return this.virtual_invalid_refund;
    }

    public void setVirtual_invalid_refund(int virtual_invalid_refund) {
        this.virtual_invalid_refund = virtual_invalid_refund;
    }

    public int getIs_appoint() {
        return this.is_appoint;
    }

    public void setIs_appoint(int is_appoint) {
        this.is_appoint = is_appoint;
    }

    public int getIs_presell() {
        return this.is_presell;
    }

    public void setIs_presell(int is_presell) {
        this.is_presell = is_presell;
    }

    public int getHave_gift() {
        return this.have_gift;
    }

    public void setHave_gift(int have_gift) {
        this.have_gift = have_gift;
    }

    public int getIs_own_shop() {
        return this.is_own_shop;
    }

    public void setIs_own_shop(int is_own_shop) {
        this.is_own_shop = is_own_shop;
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

    public String getVideo_name() {
        return this.video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getAudio_name() {
        return this.audio_name;
    }

    public void setAudio_name(String audio_name) {
        this.audio_name = audio_name;
    }

    public String getGoods_href() {
        return this.goods_href;
    }

    public void setGoods_href(String goods_href) {
        this.goods_href = goods_href;
    }

    public int getIs_fav() {
        return this.is_fav;
    }

    public void setIs_fav(int is_fav) {
        this.is_fav = is_fav;
    }

    public Date getGoodTime() {
        return this.goodTime;
    }

    public void setGoodTime(Date goodTime) {
        this.goodTime = goodTime;
    }

    public String getGoodsClass() {
        return this.goodsClass;
    }

    public void setGoodsClass(String goodsClass) {
        this.goodsClass = goodsClass;
    }

    public String getGoods_url() {
        return this.goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }


}