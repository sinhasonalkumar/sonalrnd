package com.sonal.util.exception;

public class AppException extends Exception {

	private String errorMessage = null;
	private String errorCode = null;
	private String exceptionType = null;
	private Class exceptionClass = null;
	private String rootCause;
	

	public AppException() {
		super();
	}

	public AppException(String errorMessage,String errorCode,String exceptionType,Class exceptionClass ,String rootCause,Throwable cause) {
		super(cause.toString(),cause);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.exceptionType = exceptionType;
		this.exceptionClass = exceptionClass;
		this.rootCause = rootCause;
	}

	
	public AppException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return errorMessage;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public Class getExceptionClass() {
		return exceptionClass;
	}

	public String getRootCause() {
		return rootCause;
	}
	
	

}
