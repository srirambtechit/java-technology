package com.msrm.jdk7feature.autocloseable;

public class OpenDoor implements AutoCloseable {

	public void open() throws Exception {
		System.out.println("Open door");
	}

	public void swing() throws Exception {
		System.out.println("Swing door");
		throw new SwingException();
	}

	@Override
	public void close() throws Exception {
		System.out.println("Close door");

		// below exception will be suppressed by try-with-resource
		// so get the details, Throwable.getSuppressed to be used
		throw new CloseException("Closing throws exception");
	}

}
