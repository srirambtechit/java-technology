package com.msrm.tricky;

public class NullOverloading {

    public NullOverloading(Object o) {
	System.out.println("Object constructor");
    }

    // public NullOverloading(double[] d) {
    // System.out.println("double array constructor");
    // }

    public NullOverloading(String s) {
	System.out.println("String constructor");
    }

    public NullOverloading(CharSequence s) {
	System.out.println("CharSequence constructor");
    }

    public static void main(String[] args) {
	new NullOverloading(null);
    }

}
