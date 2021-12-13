package com.company.tvapp;

public class LgTv implements TV {
	
	//private SonySpeaker speaker = new SonySpeaker(); 1. 멤버변수를 만들어서 초기화, 2. 생성자나 setter 생성한 방식
	private Speaker speaker; // has-a : 초기화(생성자, setter, 포함), is-a : (상속)
	
	public LgTv() {
		System.out.println("LgTv 객체 생성");
	}
		
	//생성자 방식
	public LgTv(Speaker speaker) { 
		super();
		this.speaker = speaker;
	}

	//setter 생성자
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker; // has-a : 초기화(생성자, 
	}
	
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
