package com.JXParesr;

import javax.xml.bind.JAXBException;

public class TestXmlJava {

	public static void main(String[] args) throws JAXBException {

		XmlJavaParser parser = new XmlJavaParser();
		parser.unmarshalling("Employee.xml");
	}

}
