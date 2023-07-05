package book;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

public class BuylistPageUI {

//	private static String id = "아이디1";
	private static JTable table;
	private static JTextArea cal;
	private static JTextArea cal2;

	private static JScrollPane scrollPane;
	private static JPanel panel;
	private static JFrame f;

	private static String[] head;
	private static Object[][] data;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void open(String id) {
//	public static void main(String[] args) {

		f = new JFrame("정산 페이지");
		panel = new JPanel();
		panel.setLayout(null);
		f.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("정산 페이지");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 40, 322, 40);
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
		btnNewButton.setBounds(1055, 53, 117, 34);
		panel.add(btnNewButton);

		cal = new JTextArea();
		cal.setBounds(995, 500, 177, 24);
		panel.add(cal);

		JLabel lblNewLabel_1 = new JLabel("정산 금액 :");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(900, 505, 83, 19);
		panel.add(lblNewLabel_1);

		f.setVisible(true);
		f.setSize(1200, 700);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		displayBuyList(id);
		displayPrice(id);

	}

	private static void displayPrice(String id) {
		BuylistDAO dao = new BuylistDAO();
		ArrayList<BookVO> list = dao.list2(id);
		
		int[] price = new int[list.size()];;
		int allPrice = 0;
		
		for (int i = 0; i < data.length; i++) {
			price[i] = list.get(i).getBookPrice();
		}
		for (int i = 0; i < price.length; i++) {
			allPrice = allPrice + price[i];
		}
		cal.append(String.valueOf(allPrice));
	}

	private static void displayBuyList(String id) {

		head = new String[] { "책 번호", "책 이름", "저자", "출간일", "가격" };
		BuylistDAO dao = new BuylistDAO();
		ArrayList<BookVO> list2 = dao.list2(id); // 아이디

		data = new String[list2.size()][5];

		for (int i = 0; i < data.length; i++) {
			data[i][0] = list2.get(i).getBookId();
			data[i][1] = list2.get(i).getBookName();
			data[i][2] = list2.get(i).getBookWriter();
			data[i][3] = list2.get(i).getBookDate();
			data[i][4] = String.valueOf(list2.get(i).getBookPrice());
		}
		table = new JTable(data, head);
		table.setPreferredScrollableViewportSize(new Dimension(1100, 600));

		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 120, 1160, 338);
		panel.add(scrollPane);
		panel.updateUI();
	}
}