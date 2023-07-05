// 검색 기능 구현 V
// 장바구니 기능 구현
// 구매 기능 구현

package book;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SellPageUI {
	private static JTable table;
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void open(String id) {

		JFrame f = new JFrame();
		f.setSize(1200, 700);
		f.getContentPane().setLayout(null);

		// Title label
		JLabel lb_title = new JLabel("도서 판매 페이지");
		lb_title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lb_title.setBounds(36, 34, 330, 77);
		f.getContentPane().add(lb_title);

		// frame에 scrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 140, 600, 440);
		f.getContentPane().add(scrollPane);

		// scrollPane에 table
		table = new JTable();
		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "책 번호", "책 이름", "저자", "출간일", "가격" }));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		displayAll(model);

		// search text
		JLabel bl1 = new JLabel("책 번호 :");
		bl1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		bl1.setBounds(680, 144, 145, 55);
		f.getContentPane().add(bl1);

		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.LEFT);
		t1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t1.setToolTipText("");
		t1.setBounds(837, 144, 276, 58);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JLabel bl2 = new JLabel("책 이름 :");
		bl2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		bl2.setBounds(680, 223, 145, 55);
		f.getContentPane().add(bl2);

		t2 = new JTextField();
		t2.setToolTipText("");
		t2.setHorizontalAlignment(SwingConstants.LEFT);
		t2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t2.setColumns(10);
		t2.setBounds(837, 223, 276, 58);
		f.getContentPane().add(t2);

		JLabel bl3 = new JLabel("저자 :");
		bl3.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		bl3.setBounds(680, 303, 145, 55);
		f.getContentPane().add(bl3);

		t3 = new JTextField();
		t3.setToolTipText("");
		t3.setHorizontalAlignment(SwingConstants.LEFT);
		t3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t3.setColumns(10);
		t3.setBounds(837, 303, 276, 58);
		f.getContentPane().add(t3);

		// 버튼
		JButton btn_search = new JButton("도서 검색");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String name = t2.getText();
				String writer = t3.getText();

				SellDAO dao = new SellDAO();
				BookVO bag = new BookVO();
				bag.setBookId(id);
				bag.setBookName(name);
				bag.setBookWriter(writer);

				ArrayList<BookVO> list2 = dao.list_search(bag);

				// 리셋
				model.setRowCount(0);

				System.out.println("받아온 가방의 갯수" + list2.size());
				System.out.println("받아온 가방의 내용" + list2);

				// table 받아오기
				String header[] = { "책 번호", "책 이름", "저자", "출간일", "가격" };
				Object[][] contents = new Object[list2.size()][5];
				for (int i = 0; i < contents.length; i++) {
					contents[i][0] = list2.get(i).getBookId();
					contents[i][1] = list2.get(i).getBookName();
					contents[i][2] = list2.get(i).getBookWriter();
					contents[i][3] = list2.get(i).getBookDate();
					contents[i][4] = list2.get(i).getBookPrice();
				}

				table = new JTable(contents, header);
				scrollPane.setViewportView(table);
//				JScrollPane scrollPane = new JScrollPane(table);
//				scrollPane.setBounds(63, 218, 1070, 302);

				// txt 비우기
				t1.setText("");
				t2.setText("");
				t3.setText("");

			}
		});
//		btn_search.setForeground(Color.WHITE);
//		btn_search.setBackground(Color.GRAY);
		btn_search.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_search.setBounds(989, 373, 124, 55);
		f.getContentPane().add(btn_search);

		// 장바구니 & 구매 txt
		JLabel bl4 = new JLabel("책 번호 : ");
		bl4.setFont(new Font("Dialog", Font.PLAIN, 25));
		bl4.setBounds(680, 459, 145, 55);
		f.getContentPane().add(bl4);

		t4 = new JTextField();
		t4.setToolTipText("");
		t4.setHorizontalAlignment(SwingConstants.LEFT);
		t4.setFont(new Font("Dialog", Font.PLAIN, 20));
		t4.setColumns(10);
		t4.setBounds(837, 459, 276, 58);
		f.getContentPane().add(t4);

		// 장바구니 버튼
		// 장바구니 추가
		JButton btn_basket = new JButton("장바구니");
		btn_basket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookNum = t4.getText();
//				String id = "idid"; // 아이디 값
				SellDAO dao = new SellDAO();
				try {
					dao.toBasket(bookNum, id);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
//		btn_basket.setForeground(Color.WHITE);
//		btn_basket.setBackground(Color.GRAY);
		btn_basket.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_basket.setBounds(837, 529, 124, 55);
		f.getContentPane().add(btn_basket);

		// 구매 버튼
		// 항목 장바구니 추가 + 구매 페이지 이동
		JButton btn_buynow = new JButton("구매");
		btn_buynow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookNum = t4.getText();
//				String id = "idid"; // 아이디 값
				SellDAO dao = new SellDAO();
				try {
					dao.toBasket(bookNum, id);
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				// 구매 페이지로 이동
			}
		});
//		btn_buynow.setForeground(Color.WHITE);
//		btn_buynow.setBackground(Color.GRAY);
		btn_buynow.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_buynow.setBounds(989, 529, 124, 55);
		f.getContentPane().add(btn_buynow);
		
		JButton btn_buynow_1 = new JButton("뒤로가기");
		btn_buynow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPageUI mainPage = new MainPageUI();
				mainPage.open(id);
				f.dispose();
			}
		});
		btn_buynow_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_buynow_1.setBounds(989, 39, 124, 55);
		f.getContentPane().add(btn_buynow_1);

		f.setVisible(true);
	}

	private static void displayAll(DefaultTableModel model) {
		SellDAO dao = new SellDAO();
		ArrayList<BookVO> allData;
		try {
			allData = dao.select();
			for (BookVO dto : allData) {
				String bookId = dto.getBookId();
				String bookName = dto.getBookName();
				String bookWriter = dto.getBookWriter();
				String bookDate = dto.getBookDate();
				int bookPrice = dto.getBookPrice();
				model.addRow(new Object[] { bookId, bookName, bookWriter, bookDate, bookPrice });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
