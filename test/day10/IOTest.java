package test.day10;

import board.BoardArticle;
import board.util.FileManager;

public class IOTest {

	public static void main(String[] args) {
		FileManager fm = new FileManager();
		
		BoardArticle a1 = new BoardArticle(1, "안녕하세요", "내용1입니다.", "2021120320000", 1, 20);
		BoardArticle a2 = new BoardArticle(2, "안녕하세요2", "내용2입니다.", "2021120420000", 2, 30);
		BoardArticle a3 = new BoardArticle(3, "안녕하세요3", "내용3입니다.", "2021120520000", 3, 40);
		
		fm.saveArticleToFile(a1);
		fm.saveArticleToFile(a2);
		fm.saveArticleToFile(a3);

		fm.loadArticleFromFile(3);
		fm.loadArticleFromFile(4);
		
		
	}

}
