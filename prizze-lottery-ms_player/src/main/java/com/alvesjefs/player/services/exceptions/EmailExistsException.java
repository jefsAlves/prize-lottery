package com.alvesjefs.player.services.exceptions;

import java.io.Serializable;

public class EmailExistsException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public EmailExistsException() {
	}

	public EmailExistsException(String msg) {
		super(msg);
	}

}
