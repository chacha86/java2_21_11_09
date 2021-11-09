package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	public void runBoard() {		
		//명령어를 입력해주세요 : (출력) help(입력)
		//add  : 게시물 등록 (출력)
		//list : 게시물 목록 조회 (출력)
		//명령어를 입력해주세요 : (출력) add(입력)
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> bodies = new ArrayList<>();
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("add")) {
				System.out.print("제목을 입력해주세요 : ");
				String title = sc.nextLine();
				System.out.print("내용을 입력해주세요 : ");
				String body = sc.nextLine();
		
				titles.add(title);
				bodies.add(body);
				
				System.out.println("게시물이 저장되었습니다.");
			} 
			else if(cmd.equals("list")) {
				
				for(int i = 0; i < titles.size(); i++) {
					String title = titles.get(i);
					String body = bodies.get(i);
					
					System.out.println("번호 : " + (i + 1));
					System.out.println("제목 : " + title);
					System.out.println("내용 : " + body);
					System.out.println("=========================");					
				}
			}
		}	
	}
}
