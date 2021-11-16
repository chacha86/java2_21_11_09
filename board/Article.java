package board;

public class Article {

	int id;
	String title;
	String body;
	String regDate;
	int memberId;
	int hit;
	
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
