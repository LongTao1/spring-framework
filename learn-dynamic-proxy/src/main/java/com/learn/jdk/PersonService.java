package com.learn.jdk;

public class PersonService implements IPersonService {
	@Override
	public String add(String name) {
		System.out.println("add参数:" + name);
		return name;
	}
}
