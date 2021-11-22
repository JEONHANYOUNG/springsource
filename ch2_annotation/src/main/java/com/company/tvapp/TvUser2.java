package com.company.tvapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser2 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		LgTv tv= (LgTv) ctx.getBean("lg");
 		//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'lg': Unsatisfied dependency expressed through field 
		//주입을 못해준다는 뜻
		//Speaker' available: expected single matching bean but found 2: apple,sonySpeaker => apple과 sonySpeake 두개가 나왔다는 의미
		
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
	}
}
