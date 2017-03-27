package com.sj.ilaoshi.entity;


/**
 * 用户权限信息表
 * Created by slt on 2017/3/27.
 */
public class UserAuth extends BaseModel {
	/**
	 * 用户id(主键)
	 */
	private Long uid;
	/**
	 * 授权信息json字符串
	 */
	private String authMessage;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getAuthMessage() {
		return authMessage;
	}

	public void setAuthMessage(String authMessage) {
		this.authMessage = authMessage;
	}
}
