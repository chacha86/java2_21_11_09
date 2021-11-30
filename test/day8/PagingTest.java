package test.day8;

import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int currentPageNo = 1;
		
		while(true) {
			for(int i = 1; i <= 5; i++) {	
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
