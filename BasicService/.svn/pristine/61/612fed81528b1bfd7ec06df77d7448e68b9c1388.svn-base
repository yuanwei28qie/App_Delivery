package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.RespCommDTO
 * @Description  数据传输基类
 * 
 * @Author bruce
 * @Version 2017年6月28
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class RespBaseDto<T> {
	private int state = 0;
	private String message;
	private T data;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

