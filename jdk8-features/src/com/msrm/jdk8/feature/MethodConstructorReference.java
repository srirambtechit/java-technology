package com.msrm.jdk8.feature;

import com.msrm.jdk8.feature.helper.Person;
import com.msrm.jdk8.feature.helper.PersonFactory;

public class MethodConstructorReference {

	public static void main(String[] args) {
		// Method reference
		Converter<String, String> caseConverter = String::toUpperCase;
		System.out.println(caseConverter.convert("hello"));
		
		// Constructor reference
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("sriram", "M");
		System.out.println(person);
		
		PersonFactory<Person> personFactory2 = (f, l) -> new Person(f, l);
		Person person2 = personFactory2.create("Prabhu", "M");
		System.out.println(person2);
	}

}
