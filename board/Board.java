package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	
	ArrayList<Article> articles = new ArrayList<>();	
	Scanner sc = new Scanner(System.in);
	int no = 1; // 게시물 번호
	
	public void runBoard() {		
				
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("help")) {
				printHelp();
			} else if(cmd.equals("add")) {
				addArticle();
			} else if(cmd.equals("list")) {
				list();
			} else if(cmd.equals("update")) {
				updateArticle();		
			} else if(cmd.equals("delete")) {
				deleteArticle();	
			}
		}	
	}
	
	private void deleteArticle() {
		System.out.print("삭제할 게시물 번호:");
		int targetNo = Integer.parseInt(sc.nextLine());
	
		int targetIndex = getIndexOfArticleNo(targetNo);
		
		if(targetIndex == -1) {
			System.out.println("없는 게시물입니다.");
		} else {
			articles.remove(targetIndex);
			System.out.println("삭제가 완료되었습니다.");
			
			list();
		}	
		
	}

	private void updateArticle() {
		System.out.print("수정할 게시물 번호:");
		int targetNo = Integer.parseInt(sc.nextLine());
	
		int targetIndex = getIndexOfArticleNo(targetNo);
		
		if(targetIndex == -1) {
			System.out.println("없는 게시물입니다.");
		} else {
			System.out.print("새제목 : ");
			String title = sc.nextLine();
			System.out.print("새내용 : ");
			String body = sc.nextLine();
			
			Article article = new Article(targetNo, title, body);
			articles.set(targetIndex, article);
			
			System.out.println("수정이 완료되었습니다.");
			list();
		}		
		
	}

	private void addArticle() {
		System.out.print("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		Article article = new Article(no, title, body);			
		articles.add(article);
		
		System.out.println("게시물이 저장되었습니다.");
		no++; 
		
	}

	private void printHelp() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update  : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
		System.out.println("search : 게시물 검색");
	}

	public int getIndexOfArticleNo(int targetNo) {
		
		for(int i = 0; i < articles.size(); i++) {
			Article currentArticle = articles.get(i);
			if(targetNo == currentArticle.id) {
				return i;
			}
		}
		
		return -1;		
	}
	
	public void list() {
		for(int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			
			System.out.println("번호 : " + article.id);
			System.out.println("제목 : " + article.title);
			System.out.println("=========================");					
		}
	}
}
