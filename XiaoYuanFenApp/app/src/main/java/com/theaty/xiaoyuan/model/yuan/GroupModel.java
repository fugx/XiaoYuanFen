package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

/**
 * Created by Yecal on 2019/5/13.
 *  分组表--暂时没用
 */

public class GroupModel {

    /**
     * id : 分组ID
     * name : 分组名称
     * time : 创建时间
     * member : 所属用户
     * type : 类型
     * enabled : 是否有效
     * members : [成员1...]
     */

    private int id;
    private String name;
    private int time;
    private MemberInfoModel member;
    private TypeModel type;
    private boolean enabled = true;
    private ArrayList<MemberInfoModel> members = new ArrayList<>();

    public GroupModel(int id, String name, int time) {
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

    public TypeModel getType() {
        return type;
    }

    public void setType(TypeModel type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ArrayList<MemberInfoModel> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<MemberInfoModel> members) {
        this.members = members;
    }
}
