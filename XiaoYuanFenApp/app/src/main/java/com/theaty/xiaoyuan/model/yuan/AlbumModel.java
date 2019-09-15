package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

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
    private ActInfoModel act;
    private String face;
    private TypeModel type;
    private ArrayList<SignModel> sign;
    private ArrayList<PhotoModel> photo;
    private LevelModel level;
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

    public ActInfoModel getAct() {
        return act;
    }

    public void setAct(ActInfoModel act) {
        this.act = act;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public TypeModel getType() {
        return type;
    }

    public void setType(TypeModel type) {
        this.type = type;
    }

    public ArrayList<SignModel> getSign() {
        return sign;
    }

    public void setSign(ArrayList<SignModel> sign) {
        this.sign = sign;
    }

    public ArrayList<PhotoModel> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<PhotoModel> photo) {
        this.photo = photo;
    }

    public LevelModel getLevel() {
        return level;
    }

    public void setLevel(LevelModel level) {
        this.level = level;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
