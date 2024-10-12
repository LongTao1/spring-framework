package com.learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRun {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
		//UserService xmlUserService = (UserService) xmlApplicationContext.getBean("userService");
		//xmlUserService.test();
		//AnimalService xmlAnimalService = xmlApplicationContext.getBean(AnimalService.class);
		//xmlAnimalService.test();

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.learn");
		UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
		userService.test();
		//AnimalService animalService = annotationConfigApplicationContext.getBean(AnimalService.class);
		//animalService.test();
	}
}