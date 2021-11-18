package board;

public class Article extends BaseInfo {

	String title;
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
