package com.create.demo.model;

public class ResponseBean {

	private int statusCode;
	private Object response;
	public ResponseBean(int statusCode, Object response) {
		super();
		this.statusCode = statusCode;
		this.response = response;
	}
	public ResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}

	

}
