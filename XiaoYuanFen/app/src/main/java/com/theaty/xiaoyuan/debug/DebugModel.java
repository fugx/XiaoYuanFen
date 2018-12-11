package com.theaty.xiaoyuan.debug;


import com.theaty.xiaoyuan.model.BaseModel;

import java.util.ArrayList;

/**
 * Created by lixiangyi on 2017/9/18.
 */

public class DebugModel extends BaseModel {

    public String url="";
    public String paras="";
    public String result="";
    public ArrayList<DebugModel> params  = new ArrayList<>();
    public String name;
    public String value;
    private static final DebugModel single= new DebugModel();
    private DebugModel(){}

    //静态工厂方法
    public static DebugModel getInstance() {
        return single;
    }
}
