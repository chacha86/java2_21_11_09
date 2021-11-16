package board;

public class Article {

	int id;
	String title;
	String body;
	String regDate;
	int memberId; // 게시물을 작성한 회원을 구별하기 위한 용도
	String nickname; // 출력시 회원의 닉네임을 얻어와 저장하기 위한 용도
	int hit;
	//회원정보
	
	public Article(int id, String title, String body, String regDate, int memberId, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.memberId = memberId;
		this.hit = hit;
	}	
	
}
