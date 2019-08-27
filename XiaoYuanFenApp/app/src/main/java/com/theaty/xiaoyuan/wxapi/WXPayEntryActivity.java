package com.theaty.xiaoyuan.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import payment.Constants;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler{

private IWXAPI api;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	api = WXAPIFactory.createWXAPI(this, Constants.WeiXin_AppID);

        api.handleIntent(getIntent(), this);
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		
		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			switch (resp.errCode) {
			case 0://成功
				Toast.makeText(WXPayEntryActivity.this,"支付成功",Toast.LENGTH_LONG).show();
//				PaySuccessActivity.into(WXPayEntryActivity.this, PaymentActivity.amount + "");
				break;
			case -1://错误
				Toast.makeText(WXPayEntryActivity.this,"支付失败",Toast.LENGTH_LONG).show();//可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。

				break;
			case -2://用户取消
				Toast.makeText(WXPayEntryActivity.this,"支付取消",Toast.LENGTH_LONG).show();//无需处理。发生场景：用户不支付了，点击取消，返回APP。
//				startActivity(new Intent(WXPayEntryActivity.this, MyOrderActivity.class));

				break;

			default:
				break;
			}
			finish();
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		api.detach();
	}
}
