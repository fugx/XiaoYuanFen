package payment.wxpay;

import android.content.Context;
import android.widget.Toast;

import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.theaty.xiaoyuan.system.DatasStore;

import payment.Constants;


/**
 * 调起微信支付
 * @author Administrator
 *
 */
public class WXPay {

	private static IWXAPI  msgApi;
	private static void registerApp(Context context){
		msgApi = WXAPIFactory.createWXAPI(context, null);
		msgApi.registerApp(Constants.WeiXin_AppID);
	}
	
	
	public static void pay(Context context,WXPayInfo prepay){
		DatasStore.setCoupons(false);
		if(msgApi == null){
			registerApp(context);
		}
		if(!msgApi.isWXAppInstalled()){
			Toast.makeText(context,"尚未安装微信，无法使用微信支付！",Toast.LENGTH_LONG).show();
			return;
		}
		PayReq request = new PayReq();
		if(prepay != null){
			request.appId = Constants.WeiXin_AppID;
			request.partnerId = prepay.partnerid;
			request.prepayId = prepay.prepayid;
			request.packageValue = Constants.WeiXin_PackageValue;
			request.nonceStr = prepay.noncestr;
			request.timeStamp = "" + prepay.timestamp;
			request.sign = prepay.sign;
		}else{
			Toast.makeText(context,"传入的参数为空！",Toast.LENGTH_LONG).show();
		}
		boolean result = msgApi.sendReq(request);
	}

	public static void pay(Context context,WXPayInfo prepay, boolean isCoupons){
		if(isCoupons){
			DatasStore.setCoupons(isCoupons);
		}
		if(msgApi == null){
			registerApp(context);
		}
		if(!msgApi.isWXAppInstalled()){
			Toast.makeText(context,"尚未安装微信，无法使用微信支付！",Toast.LENGTH_LONG).show();
			return;
		}
		PayReq request = new PayReq();
		if(prepay != null){
			request.appId = Constants.WeiXin_AppID;
			request.partnerId = prepay.partnerid;
			request.prepayId = prepay.prepayid;
			request.packageValue = Constants.WeiXin_PackageValue;
			request.nonceStr = prepay.noncestr;
			request.timeStamp = "" + prepay.timestamp;
			request.sign = prepay.sign;
		}else{
			Toast.makeText(context,"传入的参数为空！",Toast.LENGTH_LONG).show();
		}
		msgApi.sendReq(request);
	}
}
