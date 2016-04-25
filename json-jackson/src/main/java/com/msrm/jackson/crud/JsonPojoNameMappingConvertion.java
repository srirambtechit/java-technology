package com.msrm.jackson.crud;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msrm.jackson.bean.PersonTwo;
import com.msrm.jackson.util.Content;

public class JsonPojoNameMappingConvertion {

	public static void main(String[] args) {
		String file = "/home/sriram/GitHub/repository/java-technology/json-jackson/src/main/resources/person.json";
		convert(file);
	}

	private static void convert(String file) {
		String content = Content.fileStrings(file);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

		try {
			PersonTwo person = mapper.readValue(content, PersonTwo.class);
			System.out.println(person);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
