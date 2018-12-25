package com.theaty.xiaoyuan.model.xiaoyuan;
import com.theaty.xiaoyuan.model.BaseModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author Theaty 
 * @desc
 */
public class AdvModel extends BaseModel {
/** 广告自增标识编号' , */
public  int  adv_id;
/** 广告位id' , */
public  int  ap_id;
/** 广告内容描述' , */
public String adv_title;
/** 广告内容' , */
public String adv_content;
/** 广告开始时间' , */
public  int  adv_start_date;
/** 广告结束时间' , */
public  int  adv_end_date;
/** 幻灯片排序' , */
public  int  slide_sort;
/** 会员id' , */
public  int  member_id;
/** 会员用户名' , */
public String member_name;
/** 广告点击率' , */
public  int  click_num;
/** 会员购买的广告是否通过审核0未审核1审核已通过2审核未通过' , */
public  int  is_allow;
/** 购买方式' , */
public String buy_style;
/** 购买所支付的金币' , */
public  int  goldpay;
 /** adv_image' , */
 public String adv_image;
 /** adv_url_or_goodsid' , */
 public String adv_url_or_goodsid;

//初始化默认值 
 public AdvModel() {
adv_id  = 0;//广告自增标识编号' ,
ap_id  = 0;//广告位id' ,
adv_title  = "";//广告内容描述' ,
adv_content  = "";//广告内容' ,
adv_start_date  = 0;//广告开始时间' ,
adv_end_date  = 0;//广告结束时间' ,
slide_sort  = 0;//幻灯片排序' ,
member_id  = 0;//会员id' ,
member_name  = "";//会员用户名' ,
click_num  = 0;//广告点击率' ,
is_allow  = 0;//会员购买的广告是否通过审核0未审核1审核已通过2审核未通过' ,
buy_style  = "";//购买方式' ,
goldpay  = 0;//购买所支付的金币' ,
adv_image = "";
adv_url_or_goodsid = "";

}

}