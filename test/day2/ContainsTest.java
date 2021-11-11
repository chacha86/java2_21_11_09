package test.day2;

public class ContainsTest {

	public static void main(String[] args) {
		String txt1 = "가나다라" ;
        String txt2 = "해당 내용은 테스트 입니다" ;
        String txt3 = "가격은 29,000원 입니다" ;
         
        if(txt3.contains("29,000"))
            System.out.println("문자열 있음!");
        else
            System.out.println("문자열 없음!");
         
	}

}
