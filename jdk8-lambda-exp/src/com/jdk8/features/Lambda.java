package com.jdk8.features;

public class Lambda {

    public static void main(String[] args) {
	int x = 30;
	Thread t = new Thread(() -> System.out.println(x));
	t.start();
	Runnable r;
    }
}
