package com.msrm.jackson.crud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msrm.jackson.util.Content;

/**
 * Jackson Tree Model object is JsonNode
 * 
 * @author sriram
 *
 */
public class JsonTreeObjectRepresentation {

	public static void main(String[] args) {
		String str = Content.fileStrings(
				"/home/sriram/GitHub/repository/java-technology/json-jackson/src/main/resources/tree.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readValue(str, JsonNode.class);
			System.out.println(node);

			// Parsing JsonNode object. Here it is root node
			JsonNode car = node.get("car");
			
			// Parsing JsonNode object, here it is JSON array
			JsonNode features = car.get("features");
			System.out.println(features);

			// Parsing JsonNode object, here it is simple string
			JsonNode name = car.get("name");
			System.out.println(name.asText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
