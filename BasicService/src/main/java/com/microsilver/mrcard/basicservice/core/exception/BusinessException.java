package com.microsilver.mrcard.basicservice.core.exception;

import com.microsilver.mrcard.basicservice.model.enums.EWarning;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.core.exception.DataException
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月6日 上午9:25:03
 * @Copyright Micro Silver
 *
 */
public class BusinessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private EWarning warning;
	
	public BusinessException() {
		super();
		
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
	public BusinessException(EWarning warning) {
		super(warning.getName());
		this.warning = warning;
	}

	public EWarning getWarning() {
		return warning;
	}
	
}
