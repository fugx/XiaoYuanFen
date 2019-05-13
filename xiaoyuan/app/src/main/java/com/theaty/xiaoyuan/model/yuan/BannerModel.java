package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by Yecal on 2019/5/13.
 *  轮播图表
 */

public class BannerModel {

    /**
     * id : 轮播图ID
     * name : 轮播图标题
     * time : 轮播图添加时间
     * url : 链接url
     * type : 类型
     * enabled : 是否有效
     */

    private int id;
    private String name;
    private int time;
    private String url;
    private TypeModel type;
    private boolean enabled = true;

    public BannerModel(int id, String name, int time) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
