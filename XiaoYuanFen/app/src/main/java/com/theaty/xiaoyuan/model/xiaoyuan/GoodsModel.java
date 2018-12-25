package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.BaseModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;

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
    public String goods_image_url;
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
    public MemberModel member_info;
    private List<MemberModel> member_infos = new ArrayList<MemberModel>();

    public List<MemberModel> getMemberModel() {
        return member_infos;
    }


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
        goods_image_url = "";//图片' ,
        goods_href = "";//动画url' ,
//        gc_name = "";//' ,
        member_info = new MemberModel();//教师信息
//        is_fav = 0;//收藏
    }


}