package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

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
@Data
@JsonInclude(value=Include.NON_NULL)
public class RespBaseDto<T> {
	private int state = 0;
	private String message;
	private T data;
}

