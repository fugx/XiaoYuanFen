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
import com.theaty.xiaoyuan.oss.Ossutil;
import com.theaty.xiaoyuan.system.DatasStore;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import foundation.log.LogUtils;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Theaty
 * 用户/会员
 * @desc
 */
public class MemberModel extends BaseModel {
    /**
     * 用户id' ,
     */
    public int member_id;
    /**
     * 用户名称' ,
     */
    public String member_name;
    /**
     * 是否是会员' ,
     */
    public String is_vip;
    /**
     * 真实姓名' ,
     */
    public String member_truename;
    /**
     * 用户头像' ,
     */
    public String member_avatar;
    /**
     * 用户性别' ,
     */
    public int member_sex;
    /**
     * 生日' ,
     */
    public String member_birthday;
    /**
     * 用户密码' ,
     */
    public String member_passwd;
    /**
     * 支付密码' ,
     */
    public String member_paypwd;
    /**
     * 用户邮箱' ,
     */
    public String member_email;
    /**
     * 0未绑定1已绑定' ,
     */
    public int member_email_bind;
    /**
     * 手机号' ,
     */
    public String member_mobile;
    /**
     * 0未绑定1已绑定' ,
     */
    public int member_mobile_bind;
    /**
     * qq' ,
     */
    public String member_qq;
    /**
     * 阿里旺旺' ,
     */
    public String member_ww;
    /**
     * 登录次数' ,
     */
    public int member_login_num;
    /**
     * 用户注册时间' ,
     */
    public String member_time;
    /**
     * 当前登录时间' ,
     */
    public String member_login_time;
    /**
     * 上次登录时间' ,
     */
    public String member_old_login_time;
    /**
     * 当前登录ip' ,
     */
    public String member_login_ip;
    /**
     * 上次登录ip' ,
     */
    public String member_old_login_ip;
    /**
     * qq互联id' ,
     */
    public String member_qqopenid;
    /**
     * qq账号相关信息' ,
     */
    public String member_qqinfo;
    /**
     * 新浪微博登录id' ,
     */
    public String member_sinaopenid;
    /**
     * 新浪账号相关信息序列化值' ,
     */
    public String member_sinainfo;
    /**
     * 微信帐号id' ,
     */
    public String member_wx_openid;
    /**
     * 用户积分' ,
     */
    public int member_points;
    /**
     * 预存款可用金额' ,
     */
    public Double available_predeposit;
    /**
     * 预存款冻结金额' ,
     */
    public Double freeze_predeposit;
    /**
     * 可用充值卡余额' ,
     */
    public Double available_rc_balance;
    /**
     * 冻结充值卡余额' ,
     */
    public Double freeze_rc_balance;
    /**
     * 是否允许举报(1可以/2不可以)' ,
     */
    public int inform_allow;
    /**
     * 用户是否有购买权限 1为开启 0为关闭' ,
     */
    public int is_buy;
    /**
     * 用户是否有咨询和发送站内信的权限 1为开启 0为关闭' ,
     */
    public int is_allowtalk;
    /**
     * 用户的开启状态 1为开启 0为关闭' ,
     */
    public int member_state;
    /**
     * sns空间访问次数' ,
     */
    public int member_snsvisitnum;
    /**
     * 地区id' ,
     */
    public int member_areaid;
    /**
     * 城市id' ,
     */
    public int member_cityid;
    /**
     * 省份id' ,
     */
    public int member_provinceid;
    /**
     * 地区内容' ,
     */
    public String member_areainfo;
    /**
     * 隐私设定' ,
     */
    public String member_privacy;
    /**
     * 用户常用操作' ,
     */
    public String member_quicklink;
    /**
     * 用户经验值' ,
     */
    public int member_exppoints;
    /**
     * 环信用户名' ,
     */
    public String hx_username;
    /**
     * 环信密码' ,
     */
    public String hx_userpwd;
    /**
     * 用户昵称' ,
     */
    public String member_nick;
    /**
     * 用户个推cid' ,
     */
    public String member_cid_1;
    /**
     * 用户个推cid' ,
     */
    public String member_cid_2;
    /**
     * 用户个推cid' ,
     */
    public String member_cid_3;
    /**
     * 用户个推cid' ,
     */
    public String member_cid_4;
    /**
     * 用户个推cid' ,
     */
    public String member_cid_5;
    /**
     * 校验key
     */
    public String key;
    /**
     * 客户端类型 android ios（和member_cid_1对应）' ,
     */
    public String client_type_1;
    /**
     * 客户端类型 android ios（和member_cid_1对应）' ,
     */
    public String client_type_2;
    /**
     * 客户端类型 android ios（和member_cid_1对应）' ,
     */
    public String client_type_3;
    /**
     * 客户端类型 android ios（和member_cid_1对应）' ,
     */
    public String client_type_4;
    /**
     * 客户端类型 android ios（和member_cid_1对应）' ,
     */
    public String client_type_5;
    /**
     * 开始时间' ,
     */
    public int member_begin;
    /**
     * 结束时间' ,
     */
    public int member_end;

    /**
     * 身份证正面' ,
     */
    public String teacher_cardface;
    /**
     * 身份证反面' ,
     */
    public String teacher_cartreverse;

    /**
     * 粉丝数量' ,
     */
    public int friend_count;
    /**
     * 是否已关注' ,
     */
    public int is_friend;

    //初始化默认值
    public MemberModel() {
        member_id = 0;//用户id' ,
        member_name = "";//用户名称' ,
        is_vip = "";//用户名称' ,
        member_truename = "";//真实姓名' ,
        member_avatar = "";//用户头像' ,
        member_sex = 0;//用户性别' ,
        member_birthday = "";//生日' ,
        member_passwd = "";//用户密码' ,
        member_paypwd = "";//支付密码' ,
        member_email = "";//用户邮箱' ,
        member_email_bind = 0;//0未绑定1已绑定' ,
        member_mobile = "";//手机号' ,
        member_mobile_bind = 0;//0未绑定1已绑定' ,
        member_qq = "";//qq' ,
        member_ww = "";//阿里旺旺' ,
        member_login_num = 0;//登录次数' ,
        member_time = "";//用户注册时间' ,
        member_login_time = "";//当前登录时间' ,
        member_old_login_time = "";//上次登录时间' ,
        member_login_ip = "";//当前登录ip' ,
        member_old_login_ip = "";//上次登录ip' ,
        member_qqopenid = "";//qq互联id' ,
        member_qqinfo = "";//qq账号相关信息' ,
        member_sinaopenid = "";//新浪微博登录id' ,
        member_sinainfo = "";//新浪账号相关信息序列化值' ,
        member_wx_openid = "";//微信帐号id' ,
        member_points = 0;//用户积分' ,
        available_predeposit = 0.0;//预存款可用金额' ,
        freeze_predeposit = 0.0;//预存款冻结金额' ,
        available_rc_balance = 0.0;//可用充值卡余额' ,
        freeze_rc_balance = 0.0;//冻结充值卡余额' ,
        inform_allow = 0;//是否允许举报(1可以/2不可以)' ,
        is_buy = 0;//用户是否有购买权限 1为开启 0为关闭' ,
        is_allowtalk = 0;//用户是否有咨询和发送站内信的权限 1为开启 0为关闭' ,
        member_state = 0;//用户的开启状态 1为开启 0为关闭' ,
        member_snsvisitnum = 0;//sns空间访问次数' ,
        member_areaid = 0;//地区id' ,
        member_cityid = 0;//城市id' ,
        member_provinceid = 0;//省份id' ,
        member_areainfo = "";//地区内容' ,
        member_privacy = "";//隐私设定' ,
        member_quicklink = "";//用户常用操作' ,
        member_exppoints = 0;//用户经验值' ,
        hx_username = "";//环信用户名' ,
        hx_userpwd = "";//环信密码' ,
        member_nick = "";//用户昵称' ,
        member_cid_1 = "";//用户个推cid' ,
        member_cid_2 = "";//用户个推cid' ,
        member_cid_3 = "";//用户个推cid' ,
        member_cid_4 = "";//用户个推cid' ,
        member_cid_5 = "";//用户个推cid' ,
        client_type_1 = "";//客户端类型 android ios（和member_cid_1对应）' ,
        client_type_2 = "";//客户端类型 android ios（和member_cid_1对应）' ,
        client_type_3 = "";//客户端类型 android ios（和member_cid_1对应）' ,
        client_type_4 = "";//客户端类型 android ios（和member_cid_1对应）' ,
        client_type_5 = "";//客户端类型 android ios（和member_cid_1对应）' ,
        member_begin = 0;//开始时间' ,
        member_end = 0;//结束时间' ,
        teacher_cardface = "";//身份证正面' ,
        teacher_cartreverse = "";//身份证反面' ,
        friend_count = 0; //粉丝数量,
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
     * 用户登陆
     *
     * @param username 用户名（电话号码）
     * @param password 用户密码
     *                  //@param type 用户1，教师2
     *                 //@param client           类型 客户端类型（'android'，'wechat', 'ios'）
     * @param type 类型1用户2老师
     * @param bib
     */
    public void Login(String username, String password,String type, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "index"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "index 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("username", username);
        params.addBodyParameter("password", password);
        params.addBodyParameter("type", "1");
        params.addBodyParameter("client", "android");
        params.addBodyParameter("type", type);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel ims = (ThtGosn.genGson()).fromJson(rm.getJsonDatas(), MemberModel.class);
                    DatasStore.setCurMember(ims);
                    uploadCid(DatasStore.getCid());
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

    public void uploadCid(String cid) {
        if (DatasStore.isLogin()) {
            update_cid(DatasStore.getCurMember().key, cid, new BaseModelIB() {
                @Override
                public void StartOp() {
                }

                @Override
                public void successful(Object o) {
                    LogUtils.e("保存个推id： " + (String) o);
                }

                @Override
                public void failed(ResultsModel resultsModel) {
                    LogUtils.e("保存个推id： " + resultsModel.getStringDatas());
                }
            });
        }
    }

    /**
     * 验证码登录
     *
     * @param username
     * @param identify_code
     * @param type 类型1用户2老师
     * @param bib
     */
    public void index_phone(String username, String identify_code,String type, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "index_phone"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "index_phone"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("username", username);
        params.addBodyParameter("identify_code", identify_code);
        params.addBodyParameter("client", "android");
        params.addBodyParameter("type", type);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), MemberModel.class);
                    DatasStore.setCurMember(orderModels);
                    uploadCid(DatasStore.getCid());
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
     * 修改用户个推cid
     *
     * @param key        key
     * @param member_cid 个推CID
     *                   //     * @param client_type_1  客户端类型
     * @param bib
     */
    public void update_cid(String key, String member_cid, final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "update_cid"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "update_cid 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("key", key);
        params.addBodyParameter("member_cid", member_cid);
        params.addBodyParameter("client", "android");


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
     * 用户详细信息
     *
     * @param key key值
     * @param bib
     */
    public void member_info(String key, final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "member_info"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "member_info"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), MemberModel.class);
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
     * 注册生成验证码
     *
     * @param username 用户名（电话号码）
     * @param bib
     */
    public void registidentifycode(String username, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "registidentifycode"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("phone_num", username);
        params.addBodyParameter("tycode", getCode(username));
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
     * 注册校验验证码
     * @param phoneNum 手机号
     * @param verifyCode 验证码
     * @param bib
     */
    public void checkIdentify(String phoneNum,String verifyCode, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "check"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("phone_num", phoneNum);
        params.addBodyParameter("identify_code", verifyCode);
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
     * 用户注册
     *
     * @param username 用户名（电话号码）
     * @param password 用户密码
     *                 //@param client           类型 客户端类型（'android'，'wechat', 'ios'）
     * @param bib
     */
    public void register(String username, String password, String password_confirm,String identify_code, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "register"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "register 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("username", username);
        params.addBodyParameter("password", password);
        params.addBodyParameter("password_confirm", password_confirm);
        params.addBodyParameter("identify_code", identify_code);
        params.addBodyParameter("client", "android");
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel ims = (ThtGosn.genGson()).fromJson(rm.getJsonDatas(), MemberModel.class);
                    DatasStore.setCurMember(ims);
                    uploadCid(DatasStore.getCid());
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
     * 验证码登录生成验证码
     *
     * @param username 用户名（电话号码）
     * @param bib
     */
    public void identifycode(String username, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "identifycode"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("phone_num", username);
        params.addBodyParameter("tycode", getCode(username));
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
     * 忘记密码专用生成验证码
     *
     * @param username 用户名（电话号码）
     * @param bib
     */
    public void forgetidentifycode(String username, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "forgetidentifycode"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("phone_num", username);
        params.addBodyParameter("tycode", getCode(username));
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
     * 忘记密码
     *
     * @param bib
     */
    public void modify_pwd(String username, String identify_code, String password,String password_confirm, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "modify_pwd"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "modify_pwd 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("username", username);
        params.addBodyParameter("identify_code", identify_code);
        params.addBodyParameter("password", password);
        params.addBodyParameter("password_confirm", password_confirm);
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

    public String getCode(String phoneNum) {
        BigInteger b = new BigInteger(phoneNum);
        BigInteger c = new BigInteger(phoneNum.trim().substring(1, 9));
        BigInteger ss = b.mod(c);
        Calendar cc = Calendar.getInstance();
        int day = cc.get(Calendar.DAY_OF_MONTH);
        int ss2 = ss.intValue() + day;
        String ss1 = md5Password(ss2 + "");
        return ss1;
    }

    /**
     * 修改个人信息
     *
     * @param bib
     */
    public void edit_member_info(String key, String member_nick, String member_avatar,String member_sex,String member_birthday, final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "edit_member_info"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "modify_pwd 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("member_nick", member_nick);
        params.addBodyParameter("member_avatar", new Ossutil().getOssUrlAvatar(member_avatar));
        params.addBodyParameter("member_sex", member_sex);
        params.addBodyParameter("member_birthday", member_birthday);
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
     * 消息列表
     *
     * @param key     key值
     * @param curpage 页码
     * @param bib
     */
    public void msg_list(String key, String curpage, final BaseModelIB bib) {
        String url = buildGetUrl("MemberChat", "msg_list"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("curpage", curpage);
        params.addBodyParameter("message_member_type", "1");
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    ArrayList<MessageModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<MessageModel>>() {
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
     * 消息详情
     *
     * @param key     key值
     * @param message_id 通知ID
     * @param bib
     */
    public void showmsgbatch(String key, String message_id, final BaseModelIB bib) {
        String url = buildGetUrl("MemberChat", "showmsgbatch"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("message_id", message_id);
        params.addBodyParameter("message_member_type", "1");
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MessageModel orderModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<MessageModel>() {
                    }.getType());
                    BIBSucessful(bib, orderModel);
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
     * 删除消息
     *
     * @param key     key值
     * @param message_id 消息ID
     * @param bib
     */
    public void dropBatchMsg(String key, String message_id, final BaseModelIB bib) {
        String url = buildGetUrl("MemberChat", "dropbatchmsg"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("message_id", message_id);
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
     * 充值列表
     * @param bib
     */
//    public void vip_list(final BaseModelIB bib) {
//        String url = buildGetUrl("Index", "vip_list"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<VipModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<VipModel>>() {
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
     * 常见问题
     *
     * @param bib
     */
//    public void member_feedbackqs(final BaseModelIB bib) {
//        String url = buildGetUrl("UserHelp", "member_feedbackqs"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<ArticleModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<ArticleModel>>() {
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
     * 删除消息
     *
     * @param bib
     */
    public void sys_setting(final BaseModelIB bib) {
        String url = buildGetUrl("UserHelp", "sys_setting"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("setting_name", "site_phone");
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
     * 收藏列表
     *
     * @param key     key值
     * @param type 收藏类型
     * @param curpage 页码
     * @param bib
     */
    public void favorites_list(String key, String type, String curpage, final BaseModelIB bib) {
        String url = buildGetUrl("MemberFavorites", "favorites_list"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("fav_type", type);
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
     * 签到页
     *
     * @param member_id     用户ID
     * @param bib
     */
//    public void member_task(String member_id,  final BaseModelIB bib) {
//        String url = buildGetUrl("Index", "member_task"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("member_id", member_id);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    SignModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<SignModel>() {
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
     * 签到
     *
     * @param key     K 值
     * @param bib
     */
    public void member_sign(String key,  final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "member_sign"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
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
     * 我的积分
     *
     * @param key     key值
     * @param bib
     */
    public void member_points(String key, final BaseModelIB bib) {
        String url = buildGetUrl("MemberPoints", "member_points"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_list"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
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
     * 积分商品
     *
     * @param key     key值
     * @param bib
     */
//    public void member_points_goods(String key, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberPoints", "member_points_goods"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<PointsGoodsModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<PointsGoodsModel>>() {
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
     * 积分兑换
     *
     * @param key key值
     * @param pgoods_id 积分商品ID
     * @param bib
     */
    public void member_points_buy(String key,String pgoods_id,final BaseModelIB bib) {
        String url = buildGetUrl("MemberPoints", "member_points_buy"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("pgoods_id", pgoods_id);
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
     * 更换手机号
     *
     * @param key key值
     * @param username_old 旧手机号
     * @param identify_code_old 旧手机号验证码
     * @param username_new 新手机号
     * @param identify_code_new 新手机号验证码
     * @param bib
     */
    public void modify_member_name(String key,String username_old,String identify_code_old, String username_new,String identify_code_new,final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "modify_member_name"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("username_old", username_old);
        params.addBodyParameter("identify_code_old", identify_code_old);
        params.addBodyParameter("username_new", username_new);
        params.addBodyParameter("identify_code_new", identify_code_new);
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
     * 修改密码
     *
     * @param key key值
     * @param userpwd 旧密码
     * @param password 新密码
     * @param confirm_password 确认新密码
     * @param bib
     */
    public void modify_pwd2(String key,String userpwd,String password, String confirm_password,final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "modify_pwd"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        params.addBodyParameter("userpwd", userpwd);
        params.addBodyParameter("password", password);
        params.addBodyParameter("confirm_password", confirm_password);
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
     * 意见反馈
     *
     * @param member_id 用户ID
     * @param content 反馈
     * @param bib
     */
    public void member_feedback(String member_id,String content,final BaseModelIB bib) {
        String url = buildGetUrl("UserHelp", "member_feedback"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "identifycode 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("member_id", member_id);
        params.addBodyParameter("content", content);
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
     * 一级分类
     *
     * @param type     类型1动画2视频3教师
     * @param bib
     */
//    public void good_class(String type,  final BaseModelIB bib) {
//        String url = buildGetUrl("GoodsClass", "good_class"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("type", type);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<GoodsClassModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<GoodsClassModel>>() {
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
     * 课程列表
     *
     * @param gc_id     分类ID
     * @param member_id     用户ID
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
//    public void order_goods_list(String key, String order_goods_type, String curpage, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberOrder", "order_goods_list"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("order_goods_type", order_goods_type);
//        params.addBodyParameter("curpage", curpage);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    ArrayList<OrderGoodsModel> orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<ArrayList<OrderGoodsModel>>() {
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
     * 教师详情
     *
     * @param teacher_id     教师ID
     * @param member_id     用户ID
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
//    public void order_goods_detail(String key, String order_id, String rec_id, final BaseModelIB bib) {
//        String url = buildGetUrl("MemberOrder", "order_goods_detail"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "favorites_list"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("key", key);
//        params.addBodyParameter("order_id", order_id);
//        params.addBodyParameter("rec_id", rec_id);
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                if (rm.getState() == 1) { // 成功
//                    OrderGoodsModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), new TypeToken<OrderGoodsModel>() {
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

    /**
     *  首页测试
     *
     * @param bib
     */
    public void first_animation(final BaseModelIB bib) {
        String url = buildGetUrl("UserHelp", "first_animation"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "new_message 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
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
     * 生成32位md5码
     *
     * @param password
     * @return
     */
    public static String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 检验自身是否一个合法的类型
     *
     * @return
     */
    public String isLegal() {
        if (key.length() < 1) {
            return " key非法";
        }
        if (TextUtils.isEmpty(member_name)) {
            return " member_name非法";
        }
        return "access";
    }

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