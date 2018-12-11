package com.theaty.xiaoyuan.model.xiaoyuan;
import com.theaty.xiaoyuan.model.BaseModel;

/**
 * 
 * @author Theaty 
 * @desc 
 */
public class MessageModel extends BaseModel {
/** 短消息索引id' , */
public  int  message_id;
/** 回复短消息message_id' , */
public  int  message_parent_id;
/** 短消息发送人' , */
public  int  from_member_id;
/** 短消息接收人' , */
public String to_member_id;
/** 短消息标题' , */
public String message_title;
/** 短消息内容' , */
public String message_body;
/** 短消息发送时间' , */
public String message_time;
/** 短消息回复更新时间' , */
public String message_update_time;
/** 短消息打开状态' , */
public  int  message_open;
/** 短消息状态，0为正常状态，1为发送人删除状态，2为接收人删除状态' , */
public  int  message_state;
/** 0为私信、1为系统消息、2为留言' , */
public  int  message_type;
/** 已经读过该消息的会员id' , */
public String read_member_id;
/** 已经删除该消息的会员id' , */
public String del_member_id;
/** 站内信是否为一条发给多个用户 0为否 1为多条 ' , */
public  int  message_ismore;
/** 发信息人用户名' , */
public String from_member_name;
/** 接收人用户名' , */
public String to_member_name;
/** 类型（1会员2教师）' , */
public  int  message_member_type;
/** 订单商品表索引id' , */
public  int  rec_id;
/** 订单类型' , */
public  int  order_type;
/** 发消息会员头像' , */
public String from_member_avatar;
/** 发消息会员昵称' , */
public String from_member_nick;
/** 是否已读' , */
public  int  reads;



//初始化默认值 
 public MessageModel() {
message_id  = 0;//短消息索引id' ,
message_parent_id  = 0;//回复短消息message_id' ,
from_member_id  = 0;//短消息发送人' ,
to_member_id  = "";//短消息接收人' ,
message_title  = "";//短消息标题' ,
message_body  = "";//短消息内容' ,
message_time  = "";//短消息发送时间' ,
message_update_time  = "";//短消息回复更新时间' ,
message_open  = 0;//短消息打开状态' ,
message_state  = 0;//短消息状态，0为正常状态，1为发送人删除状态，2为接收人删除状态' ,
message_type  = 0;//0为私信、1为系统消息、2为留言' ,
read_member_id  = "";//已经读过该消息的会员id' ,
del_member_id  = "";//已经删除该消息的会员id' ,
message_ismore  = 0;//站内信是否为一条发给多个用户 0为否 1为多条 ' ,
from_member_name  = "";//发信息人用户名' ,
to_member_name  = "";//接收人用户名' ,
message_member_type  = 0;//类型（1会员2教师）' ,
rec_id  = 0;//订单商品表索引id' ,
order_type  = 0;//订单类型' ,
from_member_avatar  = "";//订单类型' ,
from_member_nick  = "";//订单类型' ,
reads  = 0;//订单类型' ,
}


}