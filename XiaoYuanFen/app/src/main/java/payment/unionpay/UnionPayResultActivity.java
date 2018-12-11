package payment.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class UnionPayResultActivity extends Activity{
    public static final String FLAG_TN = "tn";
    public static Class<? extends Activity> mToActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String tn = getIntent().getStringExtra(FLAG_TN);
        UnionPay.pay(this,tn);
    }

    public static void pay(Context context,String tn){
        pay(context,null,tn);
    }

    public static void pay(Context context,Class<? extends Activity> toActivity,String tn){
        mToActivity = toActivity;
        Intent intent = new Intent(context,UnionPayResultActivity.class);
        intent.putExtra(FLAG_TN,tn);
        context.startActivity(intent);
    }

    /**
     * 处理银联手机支付控件返回的支付结果
     */
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }

        String msg = "";
        /*
         * 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消
         */
        String str = data.getExtras().getString("pay_result");
        if (str.equalsIgnoreCase("success")) {
            
                        msg = "支付成功！";
            if(mToActivity != null){
                startActivity(new Intent(this,mToActivity));
            }
        } else if (str.equalsIgnoreCase("fail")) {
            msg = "支付失败！";
        } else if (str.equalsIgnoreCase("cancel")) {
            msg = "用户取消了支付";
        }

        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
       finish();
    }
}
