package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.BaseModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Yecal on 2018/12/12.
 */
@Entity
public class GoodsClassModel extends BaseModel {
    /** 索引id' , */
    @Id
    public  int  gc_id;
    /** 分类名称' , */
    public  String  gc_name;
    /** 类型id' , */
    public  int  type_id;
    /** 类型名称' , */
    public  String  type_name;
    /** 父id' , */
    public  int  gc_parent_id;
    /** 佣金比例' , */
    public  Double  commis_rate;
    /** 排序' , */
    public  int  gc_sort;
    /** 是否允许发布虚拟商品，1是，0否' , */
    public  int  gc_virtual;
    /** 名称' , */
    public  String  gc_title;
    /** 关键词' , */
    public  String  gc_keywords;
    /** 描述' , */
    public  String  gc_description;
    /** 类型（1动画2视频3教师）' , */
    public  int  type;
    /** 难度系数' , */
    public  int  type_level;




    //初始化默认值
    public GoodsClassModel() {
        gc_id  = 0;//索引id' ,
        gc_name  = "";//分类名称' ,
        type_id  = 0;//类型id' ,
        type_name  = "";//类型名称' ,
        gc_parent_id  = 0;//父id' ,
        commis_rate  = 0.0;//佣金比例' ,
        gc_sort  = 0;//排序' ,
        gc_virtual  = 0;//是否允许发布虚拟商品，1是，0否' ,
        gc_title  = "";//名称' ,
        gc_keywords  = "";//关键词' ,
        gc_description  = "";//描述' ,
        type  = 0;//类型（1动画2视频3教师）' ,
        type_level  = 0;//难度系数' ,
    }




    @Generated(hash = 984531280)
    public GoodsClassModel(int gc_id, String gc_name, int type_id, String type_name,
            int gc_parent_id, Double commis_rate, int gc_sort, int gc_virtual,
            String gc_title, String gc_keywords, String gc_description, int type,
            int type_level) {
        this.gc_id = gc_id;
        this.gc_name = gc_name;
        this.type_id = type_id;
        this.type_name = type_name;
        this.gc_parent_id = gc_parent_id;
        this.commis_rate = commis_rate;
        this.gc_sort = gc_sort;
        this.gc_virtual = gc_virtual;
        this.gc_title = gc_title;
        this.gc_keywords = gc_keywords;
        this.gc_description = gc_description;
        this.type = type;
        this.type_level = type_level;
    }




    public int getGc_id() {
        return this.gc_id;
    }




    public void setGc_id(int gc_id) {
        this.gc_id = gc_id;
    }




    public String getGc_name() {
        return this.gc_name;
    }




    public void setGc_name(String gc_name) {
        this.gc_name = gc_name;
    }




    public int getType_id() {
        return this.type_id;
    }




    public void setType_id(int type_id) {
        this.type_id = type_id;
    }




    public String getType_name() {
        return this.type_name;
    }




    public void setType_name(String type_name) {
        this.type_name = type_name;
    }




    public int getGc_parent_id() {
        return this.gc_parent_id;
    }




    public void setGc_parent_id(int gc_parent_id) {
        this.gc_parent_id = gc_parent_id;
    }




    public Double getCommis_rate() {
        return this.commis_rate;
    }




    public void setCommis_rate(Double commis_rate) {
        this.commis_rate = commis_rate;
    }




    public int getGc_sort() {
        return this.gc_sort;
    }




    public void setGc_sort(int gc_sort) {
        this.gc_sort = gc_sort;
    }




    public int getGc_virtual() {
        return this.gc_virtual;
    }




    public void setGc_virtual(int gc_virtual) {
        this.gc_virtual = gc_virtual;
    }




    public String getGc_title() {
        return this.gc_title;
    }




    public void setGc_title(String gc_title) {
        this.gc_title = gc_title;
    }




    public String getGc_keywords() {
        return this.gc_keywords;
    }




    public void setGc_keywords(String gc_keywords) {
        this.gc_keywords = gc_keywords;
    }




    public String getGc_description() {
        return this.gc_description;
    }




    public void setGc_description(String gc_description) {
        this.gc_description = gc_description;
    }




    public int getType() {
        return this.type;
    }




    public void setType(int type) {
        this.type = type;
    }




    public int getType_level() {
        return this.type_level;
    }




    public void setType_level(int type_level) {
        this.type_level = type_level;
    }


}