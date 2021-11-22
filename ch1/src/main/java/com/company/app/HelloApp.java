package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		
		System.out.println("============= 스프링 컨테이너 구동 전 =======");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml"); // ClassPath => src/main/resource의 파일 항목
		
		System.out.println("========= 스프링 컨테이너 구동 ===========");
		
		//스프링 컨테이너로부터 필요한 객체를 요청
		MessageBean msg = (MessageBean)ctx.getBean("en"); // bean을 가져오라는 의미이고, application에서 작성한 거 가져오기, msg에 주입 시켜줌
		msg.sayHello("홍길동");
		
	}
}

