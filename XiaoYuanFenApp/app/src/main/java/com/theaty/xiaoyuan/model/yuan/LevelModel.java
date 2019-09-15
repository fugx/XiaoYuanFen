package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by fu on 2019/9/1.
 *  等级表
 */

public class LevelModel {

    /**
     * id : 等级ID
     * name : 等级名称
     * describe : 等级特权描述
     * type : 类型
     * enable : 是否有效
     */

    private String id;
    private String name;
    private String describe;
    private String type;
    private String enable;

    public LevelModel(String id, String name, String enable) {
        this.id = id;
        this.name = name;
        this.enable = enable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}
