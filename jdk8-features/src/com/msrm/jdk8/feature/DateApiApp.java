package com.msrm.jdk8.feature;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateApiApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		{
			// 1. Clock
			// Current system time representation
			// prior to JDK 8
			long systemTimeOld = System.currentTimeMillis();
			Clock clock = Clock.systemDefaultZone();
			long systemTimeLastest = clock.millis();
		}

		System.out.println();

		{
			// 2. TimeZone
			// Getting time based on TimeZone
			ZoneId berlinZone = ZoneId.of("Europe/Berlin");
			Clock clock = Clock.system(berlinZone);
			clock.millis();

			// Getting available zones
			System.out.println(ZoneId.getAvailableZoneIds());
			System.out.println("No of Zones : " + ZoneId.getAvailableZoneIds().size());
			ZoneId.getAvailableZoneIds().stream().sorted().limit(5).forEach(System.out::println);
			System.out.println("Zone rules :" + ZoneId.of("Brazil/East").getRules());
		}

		System.out.println();

		{
			// 3. LocalTime
			// represents time without TimeZone
			ZoneId zone1 = ZoneId.of("Asia/Kolkata");
			ZoneId zone2 = ZoneId.of("Africa/Accra");

			LocalTime now1 = LocalTime.now(zone1);
			LocalTime now2 = LocalTime.now(zone2);

			System.out.printf("%s is before %s ? %b %n", now1, now2, now1.isBefore(now2));
			System.out.printf("%s is after %s ? %b %n", now1, now2, now1.isAfter(now2));

			// Hours between
			long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
			long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
			System.out.println(hoursBetween);
			System.out.println(minutesBetween);

			// Time creation from factory methods
			LocalTime time = LocalTime.of(4, 34, 59);
			System.out.println(time);

			// Time formatting
			DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
					.withLocale(Locale.GERMAN);
			LocalTime lateTime = LocalTime.parse("23:12", germanFormatter);
			System.out.println(lateTime);
		}

		System.out.println();

		{
			// 4. LocalDate
			// represents date and works exactly analog to LocalTime, it is
			// immutable one
			LocalDate today = LocalDate.now();
			LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
			LocalDate yesterday = tomorrow.minus(2, ChronoUnit.DAYS);

			// working day of week
			LocalDate independenceDay = LocalDate.of(1945, Month.AUGUST, 15);
			DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
			System.out.println(dayOfWeek);

			// Date formatting
			DateTimeFormatter germanFormatter = DateTimeFormatter
					.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
			LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
			System.out.println(xmas); // 2014-12-24
		}

		System.out.println();

		{
			// 5. LocalDateTime
			// represents Data-Time. it combined LocalDate and LocalTime
			LocalDateTime sylvester = LocalDateTime.of(2016, Month.DECEMBER, 25, 23, 59, 59);
			System.out.println(sylvester.getDayOfWeek());

			Month month = sylvester.getMonth();
			System.out.println(month);

			long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
			System.out.println(minuteOfDay);

			// 6. Instant
			// present date-time value
			Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();

			Date legacyDate = Date.from(instant);
			System.out.println(legacyDate); // Wed Dec 31 23:59:59 CET 2014

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
			LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
			String string = formatter.format(parsed);
			System.out.println(string); // Nov 03, 2014 - 07:13
		}

	}

}
