package com.theaty.xiaoyuan.model.xiaoyuan;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.theaty.xiaoyuan.debug.DebugUtil;
import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.SystemModel;
import com.theaty.xiaoyuan.model.adapter.ThtGosn;
import com.theaty.xiaoyuan.system.DatasStore;

import java.util.ArrayList;
import java.util.List;

import foundation.log.LogUtils;

/**
 * Created by Yecal on 2018/12/12.
 */

public class PageModel extends BaseModel {

    /**
     * 首页广告,
     */
    private List<AdvModel> advs = new ArrayList<AdvModel>();

    public List<AdvModel> getAdvModel() {
        return advs;
    }

    //动画课程
    private ChildrenBean cartoon;

    //视频课程
    private ChildrenBean video;

    //人气教师
    private ChildrenBean teacher;

    public ChildrenBean getCartoon() {
        return cartoon;
    }

    public ChildrenBean getVideo() {
        return video;
    }

    public ChildrenBean getTeacher() {
        return teacher;
    }

    public static class ChildrenBean {

        //动画课程名称
        private String cartoon_name;

        //视频课程名称
        private String video_name;

        private List<GoodsModel> goods_list = new ArrayList<GoodsModel>();

        public String getCartoonName() {
            return cartoon_name;
        }

        public String getVideoName() {
            return video_name;
        }

        public List<GoodsModel> getGoodsList() {
            return goods_list;
        }

        //人气教师名称
        private String teacher_name;

        public String getTeacherName() {
            return teacher_name;
        }

        private List<MemberModel> teacher_list = new ArrayList<MemberModel>();

        public List<MemberModel> getTeacherList() {
            return teacher_list;
        }

        public ChildrenBean() {
            cartoon_name = "";
            video_name = "";
            teacher_name = "";
        }
    }

    /**
     * 首页
     *
     * @param type_level 等级ID
     * @param bib
     */
    public void first_page(String type_level, final BaseModelIB bib) {
        String url = buildGetUrl("Index", "first_page"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "index 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("type_level", type_level);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel ims = (ThtGosn.genGson()).fromJson(rm.getJsonDatas(), MemberModel.class);
                    BIBSucessful(bib, ims);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }


    /**
     * 一级分类
     *
     * @param type     类型1动画2视频3教师
     * @param bib
     */
    public void good_class(String type,  final BaseModelIB bib) {
        String url = buildGetUrl("GoodsClass", "good_class"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("type", type);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    ArrayList<GoodsClassModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<GoodsClassModel>>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 课程列表
     *
     * @param gc_id     分类ID
     * @param member_id     会员ID
     * @param key_words     关键字
     * @param goods_type     类型1动画2视频
     * @param a_id     标签ID英文逗号
     * @param curpage     页码
     * @param bib
     */
    public void SearchGoodslist(String gc_id, String member_id, String key_words, String goods_type, String a_id, String curpage,  final BaseModelIB bib) {
        String url = buildGetUrl("Goods", "SearchGoodslist"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("gc_id", gc_id);
        params.addBodyParameter("member_id", member_id);
        params.addBodyParameter("key_words", key_words);
        params.addBodyParameter("goods_type", goods_type);
        params.addBodyParameter("a_id", a_id);
        params.addBodyParameter("curpage", curpage);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    ArrayList<GoodsModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<GoodsModel>>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 课程详情
     *
     * @param goods_id     商品ID
     * @param member_id
     * @param bib
     */
    public void goods_details(String goods_id, String member_id, final BaseModelIB bib) {
        String url = buildGetUrl("Goods", "goods_details"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("goods_id", goods_id);
        params.addBodyParameter("member_id", member_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    GoodsModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<GoodsModel>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 添加收藏
     *
     * @param key key值
     * @param goods_id 商品ID
     * @param bib
     */
    public void favorites_add(String key,String goods_id,final BaseModelIB bib) {
        String url = buildGetUrl("MemberFavorites", "favorites_add"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("goods_id", goods_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 删除收藏
     *
     * @param key key值
     * @param goods_id 商品ID
     * @param bib
     */
    public void favorites_del(String key,String goods_id,final BaseModelIB bib) {
        String url = buildGetUrl("MemberFavorites", "favorites_del"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("goods_id", goods_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 教师列表
     *
     * @param gc_id     商品ID
     * @param member_id
     * @param key_words
     * @param a_id
     * @param page
     * @param bib
     */
    public void SearchTeacherList(String gc_id, String member_id,String key_words,String a_id,String page, final BaseModelIB bib) {
        String url = buildGetUrl("Goods", "SearchTeacherlist"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("gc_id", gc_id);
        params.addBodyParameter("member_id", member_id);
        params.addBodyParameter("key_words", key_words);
        params.addBodyParameter("a_id", a_id);
        params.addBodyParameter("curpage", page);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    ArrayList<MemberModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<MemberModel>>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 我的课程表
     *
     * @param key     key值
     * @param order_goods_type     1今日2其他
     * @param curpage     页码
     * @param bib
     */
    public void order_goods_list(String key, String order_goods_type, String curpage, final BaseModelIB bib) {
        String url = buildGetUrl("MemberOrder", "order_goods_list"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("order_goods_type", order_goods_type);
        params.addBodyParameter("curpage", curpage);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    ArrayList<OrderGoodsModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<OrderGoodsModel>>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 教师详情
     *
     * @param teacher_id     教师ID
     * @param member_id     会员ID
     * @param bib
     */
    public void teacher_detail(String teacher_id, String member_id, final BaseModelIB bib) {
        String url = buildGetUrl("Goods", "teacher_detail"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("teacher_id", teacher_id);
        params.addBodyParameter("member_id", member_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<MemberModel>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 教师评论
     *
     * @param member_id     教师ID
     * @param curpage     页码
     * @param bib
     */
    public void teacher_evaluation(String member_id, String curpage, final BaseModelIB bib) {
        String url = buildGetUrl("Goods", "teacher_evaluation"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("member_id", member_id);
        params.addBodyParameter("curpage", curpage);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    ArrayList<EvaluateStoreModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<EvaluateStoreModel>>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 关注的教师列表
     *
     * @param key     key值
     * @param curpage 页码
     * @param bib
     */
//    public void member_teacher_list(String key, String curpage, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberIndex", "member_teacher_list"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("curpage", curpage);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<SnsFriendModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<SnsFriendModel>>() {
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

    /**
     * 关注教师
     *
     * @param key     key值
     * @param teacher_id     老师ID
     * @param bib
     */
    public void member_addteacher(String key, String teacher_id, final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "member_addteacher"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("teacher_id", teacher_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 取消关注教师
     *
     * @param key     key值
     * @param teacher_id     老师ID
     * @param bib
     */
    public void member_delTeacher(String key, String teacher_id, final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "member_delteacher"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("teacher_id", teacher_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 预约详情
     *
     * @param key     key值
     * @param order_id     订单ID
     * @param rec_id     订单商品ID
     * @param bib
     */
    public void order_goods_detail(String key, String order_id, String rec_id, final BaseModelIB bib) {
        String url = buildGetUrl("MemberOrder", "order_goods_detail"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("order_id", order_id);
        params.addBodyParameter("rec_id", rec_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    OrderGoodsModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<OrderGoodsModel>() {
                    }.getType());
                    BIBSucessful(bib, orderModels);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 添加评论
     *
     * @param key     key值
     * @param seval_orderid     rec_id
     * @param seval_desccredit     评分
     * @param seval_des	     评价
     * @param seval_image     图片多个用逗号隔开
     * @param bib
     */
    public void add_evaluation(String key, String seval_orderid, String seval_desccredit, String seval_des, String seval_image, final BaseModelIB bib) {
        String url = buildGetUrl("MemberOrder", "teacher_evaluation"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("seval_orderid", seval_orderid);
        params.addBodyParameter("seval_desccredit", seval_desccredit);
        params.addBodyParameter("seval_des", seval_des);
        params.addBodyParameter("seval_image", seval_image);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 新消息提醒
     *
     * @param bib
     */
    public void new_message(final BaseModelIB bib) {
        String url = buildGetUrl("MemberChat", "receivedSystemNewNum"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "new_message 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);
        params.addBodyParameter("message_member_type", "1");
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 添加分享
     *
     * @param member_id
     * @param goods_id
     * @param bib
     */
    public void member_share(String member_id, String goods_id, final BaseModelIB bib) {
        String url = buildGetUrl("UserHelp", "member_share"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "new_message 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("member_id", member_id);
        params.addBodyParameter("goods_id", goods_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 添加分享
     *
     * @param member_id
     * @param bib
     */
    public void member_share_app(String member_id, final BaseModelIB bib) {
        String url = buildGetUrl("UserHelp", "member_share_app"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "new_message 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("member_id", member_id);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    BIBSucessful(bib, rm.getStringDatas());
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

//    /**
//     * 检验自身是否一个合法的类型
//     *
//     * @return
//     */
//    public String isLegal() {
//        if (key.length() < 1) {
//            return " key非法";
//        }
//        if (TextUtils.isEmpty(member_name)) {
//            return " member_name非法";
//        }
//        return "access";
//    }

    /**
     * 获取版本号，检测版本更新
     * version_num 当前版本号
     * version_code 安卓传Android,IOS传IOS
     */
    public void mb_version_new(String version_num,final BaseModelIB bib){
        String url = buildGetUrl("UserHelp", "mb_version_new"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "txRules 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("version_code", "Android");
        params.addBodyParameter("version_num", version_num);

        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功

                    SystemModel systemModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), SystemModel.class);
                    BIBSucessful(bib, systemModel);
                } else {// 失败
                    BIBFailed(bib, rm); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, new ResultsModel(-999, "网络超时")); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }
}