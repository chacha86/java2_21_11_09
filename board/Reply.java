package board;

public class Reply {

	int id; // 식별데이터
	int parentId; // 부모글 번호
	String body; // 댓글내용
	int memberId; // 댓글 작성자
	String nickname; // 댓글 작성자
	String regDate; // 작성일
	
	public Reply(int id, int parentId, String body, int memberId, String regDate) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.body = body;
		this.memberId = memberId;
		this.regDate = regDate;
	}
}
