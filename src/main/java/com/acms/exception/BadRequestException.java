package com.acms.exception;

public class BadRequestException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public BadRequestException(String message) {
		super(message);
	}
}