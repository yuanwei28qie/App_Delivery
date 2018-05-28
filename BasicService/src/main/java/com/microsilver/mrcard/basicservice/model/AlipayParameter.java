package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class AlipayParameter {
	private String body ;
	private String subject ;
	private String out_trade_no ;
	private String timeout_express ;
	private String total_amount ;
	private String seller_id ;
	private String product_code ;

	public AlipayParameter() {
	}

	public AlipayParameter(String body, String subject, String out_trade_no, String timeout_express, String total_amount, String seller_id, String product_code) {
		this.body = body;
		this.subject = subject;
		this.out_trade_no = out_trade_no;
		this.timeout_express = timeout_express;
		this.total_amount = total_amount;
		this.seller_id = seller_id;
		this.product_code = product_code;
	}
}
