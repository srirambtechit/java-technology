package com.msrm.tricky;

public class Tricky10 {

    public static void main(String[] args) {
	Long l = new Long(0);

	// output will be false if equals
	// doesn't have 0L; bcoz, 0 is Integer
	System.out.println(l.equals(0L));

	Double d = new Double(0);
	System.out.println(d.equals(0));
    }

}
