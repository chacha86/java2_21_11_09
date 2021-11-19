package board;

public class GeneralMember extends Member {
	
	public GeneralMember(int id, String loginId, String loginPw, String nickname) {
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
	}
	
	public void greeting() {
		System.out.println("안녕하세요 일반회원 " + nickname + "님 반갑습니다");
	}
}
