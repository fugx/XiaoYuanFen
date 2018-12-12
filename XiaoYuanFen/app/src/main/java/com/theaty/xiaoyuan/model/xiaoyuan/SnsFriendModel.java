package com.theaty.xiaoyuan.model.xiaoyuan;
import com.theaty.xiaoyuan.model.BaseModel;

/**
 * 
 * @author Theaty 
 * @desc 
 */
public class SnsFriendModel extends BaseModel {
/** id值' , */
public  int  friend_id;
/** 会员id' , */
public  int  friend_frommid;
/** 会员名称' , */
public String friend_frommname;
/** 会员头像' , */
public String friend_frommavatar;
/** 朋友id' , */
public  int  friend_tomid;
/** 好友会员名称' , */
public String friend_tomname;
/** 朋友头像' , */
public String friend_tomavatar;
/** 添加时间' , */
public  int  friend_addtime;
/** 关注状态 1为单方关注 2为双方关注' , */
public  int  friend_followstate;
/** 用户' , */
public  MemberModel  member_info;




//初始化默认值 
 public SnsFriendModel() {
friend_id  = 0;//id值' ,
friend_frommid  = 0;//会员id' ,
friend_frommname  = "";//会员名称' ,
friend_frommavatar  = "";//会员头像' ,
friend_tomid  = 0;//朋友id' ,
friend_tomname  = "";//好友会员名称' ,
friend_tomavatar  = "";//朋友头像' ,
friend_addtime  = 0;//添加时间' ,
friend_followstate  = 0;//关注状态 1为单方关注 2为双方关注' ,
member_info = new MemberModel();//教师信息
}


}