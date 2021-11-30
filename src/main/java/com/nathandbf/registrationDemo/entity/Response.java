package com.nathandbf.registrationDemo.entity;

import java.util.Objects;

public class Response {
	private int code;
	private String message;
	
	
	public Response() {
		super();
	}
	public Response(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return code == other.code && Objects.equals(message, other.message);
	}
}
