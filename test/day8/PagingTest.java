package test.day8;

import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int currentPageNo = 1;
		
		// 현재페이지 : 0 +  1 ~ 5 , 블럭 1
		// 현재페이지 : 5 +  1 ~ 10 , 블럭 2
		// 현재페이지 : 10 + 1 ~ 15 , 블럭 3
		
		
		
		
		int currentBlock = 1; 
		
		
		
		
		// 페이지 블럭번호 1 , (5 * 0) + 1 ~ 5
		// 페이지 블럭번호 2,  (5 * 1) + 1 ~ 10
		// 페이지 블럭번호 3 , (5 * 2) + 1 ~ 15
		
		// (5 * 페이지 블럭번호 - 1) + 1 ==> 현재 페이지 블럭의 시작 번호
		// 현재 페이지 블럭의 시작 번호 + 4 ==> 현재 페이지 블럭의 마지막 번호
		
		while(true) {
			// 현재페이지 번호 / 한 블럭당 페이지 개수
			int currentBlockNo = (int)Math.ceil((double)currentPageNo / 5);
			
			int startPageNoInBlock = 5 * (currentBlockNo - 1) + 1;
			int endPageNoInBlock = startPageNoInBlock + 4;
			
			for(int i = startPageNoInBlock; i <= endPageNoInBlock; i++) {	
				if(i == currentPageNo) {
					System.out.print("["+i + "] ");				
				} else {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			
			System.out.println("1. 다음, 2. 이전");
			int pcmd = Integer.parseInt(sc.nextLine());
			if(pcmd == 1) {			
				currentPageNo++;
			} else if(pcmd == 2) {
				currentPageNo--;
			}			
		}
		
		
	}

}
