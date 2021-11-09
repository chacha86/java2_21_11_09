package test;

public class 동물 {
	
	void 숨쉬다() {
		System.out.println("숨을 쉽니다.");
	}
	
}

class 강아지 extends 동물 {
	
	void 짖다() {
		System.out.println("멍멍");
	}
	
	void 숨쉬다() {
		System.out.println("헥헥헥");
	}
}

class 고양이 extends 동물 {
	
	void 야옹() {
		System.out.println("야옹");
	}
	
	void 숨쉬다() {
		System.out.println("갸르릉");
	}
}