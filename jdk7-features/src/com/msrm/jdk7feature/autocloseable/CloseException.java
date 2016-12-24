package com.msrm.jdk7feature.autocloseable;

public class CloseException extends Exception {

	private static final long serialVersionUID = 1L;

	public CloseException() {
		super();
	}

	public CloseException(String exception) {
		super(exception);
	}

}
