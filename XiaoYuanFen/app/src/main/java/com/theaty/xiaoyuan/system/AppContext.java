package com.theaty.xiaoyuan.system;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.multidex.MultiDex;
import android.view.WindowManager;

import com.blankj.utilcode.utils.Utils;
import com.theaty.xiaoyuan.db.DBOpenHelper;
import com.theaty.xiaoyuan.db.HistoryDataManager;
import com.theaty.xiaoyuan.oss.OssManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import foundation.toast.ToastManager;
import foundation.util.DataCleanManager;
import foundation.util.MethodsCompat;
import foundation.util.ThreadUtils;


public class AppContext extends CrashReportingApplication {

    private static final String TAG = AppContext.class.getSimpleName();
    private static AppContext mContext;
    private DBOpenHelper dbOpenHelper;
    private HistoryDataManager historyDataManager;
    private WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getWindowParams() {
        return windowParams;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        // 工具类初始化
        Utils.init(this);

        //PgyCrashManager.register(this);

//        // 效果图比对功能
//		if (BuildConfig.DEBUG) {
//            startService(new Intent(this, DebugService.class));
//        }

        // 个推初始化
        //PushManager.getInstance().initialize(this.getApplicationContext(), MyPushService.class);
        //PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), MyIntentService.class);

        // 友盟初始化，未申请到各平台key时请注释友盟初始化方法
        Config.DEBUG = true;
//        Config.REDIRECT_URL = "http://sns.whalecloud.com/sin2/callback";
        UMShareAPI.get(this);
        Config.isJumptoAppStore = true;

        //友盟统计
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.openActivityDurationTrack(false);
        //OSS初始化
        OssManager.initOSS();

    }


    public DBOpenHelper getDBOpenHelper() {
        if (dbOpenHelper == null) {
            dbOpenHelper = new DBOpenHelper(this, DatasStore.getUserPhone());
        }
        return dbOpenHelper;
    }

    public HistoryDataManager getHistoryDataManager() {
        if (historyDataManager == null) {
            historyDataManager = new HistoryDataManager(this, getDBOpenHelper().getReadableDatabase());
        }
        return historyDataManager;
    }

    @Override
    public String getReportUrl() {
        return null;
    }

    @Override
    public Bundle getCrashResources() {
        return null;
    }

    //dex65k限制
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static AppContext getInstance() {
        return mContext;
    }
    {
        PlatformConfig.setWeixin("wxa1228c22e6221821", "dc4ebc2c7ba13187234b1467b203361b");
        PlatformConfig.setSinaWeibo("4129882210", "dc4ebc2c7ba13187234b1467b203361b", "http://www.quwudao.com/");
        PlatformConfig.setQQZone("1106202035", "KEYfj1U8GtbNZMjf47p");
    }

    /**
     * 清除app缓存
     */
    public void clearAppCache(boolean showToast) {
        final Handler handler = showToast ? new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    ToastManager.manager.show("缓存清除成功");
                } else {
                    ToastManager.manager.show("缓存清除失败");
                }
            }
        } : null;
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                try {
                    clearAppCache();
                    msg.what = 1;
                } catch (Exception e) {
                    e.printStackTrace();
                    msg.what = -1;
                }
                if (handler != null)
                    handler.sendMessage(msg);
            }
        });
    }

    /**
     * 清除app缓存
     */
    public void clearAppCache() {
        DataCleanManager.cleanDatabases(this);
        // 清除数据缓存
        DataCleanManager.cleanInternalCache(this);
        // 2.2版本才有将应用缓存转移到sd卡的功能
        if (isMethodsCompat(android.os.Build.VERSION_CODES.FROYO)) {
            DataCleanManager.cleanCustomCache(MethodsCompat
                    .getExternalCacheDir(this));
        }

    }

    /**
     * 判断当前版本是否兼容目标版本的方法
     *
     * @param VersionCode
     * @return
     */
    public static boolean isMethodsCompat(int VersionCode) {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        return currentVersion >= VersionCode;
    }
}
