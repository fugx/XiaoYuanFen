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
@Entity
public class AdvModel extends BaseModel {
/** 广告自增标识编号' , */
@Id
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




	@Generated(hash = 536144780)
	public AdvModel(int adv_id, int ap_id, String adv_title, String adv_content,
									int adv_start_date, int adv_end_date, int slide_sort, int member_id,
									String member_name, int click_num, int is_allow, String buy_style,
									int goldpay, String adv_image, String adv_url_or_goodsid) {
					this.adv_id = adv_id;
					this.ap_id = ap_id;
					this.adv_title = adv_title;
					this.adv_content = adv_content;
					this.adv_start_date = adv_start_date;
					this.adv_end_date = adv_end_date;
					this.slide_sort = slide_sort;
					this.member_id = member_id;
					this.member_name = member_name;
					this.click_num = click_num;
					this.is_allow = is_allow;
					this.buy_style = buy_style;
					this.goldpay = goldpay;
					this.adv_image = adv_image;
					this.adv_url_or_goodsid = adv_url_or_goodsid;
	}




	public int getAdv_id() {
					return this.adv_id;
	}




	public void setAdv_id(int adv_id) {
					this.adv_id = adv_id;
	}




	public int getAp_id() {
					return this.ap_id;
	}




	public void setAp_id(int ap_id) {
					this.ap_id = ap_id;
	}




	public String getAdv_title() {
					return this.adv_title;
	}




	public void setAdv_title(String adv_title) {
					this.adv_title = adv_title;
	}




	public String getAdv_content() {
					return this.adv_content;
	}




	public void setAdv_content(String adv_content) {
					this.adv_content = adv_content;
	}




	public int getAdv_start_date() {
					return this.adv_start_date;
	}




	public void setAdv_start_date(int adv_start_date) {
					this.adv_start_date = adv_start_date;
	}




	public int getAdv_end_date() {
					return this.adv_end_date;
	}




	public void setAdv_end_date(int adv_end_date) {
					this.adv_end_date = adv_end_date;
	}




	public int getSlide_sort() {
					return this.slide_sort;
	}




	public void setSlide_sort(int slide_sort) {
					this.slide_sort = slide_sort;
	}




	public int getMember_id() {
					return this.member_id;
	}




	public void setMember_id(int member_id) {
					this.member_id = member_id;
	}




	public String getMember_name() {
					return this.member_name;
	}




	public void setMember_name(String member_name) {
					this.member_name = member_name;
	}




	public int getClick_num() {
					return this.click_num;
	}




	public void setClick_num(int click_num) {
					this.click_num = click_num;
	}




	public int getIs_allow() {
					return this.is_allow;
	}




	public void setIs_allow(int is_allow) {
					this.is_allow = is_allow;
	}




	public String getBuy_style() {
					return this.buy_style;
	}




	public void setBuy_style(String buy_style) {
					this.buy_style = buy_style;
	}




	public int getGoldpay() {
					return this.goldpay;
	}




	public void setGoldpay(int goldpay) {
					this.goldpay = goldpay;
	}




	public String getAdv_image() {
					return this.adv_image;
	}




	public void setAdv_image(String adv_image) {
					this.adv_image = adv_image;
	}




	public String getAdv_url_or_goodsid() {
					return this.adv_url_or_goodsid;
	}




	public void setAdv_url_or_goodsid(String adv_url_or_goodsid) {
					this.adv_url_or_goodsid = adv_url_or_goodsid;
	}


}