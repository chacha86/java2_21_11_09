package test.day10;

import board.BoardArticle;
import board.util.FileManager;

public class IOTest {

	public static void main(String[] args) {
		FileManager fm = new FileManager();
		
		BoardArticle a1 = new BoardArticle(1, "안녕하세요", "내용1입니다.", "2021120320000", 1, 20);
		
		fm.saveArticleToFile(a1);

	}

}
