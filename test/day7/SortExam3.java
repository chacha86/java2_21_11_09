package test.day7;

import java.util.ArrayList;
import java.util.Collections;

public class SortExam3 {

	public static void main(String[] args) {
		
		사람 사람1 = new 사람(20, "홍길동");
		사람 사람2 = new 사람(17, "유관순");
		사람 사람3 = new 사람(21, "을지문덕");
		사람 사람4 = new 사람(30, "이순신");
		사람 사람5 = new 사람(28, "강감찬");
		
		ArrayList<사람> 사람들 = new ArrayList<>();
		
		사람들.add(사람1);
		사람들.add(사람2);
		사람들.add(사람3);
		사람들.add(사람4);
		사람들.add(사람5);
		
		for(int i = 0; i < 사람들.size(); i++) {
			사람 현재사람 = 사람들.get(i);
			현재사람.자기소개();
		}
		
		//Collections.sort(사람들);
		
		System.out.println("====================================");
		for(int i = 0; i < 사람들.size(); i++) {
			사람 현재사람 = 사람들.get(i);
			현재사람.자기소개();
		}
		
	}

}

class 사람 {
	int 나이;
	int 몸무게;
	String 이름;
	
	사람(int 나이, int 몸무게, String 이름) {
		this.나이 = 나이;
		this.이름 = 이름;
		this.몸무게 = 몸무게;
	}
	
	void 자기소개() {
		System.out.println("안녕하세요 저는 " + 이름 + "이고, " + 나이 + "살입니다." );
	}
}