package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BuylistDAO {
	public ArrayList<BookVO> list2(String id) {// 구매내역 읽어오기
		ArrayList<BookVO> list2 = new ArrayList<BookVO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공");

			String sql = "select * from buylist inner join book on buylist.buyBook = book.bookId where buyMember = ?";
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
				int bookPrice = rs.getInt("bookPrice");

				BookVO vo = new BookVO();

				vo.setBookId(bookId);
				vo.setBookName(bookName);
				vo.setBookWriter(bookWriter);
				vo.setBookDate(bookDate);
				vo.setBookPrice(bookPrice);

				list2.add(vo);
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

	public void insert(BuylistVO bag) {// 구매내역 등록

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/book?serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "insert into buylist values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getBuyBook());
			ps.setString(2, bag.getBuyMember());
			ps.setString(3, bag.getBuyDate());
			System.out.println("성공");

			int result = ps.executeUpdate(); // r 결과는 table cud는 숫자
			System.out.println("4번성공 반영된 row 수>>" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertBuyList(String[][] a,int i) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/book?serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "insert into buylist values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			Object value[][]= a;
			ps.setString(1,(String) value[i][0]);
			ps.setString(2,(String) value[i][1]);
			ps.setString(3,(String) value[i][2]);
		
			
			int result = ps.executeUpdate(); // r 결과는 table cud는 숫자
			System.out.println("4번성공 반영된 row 수>>" + result);
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}
	

}
