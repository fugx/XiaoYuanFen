package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

/**
 * Created by Yecal on 2019/5/13.
 *  照片表
 */

public class PhotoModel {

    /**
     * id : 照片ID
     * name : 照片标注
     * url : oss链接
     * time : 照片上传时间
     * type : 暂时没有用
     * sign : [标签1...]
     * level : 查看权限等级
     * enabled : 是否有效
     */

    private int id;
    private String name;
    private String url;
    private int time;
    private TypeModel type;
    private ArrayList<SignModel> sign = new ArrayList<>();
    private int level = 0;
    private boolean enabled;

    public PhotoModel(int id, String name, String url, int time) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public ArrayList<SignModel> getSign() {
        return sign;
    }

    public void setSign(ArrayList<SignModel> sign) {
        this.sign = sign;
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
