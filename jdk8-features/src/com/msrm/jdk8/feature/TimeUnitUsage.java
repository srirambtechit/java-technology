package com.msrm.jdk8.feature;

import java.util.concurrent.TimeUnit;

public class TimeUnitUsage {

	public static void main(String[] args) {
		long t0 = System.nanoTime();
		delay(3000);
		long t1 = System.nanoTime();

		System.out.println("start        : " + t0);
		System.out.println("end          : " + t1);

		System.out.println();

		long nanos = TimeUnit.NANOSECONDS.toNanos(t1 - t0);
		System.out.println("Nano    diff : " + nanos);

		long micros = TimeUnit.NANOSECONDS.toMicros(t1 - t0);
		System.out.println("Micro   diff : " + micros);

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println("Miilis  diff : " + millis);

		long seconds = TimeUnit.NANOSECONDS.toSeconds(t1 - t0);
		System.out.println("Seconds diff : " + seconds);

		long minutes = TimeUnit.NANOSECONDS.toMinutes(t1 - t0);
		System.out.println("Minutes diff : " + minutes);

		long hours = TimeUnit.NANOSECONDS.toHours(t1 - t0);
		System.out.println("Hours   diff : " + hours);

		long days = TimeUnit.NANOSECONDS.toDays(t1 - t0);
		System.out.println("Days    diff : " + days);

		// converting seconds into minutes
		long _20_Minutes = TimeUnit.MINUTES.convert(1200, TimeUnit.SECONDS);
		System.out.println("1200 seconds in minutes is " + _20_Minutes);

	}

	private static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
