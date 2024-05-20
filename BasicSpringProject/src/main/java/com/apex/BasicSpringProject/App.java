package com.apex.BasicSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.apex.BasicSpringProject.bean.Person;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = (Person) applicationContext.getBean("person");
		Person person1 = applicationContext.getBean(Person.class);

		person.setName("John");

		System.out.println(person);

		System.out.println(person1);

//		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
//		configurableApplicationContext.close();

		AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
		abstractApplicationContext.close();

	}
}
