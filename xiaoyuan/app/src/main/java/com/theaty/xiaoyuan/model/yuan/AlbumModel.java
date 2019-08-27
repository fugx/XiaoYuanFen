package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by Yecal on 2019/5/13.
 *  相册表
 */

public class AlbumModel {

    /**
     * id : 相册ID
     * name : 相册标注
     * time : 相册创建时间
     * member : 所属用户
     * act : 所属活动
     * face : 相册封面
     * type : 类型
     * sign : [标签1...]
     * photo : [照片1...]
     * level : 查看权限等级
     * enabled : 是否有效
     */

    private int id;
    private String name;
    private int time;
    private MemberInfoModel member;
    private ActivityInfoModel act;
    private String face;
    private String type;
    private String sign;
    private String photo;
    private int level;
    private boolean enabled;

    public AlbumModel(int id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public MemberInfoModel getMember() {
        return member;
    }

    public void setMember(MemberInfoModel member) {
        this.member = member;
    }

    public ActivityInfoModel getAct() {
        return act;
    }

    public void setAct(ActivityInfoModel act) {
        this.act = act;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
