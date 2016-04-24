package com.srm.jackson.crud;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srm.jackson.bean.Employee;
import com.srm.jackson.util.Content;

public class JsonToPojoConvertion {

	public static void main(String[] args) {
		String file = "/home/sriram/workspace/json-jackson/src/main/resources/employee.json";
		convert(file);
	}

	private static void convert(String file) {

		String content = Content.fileStrings(file);

		ObjectMapper mapper = new ObjectMapper();

		try {
			Employee employee = mapper.readValue(content, Employee.class);
			print(employee);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void print(Employee e) {
		System.out.println("Id: " + e.getId());
		System.out.println("Name: " + e.getName());
		System.out.println("Salary: " + e.getSalary());
		System.out.println("Gender: " + e.getGender().name());
		System.out.println("DOB: " + e.getDob());
	}

}
