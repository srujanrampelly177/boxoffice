package com.example.demo.exception;

public class ErrorMessage 
{
	String errorMessage;
	String authenticated;

	public String getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(String authenticated) {
		this.authenticated = authenticated;
	}

	public ErrorMessage(String errorMessage, String authenticated) {
		super();
		this.errorMessage = errorMessage;
		this.authenticated = authenticated;
	}

	public ErrorMessage(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [errorMessage=" + errorMessage + ", authenticated=" + authenticated + "]";
	}
	
}
