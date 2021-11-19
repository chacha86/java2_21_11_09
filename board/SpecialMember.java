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
}
