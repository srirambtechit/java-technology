package com.msrm.lambda.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.msrm.lambda.pojo.Student;
import com.msrm.lambda.util.NumberUtil;

public final class StudentRepo {

	private static final StudentRepo instance = new StudentRepo();

	private static List<Student> students;

	static {
		students = new ArrayList<>();
		String[] names = { "Ziaur", "Sriram", "Peraj", "Prabhu", "Samim", "Suresh", "Kannan", "Chittra", "Priya",
				"Guna", "Alber", "Sekar", "Mani", "Natraj", "Subha" };

		List<Integer> ids = new ArrayList<>();
		for (int i = 1; i < names.length; i++) {
			ids.add(i);
		}
		Collections.shuffle(ids);

		for (int i = 1; i < names.length; i++) {
			Student student = new Student();
			student.setId(i);
			int index = ids.remove(0);
			student.setName(names[index]);
			student.setTamil(newMark());
			student.setEnglish(newMark());
			student.setMaths(newMark());
			student.setScience(newMark());
			student.setGraduationYear(NumberUtil.generateInt(1990, 2016));
			students.add(student);
		}

	}

	private StudentRepo() {
	}

	public static synchronized StudentRepo getInstance() {
		return instance;
	}

	public static List<Student> students() {
		students.forEach(System.out::println);
		return students;
	}

	public static void main(String[] args) {
		students();
	}

	public static double newMark() {
		return NumberUtil.generateDouble(0, 100);
	}

}
