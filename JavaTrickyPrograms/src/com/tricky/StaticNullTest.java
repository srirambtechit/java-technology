package com.tricky;

class A {

    public static void staticMethod() {
	System.out.println("Static Method");
    }
}

public class StaticNullTest {

    public static void main(String[] args) {
	A a = null;

	// after compiling class would have A.staticMethod(),
	// so will not throw NPE
	a.staticMethod();
    }

}
