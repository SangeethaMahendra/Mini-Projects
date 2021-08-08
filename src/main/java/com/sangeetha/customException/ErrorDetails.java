package com.sangeetha.customException;

import java.util.Date;

public class ErrorDetails {
	
	private String errorMsg;
	private String errorCode;
	private Date timeStamp;


	public ErrorDetails() {}

	public ErrorDetails(String errorMsg, String errorCode, Date timeStamp) {
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.timeStamp = timeStamp;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


}
