package board;

public class SpecialMember extends Member {

	int point;
	
	public SpecialMember(int id, String loginId, String loginPw, String nickname, int point) {
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
		this.point = point;
	}
	
	public void greeting() {
		System.out.println("안녕하세요 일반회원 " + nickname + "님 사랑합니다. 회원님의 남은 포인트는 현재 " + point + "입니다.");
	}
	
}
