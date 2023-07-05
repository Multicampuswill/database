package 자바DB연결;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class Test {
	//부품은 기능을 처리하기 위해서 만든 부품
		//휴대폰의 기능 -> 함수(메서드)
		public void add2() {
			System.out.println("더하기 기능을 수행합니다.");
		}
		
		
		public int add(int x, int y) {
			return x + y;
		}

		public double add (double x, int y)
		{
			return x + y; //자바에서는 하나라도 double이면 무조건 결과는 double
			
		}
		
		
		public String add(String x, String y) {
			return x + y;
		}
		
		public String add(int x, String y) {
			return x + y;
		}
		
		public int[] add() { //x앞에 있는 타입 int[]를 써준다
			int[]x = {1, 2, 3};
			return x;
		}
		
		public Date getDate() {
			Date date = new Date();
			return date;
		}
		
		public Random getRandom() {
			Random r = new Random();
			return r;
		}
		
		
		public int getRandom2() {
			Random r = new Random();
			return r.nextInt(); //랜덤한 정수값 29, 305
		}
		
		public int getHour() { // 반환값이 정수이므로 int
			Date date = new Date();
			return date.getHours(); //11
		}
		
		public ArrayList getList() {
			ArrayList list = new ArrayList();
			list.add("감자");
			list.add("고구마");
			return list;
		}
		
		public HashSet getSet() { // 반환값이 정수이므로 int
			HashSet bag = new HashSet();
			bag.add("휴지");
			bag.add("팬");
			return bag;
		}
		
		
		
//		public Connection getConnection(String url, String user, String password) {
//			//연결처리..
//			Connection con = 연결처리하는 커넥션..;
//			return con;
//		}
		
}
