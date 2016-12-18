package com.msrm.lambda.mappings;

import java.util.Optional;

//@formatter:off
public class OptionalFlatMapNPEApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("sriram", new Office("KM-2", new Address(12, new City("Chennai"))));
		Employee e2 = new Employee("sekar", new Office("KM-1", new Address(11, null)));
		Employee e3 = new Employee("prakash", new Office("KM-22", null));
		Employee e4 = new Employee("bob", null);

		System.out.println("Prior to JDK 8");
		// pre-JDK 8 version, printing city name of e1
		printCity(e1);
		printCity(e2);
		printCity(e3);
		printCity(e4);
		
		System.out.println("\nJDK 8 onwards");
		
		// from JDK 8 onwards
		String cityFoundString = Optional.ofNullable(e1)
			.flatMap(e -> Optional.ofNullable(e.office))
			.flatMap(o -> Optional.ofNullable(o.address))
			.flatMap(a -> Optional.ofNullable(a.city))
			.flatMap(c -> Optional.ofNullable(c.name))
			.orElse("City not found");
		System.out.println(cityFoundString);
		
		System.out.println();
		
		cityFoundString = Optional.ofNullable(e2)
				.flatMap(e -> Optional.ofNullable(e.office))
				.flatMap(o -> Optional.ofNullable(o.address))
				.flatMap(a -> Optional.ofNullable(a.city))
				.flatMap(c -> Optional.ofNullable(c.name))
				.orElse("City not found");
			System.out.println(cityFoundString);
	}

	// pre-JDK 7 version, printing city name of e1
	private static void printCity(Employee e) {
		if (e != null) {
			if (e.office != null) {
				if (e.office.address != null) {
					if (e.office.address.city != null) {
						if (e.office.address.city.name != null) {
							System.out.println("City : " + e.office.address.city.name);
						} else {
							System.out.println("City not found");
						}
					}
				}
			}
		}		
	}

}
