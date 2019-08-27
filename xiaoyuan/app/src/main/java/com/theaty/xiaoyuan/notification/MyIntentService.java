package com.theaty.xiaoyuan.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.system.DatasStore;
import com.theaty.xiaoyuan.ui.activity.MainActivity;

import foundation.log.LogUtils;
import foundation.notification.NotificationCenter;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */

public class MyIntentService extends GTIntentService {

    /**
     * 为了观察透传数据变化.
     */
    private static int cnt;

    public MyIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
        LogUtils.e("个推onReceiveServicePid -> " + pid);
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        LogUtils.e("个推onReceiveMessageData -> " + msg.toString());
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();

        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        LogUtils.e("个推call sendFeedbackMessage = " + (result ? "success" : "failed"));

        LogUtils.e("个推onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid
                + "\npayload = " + new String(payload)
                + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            LogUtils.e("个推receiver payload = null");
        } else {
            String data = new String(payload);
            JSONObject datas = JSON.parseObject(data);
            LogUtils.e("个推receiver payload = " + datas.toString() + "\n title：" + datas.getString("title") +
                    "\n transmissionContent：" + datas.getString("transmissionContent") +
                    "\n message_id：" + datas.getInteger("message_id") );
            showNotification(datas.getString("title"),datas.getString("transmissionContent"),datas.getInteger("message_id"), context);
        }
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
        DatasStore.setCid(clientid);

//        new MemberModel().update_cid(DatasStore.getCurMember().key, clientid, new BaseModel.BaseModelIB() {
//            @Override
//            public void StartOp() {}
//
//            @Override
//            public void successful(Object o) {
//                Log.e("上传clientid：", "成功");
//            }
//
//            @Override
//            public void failed(ResultsModel resultsModel) {
//                Log.e("上传clientid：", resultsModel.getStringDatas());
//            }
//        });
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
        LogUtils.e("个推onReceiveCommandResult -> " + cmdMessage.toString());

        int action = cmdMessage.getAction();

        if (action == PushConsts.SET_TAG_RESULT) {
            setTagResult((SetTagCmdMessage) cmdMessage);
        } else if ((action == PushConsts.THIRDPART_FEEDBACK)) {
            feedbackResult((FeedbackCmdMessage) cmdMessage);
        }
    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage gtNotificationMessage) {
        LogUtils.e("个推onNotificationMessageArrived -> " + gtNotificationMessage.getTitle()+",content:"+gtNotificationMessage.getContent());
        //showNotification(gtNotificationMessage.getTitle(),gtNotificationMessage.getContent(),Integer.valueOf(gtNotificationMessage.getMessageId()),context);
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage gtNotificationMessage) {
        LogUtils.e("个推onNotificationMessageClicked -> " + gtNotificationMessage.getTitle()+",content:"+gtNotificationMessage.getContent());
    }

    private void setTagResult(SetTagCmdMessage setTagCmdMsg) {
        String sn = setTagCmdMsg.getSn();
        String code = setTagCmdMsg.getCode();

        String text = "设置标签失败, 未知异常";
        switch (Integer.valueOf(code)) {
            case PushConsts.SETTAG_SUCCESS:
                text = "设置标签成功";
                break;

            case PushConsts.SETTAG_ERROR_COUNT:
                text = "设置标签失败, tag数量过大, 最大不能超过200个";
                break;

            case PushConsts.SETTAG_ERROR_FREQUENCY:
                text = "设置标签失败, 频率过快, 两次间隔应大于1s且一天只能成功调用一次";
                break;

            case PushConsts.SETTAG_ERROR_REPEAT:
                text = "设置标签失败, 标签重复";
                break;

            case PushConsts.SETTAG_ERROR_UNBIND:
                text = "设置标签失败, 服务未初始化成功";
                break;

            case PushConsts.SETTAG_ERROR_EXCEPTION:
                text = "设置标签失败, 未知异常";
                break;

            case PushConsts.SETTAG_ERROR_NULL:
                text = "设置标签失败, tag 为空";
                break;

            case PushConsts.SETTAG_NOTONLINE:
                text = "还未登陆成功";
                break;

            case PushConsts.SETTAG_IN_BLACKLIST:
                text = "该应用已经在黑名单中,请联系售后支持!";
                break;

            case PushConsts.SETTAG_NUM_EXCEED:
                text = "已存 tag 超过限制";
                break;

            default:
                break;
        }

        LogUtils.e("个推settag result sn = " + sn + ", code = " + code + ", text = " + text);
    }

    private void feedbackResult(FeedbackCmdMessage feedbackCmdMsg) {
        String appid = feedbackCmdMsg.getAppid();
        String taskid = feedbackCmdMsg.getTaskId();
        String actionid = feedbackCmdMsg.getActionId();
        String result = feedbackCmdMsg.getResult();
        long timestamp = feedbackCmdMsg.getTimeStamp();
        String cid = feedbackCmdMsg.getClientId();

        LogUtils.e("个推onReceiveCommandResult -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nactionid = " + actionid + "\nresult = " + result
                + "\ncid = " + cid + "\ntimestamp = " + timestamp);
    }

    private void showNotification(String title,String text,int message_id, Context context) {
        LogUtils.e("个推：showNotification" + title + ", text: " + text);
        Intent intent;
        if(DatasStore.isLogin()){
            LogUtils.e("个推：页面点击效果：MessageActivity");
//            new AlertDialog.Builder(getApplicationContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
//                    .setMessage(text)
//                    .setPositiveButton("保存", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    }).show();
            //如果已经等了就跳转到接受信息的展示的界面，这里暂用MainActivity代替
            intent = new Intent(context, MainActivity.class);
            NotificationCenter.defaultCenter.postNotification(NotificationKey.ISMESSAGE);
            intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }else{
            LogUtils.e("个推：页面点击效果：TabMainActivity");
            //如果是没有登录的就跳转到Splash起始界面
            intent = new Intent(context, MainActivity.class);
            NotificationCenter.defaultCenter.postNotification(NotificationKey.ISMESSAGE);
            intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        }
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        PendingIntent pendingIntent = PendingIntent.getActivities(context, 1, makeIntentStack(context), PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent).build();

        NotificationManager nManger = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nManger.notify(message_id, notification);
    }

}
