package com.msrm.java8.features;

public class LambdaThread {

    public static void main(String[] args) {
	// before java 8
	Thread old = new Thread(new Runnable() {
	    @Override
	    public void run() {
		System.out.println("Hello World");
	    }
	});
	old.start();

	
	// after java 8
	Thread t = new Thread(() -> System.out.println("Hello World"));
	t.start();

    }
}
