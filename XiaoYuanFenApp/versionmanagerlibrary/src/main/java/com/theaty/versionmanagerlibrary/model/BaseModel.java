package com.theaty.versionmanagerlibrary.model;


import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @desc 基础模型
 */
public class BaseModel implements Serializable {
	public static String HOSTIP = "www.aiyakeji.com";
	public static String API_HOST_PRE = "http://" + HOSTIP
			+ "/mobilecustomer";// 主机地址


	public BaseModel() {
		// 网络检验
//		if (AppContext.getInstance() != null
//				&& !SystemUtil.isConnected()) {
//			ToastUtil.showToast("请检查网络!");
//		}
	}

	// 通用接口
	public abstract interface BaseModelIB {
		public abstract void StartOp();// 开始执行

		public abstract void successful(Object o);// 成功返回

		public abstract void failed(ResultsModel resultsModel);// 失败 及标识
	}

	// 通用接口2
	public abstract interface BaseModelIB2 extends BaseModelIB {

		public abstract void onLoading(long total, long current,
                                       boolean isUploading);
	}

	// 对外接口
	public void BIBStart(BaseModelIB bib) {
		bib.StartOp();
	}

	public void BIBSucessful(BaseModelIB bib, Object o) {
		bib.successful(o);
	}

	public void BIBFailed(BaseModelIB bib, ResultsModel resultsModel) {
		bib.failed(resultsModel);
	}

	public void BIBOnLoading(BaseModelIB2 bib, long total, Long current,
							 Boolean isUploading) {
		bib.onLoading(total, current, isUploading);
	}

	// 根据act和op构建url
	public String buildGetUrl(String actName, String opName) {
		return API_HOST_PRE + "/" + actName + "/" + opName;
	}

	// 通过json反序列化为实例
	public BaseModel fromJson(String jsonStr) {
		return (new Gson()).fromJson(jsonStr, this.getClass());
	}

	// 类 序列化为 json字符串
	public String toJson() {
		return (new Gson()).toJson(this);
	}
}
