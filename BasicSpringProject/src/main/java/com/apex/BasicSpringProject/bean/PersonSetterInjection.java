package com.apex.BasicSpringProject.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class PersonSetterInjection {

	private String name;
	private int age;
	private String city;

	public String getName() {
		return name;
	}

	@Value("Rohit")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Value("28")
	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	@Value("LA")
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
