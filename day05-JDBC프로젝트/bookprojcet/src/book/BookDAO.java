package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {

	public void insert(String bookId, String bookName, String bookWriter, String bookDate, int bookPrice)
			throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "insert into book values (?, ?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookId);
		ps.setString(2, bookName);
		ps.setString(3, bookWriter);
		ps.setString(4, bookDate);
		ps.setInt(5, bookPrice);

		int result = ps.executeUpdate();
		System.out.println(result);
	}

	public void delete(String bookId) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "delete from book where bookId = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookId);

		int result = ps.executeUpdate();
		System.out.println(result);

	}

	public void update(String bookId, String bookName, String bookWriter, String bookDate, int bookPrice)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "update book set bookName = ?, bookWriter = ?, bookDate = ?, bookPrice = ? where bookId = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookName);
		ps.setString(2, bookWriter);
		ps.setString(3, bookDate);
		ps.setInt(4, bookPrice);
		ps.setString(5, bookId);

		int result = ps.executeUpdate();
		System.out.println(result);
	}

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
}
