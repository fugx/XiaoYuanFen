package com.theaty.xiaoyuan.system;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.theaty.xiaoyuan.model.yuan.MemberModel;

import java.lang.reflect.Type;
import java.util.ArrayList;

import foundation.toast.ToastUtil;
import foundation.util.StringUtil;

/**
 * 数据存取
 *
 * @author
 */
public class DatasStore {
    private static AppContext myApp = AppContext.getInstance();
    public static SharedPreferences infoSP = myApp.getSharedPreferences("songqi_deliver_info", Context.MODE_PRIVATE);
    private static final String KEY_FIRST_LAUNCH = "fistLaunch";
    private static final String KEY_USER_PHONE = "key_user_phone";
    private static final String KEY_USER_PASSWORD = "key_user_password";
    //用户城市
    private static final String KEY_USER_CITY = "key_user_city";

    public static void setFirstLaunch(Boolean mm) {
        infoSP.edit().putBoolean(KEY_FIRST_LAUNCH, mm)
                .commit();
    }

    public static Boolean isFirstLaunch() {
        return infoSP.getBoolean(KEY_FIRST_LAUNCH, true);
    }

    private static String KEY_SAVE_PASSWORD = "isSavePassword";

    /**
     * 读取登陆页面"记住密码"复选框状态
     *
     * @return
     */
    public static boolean isSavePassword() {
        return infoSP.getBoolean(KEY_SAVE_PASSWORD, false);
    }

    /**
     * 保存登陆页面"记住密码"复选框状态
     *
     * @return
     */
    public static void setSavePassword(boolean isSave) {
        infoSP.edit().putBoolean(KEY_SAVE_PASSWORD, isSave).commit();
    }

    /**
     * 保存用户电话登录使用的电话号码
     *
     * @param phone
     */
    public static void saveUserPhone(String phone) {
        infoSP.edit().putString(KEY_USER_PHONE, phone).commit();
    }

    /**
     * 读取用户电话号码
     */
    public static String getUserPhone() {
        return infoSP.getString(KEY_USER_PHONE, "");
    }


    private static final String CUR_MEMBER_KEY = "curMember";

    // 存档会员信息
    public static void setCurMember(MemberModel mm) {
        if (mm == null) {
            ToastUtil.showToast("模型消息：setCurMember 模型为 null");
            return;
        }
        String verString = mm.isLegal();
        if (verString.equals("access")) {
            putObj2Sp(infoSP, CUR_MEMBER_KEY, mm);
        } else {
            ToastUtil.showToast("模型消息：setCurMember" + verString);
        }
    }

    // 获取会员信息
    public static MemberModel getCurMember() {
        MemberModel mmMemberModel = (MemberModel) getObjectFromSp(
                infoSP, CUR_MEMBER_KEY, MemberModel.class);

		if (mmMemberModel == null) {
            return new MemberModel();
		}
		String verString = mmMemberModel.isLegal();
		if (!verString.equals("access")) {
			ToastUtil.showToast("模型消息：getCurMember" + verString);
			return null;
		}
       /* if (mmMemberModel == null) {
            mmMemberModel = new MemberModel();
            mmMemberModel.key = "0725251148c2b9ab065f27d0ef823be7";
            mmMemberModel.member_name = "不要大声点";
            mmMemberModel.member_avatar = "http://quwudao.oss-cn-beijing.aliyuncs.com/Upload/shop/adv/05747819821143069.jpg";
            mmMemberModel.member_intro = "一半是春夏，一半是秋冬";
            mmMemberModel.member_id = 1;
        }*/
        return mmMemberModel;
    }

    // 清除当前用户
    public static void removeCurMember() {
        infoSP.edit().remove(CUR_MEMBER_KEY).commit();// 移除
    }

    // 判断是否登录
    public static boolean isLogin() {
        if (getCurMember() != null && !StringUtil.isEmpty(getCurMember().key)) {
            return true;
        } else {
            return false;
        }
    }

    private static final String IS_BUT_COUPONS = "buyCoupons";

    public static void setCoupons(Boolean mm) {
        infoSP.edit().putBoolean(IS_BUT_COUPONS, mm)
                .commit();
    }

    public static Boolean getCoupons() {
        return infoSP.getBoolean(IS_BUT_COUPONS, true);
    }


    //
    // gson一个对象并存储 如果为null 就删除原有对象
    public static void putObj2Sp(SharedPreferences sp, String key, Object o) {
        if (o != null) {
            Gson gson = new Gson();
            try {
                String ssString = gson.toJson(o, o.getClass());
                sp.edit().putString(key, ssString).commit();
            } catch (Exception e) {
                Log.e("putObj2Sp json转换出错: ", e.getMessage());
            }
        } else {
            sp.edit().remove(key).commit();
        }
    }

    // 获取一个对象 getObjectFromSp(String key,*.class) 失败返回null
    public static Object getObjectFromSp(SharedPreferences sp, String key, Type type) {
        Gson gson = new Gson();
        String ssString = sp.getString(key, "");
        return gson.fromJson(ssString, type);
    }

    private static final String VERSION_NUM = "version_num";

    public static String getVersionNum() {
        return infoSP.getString(VERSION_NUM, "1");
    }

    public static void saveVersionNum(String versionNum) {
        infoSP.edit().putString(VERSION_NUM, versionNum).apply();
    }

    private static final String KEY_GETUI_CID = "getui_cid";

    public static void setCid(String cid) {
        infoSP.edit().putString(KEY_GETUI_CID, cid).apply();
    }

    public static String getCid() {
        return infoSP.getString(KEY_GETUI_CID, null);
    }


    // ********** 搜索商品历史 **********
    private static final String SP_SEARCH_GOODS_HISTORY = "sp_search_goods_history";

    // 保存单个
    public static void saveGoodsSearchHistory(String word) {
        ArrayList<String> list = getGoodsSearchHistory();
        list.add(word);

        infoSP.edit().putString(SP_SEARCH_GOODS_HISTORY, new Gson().toJson(list)).apply();
    }

    // 获取全部
    public static ArrayList<String> getGoodsSearchHistory() {
        ArrayList<String> list = new ArrayList<>();

        String json = infoSP.getString(SP_SEARCH_GOODS_HISTORY, null);
        if (!TextUtils.isEmpty(json)) {
            list = new Gson().fromJson(json, new TypeToken<ArrayList<String>>() {
            }.getType());
        }

        return list;
    }

    // 移除单个
    public static void removeGoodsSearcHistory(String word) {
        ArrayList<String> list = getGoodsSearchHistory();
        list.remove(word);

        infoSP.edit().putString(SP_SEARCH_GOODS_HISTORY, new Gson().toJson(list)).apply();
    }

    // **********  ********** **********
    // ********** 音乐播放足迹历史 **********
    // **********  ********** **********
    private static final String SP_MUSIC_PLAY_HISTORY = "sp_music_play_history";

    // 保存单个
    public static void saveMusicPlayHistory(int music_id) {
        ArrayList<Integer> list = getMusicPlayHistory();
        if (list.contains(Integer.valueOf(music_id))) {
            return;
        }
        list.add(music_id);
        infoSP.edit().putString(SP_MUSIC_PLAY_HISTORY, new Gson().toJson(list)).apply();
    }

    // 获取全部
    public static ArrayList<Integer> getMusicPlayHistory() {
        ArrayList<Integer> list = new ArrayList<>();

        String json = infoSP.getString(SP_MUSIC_PLAY_HISTORY, null);
        if (!TextUtils.isEmpty(json)) {
            list = new Gson().fromJson(json, new TypeToken<ArrayList<Integer>>() {
            }.getType());
        }

        return list;
    }

    // 清楚全部足迹
    public static void removeAllMusicPlayHistory() {
        ArrayList<Integer> list = getMusicPlayHistory();
        list.clear();
        infoSP.edit().putString(SP_MUSIC_PLAY_HISTORY, new Gson().toJson(list)).apply();
    }

    // 移除单个
    public static void removeMusicPlayHistory(int music_id) {
        ArrayList<Integer> list = getMusicPlayHistory();
        list.remove(music_id);

        infoSP.edit().putString(SP_MUSIC_PLAY_HISTORY, new Gson().toJson(list)).apply();
    }

    // ********** 获取搜藏菜谱 **********
    private static final String SP_COOKS = "sp_cooks";


    private static final String DEBUGSTATE = "debugstate";

    /**
     * 保存debug状态
     *
     * @param isshow
     */
    public static void saveDebugState(int isshow) {
        infoSP.edit().putInt(DEBUGSTATE, isshow).commit();
    }

    /**
     * 获取
     */
    public static int getDebugState() {
        return infoSP.getInt(DEBUGSTATE, 2);
    }

}
