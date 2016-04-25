package com.msrm.tricky;

public class Tricky8 {

    public static void main(String[] args) {
	String s = "ONE" + 1 * 2 + "TWO" + "THREE" + 3 + 4 + "FOUR" + "FIVE" + 5;
	
	int value = 1 + + 2 - - 3 + + 4;
	
	int i = 10 + + 11 - - 12 + + 13;
	
	System.out.println(s);
	
	System.out.println(value);
	
	System.out.println(i);
    }

}
