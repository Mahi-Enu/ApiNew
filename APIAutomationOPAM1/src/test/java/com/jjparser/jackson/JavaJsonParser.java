package com.jjparser.jackson;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JavaJsonParser {

	public void marshalling(Person pobj) throws JsonGenerationException, 
													JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Person.json"), pobj);
	}
}

class JsonJavaParser
{
	public Person unmarshalling(String filename , Class<Person> pobj) 
								throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Person personData = mapper.readValue(new File(filename), pobj);
		return personData;
	}
}















