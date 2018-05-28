package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenType  implements Serializable {
	//用户或者骑手id
	private Integer userId;
	//登陆token
	private String token;
	//app类型-1表示用户端,2表示骑手端
	private Short appType;

	public TokenType() {
	}

	public TokenType(Integer userId, String token, Short appType) {

		this.userId = userId;
		this.token = token;
		this.appType = appType;
	}
}
