package org.home.blackjack.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext-blackjack-core.xml");
		applicationContext.registerShutdownHook();
		applicationContext.start();
		
		System.err.println("heyy3");


	}

}