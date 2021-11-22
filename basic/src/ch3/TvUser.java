package ch3;

public class TvUser {
	public static void main(String[] args) {
		// 결합력을 낮추는 방식 => 다형성
		//TV tv = new LgTv(new SonySpeaker());
		
		TV tv = new SamsungTv(); // tv => stack에 생성 Samsung은 heap에 생성, new를 할때마다 heap에 객체를 계속 생성되므로 객체는 다르다라고 뜨게됨
		//tv.setSpeaker(new SonySpeaker());
		//tv.setSpeaker(new AppleSpeaker());
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
				
		TV tv1 = new SamsungTv(); //tv1 => stack에 생성 Samsung은 heap에 생성
		
		System.out.println(tv == tv1 ? "객체 동등":"객체 다름"); //객체를 하나만 생성하는 것은 singleton 패턴
	}
}
