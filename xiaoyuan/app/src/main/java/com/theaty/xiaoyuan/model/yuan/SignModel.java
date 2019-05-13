package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by Yecal on 2019/5/13.
 *  标签表
 */

public class SignModel {

    /**
     * id : 标签ID
     * name : 标签名称
     * time : 标签添加时间
     * type : 类型
     * enabled : 是否有效
     */

    private int id;
    private String name;
    private int time;
    private TypeModel type;
    private boolean enabled = true;

    public SignModel(int id, String name, int time) {
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
}
