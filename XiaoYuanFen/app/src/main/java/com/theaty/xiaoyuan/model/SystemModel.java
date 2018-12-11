package com.theaty.xiaoyuan.model;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SystemModel extends BaseModel {
	/**
	 * update_state : 1
	 * version_info : {"version_id":"3","version_code":"Android","update_url":"http://www.Andro","version_num":"3.0","reviewed_status":"0","update_reason":"提示更新"}
	 */

	private int update_state;
	private VersionInfoBean version_info;

	public int getUpdate_state() {
		return update_state;
	}

	public void setUpdate_state(int update_state) {
		this.update_state = update_state;
	}

	public VersionInfoBean getVersion_info() {
		return version_info;
	}

	public void setVersion_info(VersionInfoBean version_info) {
		this.version_info = version_info;
	}

	public static class VersionInfoBean {
		/**
		 * version_id : 3
		 * version_code : Android
		 * update_url : http://www.Andro
		 * version_num : 3.0
		 * reviewed_status : 0
		 * update_reason : 提示更新
		 */

		private String version_id;
		private String version_code;
		private String update_url;
		private int version_num;
		private String reviewed_status;
		private String update_reason;

		public String getVersion_id() {
			return version_id;
		}

		public void setVersion_id(String version_id) {
			this.version_id = version_id;
		}

		public String getVersion_code() {
			return version_code;
		}

		public void setVersion_code(String version_code) {
			this.version_code = version_code;
		}

		public String getUpdate_url() {
			return update_url;
		}

		public void setUpdate_url(String update_url) {
			this.update_url = update_url;
		}

		public int getVersion_num() {
			return version_num;
		}

		public void setVersion_num(int version_num) {
			this.version_num = version_num;
		}

		public String getReviewed_status() {
			return reviewed_status;
		}

		public void setReviewed_status(String reviewed_status) {
			this.reviewed_status = reviewed_status;
		}

		public String getUpdate_reason() {
			return update_reason;
		}

		public void setUpdate_reason(String update_reason) {
			this.update_reason = update_reason;
		}
	}

	/**
	 * 版本id
	 *//*
	public int version_id;
	*//**
	 * 版本编号(安卓返回：Android，IOS返回：IOS)
	 *//*
	public String version_code;
	*//**
	 * 版本号, 后台用的是此变量，对应versionCode
	 *//*
	public long version_num;
	*//**
	 * 更新地址
	 *//*
	public String update_url;*/



}
