package com.pawan.jsonwebtokensecurity.util;

public class APIResponse {
	
	private String responseStatus;
	private String responseMessage;
	private Object responseData;
	
	public APIResponse(){
		
	}
	
	
	public APIResponse(String responseStatus, String responseMessage, Object responseData) {
		super();
		this.responseStatus = responseStatus;
		this.responseMessage = responseMessage;
		this.responseData = responseData;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	
	@Override
	public String toString() {
		return "APIResponse [responseStatus=" + responseStatus + ", responseMessage=" + responseMessage
				+ ", responseData=" + responseData + "]";
	}


}
