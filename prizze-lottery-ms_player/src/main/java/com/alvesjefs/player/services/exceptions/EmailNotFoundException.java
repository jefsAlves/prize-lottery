package com.alvesjefs.player.services.exceptions;

public class EmailNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmailNotFoundException() {
	}

	public EmailNotFoundException(String msg) {
		super(msg);
	}

}
