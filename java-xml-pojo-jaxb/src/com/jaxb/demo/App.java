package com.jaxb.demo;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class App {

    public static void main(String[] args) {
	System.out.println("Marshalling");
	doMarshall();
	System.out.println("\nUnmarshalling");
	doUnmarshall();
    }

    public static void doUnmarshall() {
	try {
	    JAXBContext jc = JAXBContext.newInstance(Employee.class);
	    Unmarshaller um = jc.createUnmarshaller();
	    Employee emp = (Employee) um.unmarshal(new File("employee.xml"));
	    System.out.println(emp);
	} catch (JAXBException e) {
	    e.printStackTrace();
	}
    }

    public static void doMarshall() {
	try {
	    JAXBContext jc = JAXBContext.newInstance(Employee.class);
	    Marshaller m = jc.createMarshaller();
	    Employee e = new Employee();
	    e.setActive(false);
	    e.setDob(new Date());
	    e.setDoj(new Date());
	    e.setId(1240);
	    e.setName("Bob");
	    e.setSalary(5000.25);
	    m.marshal(e, System.out);
	} catch (JAXBException e) {
	    e.printStackTrace();
	}
    }

}
