package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.BaseModel;

/**
 * Created by Yecal on 2018/12/12.
 */

public class GoodsClassModel extends BaseModel {
    /** 索引id' , */
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


}