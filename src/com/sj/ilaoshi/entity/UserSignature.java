package com.sj.ilaoshi.entity;


import java.util.Date;

/**
 * 用户签名关联表
 * Created by slt on 2017/3/27.
 */
public class UserSignature extends BaseModel {
	/**
	 * 用户id(主键)
	 */
	private Long uid;

	/**
	 * 提供给第三方的身份唯一标示
	 */
	private Long secretId;

	/**
	 * 提供给第三方的签名加密字符串
	 */
	private String SecretKey;

	/**
	 * 身份有效期开始时间
	 */
	private Date startTime;

	/**
	 * 身份有效期结束时间
	 */
	private Date endTime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getSecretId() {
		return secretId;
	}

	public void setSecretId(Long secretId) {
		this.secretId = secretId;
	}

	public String getSecretKey() {
		return SecretKey;
	}

	public void setSecretKey(String secretKey) {
		SecretKey = secretKey;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
