package com.company.tvapp;

import org.springframework.stereotype.Component;

// 1. @Component //Component 코드가 앞자리를 소문자로 만든 samsungTv 객체 생성

@Component("samsung") // samsung 객체 생성
public class SamsungTv implements TV {

	public SamsungTv( ) { // spring container에서 default 생성자를 이용해서 객체 생성해준다
		System.out.println("Samsung Tv 객체 생성");
	}
	
	
	@Override
	public void turnOn() {
		System.out.println("SamsungTv - 파워 On");		
	}
	@Override
	public void turnOff() {
		System.out.println("SamsungTv - 파워 Off");
	}
	@Override
	public void soundUp() {
		System.out.println("SamsungTv - 볼륨 Up");
	}
	@Override
	public void soundDown() {
		System.out.println("SamsungTv - 볼륨 Down");
	}
}
