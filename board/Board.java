package board;

import java.util.ArrayList;
import java.util.Scanner;

import board.util.MyUtil;

public class Board {

	ArrayList<BoardArticle> boardArticles = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<ReplyArticle> replies = new ArrayList<>();

	Scanner sc = new Scanner(System.in);
	String dateFormat = "yyyy.MM.dd";
	Member loginedMember = null; // 로그인한 유저 정보
	int boardArticleNo = 4; // 게시물 번호
	int memberNo = 3;
	int replyArticleNo = 1;

	public Board() {
		makeTestData();
	}

	public void runBoard() {

		while (true) {
			if (loginedMember == null) {
				System.out.print("명령어를 입력해주세요 : ");
			} else {
				System.out.print("명령어를 입력해주세요[" + loginedMember.nickname + "(" + loginedMember.loginId + ")] : ");
			}
			String cmd = sc.nextLine();

			if (cmd.equals("help")) {
				printHelp();
			} else if (cmd.equals("add")) {
				if (isLoginCheck() == true) {
					addBoardArticle();
				}
			} else if (cmd.equals("list")) {
				list(boardArticles);
			} else if (cmd.equals("update")) {
				updateBoardArticle();
			} else if (cmd.equals("delete")) {
				deleteBoardArticle();
			} else if (cmd.equals("search")) {
				searchboardArticles();
			} else if (cmd.equals("read")) {
				read();
			} else if (cmd.equals("signup")) {
				signup();
			} else if (cmd.equals("login")) {
				login();
			} else if (cmd.equals("logout")) {
				if (isLoginCheck() == true) {
					logout();
				}
			}
		}
	}

	private boolean isLoginCheck() {
		if (loginedMember == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		}

		return true;
	}

	private void logout() {

		loginedMember = null;
		System.out.println("로그아웃 되셨습니다.");

	}

	private void login() {
		System.out.print("아이디 : ");
		String loginId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String loginPw = sc.nextLine();

		boolean isExistLoginId = false;

		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			if (member.loginId.equals(loginId) && member.loginPw.equals(loginPw)) {
				
				// 우수회원 일반회원 구별
//				if(member instanceof GeneralMember) {
//					System.out.println("안녕하세요 일반회원 " + member.nickname + "님 반갑습니다");
//				} else if(member instanceof SpecialMember) {
//					SpecialMember specialMember = (SpecialMember)member;
//					System.out.println("안녕하세요 우수회원" + specialMember.nickname + "님 사랑합니다. 회원님의 잔여 포인트는 " + specialMember.point);
//				}
				
				member.greeting();
				
				System.out.println(member.nickname + "님 환영합니다.!");
				loginedMember = member;
				isExistLoginId = true;
				break;
			}
		}
		if (isExistLoginId == false) {
			System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
		}
	}

	private void signup() {
		
		System.out.print("1. 일반회원, 2. 우수회원 :");
		int memberFlag = Integer.parseInt(sc.nextLine());
		
		System.out.print("아이디를 입력해주세요 : ");
		String loginId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String loginPw = sc.nextLine();
		System.out.print("닉네임을 입력해주세요 : ");
		String nickname = sc.nextLine();

		Member member = null;
		
		if(memberFlag == 2) {
			member = new SpecialMember(memberNo, loginId, loginPw, nickname, 0);
		} else {
			member = new GeneralMember(memberNo, loginId, loginPw, nickname);
		}
		members.add(member);

		System.out.println("회원가입이 완료되었습니다.");
		memberNo++;
	}

	private void read() {
		System.out.print("상세보기할 게시물 번호 : ");
		int targetNo = Integer.parseInt(sc.nextLine());

		BoardArticle BoardArticle = getBoardArticleByNo(targetNo);

		if (BoardArticle == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			BoardArticle.hit++; // 조회수 증가

			printBoardArticle(BoardArticle);
			readProcess(BoardArticle);

		}
	}

	private void printBoardArticle(BoardArticle BoardArticle) {
		System.out.println("==== " + BoardArticle.id + "번 게시물 ====");
		System.out.println("번호 : " + BoardArticle.id);
		System.out.println("제목 : " + BoardArticle.title);
		System.out.println("-------------------");
		System.out.println("내용 : " + BoardArticle.body);
		System.out.println("-------------------");
		System.out.println("작성자 : " + BoardArticle.nickname);
		System.out.println("등록날짜: " + BoardArticle.regDate);
		System.out.println("조회수 : " + BoardArticle.hit);
		System.out.println("====================");
		System.out.println("======== 댓글 =======");
		for (int i = 0; i < replies.size(); i++) {
			ReplyArticle currentReplyArticle = replies.get(i);

			BaseArticle info = currentReplyArticle;
			
			if (currentReplyArticle.parentId == BoardArticle.id) {

				currentReplyArticle = (ReplyArticle)setNickname(currentReplyArticle);

				System.out.println("내용 : " + currentReplyArticle.body);
				System.out.println("작성자 : " + currentReplyArticle.nickname);
				System.out.println("작성일 : " + currentReplyArticle.regDate);
				System.out.println("====================");
			}
		}
	}

//	private ReplyArticle setReplyArticleNickname(ReplyArticle ReplyArticle) {
//
//		// null이 아니면 게시물에 닉네임을 세팅해주고 반환 아니면 null 그대로 반환
//		if ( ReplyArticle != null) {
//			Member member = getMemberByMemberNo(ReplyArticle.memberId);
//			ReplyArticle.nickname = member.nickname;
//		}
//
//		return ReplyArticle;
//	}

	private void readProcess(BoardArticle BoardArticle) {

		while (true) {
			System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
			int readCmd = Integer.parseInt(sc.nextLine());

			if (readCmd == 1) {
				ReplyArticle(BoardArticle);
			} else if (readCmd == 2) {
				System.out.println("좋아요 기능");
			} else if (readCmd == 5) {
				System.out.println("목록으로 돌아갑니다.");
				break;
			}
		}

	}

	private void ReplyArticle(BoardArticle BoardArticle) {
		System.out.print("댓글 내용을 입력해주세요 :");

		String rbody = sc.nextLine();
		int memberId = loginedMember.id;
		String regDate = MyUtil.getCurrentDate(dateFormat);

		ReplyArticle ReplyArticle = new ReplyArticle(replyArticleNo, BoardArticle.id, rbody, memberId, regDate);
		replies.add(ReplyArticle);

		System.out.println("댓글이 등록되었습니다.");

		// 상세보기 다시 보여주기.
		printBoardArticle(BoardArticle);

	}

	private void makeTestData() {
		String currentDate = MyUtil.getCurrentDate(dateFormat);
		boardArticles.add(new BoardArticle(1, "안녕하세요", "내용1입니다.", currentDate, 1, 0));
		boardArticles.add(new BoardArticle(2, "반갑습니다.", "내용2입니다.", currentDate, 2, 0));
		boardArticles.add(new BoardArticle(3, "안녕안녕", "내용3입니다.", currentDate, 1, 0));
		members.add(new GeneralMember(1, "hong123", "h1234", "홍길동"));
		members.add(new SpecialMember(2, "lee123", "1234", "이순신", 0));

		loginedMember = members.get(0);

	}

	private void searchboardArticles() {

		System.out.print("검색어 : ");
		String keyword = sc.nextLine();

		ArrayList<BoardArticle> searchedboardArticles = new ArrayList<>();

		for (int i = 0; i < boardArticles.size(); i++) {
			if (boardArticles.get(i).title.contains(keyword)) {
				searchedboardArticles.add(boardArticles.get(i));
			}
		}

		list(searchedboardArticles);

	}

	private void deleteBoardArticle() {
		System.out.print("삭제할 게시물 번호:");
		int targetNo = Integer.parseInt(sc.nextLine());

		BoardArticle BoardArticle = getBoardArticleByNo(targetNo);

		if (BoardArticle == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			boardArticles.remove(BoardArticle);
			System.out.println("삭제가 완료되었습니다.");

			list(boardArticles);
		}

	}

	private void updateBoardArticle() {
		System.out.print("수정할 게시물 번호:");
		int targetNo = Integer.parseInt(sc.nextLine());

		BoardArticle BoardArticle = getBoardArticleByNo(targetNo);

		if (BoardArticle == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			System.out.print("새제목 : ");
			String title = sc.nextLine();
			System.out.print("새내용 : ");
			String body = sc.nextLine();

			BoardArticle.title = title;
			BoardArticle.body = body;

			System.out.println("수정이 완료되었습니다.");
			list(boardArticles);
		}

	}

	private void addBoardArticle() {

		System.out.print("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		String currentDate = MyUtil.getCurrentDate(dateFormat);
		BoardArticle BoardArticle = new BoardArticle(boardArticleNo, title, body, currentDate, loginedMember.id, 0);
		boardArticles.add(BoardArticle);

		System.out.println("게시물이 저장되었습니다.");
		boardArticleNo++;

	}

	private void printHelp() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update  : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
		System.out.println("search : 게시물 검색");
	}

	// 게시물 데이터를 찾을 때 index가 아닌 게시물 데이터 그 자체를 찾는 것으로 변경
	// 회원이름을 게시물에 적용시켜 조립된 상태로 얻기 위함.
	public BoardArticle getBoardArticleByNo(int targetNo) {

		BoardArticle targetBoardArticle = null;

		// 찾고자하는 게시물을 찾고
		for (int i = 0; i < boardArticles.size(); i++) {
			BoardArticle currentBoardArticle = boardArticles.get(i);
			if (targetNo == currentBoardArticle.id) {
				targetBoardArticle = currentBoardArticle;
				break;
			}
		}

		// 닉네임을 세팅하고
		targetBoardArticle = (BoardArticle)setNickname(targetBoardArticle);

		// 반환
		return targetBoardArticle;
	}

	// 게시물을 받아 해당 게시물의 작성자 번호에 맞는 작성자 닉네임을 세팅해주는 메서드
	private BaseArticle setNickname(BaseArticle baseArticle) {

		// null이 아니면 게시물에 닉네임을 세팅해주고 반환 아니면 null 그대로 반환
		if (baseArticle != null) {
			Member member = getMemberByMemberNo(baseArticle.memberId);
			baseArticle.nickname = member.nickname;
		}

		return baseArticle;
	}

	// 게시물을 받아 해당 게시물의 작성자 번호에 맞는 작성자 닉네임을 세팅해주는 메서드
//	private BoardArticle setBoardArticleNickname(BoardArticle BoardArticle) {
//
//		// null이 아니면 게시물에 닉네임을 세팅해주고 반환 아니면 null 그대로 반환
//		if (BoardArticle != null) {
//			Member member = getMemberByMemberNo(BoardArticle.memberId);
//			BoardArticle.nickname = member.nickname;
//		}
//
//		return BoardArticle;
//	}

	// 게시물 찾기와 마찬가지로 역시 회원 정보 그 자체를 찾은 것으로 변경
	private Member getMemberByMemberNo(int memberId) {

		Member targetMember = null;

		for (int i = 0; i < members.size(); i++) {
			Member currentMember = members.get(i);
			if (memberId == currentMember.id) {
				targetMember = currentMember;
				break;
			}
		}

		return targetMember;
	}

	public void list(ArrayList<BoardArticle> list) {
		for (int i = 0; i < list.size(); i++) {
			BoardArticle BoardArticle = list.get(i);
			BoardArticle = (BoardArticle)setNickname(BoardArticle); // 모든 게시물의 닉네임을 작성자에 맞게 세팅

			System.out.println("번호 : " + BoardArticle.id);
			System.out.println("제목 : " + BoardArticle.title);
			System.out.println("작성자 : " + BoardArticle.nickname);
			System.out.println("등록날짜 : " + BoardArticle.regDate);
			System.out.println("조회수 : " + BoardArticle.hit);
			System.out.println("=========================");
		}
	}
}
