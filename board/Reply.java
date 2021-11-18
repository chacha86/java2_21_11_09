package board;

public class Reply {

	int id; // 식별데이터
	String body; // 댓글내용
	int memberId; // 댓글 작성자
	String regDate; // 작성일
	
	public Reply(int id, String body, int memberId, String regDate) {
		super();
		this.id = id;
		this.body = body;
		this.memberId = memberId;
		this.regDate = regDate;
	}
}
