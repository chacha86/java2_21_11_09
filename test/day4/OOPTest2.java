package test.day4;

public class OOPTest2 {

	public static void main(String[] args) {

		// 일반 형변환 규칙
		int a = 10;
		double d = 10.0;
		
		d = a; // 자동 형변환 - 안전할 때 자바가 해줌
		a = (int)d; // 수동 형변환 - 안전하지 않을 때 개발자가 직접 수행
		
		// 객체 형변환 규칙
		경차 경차1 = new 경차();
		경차 경차2 = new 경차();
		
		세단 세단1 = new 세단();
		
		경차1.연비절감();
		세단1.안정된주행();
		
		경차1.연비절감();
		
		경차1.달리다();
		세단1.달리다();
		
		자동차 자동차1 = new 경차(); // 경차가 자동차로 형변환. 자동형변환
		
		자동차1.달리다();	
		자동차1.달리다();
		
		
		자동차1 = 경차1;
		경차 경차3 = (경차)자동차1; // 형이 다름. 형변환하면 위험함. 잘못된 실행 명령		
		경차3.연비절감();
		
		
		
	}

}

class 자동차 {
	void 달리다() {
		System.out.println("자동차가 달립니다.");
	}
}

class 경차 extends 자동차 {
	void 연비절감() {
		System.out.println("연비가 절감됩니다.");
	}
}

class 세단 extends 자동차 {
	void 안정된주행() {
		System.out.println("차가 정숙합니다.");
	}
}
