package test.day10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOExam {

	public static void main(String[] args) {
		
		try {
			FileWriter writer = new FileWriter("c:/test/test1.txt"); // 해당 파일에 내용을 작성해주는 파일 입력 도구
			writer.write("안녕하세요.\n"); // 파일에 내용 작성
			writer.write("반갑습니다~\n");
			writer.write("잘가세요.\n");
			
			writer.close(); // 파일 작성이 끝난 후 자원 해제
			
		} catch(IOException e) { // 파일 작성 중 문제가 생기면 처리
			
			System.out.println("파일 쓰기 중 문제가 발생했습니다.");
		}
		
		
		try {
			FileReader reader = new FileReader("c:/test/test1.txt"); // 해당 파일의 내용을 읽어오는 파일 출력 도구
			BufferedReader br = new BufferedReader(reader); // FileReader는 사용하기 불편해서 사용하기 편한 형태로 읽어옴. 속도도 빠름
			String line = br.readLine(); // 한줄 읽어오기
			
			while(line != null) { // 다 읽어서 더 읽은 것이 없으면 null 반환.
				System.out.println(line);
				line = br.readLine();
			}		
			
			br.close(); // 자원해제는 생성의 역순
			reader.close();  
			
		} catch (FileNotFoundException e) { // 파일을 찾지 못했을 때 처리
			
			System.out.println("파일이 없습니다.");
		} catch(IOException e) { // 파일 읽어오는중 문제가 발생하면 처리
			
			System.out.println("파일을 읽어오는 중 문제가 발생했습니다.");
		}
		
		
		
		
	}

}

