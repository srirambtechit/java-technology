package com.msrm.jackson.crud;

import java.io.Reader;
import java.io.StringReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msrm.jackson.bean.Car;

public class JsonFromReader {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();

		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";
		Reader reader = new StringReader(carJson);

		try {
			Car car = objectMapper.readValue(reader, Car.class);
			System.out.println(car);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
