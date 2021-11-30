package test.day6;

public class AbstractClassExam {

	public static void main(String[] args) {
		
		경차 경차1 = new 경차();
		세단 세단1 = new 세단();
		SUV SUV1 = new SUV();
		
		자동차 자동차1 = 경차1;
		자동차 자동차2 = 세단1;
		자동차 자동차3 = SUV1;
		
		자동차[] 자동차들 = {자동차1, 자동차2, 자동차3};
		
		for(int i = 0; i < 자동차들.length; i++) {
			자동차들[i].달리다();
		}
		
		
	}

}

abstract class 자동차 { // 추상 클래스
	abstract void 달리다(); // 구현이 없는 메서드 > 추상 메서드
}

class 경차 extends 자동차 {
	void 달리다() {
		System.out.println("경차가 경쾌하게 달립니다.");
	}
	void 연비절감() {
		System.out.println("연비가 절감됩니다.");
	}
}

class 세단 extends 자동차 {
	
	void 달리다() {
		System.out.println("세단이 우아하게 달립니다.");
	}
	
	void 안정된주행() {
		System.out.println("차가 정숙합니다.");
	}
}

class SUV extends 자동차 {

	void 달리다() {
		System.out.println("SUV가 힘차게 달립니다.");
	}
	
	void 많은적재( ) {
		System.out.println("짐을 많이 싣습니다.");
	}
}
