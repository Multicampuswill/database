package book;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;


import java.awt.Color;

public class BasketPageUI {
//	private static String id = "아이디1";
	private static int wallet;// 구매전 금액(충전잔액)
	private static int wallet2;// 구매후 금액
	private static int allPrice;// 장바구니 금액 총합
	private static JTable table;
	private static JTextArea bal;// 구매전 금액 표시
	private static JTextArea bal2;// 구매후 금액 표시

	private static JScrollPane scrollPane;
	private static JPanel panel;
	private static JFrame f;

	private static String[] head;
	private static Object[][] data;
	private static String[][] data2;
	private static BasketVO bag;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void open(String id) throws Exception {

		f = new JFrame("구매 페이지");
		panel = new JPanel();

		try {
			displayBasket(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		head = new String[] { "책 번호", "책 이름", "저자", "출간일", "가격" };

		panel.setLayout(null);
		table = new JTable(data, head);
		table.setPreferredScrollableViewportSize(new Dimension(1100, 600));

		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 120, 1160, 338);
		panel.add(scrollPane);
		f.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("구매 페이지");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 40, 280, 40);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPageUI mainPage = new MainPageUI();
				mainPage.open(id);
				f.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(900, 600, 117, 34);

		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("구매");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(f, "결제 완료");
				buyBook(id);
				panel.updateUI();
			}
		});

		btnNewButton_1.setBounds(1055, 600, 117, 34);
		panel.add(btnNewButton_1);

		bal = new JTextArea();
		bal.setBounds(995, 500, 177, 24);
		panel.add(bal); // 현재충전액

		JLabel lblNewLabel_1 = new JLabel("현재 금액 :");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(900, 505, 83, 19);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("구매 후 금액 :");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(900, 550, 90, 19);
		panel.add(lblNewLabel_1_1);

		bal2 = new JTextArea();
		bal2.setBounds(995, 545, 177, 24);
		panel.add(bal2); // 구매후 잔액

		f.setVisible(true);
		f.setSize(1200, 700);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		displayWallet(id);
		displayWallet2(id);

	}

	private static void displayWallet(String id) {
		MemberDAO dao = new MemberDAO();
		wallet = dao.myWallet(id);
		bal.append(String.valueOf(wallet));
	}

	private static void displayBasket(String id) {
		head = new String[] { "책 번호", "책 이름", "저자", "출간일", "가격" };
		BasketDAO dao = new BasketDAO();
		ArrayList<BookVO> list = dao.list(id); // 아이디

		data = new String[list.size()][5];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = list.get(i).getBookId();
			data[i][1] = list.get(i).getBookName();
			data[i][2] = list.get(i).getBookWriter();
			data[i][3] = list.get(i).getBookDate();
			data[i][4] = String.valueOf(list.get(i).getBookPrice());
		}
		table = new JTable(data, head);
		table.setPreferredScrollableViewportSize(new Dimension(1100, 600));

		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 1160, 338);
		panel.add(scrollPane);
		panel.updateUI();
	}

	private static void displayWallet2(String id) {

		allPrice = 0; // 장바구니 책 가격 총합

		BasketDAO dao = new BasketDAO();
		ArrayList<BookVO> list = dao.list(id);
		int[] price;
		price = new int[list.size()];

		for (int i = 0; i < data.length; i++) {
			price[i] = list.get(i).getBookPrice();
		}

		for (int i = 0; i < price.length; i++) {
			allPrice = allPrice + price[i];
		}

		if (wallet > allPrice) {
			wallet2 = wallet - allPrice;
			bal2.append(String.valueOf(wallet2));
		} else {
			bal2.append("구매 불가");
		}

	}

	private static void buyBook(String id) {
		
		BuylistDAO buyDAO = new BuylistDAO();
		BasketDAO basketDAO = new BasketDAO();
		MemberDAO memberDAO = new MemberDAO();
		
		ArrayList<BasketVO> list2 = basketDAO.list2(id);
		data2 = new String[list2.size()][3];
		
		for (int i = 0; i < data.length; i++) {
			bag = list2.get(i);
			
			data2[i][0] = bag.getBasketBook();
			data2[i][1] = bag.getBasketMember();
			data2[i][2] = bag.getBasketDate();
			
			buyDAO.insertBuyList(data2,i);
		}
		for(int i =0;i<data.length;i++) {
			basketDAO.deleteBasket(data2[i][0], data2[i][1]);
		}
		memberDAO.updateWallet(id,wallet2);//구매후 잔액 업데이트
		BuylistPageUI buy = new BuylistPageUI();
		//buy.open();// 다음페이지
		

	}
}