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
public class EvaluateStoreModel extends BaseModel {
/** 评价id' , */
@Id
public  int  seval_id;
/** 订单id' , */
public  int  seval_orderid;
/** 订单编号' , */
public String seval_orderno;
/** 评价时间' , */
public  int  seval_addtime;
/** 店铺编号' , */
public  int  seval_storeid;
/** 店铺名称' , */
public String seval_storename;
/** 买家编号' , */
public  int  seval_memberid;
/** 买家名称' , */
public String seval_membername;
/** 描述相符评分' , */
public  int  seval_desccredit;
/** 服务态度评分' , */
public  int  seval_servicecredit;
/** 发货速度评分' , */
public  int  seval_deliverycredit;
/** 评价' , */
public String seval_des;
/** 头像' , */
public String member_avatar;




//初始化默认值 
 public EvaluateStoreModel() {
seval_id  = 0;//评价id' ,
seval_orderid  = 0;//订单id' ,
seval_orderno  = "";//订单编号' ,
seval_addtime  = 0;//评价时间' ,
seval_storeid  = 0;//店铺编号' ,
seval_storename  = "";//店铺名称' ,
seval_memberid  = 0;//买家编号' ,
seval_membername  = "";//买家名称' ,
seval_desccredit  = 0;//描述相符评分' ,
seval_servicecredit  = 0;//服务态度评分' ,
seval_deliverycredit  = 0;//发货速度评分' ,
seval_des  = "";//评价' ,
member_avatar = "";//用户头像
}




	@Generated(hash = 1213555255)
	public EvaluateStoreModel(int seval_id, int seval_orderid, String seval_orderno,
									int seval_addtime, int seval_storeid, String seval_storename,
									int seval_memberid, String seval_membername, int seval_desccredit,
									int seval_servicecredit, int seval_deliverycredit, String seval_des,
									String member_avatar) {
					this.seval_id = seval_id;
					this.seval_orderid = seval_orderid;
					this.seval_orderno = seval_orderno;
					this.seval_addtime = seval_addtime;
					this.seval_storeid = seval_storeid;
					this.seval_storename = seval_storename;
					this.seval_memberid = seval_memberid;
					this.seval_membername = seval_membername;
					this.seval_desccredit = seval_desccredit;
					this.seval_servicecredit = seval_servicecredit;
					this.seval_deliverycredit = seval_deliverycredit;
					this.seval_des = seval_des;
					this.member_avatar = member_avatar;
	}




	public int getSeval_id() {
					return this.seval_id;
	}




	public void setSeval_id(int seval_id) {
					this.seval_id = seval_id;
	}




	public int getSeval_orderid() {
					return this.seval_orderid;
	}




	public void setSeval_orderid(int seval_orderid) {
					this.seval_orderid = seval_orderid;
	}




	public String getSeval_orderno() {
					return this.seval_orderno;
	}




	public void setSeval_orderno(String seval_orderno) {
					this.seval_orderno = seval_orderno;
	}




	public int getSeval_addtime() {
					return this.seval_addtime;
	}




	public void setSeval_addtime(int seval_addtime) {
					this.seval_addtime = seval_addtime;
	}




	public int getSeval_storeid() {
					return this.seval_storeid;
	}




	public void setSeval_storeid(int seval_storeid) {
					this.seval_storeid = seval_storeid;
	}




	public String getSeval_storename() {
					return this.seval_storename;
	}




	public void setSeval_storename(String seval_storename) {
					this.seval_storename = seval_storename;
	}




	public int getSeval_memberid() {
					return this.seval_memberid;
	}




	public void setSeval_memberid(int seval_memberid) {
					this.seval_memberid = seval_memberid;
	}




	public String getSeval_membername() {
					return this.seval_membername;
	}




	public void setSeval_membername(String seval_membername) {
					this.seval_membername = seval_membername;
	}




	public int getSeval_desccredit() {
					return this.seval_desccredit;
	}




	public void setSeval_desccredit(int seval_desccredit) {
					this.seval_desccredit = seval_desccredit;
	}




	public int getSeval_servicecredit() {
					return this.seval_servicecredit;
	}




	public void setSeval_servicecredit(int seval_servicecredit) {
					this.seval_servicecredit = seval_servicecredit;
	}




	public int getSeval_deliverycredit() {
					return this.seval_deliverycredit;
	}




	public void setSeval_deliverycredit(int seval_deliverycredit) {
					this.seval_deliverycredit = seval_deliverycredit;
	}




	public String getSeval_des() {
					return this.seval_des;
	}




	public void setSeval_des(String seval_des) {
					this.seval_des = seval_des;
	}




	public String getMember_avatar() {
					return this.member_avatar;
	}




	public void setMember_avatar(String member_avatar) {
					this.member_avatar = member_avatar;
	}


}