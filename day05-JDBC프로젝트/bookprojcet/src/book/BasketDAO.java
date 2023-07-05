package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class BasketDAO {

	public ArrayList<BookVO> list(String id) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공");

			String sql = "select * from basket inner join book on basket.basketBook = book.bookId where basketMember = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");

			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된 row수)

			while (rs.next()) {
				System.out.println("검색 결과가 있음");
				String bookId = rs.getString("bookId");
				String bookName = rs.getString("bookName");
				String bookWriter = rs.getString("bookWriter");
				String bookDate = rs.getString("bookDate");
				int bookPrice = rs.getInt("bookprice");

				BookVO vo = new BookVO();
				
				vo.setBookId(bookId);
				vo.setBookName(bookName);
				vo.setBookWriter(bookWriter);
				vo.setBookDate(bookDate);
				vo.setBookPrice(bookPrice);

				list.add(vo);
			}
			System.out.println("박스(list)에 들어간 가방의 갯수>> " + list.size());

			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BasketVO> list2 (String id) {
		ArrayList<BasketVO> list2 = new ArrayList<BasketVO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공");

			String sql = "select * from basket where basketMember = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");

			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된 row수)

			while (rs.next()) {
				System.out.println("검색 결과가 있음");
				String basketBook = rs.getString("basketBook");
				String basketMember = rs.getString("basketMember");
				String basketDate = rs.getString("basketDate");

				BasketVO vo2 = new BasketVO();
				
				vo2.setBasketBook(basketBook);
				vo2.setBasketMember(basketMember);
				vo2.setBasketDate(basketDate);
				

				list2.add(vo2);
			}
			System.out.println("박스(list)에 들어간 가방의 갯수>> " + list2.size());

			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list2;
	}
	
	public void deleteBasket(String basketBook, String basketMember) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공");

			String sql = "delete from basket where basketBook = ? and basketMember = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, basketBook);
			ps.setString(2, basketMember);
			System.out.println("3. sql문 생성 성공");

			int result = ps.executeUpdate();
			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + result);
			//JOptionPane.showMessageDialog(null, "삭제 완료");
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
