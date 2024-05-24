package com.apex.BasicSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.apex.BasicSpringProject.bean.Person;
import com.apex.BasicSpringProject.bean.PersonConstructorInjection;
import com.apex.BasicSpringProject.bean.PersonFieldInjection;
import com.apex.BasicSpringProject.bean.PersonSetterInjection;

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

		PersonConstructorInjection constructorInjection = applicationContext.getBean(PersonConstructorInjection.class);
		System.out.println("constructorInjection Person name  :" + constructorInjection.getName());
		System.out.println("constructorInjection Person Age  :" + constructorInjection.getAge());
		System.out.println("constructorInjection Person City  :" + constructorInjection.getCity());

		PersonFieldInjection fieldInjection = applicationContext.getBean(PersonFieldInjection.class);
		System.out.println("fieldInjection Person name  :" + fieldInjection.getName());
		System.out.println("fieldInjection Person Age  :" + fieldInjection.getAge());
		System.out.println("fieldInjection Person City  :" + fieldInjection.getCity());

		PersonSetterInjection setterInjection = applicationContext.getBean(PersonSetterInjection.class);
		System.out.println("setterInjection Person name  :" + setterInjection.getName());
		System.out.println("setterInjection Person Age  :" + setterInjection.getAge());
		System.out.println("setterInjection Person City  :" + setterInjection.getCity());

//		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
//		configurableApplicationContext.close();

		AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
		abstractApplicationContext.close();

	}
}
