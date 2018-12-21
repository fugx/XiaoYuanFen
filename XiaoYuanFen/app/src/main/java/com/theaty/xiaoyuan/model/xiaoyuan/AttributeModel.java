package com.theaty.xiaoyuan.model.xiaoyuan;

import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.theaty.xiaoyuan.debug.DebugUtil;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.adapter.ThtGosn;
import com.theaty.xiaoyuan.system.DatasStore;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;

import foundation.log.LogUtils;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Yecal on 2018/12/12.
 */
@Entity
public class AttributeModel extends BaseModel {
    /**
     * 属性id' ,
     */
    @Id
    public int attr_value_id;
    /**
     * 属性名称' ,
     */
    public String attr_name;
    /**
     * id' ,
     */
    public int attr_id;
    /**
     * 所属类型id' ,
     */
    public int type_id;
    /** 属性值列' , */
    //public  String  attr_value;
    /**
     * 是否显示。0为不显示、1为显示' ,
     */
    public int attr_show;
    /**
     * 排序' ,
     */
    public int attr_value_sort;

    /**
     * 教师特点,
     */
//    private List<AttributeModel> attr_value = new ArrayList<AttributeModel>();


    //初始化默认值
    public AttributeModel() {
        attr_value_id = 0;//属性id' ,
        attr_name = "";//属性名称' ,
        attr_name = "";//属性名' ,
        type_id = 0;//所属类型id' ,
        attr_id = 0;//id' ,
//attr_value  = "";//属性值列' ,
        attr_show = 0;//是否显示。0为不显示、1为显示' ,
        attr_value_sort = 0;//排序' ,
//        attr_value = new ArrayList<AttributeModel>();//教师特点,
    }

    @Generated(hash = 666839934)
    public AttributeModel(int attr_value_id, String attr_name, int attr_id, int type_id, int attr_show, int attr_value_sort) {
        this.attr_value_id = attr_value_id;
        this.attr_name = attr_name;
        this.attr_id = attr_id;
        this.type_id = type_id;
        this.attr_show = attr_show;
        this.attr_value_sort = attr_value_sort;
    }

    public int getAttr_value_id() {
        return this.attr_value_id;
    }

    public void setAttr_value_id(int attr_value_id) {
        this.attr_value_id = attr_value_id;
    }

    public String getAttr_name() {
        return this.attr_name;
    }

    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }

    public int getAttr_id() {
        return this.attr_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public int getType_id() {
        return this.type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getAttr_show() {
        return this.attr_show;
    }

    public void setAttr_show(int attr_show) {
        this.attr_show = attr_show;
    }

    public int getAttr_value_sort() {
        return this.attr_value_sort;
    }

    public void setAttr_value_sort(int attr_value_sort) {
        this.attr_value_sort = attr_value_sort;
    }

    /**
     * 标签列表
     *
     * @param type_id 类型1动画2视频3教师
     * @param bib
     */
//    public void tag_list(String type_id, final BaseModelIB bib) {
//        String url = buildGetUrl("Goods", "tag_list"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("type_id", type_id);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<AttributeModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<AttributeModel>>() {
//                    }.getType());
//                    BIBSucessful(bib, orderModels);
//                } else {// 失败
//                    BIBFailed(bib, rm); // 失败标志位
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
}