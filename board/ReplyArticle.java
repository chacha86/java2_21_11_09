package board;

public class ReplyArticle extends BaseArticle {

	int parentId; // 부모글 번호
	
	public ReplyArticle(int id, int parentId, String body, int memberId, String regDate) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.body = body;
		this.memberId = memberId;
		this.regDate = regDate;
	}
}
