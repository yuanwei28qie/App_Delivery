package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class MobileCheckCode implements Serializable {

	private Long mobile;
	//type为1是注册,2是登陆,3是收货码,4修改(忘记)密码
	private short type;
	private int checkCode;

	public MobileCheckCode() {
	}

	public MobileCheckCode(Long mobile, short type, int checkCode) {
		this.mobile = mobile;
		this.type = type;
		this.checkCode = checkCode;

	}
}
