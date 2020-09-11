package com.JXParesr;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class Employee {

	private String name, designation;
	private int id, salary;
	
	Employee(String name , String designation, int id , int salary)
	{
		this.name = name;
		this.designation = designation;
		this.id = id;
		this.salary = salary;
	}
	Employee()
	{
		
	}
	@XmlAttribute
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@XmlElement
	public String getDesignation()
	{
		return designation;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	
	@XmlAttribute
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	@XmlElement
	public int getSalary()
	{
		return salary;
	}
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "name : " + name + "\n" + "id : " + id + "\n" + "salary : " + salary 
				+ "\n" + "designation : " + designation;
	}
}













