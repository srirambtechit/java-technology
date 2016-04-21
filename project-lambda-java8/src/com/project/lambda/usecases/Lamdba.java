package com.project.lambda.usecases;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.project.lambda.db.StudentRepo;
import com.project.lambda.pojo.Student;

public class Lamdba {

	public static void main(String[] args) {
		List<Student> students = StudentRepo.students();

		List<String> passedNames = findPassedStudent(students);
		System.out.println("Passed student names list: " + passedNames);

		System.out.println();

		Map<Integer, String> map = failedStudent(students, 2004, 2010);
		System.out.println("Map: " + map);

		System.out.println();

		List<String> names = namesStartsWith(students, "s");
		System.out.println("Names starts with 'S' : " + names);

	}

	// 3. find student name starts with given string
	public static List<String> namesStartsWith(List<Student> students, String string) {
		//@formatter:off
		return students.stream()
				.filter(s->s.getName().startsWith(string.toUpperCase()))
				.map(Student::getName)
				.collect(Collectors.toList());
		//@formatter:on
	}

	// 2. find student's name along with id who failed in any one subject
	// in the graduation year between 2004 and 2010
	public static Map<Integer, String> failedStudent(List<Student> students, int fromYear, int toYear) {
		int pass = 35;

		//@formatter:off
		return students.stream()
				.filter(s -> s.getGraduationYear() >= fromYear)
				.filter(s -> s.getGraduationYear() <= toYear)
				.filter(
						 // putting predicate to invoke its methods like or(), and(), etc,.
						new Predicate<Student>() {        
							@Override
							public boolean test(Student t) {
								return t.getTamil() < pass;
							}
						}
					.or((s) -> {return s.getEnglish() < pass;}) // another form of lambda expression
					.or(s -> s.getMaths() < pass)
					.or(s -> s.getScience() < pass)
				).collect(Collectors.toMap(Student::getId, Student::getName));
		//@formatter:on				
	}

	// 1. find student names who passed all subjects
	public static List<String> findPassedStudent(List<Student> students) {
		int pass = 35;

		//@formatter:off
		return students.stream()
				.filter(s -> s.getTamil() > pass)
				.filter(s -> s.getEnglish() > pass)
				.filter(s -> s.getMaths() > pass)
				.filter(s -> s.getScience() > pass)
				.map(s -> s.getName())
				.collect(Collectors.toList());
		//@formatter:on
	}

}
