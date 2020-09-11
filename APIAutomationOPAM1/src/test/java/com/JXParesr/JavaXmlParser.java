package com.JXParesr;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JavaXmlParser {

	public void marshalling(Employee eobj) throws JAXBException
	{
		// To get object Reference of JaxbContext as per Employee
		JAXBContext jc = JAXBContext.newInstance(Employee.class);
		
		// To get a Marshaller Reference
		Marshaller m = jc.createMarshaller();
		
		// To get the standard xml format output
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		// Java Object convert to xml
		m.marshal(eobj, System.out);
		m.marshal(eobj, new File("Employee.xml"));
	}
}

class XmlJavaParser
{
	public void unmarshalling(String filename) throws JAXBException
	{
		JAXBContext jc = JAXBContext.newInstance(Employee.class);
		Unmarshaller um = jc.createUnmarshaller();
		Employee eobj = (Employee)um.unmarshal(new File(filename));
		System.out.println(eobj);
	}
}










