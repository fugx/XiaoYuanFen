package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

/**
 * Created by Yecal on 2019/5/13.
 *  类型表
 */

public class TypeModel {

    /**
     * id : 类型ID
     * name : 类型名称
     * time : 类型添加时间
     * child : [子类型1...]
     * father : 父类型
     * enabled : 是否有效
     */

    private int id;
    private String name;
    private int time;
    private ArrayList<TypeModel> child = new ArrayList<>();
    private TypeModel father;
    private boolean enabled = true;

    public TypeModel(int id, String name, int time) {
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

    public ArrayList<TypeModel> getChild() {
        return child;
    }

    public void setChild(ArrayList<TypeModel> child) {
        this.child = child;
    }

    public TypeModel getFather() {
        return father;
    }

    public void setFather(TypeModel father) {
        this.father = father;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
