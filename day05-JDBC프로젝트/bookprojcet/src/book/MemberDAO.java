package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MemberDAO {

	public void insert(MemberVO bag) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/book?serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "insert into member values(?,?,?,0)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣어 set.integar
			ps.setString(2, bag.getName());
			ps.setString(3, bag.getPwd());
			System.out.println("성공");

			int result = ps.executeUpdate(); // r 결과는 table cud는 숫자
			System.out.println("4번성공 반영된 row 수>>" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int signup(MemberVO bag) {
		// 전달 잘됐나 확인
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/book?serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "select * from member where id =  ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣어 set.integar
			ResultSet rs = ps.executeQuery(); // r 결과는 table cud는 숫자
			if (rs.next()) {
				System.out.println("사용불가능한 id");
				result = 1;
			} else {
				System.out.println("사용가능한 id");
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int signin(MemberVO bag) {
		int result = 0; // 없는 경우
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/book?serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "select * from member where id = ? and pwd = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPwd());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("검색결과가 있음.");
				result = 1;
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int myWallet(String id) {
		System.out.println(id);

		MemberVO vo = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공");

			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");

			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된 row수)
//			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + rs.next());

			if (rs.next()) {
				System.out.println("검색 결과가 있음");
				String id2 = rs.getString(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				int wallet = Integer.parseInt(rs.getString(4));
				System.out.println(id2 + " " + name + " " + pwd + " " + wallet);

				vo = new MemberVO();
				vo.setId(id2);
				vo.setName(name);
				vo.setPwd(pwd);
				vo.setWallet(wallet);

			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo.wallet;
	}

	public void updateWallet(String id, int wallet) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공");

			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공");

			String sql = "update member set wallet = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, wallet);
			ps.setString(2, id);
			System.out.println("3. sql문 생성 성공");

			int result = ps.executeUpdate();
			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + result);
//			JOptionPane.showMessageDialog(null, "충전 완료");
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
