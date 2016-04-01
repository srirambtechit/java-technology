package com.project.lambda.util;

import java.text.DecimalFormat;
import java.util.Random;

public class NumberUtil {

	private static DecimalFormat df = new DecimalFormat("#.00");
	private static Random random = new Random(50);

	public static int generateInt(int min, int max) {
		return random.ints(min, max + 1).findFirst().getAsInt();
	}

	public static double generateDouble(int min, int max) {
		return Double.valueOf(df.format(random.doubles(min, max + 1).findFirst().getAsDouble()));
	}

}
