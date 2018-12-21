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
public class MessageModel extends BaseModel {
/** 短消息索引id' , */
@Id
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



	@Generated(hash = 795197314)
	public MessageModel(int message_id, int message_parent_id, int from_member_id,
									String to_member_id, String message_title, String message_body,
									String message_time, String message_update_time, int message_open,
									int message_state, int message_type, String read_member_id,
									String del_member_id, int message_ismore, String from_member_name,
									String to_member_name, int message_member_type, int rec_id,
									int order_type, String from_member_avatar, String from_member_nick,
									int reads) {
					this.message_id = message_id;
					this.message_parent_id = message_parent_id;
					this.from_member_id = from_member_id;
					this.to_member_id = to_member_id;
					this.message_title = message_title;
					this.message_body = message_body;
					this.message_time = message_time;
					this.message_update_time = message_update_time;
					this.message_open = message_open;
					this.message_state = message_state;
					this.message_type = message_type;
					this.read_member_id = read_member_id;
					this.del_member_id = del_member_id;
					this.message_ismore = message_ismore;
					this.from_member_name = from_member_name;
					this.to_member_name = to_member_name;
					this.message_member_type = message_member_type;
					this.rec_id = rec_id;
					this.order_type = order_type;
					this.from_member_avatar = from_member_avatar;
					this.from_member_nick = from_member_nick;
					this.reads = reads;
	}



	public int getMessage_id() {
					return this.message_id;
	}



	public void setMessage_id(int message_id) {
					this.message_id = message_id;
	}



	public int getMessage_parent_id() {
					return this.message_parent_id;
	}



	public void setMessage_parent_id(int message_parent_id) {
					this.message_parent_id = message_parent_id;
	}



	public int getFrom_member_id() {
					return this.from_member_id;
	}



	public void setFrom_member_id(int from_member_id) {
					this.from_member_id = from_member_id;
	}



	public String getTo_member_id() {
					return this.to_member_id;
	}



	public void setTo_member_id(String to_member_id) {
					this.to_member_id = to_member_id;
	}



	public String getMessage_title() {
					return this.message_title;
	}



	public void setMessage_title(String message_title) {
					this.message_title = message_title;
	}



	public String getMessage_body() {
					return this.message_body;
	}



	public void setMessage_body(String message_body) {
					this.message_body = message_body;
	}



	public String getMessage_time() {
					return this.message_time;
	}



	public void setMessage_time(String message_time) {
					this.message_time = message_time;
	}



	public String getMessage_update_time() {
					return this.message_update_time;
	}



	public void setMessage_update_time(String message_update_time) {
					this.message_update_time = message_update_time;
	}



	public int getMessage_open() {
					return this.message_open;
	}



	public void setMessage_open(int message_open) {
					this.message_open = message_open;
	}



	public int getMessage_state() {
					return this.message_state;
	}



	public void setMessage_state(int message_state) {
					this.message_state = message_state;
	}



	public int getMessage_type() {
					return this.message_type;
	}



	public void setMessage_type(int message_type) {
					this.message_type = message_type;
	}



	public String getRead_member_id() {
					return this.read_member_id;
	}



	public void setRead_member_id(String read_member_id) {
					this.read_member_id = read_member_id;
	}



	public String getDel_member_id() {
					return this.del_member_id;
	}



	public void setDel_member_id(String del_member_id) {
					this.del_member_id = del_member_id;
	}



	public int getMessage_ismore() {
					return this.message_ismore;
	}



	public void setMessage_ismore(int message_ismore) {
					this.message_ismore = message_ismore;
	}



	public String getFrom_member_name() {
					return this.from_member_name;
	}



	public void setFrom_member_name(String from_member_name) {
					this.from_member_name = from_member_name;
	}



	public String getTo_member_name() {
					return this.to_member_name;
	}



	public void setTo_member_name(String to_member_name) {
					this.to_member_name = to_member_name;
	}



	public int getMessage_member_type() {
					return this.message_member_type;
	}



	public void setMessage_member_type(int message_member_type) {
					this.message_member_type = message_member_type;
	}



	public int getRec_id() {
					return this.rec_id;
	}



	public void setRec_id(int rec_id) {
					this.rec_id = rec_id;
	}



	public int getOrder_type() {
					return this.order_type;
	}



	public void setOrder_type(int order_type) {
					this.order_type = order_type;
	}



	public String getFrom_member_avatar() {
					return this.from_member_avatar;
	}



	public void setFrom_member_avatar(String from_member_avatar) {
					this.from_member_avatar = from_member_avatar;
	}



	public String getFrom_member_nick() {
					return this.from_member_nick;
	}



	public void setFrom_member_nick(String from_member_nick) {
					this.from_member_nick = from_member_nick;
	}



	public int getReads() {
					return this.reads;
	}



	public void setReads(int reads) {
					this.reads = reads;
	}


}