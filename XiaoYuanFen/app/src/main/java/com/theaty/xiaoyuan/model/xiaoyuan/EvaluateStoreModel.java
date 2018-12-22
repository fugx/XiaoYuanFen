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
public class EvaluateStoreModel extends BaseModel {
/** 评价id' , */
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

}