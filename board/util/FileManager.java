package board.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import board.BoardArticle;

public class FileManager {
	String articlePath = "c:/test/article/";
	String filePrefix = "article_";
	String fileSuffix = ".txt";

	public void deleteArticleFile(int id) {
		String filename = getFilename(id);
		String filepath = getFilepath(filename);
		File file = new File(filepath);
		if(!file.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		file.delete();
	}

	public String getFilename(int id) {
		return filePrefix + id + fileSuffix;
	}
	public String getFilepath(String filename) {
		return articlePath + filename;
	}
	public BoardArticle loadArticleFromFile(String filename) {
		String path = getFilepath(filename);
		BoardArticle article = null;

		try {
			FileReader reader = new FileReader(path);
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();

			while (br.readLine() != null) {
				System.out.println(line);
				line += br.readLine();
			}

			br.close();
			reader.close();
			article = getBoardArticleFromString(line);

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("파일을 읽어오는 중 문제가 발생했습니다.");
			e.printStackTrace();

		}
		return article;
	}

	public BoardArticle loadArticleFromFile(int id) {
		String filename = getFilename(id);
		BoardArticle article = loadArticleFromFile(filename);

		return article;
	}

	public void saveArticleToFile(BoardArticle article) {
		try {
			String filepath = getFilepath(getFilename(article.id));
			FileWriter writer = new FileWriter(filepath);
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

		for (int i = 0; i < properties.length; i++) {
			String[] property = properties[i].split(":");

			if (property[0].equals("id")) {
				article.id = Integer.parseInt(property[1]);
			} else if (property[0].equals("title")) {
				article.title = property[1];
			} else if (property[0].equals("body")) {
				article.body = property[1];
			} else if (property[0].equals("memberId")) {
				article.memberId = Integer.parseInt(property[1]);
			} else if (property[0].equals("regDate")) {
				article.regDate = property[1];
			} else if (property[0].equals("hit")) {
				article.hit = Integer.parseInt(property[1]);
			}
		}

		return article;
	}

	public ArrayList<BoardArticle> getAllArticles() {
		ArrayList<BoardArticle> articles = new ArrayList<>();
		File articleFolder = new File(articlePath);
		String[] articleFilenames = articleFolder.list();
		
		for(int i = 0; i < articleFilenames.length; i++) {
			String filename = articleFilenames[i];
			BoardArticle article = loadArticleFromFile(filename);
			articles.add(article);
		}
		Collections.sort(articles, new ArticleComparator(1,1));
		return articles;
	}

}
