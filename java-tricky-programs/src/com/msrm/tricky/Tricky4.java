package com.msrm.tricky;

class A1 {
    static int i = 100;

    static {
	i = i-- - --i;
	System.out.println("A1 static, i=" + i);
    }

    {
	i = i++ + ++i;
	System.out.println("A1, i=" + i);
    }
}

class B1 extends A1 {

    static {
	i = --i - i--;
	System.out.println("B1 static, i=" + i);
    }

    {
	i = ++i + i++;
	System.out.println("B1, i=" + i);
    }
}

public class Tricky4 {

    public static void main(String[] args) {
	// B1 b = new B1();
	// System.out.println(b.i);
	System.out.println(B1.i);
    }

}
