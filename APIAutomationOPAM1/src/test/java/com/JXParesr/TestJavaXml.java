package com.JXParesr;

import javax.xml.bind.JAXBException;

public class TestJavaXml {

	public static void main(String[] args) throws JAXBException {

		Employee eobj = new Employee("Rancho", "Test Engineer", 25, 35000);

		JavaXmlParser parser = new JavaXmlParser();
		parser.marshalling(eobj);
	}

}
