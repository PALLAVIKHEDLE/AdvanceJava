package com.apex.BasicSpringProject.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class PersonConstructorInjection {
	@Value("TOM")
	private String name;
	@Value("50")
	private int age;
	@Value("LA")
	private String city;

	public PersonConstructorInjection(@Value("RAM") String name, @Value("12") int age,
			@Value("Fullerton") String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("entered Into init method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("entered Into Destroy method");
	}
}
