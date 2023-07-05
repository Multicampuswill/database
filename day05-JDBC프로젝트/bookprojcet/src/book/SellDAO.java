package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class SellDAO {

	// 검색 테이블 불러오기
	public ArrayList<BookVO> list_search(BookVO bag) {
		ArrayList<BookVO> list2 = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공.@@@@");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공.@@@@@@");

			String sql = "select * from book where bookId = ? or bookName = ? or bookWriter = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getBookId());
			ps.setString(2, bag.getBookName());
			ps.setString(3, bag.getBookWriter());
			System.out.println("3. sql문 생성 성공.@@@@@");

			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된row수) //1
			System.out.println("4. sql문 db서버로 전송 성공. @@@@@ 반영된 row수 >>" + rs.next());
			// rs.next() true면 결과가 있음. false면 결과가 없음.

			while (rs.next()) { // 결과값이 true이면!!
				System.out.println("검색결과가 있음.");
				String id = rs.getString(1); // 컬럼의 순서 1번 id값 추출
				String name = rs.getString(2);
				String writer = rs.getString(3);
				String date = rs.getString(4);
				int price = rs.getInt(5);
				System.out.println("검색한 결과>>" + id + " " + name + " " + writer + " " + date + " " + price);

				BookVO bag2 = new BookVO();
				bag2.setBookId(id);
				bag2.setBookName(name);
				bag2.setBookWriter(writer);
				bag2.setBookDate(date);
				bag2.setBookPrice(price);

				list2.add(bag2);
				System.out.println(list2);
			} // while
			System.out.println("box(list)에 들어간 가방의 갯수>> " + list2.size());
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	} // list

	// display all
	public ArrayList<BookVO> select() throws Exception {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		ResultSet rs = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from book";
		PreparedStatement ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			BookVO dto = new BookVO();
			dto.setBookId(rs.getString("bookId"));
			dto.setBookName(rs.getString("bookName"));
			dto.setBookWriter(rs.getString("bookWriter"));
			dto.setBookDate(rs.getString("bookDate"));
			dto.setBookPrice(rs.getInt("bookPrice"));
			list.add(dto);
		}
		System.out.println("displayAll");
		return list;
	}

	// 도서 판매 페이지 - 장바구니 추가
	public void toBasket(String bookNum, String id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO basket VALUES (?, ?, NOW())";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookNum);
		ps.setString(2, id);
		
		// 예외 처리
		String result2 = "실패";
		try {
			int result = ps.executeUpdate();
			if (result == 1) {
				result2 = "성공";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("에러 발생");
		}
		JOptionPane.showMessageDialog(null, result2);
		
	}
} // class
