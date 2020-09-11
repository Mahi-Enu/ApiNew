package com.jjparser.jackson;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder(value = {
	"id",
	"name",
	"designation",
	"salary"
})
public class Person {

	private String name, designation;
	private int id, salary;
	
	Person(String name , String designation, int id , int salary)
	{
		this.name = name;
		this.designation = designation;
		this.id = id;
		this.salary = salary;
	}
	Person()
	{
		
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDesignation()
	{
		return designation;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
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
