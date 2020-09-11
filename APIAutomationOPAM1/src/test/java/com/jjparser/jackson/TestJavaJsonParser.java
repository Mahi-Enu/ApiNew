package com.jjparser.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class TestJavaJsonParser {

	public static void main(String[] args) throws JsonGenerationException, 
													JsonMappingException, IOException {
		
		Person pobj = new Person("Prajna", "Test Engineer", 23, 25000);
		JavaJsonParser parser = new JavaJsonParser();
		parser.marshalling(pobj);
		System.out.println("pass");
	}
}
