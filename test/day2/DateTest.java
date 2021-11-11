package test.day2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTest {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatedNow = now.format(formatter);
		

	}

}
