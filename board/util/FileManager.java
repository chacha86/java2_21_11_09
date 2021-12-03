package board.util;

import java.io.FileWriter;
import java.io.IOException;

import board.BoardArticle;

public class FileManager {

	public void saveArticleToFile(BoardArticle article) {
		try {
			FileWriter writer = new FileWriter("c:/test/article/article_" + article.id + ".txt");
			// 게시물 저장
			// 번호
			writer.write("id:" + article.id + ",");
			// 제목
			writer.write("title:" + article.title + ",");
			// 내용
			writer.write("body:" + article.body + ",");
			// 작성자
			writer.write("memberId:" + article.memberId + ",");
			// 작성일
			writer.write("regDate:" + article.regDate + ",");
			// 조회수
			writer.write("hit:" + article.regDate);
			
			writer.close(); 

		} catch (IOException e) { 

			System.out.println("파일 쓰기 중 문제가 발생했습니다.");
			e.printStackTrace();
		}
	}

}
