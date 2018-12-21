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
public class SnsFriendModel extends BaseModel {
/** id值' , */
@Id
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
//public  MemberModel  member_info;




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
//member_info = new MemberModel();//教师信息
}
@Generated(hash = 1073101089)
public SnsFriendModel(int friend_id, int friend_frommid,
								String friend_frommname, String friend_frommavatar, int friend_tomid,
								String friend_tomname, String friend_tomavatar, int friend_addtime,
								int friend_followstate) {
				this.friend_id = friend_id;
				this.friend_frommid = friend_frommid;
				this.friend_frommname = friend_frommname;
				this.friend_frommavatar = friend_frommavatar;
				this.friend_tomid = friend_tomid;
				this.friend_tomname = friend_tomname;
				this.friend_tomavatar = friend_tomavatar;
				this.friend_addtime = friend_addtime;
				this.friend_followstate = friend_followstate;
}
public int getFriend_id() {
				return this.friend_id;
}
public void setFriend_id(int friend_id) {
				this.friend_id = friend_id;
}
public int getFriend_frommid() {
				return this.friend_frommid;
}
public void setFriend_frommid(int friend_frommid) {
				this.friend_frommid = friend_frommid;
}
public String getFriend_frommname() {
				return this.friend_frommname;
}
public void setFriend_frommname(String friend_frommname) {
				this.friend_frommname = friend_frommname;
}
public String getFriend_frommavatar() {
				return this.friend_frommavatar;
}
public void setFriend_frommavatar(String friend_frommavatar) {
				this.friend_frommavatar = friend_frommavatar;
}
public int getFriend_tomid() {
				return this.friend_tomid;
}
public void setFriend_tomid(int friend_tomid) {
				this.friend_tomid = friend_tomid;
}
public String getFriend_tomname() {
				return this.friend_tomname;
}
public void setFriend_tomname(String friend_tomname) {
				this.friend_tomname = friend_tomname;
}
public String getFriend_tomavatar() {
				return this.friend_tomavatar;
}
public void setFriend_tomavatar(String friend_tomavatar) {
				this.friend_tomavatar = friend_tomavatar;
}
public int getFriend_addtime() {
				return this.friend_addtime;
}
public void setFriend_addtime(int friend_addtime) {
				this.friend_addtime = friend_addtime;
}
public int getFriend_followstate() {
				return this.friend_followstate;
}
public void setFriend_followstate(int friend_followstate) {
				this.friend_followstate = friend_followstate;
}


}