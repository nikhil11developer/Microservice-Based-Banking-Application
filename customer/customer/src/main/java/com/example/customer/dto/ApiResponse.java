package com.example.customer.dto;

public class ApiResponse {
     private boolean valid;
     private String message;
     
    public ApiResponse() {}
    
    public ApiResponse(boolean valid , String message) {
    	this.valid=valid;
    	this.message=message;
    }
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
     
}
