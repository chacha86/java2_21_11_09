package board;

public class Like {
	int articleId;
	int memberId;
	String regDate;
	
	public Like(int articleId, int memberId, String regDate) {
		super();
		this.articleId = articleId;
		this.memberId = memberId;
		this.regDate = regDate;
	}
}
