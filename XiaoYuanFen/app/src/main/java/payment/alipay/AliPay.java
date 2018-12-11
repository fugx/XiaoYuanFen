package payment.alipay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AliPay {
    protected static final int SDK_PAY_FLAG = 1;
    static int PAY = 1;
    private static Context mContext;
    private static Class<? extends Activity> mTo;
    String url;

    public static void pay(final Activity activity, final String orderInfo) {
        pay(activity, null, orderInfo);
    }

    public static void pay(final Activity activity, Class<? extends Activity> to, final String orderInfo) {
        mTo = to;
        mContext = activity;
        new Thread(new Runnable() {

            @Override
            public void run() {
                PayTask payTask = new PayTask(activity);
                String result = payTask.pay(orderInfo, true);

                Message message = Message.obtain();
                message.what = SDK_PAY_FLAG;
                message.obj = result;
                handler.sendMessage(message);
            }
        }).start();
    }

    private static Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG:
                    AliPayResult payResult = new AliPayResult((String) msg.obj);
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(mContext, "支付成功", Toast.LENGTH_LONG).show();
//                        startActivity(PaymentActivity.amount + "");

                    } else if (TextUtils.equals(resultStatus, "6001")) {
                        Toast.makeText(mContext, "取消支付", Toast.LENGTH_LONG).show();
                       // sendNotification(2);
//                        startActivity2();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(mContext, "支付结果确认中", Toast.LENGTH_LONG).show();
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(mContext, "支付失败", Toast.LENGTH_LONG).show();
//                            startActivity2();
                           // sendNotification(2);
                        }
                    }

                    break;
            }
        }

    };

//    private static void sendNotification(int isSuccess) {
//        if (ChoicePaymentActivity.getResultJump()) {
//            NotificationCenter.defaultCenter.postNotification(matchRegistrationFee, isSuccess);
//        } else {
//            if (null != mContext)
//                mContext.startActivity(new Intent(mContext, MyOrderActivity.class));
//        }
//    }

//    private static void startActivity2() {
//        if (null == mTo)
//            return;
//        Intent intent = new Intent(mContext, MyOrderActivity.class);
//        mContext.startActivity(intent);
//    }
    private static void startActivity(String amount) {
        if (null == mTo)
            return;
        Intent intent = new Intent(mContext, mTo);
        intent.putExtra("amount", amount);
        mContext.startActivity(intent);
    }

    public static String getOrderInfoForAliClient(String orderInfoNotSign, String sign) {

        // 仅需对sign 做URL编码
        try {
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return orderInfoNotSign + "&sign=" + "\"" + sign + "\"" + "&sign_type=\"RSA\"";
    }

    /**
     * @param rightNow 是否立即支付
     * @param pay_sn
     * @param order_sn
     * @param subject
     * @param body
     * @param total_fee
     * @return
     */
    public static String getOrderInfoForOwnInterface(boolean rightNow, String pay_sn, String order_sn, String subject, String body, double total_fee) {
        String orderInfo = "";
        // 商户网站唯一订单号
        //立即支付pay_sn,非立即order_sn
        if (rightNow) {
            orderInfo += "out_trade_no=" + "\"" + pay_sn + "\"";

            orderInfo += "&pay_sn=" + "\"" + pay_sn + "\"";
        } else {
            orderInfo += "out_trade_no=" + "\"" + order_sn + "\"";

            orderInfo += "&order_sn=" + "\"" + order_sn + "\"";
        }


        orderInfo += "&subject=" + "\"" + subject + "\"";
        orderInfo += "&body=" + "\"" + body + "\"";
        orderInfo += "&total_fee=" + "\"" + total_fee + "\"";
        orderInfo += "&notify_url=\"http://39.106.155.228/Mobile/Payment/notify/payment_code/alipay.html\"";

        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";
        return orderInfo;

    }
    /**(支付券)
     * @param rightNow
     * @param pay_sn
     * @param order_sn
     * @param subject
     * @param body
     * @param total_fee
     * @return
     */
    public static String getOrderInfoForOwnInterface2(boolean rightNow, String pay_sn, String order_sn, String subject, String body, double total_fee) {
        String orderInfo = "";
        // 商户网站唯一订单号
        //立即支付pay_sn,非立即order_sn
        if (rightNow) {
            orderInfo += "out_trade_no=" + "\"" + pay_sn + "\"";

            orderInfo += "&pay_sn=" + "\"" + pay_sn + "\"";
        } else {
            orderInfo += "out_trade_no=" + "\"" + order_sn + "\"";

            orderInfo += "&order_sn=" + "\"" + order_sn + "\"";
        }


        orderInfo += "&subject=" + "\"" + subject + "\"";
        orderInfo += "&body=" + "\"" + body + "\"";
        orderInfo += "&total_fee=" + "\"" + total_fee + "\"";
        orderInfo += "&notify_url=\"http://47.94.198.177/Mobile/Payment/notify_voucher/payment_code/alipay\"";

        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";
        return orderInfo;

    }
}
