package com.msrm.tricky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tricky2 {

    public static void main(String[] args) throws ParseException {

	SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy G");

	SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd G");

	Date date = sdfInput.parse("-1/1/2015 AD");
	// uncomment and see the output difference
	// Date date = sdfInput.parse("31/1/2015 AD");
	// Date date = sdfInput.parse("32/1/2015 AD");

	String output = sdfOutput.format(date);

	System.out.println(output);
    }

}
