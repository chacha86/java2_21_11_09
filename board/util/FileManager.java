package board.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import board.BoardArticle;

public class FileManager {

	public BoardArticle loadArticleFromFile(int id) {
		
		BoardArticle article = null;
		
		try {
			String file = "c:/test/article/article_" + id + ".txt";
			FileReader reader = new FileReader(file); 
			BufferedReader br = new BufferedReader(reader); 
			String line = br.readLine(); 
			
			while(br.readLine() != null) { 
				System.out.println(line);
				line += br.readLine();
			}		
			
			br.close(); 
			reader.close();			
			article = getBoardArticleFromString(line);
			
			
		} catch (FileNotFoundException e) { 
			System.out.println("파일이 없습니다.");
			e.printStackTrace();
			
		} catch(IOException e) {
			System.out.println("파일을 읽어오는 중 문제가 발생했습니다.");
			e.printStackTrace();
			
		}
		return article;
	}
	
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
			writer.write("hit:" + article.hit);
			
			writer.close(); 

		} catch (IOException e) { 

			System.out.println("파일 쓰기 중 문제가 발생했습니다.");
			e.printStackTrace(); // 문제 원인을 대략적으로 파악해줌
		}
	}

	public BoardArticle getBoardArticleFromString(String target) {
		String[] properties = target.split(",");
		BoardArticle article = new BoardArticle();
		
		for(int i = 0; i < properties.length; i++) {
			String[] property = properties[i].split(":");
			
			if(property[0].equals("id")) {
				article.id = Integer.parseInt(property[1]);
			} else if(property[0].equals("title")) {
				article.title = property[1];
			} else if(property[0].equals("body")) {
				article.body = property[1];
			} else if(property[0].equals("memberId")) {
				article.memberId = Integer.parseInt(property[1]);
			} else if(property[0].equals("regDate")) {
				article.regDate = property[1];
			} else if(property[0].equals("hit")) {
				article.hit = Integer.parseInt(property[1]);
			}
		}
		
		return article;
	}
	
	
}
