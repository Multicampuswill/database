package 자바DB연결;

import java.util.Scanner;

public class 게시판정보수정 {

	public static void main(String[] args) {
	
		//입력해보자.
		Scanner sc = new Scanner(System.in);
		System.out.println("no/title순으로 입력하세요.");
		
		int	no = sc.nextInt(); //"10" --> 10
		String title = sc.next();
		
		BbsDAO dao = new BbsDAO();
		dao.update(no, title);
	}

}

