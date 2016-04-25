package com.msrm.jackson.crud;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msrm.jackson.bean.Employee;
import com.msrm.jackson.bean.Employee.Gender;

class PojoToJsonStringRepresentation {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId(2000);
		e.setName("Sriarm");
		e.setGender(Gender.M);
		e.setSalary(12005.75f);
		e.setDob(new Date());
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("src/main/resources/emp.json"), e);
			System.out.println("json generated");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
