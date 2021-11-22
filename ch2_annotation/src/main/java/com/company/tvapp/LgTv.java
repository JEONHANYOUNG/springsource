package com.company.tvapp;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTv implements TV {
	
	// @Autowired // 생성된 객체를 주입해줘(Speaker를 구현하는 모든 클래스가 대상) , has-a 형태에 쓰임
	
	@Inject // @Autowired 대신해서 사용 가능 , 자바쪽
	@Qualifier("apple") //이름 지정 기능 밖에 없음 , 스프링 프레임 워크
 	//private SonySpeaker speaker = new SonySpeaker(); 1. 멤버변수를 만들어서 초기화, 2. 생성자나 setter 생성한 방식
	private Speaker speaker; // has-a : 초기화(생성자, setter, 포함), is-a : (상속)
	
	public LgTv() {
		System.out.println("LgTv 객체 생성");
	}
		
//	//생성자 방식
//	public LgTv(Speaker speaker) { 
//		super();
//		this.speaker = speaker;
//	}
//
//	//setter 생성자
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker; // has-a : 초기화(생성자, 
//	}
	
	@Override
	public void turnOn() {
		System.out.println("LgTv - 전원 On");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTv - 전원 Off");  
	}
	@Override
	public void soundUp() {
		//System.out.println("LgTv - 볼륨 Up");
		//speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTv - 볼륨 Down");
		//speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
