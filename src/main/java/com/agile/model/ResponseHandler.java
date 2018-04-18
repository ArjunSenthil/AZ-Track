package com.agile.model;

import org.springframework.http.HttpStatus;

public class ResponseHandler 
{
	 
	private Object object;
    private HttpStatus statuscode;
    private String message;
    
    public ResponseHandler(Object object, HttpStatus statuscode, String message) {
		super();
		this.object = object;
		this.statuscode = statuscode;
		this.message = message;
	}
	public ResponseHandler(HttpStatus statuscode, String message) 
	{
		this.statuscode = statuscode;
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public HttpStatus getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    
}
   