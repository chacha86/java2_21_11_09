package test.day1;

import java.util.Scanner;

public class StringExam {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String str2 = "aaa";
		String str1 = sc.nextLine();
		
		if(str1.equals(str2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
	}

}
