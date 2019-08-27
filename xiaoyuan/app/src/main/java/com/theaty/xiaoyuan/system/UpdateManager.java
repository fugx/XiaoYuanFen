package com.theaty.xiaoyuan.system;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;

import com.theaty.xiaoyuan.model.BaseModel;
import com.theaty.xiaoyuan.model.ResultsModel;
import com.theaty.xiaoyuan.model.SystemModel;
import com.theaty.xiaoyuan.model.yuan.MemberModel;


/**
 * Created by Administrator on 2016/4/29.
 */
public class UpdateManager {

    private static Activity mActivity;

    public static void checkUpdate(Activity activity){
        mActivity = activity;
        new MemberModel().mb_version_new(foundation.util.AppUtils.getAppVersionCode(activity)+"",new BaseModel.BaseModelIB() {
            @Override
            public void StartOp() {}

            @Override
            public void successful(Object o) {
                if (null != o && o instanceof SystemModel) {
                    final SystemModel bean = (SystemModel) o;
                    if (AppUtils.isApplicationUpdatable(mActivity, mActivity.getPackageName(), (int) bean.getVersion_info().getVersion_num())) {
                        new AlertDialog.Builder(mActivity).setMessage("检测到新版本，是否更新？").setPositiveButton("更新", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(bean.getVersion_info().getUpdate_url()));
                                mActivity.startActivity(intent);
                                dialog.dismiss();
                            }
                        }).setNegativeButton("取消", null).show();
                    }
                }
            }

            @Override
            public void failed(ResultsModel resultsModel) {}
        });
    }
}
