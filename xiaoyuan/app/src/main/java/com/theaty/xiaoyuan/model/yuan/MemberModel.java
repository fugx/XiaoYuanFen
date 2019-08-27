package com.theaty.xiaoyuan.model.yuan;


import android.app.Activity;
import android.text.TextUtils;

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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;

import foundation.log.LogUtils;

/**
 * @author Theaty
 * @desc 会员模型
 */
public class MemberModel extends BaseModel {

    public int member_type;
    public int trace_id;
    /**
     * 背景
     */
    public String member_back;

    /**
     * freeze_points',
     */
    public int freeze_points;
    /**
     * 个性签名',
     */
    public String member_sign;
    public String conversationId;
    /**
     * 绑定店铺id',
     */
    public int bind_storeid;
    /**
     * 点赞数',
     */
    public int like_num;
    /**
     * 会员id',
     */
    public int member_id;
    /**
     * 校验key
     */
    public String key;
    /**
     * 会员名称',
     */
    public String member_name;
    /**
     * 会员昵称
     */
    public String member_nick;
    /**
     * 真实姓名',
     */
    public String member_truename;
    /**
     * 会员头像',
     */
    public String member_avatar;
    /**
     * 会员性别 (男1，女2)
     */
    public int member_sex;
    /**
     * 生日',
     */
    public String member_birthday;
    /**
     * 会员密码',
     */
    public String member_passwd;
    /**
     * 支付密码',
     */
    public String member_paypwd;
    /**
     * 会员邮箱',
     */
    public String member_email;

    /**
     * 可用充值卡余额
     */
    public double available_rc_balance;
    /**
     * 冻结充值卡余额
     */
    public double freeze_rc_balance;
    /**
     * 0未绑定1已绑定',
     */
    public boolean member_email_bind;
    /**
     * 手机号',
     */
    public String member_mobile;
    /**
     * 0未绑定1已绑定',
     */
    public boolean member_mobile_bind;
    /**
     * qq',
     */
    public String member_qq;
    /**
     * 阿里旺旺',
     */
    public String member_ww;
    /**
     * 登录次数',
     */
    public int member_login_num;
    /**
     * 会员注册时间',
     */
    public String member_time;
    /**
     * 当前登录时间',
     */
    public String member_login_time;
    /**
     * 上次登录时间',
     */
    public String member_old_login_time;
    /**
     * 当前登录ip',
     */
    public String member_login_ip;
    /**
     * 上次登录ip',
     */
    public String member_old_login_ip;
    /**
     * qq互联id',
     */
    public String member_qqopenid;
    /**
     * qq账号相关信息',
     */
    public String member_qqinfo;
    /**
     * 新浪微博登录id',
     */
    public String member_sinaopenid;
    /**
     * 新浪账号相关信息序列化值',
     */
    public String member_sinainfo;
    /**
     * 微信登录openid
     */
    public String member_wx_openid;
    /**
     * 会员积分',
     */
    public int member_points;
    /**
     * 预存款可用金额',
     */
    public double available_predeposit;
    /**
     * 运费金额',
     */
    public double order_goods_num;
    /**
     * 订单总金额',
     */
    public String order_shipping_sum;
    /**
     * 预存款冻结金额',
     */
    public double freeze_predeposit;

    /**
     * 是否允许举报(1可以/2不可以)',
     */
    public int inform_allow;
    /**
     * 会员是否有购买权限 1为开启 0为关闭',
     */
    public boolean is_buy;
    /**
     * 会员是否有咨询和发送站内信的权限 1为开启 0为关闭',
     */
    public boolean is_allowtalk;
    /**
     * 会员的开启状态 1为开启 0为关闭',
     */
    public boolean member_state;
    /**
     * 会员信用',
     */
    public int member_credit;
    /**
     * sns空间访问次数',
     */
    public int member_snsvisitnum;
    /**
     * 地区id',
     */
    public int member_areaid;
    /**
     * 城市id',
     */
    public int member_cityid;
    /**
     * 省份id',
     */
    public int member_provinceid;
    /**
     * 地区内容',
     */
    public String member_areainfo;
    public String member_contell;//星座
    /**
     * 提现手续费（百分比）',
     */
    public String site_poundage;
    /**
     * 提现规则
     * 规则1，规则2',
     */
    public String site_tx_rules;
    //星座
    public String member_constell;
    //简介
    public String member_intro;


    /**
     * 检验自身是否一个合法的类型
     *
     * @return
     */
    public String isLegal() {

//		if (member_id <= 0) {
//			return " member_id非法";
//		}
        if (key.length() < 1) {
            return " key非法";
        }
        if (TextUtils.isEmpty(member_name)) {
            return " member_name非法";
        }
        return "access";
    }

    /**
     * 分享接口
     *
     * @param type         分享的类型（0--商品详情，1--收藏菜谱列表的分享）
     * @param cookbook_ids 对应要分享的菜谱id(注：分享收藏列表时，该参数传列表的所有cookbook_id,且以","分割)
     * @param bib
     */
    public void share_interface(int type, String cookbook_ids, final BaseModelIB bib) {
        String url = buildGetUrl("Index", "share_interface"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "share_interface"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("type", String.valueOf(type));
        switch (type) {
            case 0:
                params.addBodyParameter("cookbook_ids", cookbook_ids);
                break;
            case 1:
                params.addBodyParameter("cookbook_ids", cookbook_ids);
                break;
            case 2:
                break;
        }
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
     * 关于我们
     *
     * @param bib
     */
    public void about_us(final BaseModelIB bib) {
        String url = buildGetUrl("Index", "about_us"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "about_us"); // 回调不能为空

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
     * 注册生成验证码
     *
     * @param username 用户名（电话号码）
     * @param bib
     */
    public void login_identifycode(String username, final BaseModelIB bib) {
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
        String url = buildGetUrl("Login", "checkIdentify"); // 构建API地址
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
     * 会员注册
     *
     * @param username 用户名（电话号码）
     * @param password 用户密码
     *                 //@param client           类型 客户端类型（'android'，'wechat', 'ios'）
     * @param bib
     */
    public void register(String username, String password, String identify_code, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "register"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "register 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("username", username);
        params.addBodyParameter("password", password);
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
     * 忘记密码
     *
     * @param bib
     */
    public void modify_pwd(
            String phone_num,
            String captcha,
            String password,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberPwd", "modify_pwd"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "modify_pwd 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("phone_num", phone_num);
        params.addBodyParameter("captcha", captcha);
        params.addBodyParameter("password", password);
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
     * 会员登陆
     *
     * @param username 用户名（电话号码）
     * @param password 用户密码
     *                 //@param client           类型 客户端类型（'android'，'wechat', 'ios'）
     * @param bib
     */
    public void Login(String username, String password, final BaseModelIB bib) {
        String url = buildGetUrl("Login", "index"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "index 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("username", username);
        //params.addBodyParameter("identify_code", password);
        params.addBodyParameter("password", password);
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
     * 修改会员个推cid
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
        params.addBodyParameter("client_type_1", "android");


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
     * 会员详细信息
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
     * 修改会员详细信息
     *
     * @param key key值
     * @param bib
     */
    public void member_edit(String key,
                            String member_avatar,
                            String member_nick,
                            String member_intro,
                            String member_sex,//性别(男:1;女:2)
                            String member_birthday,//生日(格式:1992/02/14)
                            String province_id,
                            String province_name,
                            String city_id,
                            String city_name,
                            String area_id,
                            String area_name,
                            String member_constell,//星座
                            final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "member_edit"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "member_edit"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        //if (member_avatar.trim().length() > 0) {
            params.addBodyParameter("member_avatar", new Ossutil().getOssUrlAvatar(member_avatar));
        //}
        if (member_nick.length() > 0) {
            params.addBodyParameter("member_nick", member_nick);
        }

        if (member_intro.length() >= 0) {
            params.addBodyParameter("member_intro", member_intro);
        }
        if (member_sex.length() > 0) {
            params.addBodyParameter("member_sex", member_sex);
        }
        if (member_birthday.length() > 0) {
            params.addBodyParameter("member_birthday", member_birthday);
        }
       // if (province_id.length() > 0) {
            params.addBodyParameter("province_id", province_id);
       // }
       // if (province_name.length() > 0) {
            params.addBodyParameter("province_name", province_name);
       // }
       // if (city_id.length() > 0) {
            params.addBodyParameter("city_id", city_id);
       // }
       // if (city_name.length() > 0) {
            params.addBodyParameter("city_name", city_name);
       // }
        //if (area_id.length() > 0) {
            params.addBodyParameter("area_id", area_id);
       // }
       // if (area_name.length() > 0) {
            params.addBodyParameter("area_name", area_name);
       // }
        if (member_constell.length() > 0) {
            params.addBodyParameter("member_constell", member_constell);
        }

        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), MemberModel.class);
                    DatasStore.setCurMember(orderModels);
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
     * 修改会员头像
     *
     * @param key key值
     * @param bib
     */
    public void member_edit_avater(String key,
                                   String member_avatar,

                                   final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "member_edit"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "member_edit"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", key);
        if (member_avatar.trim().length() > 0) {
            params.addBodyParameter("member_avatar", new Ossutil().getOssUrlAvatar(member_avatar));
        }
        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功
                    MemberModel orderModels = ThtGosn.genGson().fromJson(rm.getJsonDatas(), MemberModel.class);
                    DatasStore.setCurMember(orderModels);
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
     * 会员银行卡删除
     *
     * @param bib
     */
    public void card_del(
            int card_id,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberCard", "card_del"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "card_del 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("card_id", card_id + "");

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
     * 会员银行卡增加
     *
     * @param bib
     */
    public void card_add(

            String bank_name,
            String card_num,
            String card_username,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberCard", "card_add"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "card_add 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("bank_name", bank_name + "");
        params.addBodyParameter("card_num", card_num + "");
        params.addBodyParameter("card_username", card_username + "");

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
     * 会员银行卡编辑
     *
     * @param bib
     */
    public void card_edit(
            int card_id,
            String bank_name,
            String card_num,
            String card_username,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberCard", "card_edit"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "card_edit 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);
        params.addBodyParameter("card_id", card_id + "");

        params.addBodyParameter("bank_name", bank_name);
        params.addBodyParameter("card_num", card_num);
        params.addBodyParameter("card_username", card_username);

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
     * 会员银行卡详情
     *
     * @param bib
     */
    public void card_info(
            int card_id,

            final BaseModelIB bib) {
        String url = buildGetUrl("MemberCard", "card_info"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "card_info 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("card_id", card_id + "");

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
     * 删除视频/资讯
     *
     * @param trace_ids 视频id/资讯id(多个用","隔开)
     * @param bib
     */
    public void tracelog_del(
            String trace_ids,

            final BaseModelIB bib) {
        String url = buildGetUrl("MemberAdd", "tracelog_del"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "tracelog_del 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("trace_ids", trace_ids + "");

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
     * 删除评论
     *
     * @param comment_id 评论id
     * @param bib
     */
    public void del_comment(
            int comment_id,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberAdd", "del_comment"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "del_comment 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("comment_id", comment_id + "");

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
     * 发布视频
     *
     * @param title   视频标题
     * @param content 视频简介
     * @param video   视频文件名称
     * @param image   视频封面
     *  @param label_id 标签id
     * @param bib
     */
    public void video_add(final Activity activity,
                          final String title,
                          final String content,
                          final String video,
                          final String image,
                          final String video_length,
                          final int label_id,
                          final BaseModelIB bib) {
        new Thread(new Runnable() {
            @Override
            public void run() {


                final String url = buildGetUrl("MemberAdd", "video_add"); // 构建API地址
                if (bib == null)
                    LogUtils.e("TTError", "video_add 参数bib为null"); // 回调不能为空
                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            BIBStart(bib); // 开始bib
                        }
                    });

                final RequestParams params = new RequestParams();
                params.addBodyParameter("key", DatasStore.getCurMember().key);
                params.addBodyParameter("title", title + "");
                params.addBodyParameter("content", content + "");
                params.addBodyParameter("video_length", video_length + "");
                params.addBodyParameter("label_id", label_id + "");
                if (image != null) {
                    //封面单张
                    params.addBodyParameter("image", new Ossutil().getOssUrl(image, Ossutil.tracelog));
                }
                if (video != null) {
                    //视频
                    params.addBodyParameter("video", new Ossutil().getOssUrl(video, Ossutil.tracelog));
                }
                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
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
                    });

            }
        }).start();

    }

    /**
     * 发布评论
     *
     * @param item_id 资讯id/视频id
     * @param content 评论内容
     * @param bib
     */
    public void add_comment(
            int item_id,
            String content,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberAdd", "add_comment"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "add_comment 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("item_id", item_id + "");
        params.addBodyParameter("content", content);
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
     * 发布资讯
     *
     * @param title   资讯标题
     * @param content 资讯内容
     * @param img     资讯图片
     * @param label_id    标签id
     * @param bib
     */
    public void news_add(final Activity activity,
                         final String title,
                         final String content,
                         final ArrayList<String> img,
                         final int label_id,
                         final BaseModelIB bib) {
        new Thread(new Runnable() {
            @Override
            public void run() {


                final String url = buildGetUrl("MemberAdd", "news_add"); // 构建API地址
                if (bib == null)
                    LogUtils.e("TTError", "news_add 参数bib为null"); // 回调不能为空
                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            BIBStart(bib); // 开始bib
                        }
                    });

                final RequestParams params = new RequestParams();
                params.addBodyParameter("key", DatasStore.getCurMember().key);
                params.addBodyParameter("title", title + "");
                params.addBodyParameter("content", content + "");
                params.addBodyParameter("label_id", label_id + "");
                final ArrayList<String> imgs = new Ossutil().getOssUrl(img, Ossutil.tracelog);
                if (null != imgs) {
                    for (int i = 0; i < imgs.size(); i++) {
                        params.addBodyParameter("img" + i, imgs.get(i));
                    }
                }

                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
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
                    });

            }
        }).start();

    }


    /**
     * 删除收藏
     *
     * @param item_id   收藏id 多个加 ，
     * @param item_type 收藏类型(1:音乐;2:视频;3:资讯)
     * @param bib
     */
    public void favorites_del(
            String item_id,
            int item_type,

            final BaseModelIB bib) {
        String url = buildGetUrl("MemberFavorites", "favorites_del"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_del 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("item_ids", item_id + "");
        params.addBodyParameter("item_type", item_type + "");


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
     * 添加收藏
     *
     * @param item_id   收藏id
     * @param item_type 收藏类型(1:音乐;2:视频;3:资讯)
     * @param bib
     */
    public void favorites_add(
            int item_id,
            int item_type,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberFavorites", "favorites_add"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "favorites_add 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("item_id", item_id + "");
        params.addBodyParameter("item_type", item_type + "");
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
     * 举报视频/资讯
     *
     * @param item_id   收藏id
     * @param item_type 收藏类型(1:音乐;2:视频;3:资讯)
     * @param content   举报内容
     * @param bib
     */
    public void inform(
            int item_id,
            int item_type,
            String content,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberFeedback", "inform"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "inform 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("item_id", item_id + "");
        params.addBodyParameter("item_type", item_type + "");
        params.addBodyParameter("content", content + "");
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
     * 删除消息
     *
     * @param message_id 消息id
     * @param bib
     */
    public void del_message(
            int message_id,

            final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "del_message"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "del_message 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("message_id", message_id + "");

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
     * 新消息提醒
     *
     * @param bib
     */
    public void new_message(
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "new_message"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "new_message 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);
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
     * 意见反馈
     *
     * @param
     */
    public void feedback_add(
            String feedback,
            String img,
            final BaseModelIB bib) {
        String url = buildGetUrl("MemberFeedback", "feedback_add"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "feedback_add 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();
        params.addBodyParameter("key", DatasStore.getCurMember().key);

        params.addBodyParameter("feedback", feedback + "");

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
     * 提现规则
     *
     * @param bib
     */

    public void txRules(String key, final BaseModelIB bib) {
        String url = buildGetUrl("MemberIndex", "tx_rules"); // 构建API地址
        if (bib == null)
            LogUtils.e("TTError", "txRules 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams();

        params.addBodyParameter("key", key);

        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                DebugUtil.getIntance().getInfo(resultInfo.result, DatasStore.getDebugState());
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (rm.getState() == 1) { // 成功

                    MemberModel memberModel = ThtGosn.genGson().fromJson(rm.getJsonDatas(), MemberModel.class);
                    BIBSucessful(bib, memberModel);
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