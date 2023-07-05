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
import javax.swing.JTextField;

import java.awt.Color;
// 아이디   <- 주석 표시는 앞의 페이지에서 로그인한 사람 아이디를 가져와서 넘겨야함
public class MyPageUI {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTable table;
	private static JScrollPane scrollPane;
	private static JPanel panel;
	private static JFrame f;
	
	private static String[] head;
	private static Object[][] data;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void open(String id) {
		f = new JFrame("마이 페이지");
		f.setSize(1200, 700);
		f.setLocationRelativeTo(null);
		panel = new JPanel();
		f.getContentPane().add(panel);
		panel.setLayout(null);
		displayBasket(id);
		
		JLabel lblNewLabel = new JLabel("마이 페이지");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 40, 226, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("현재 금액 :");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(120, 155, 95, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("충전 금액 :");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(120, 205, 95, 25);
		panel.add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 14));
		t1.setBounds(216, 155, 226, 25);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 14));
		t2.setColumns(10);
		t2.setBounds(216, 205, 226, 25);
		panel.add(t2);
		
		JButton btnNewButton = new JButton("충전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wallet = Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText());
				MemberDAO dao = new MemberDAO();
				dao.updateWallet(id, wallet);     // 아이디
				JOptionPane.showMessageDialog(null, "충전 완료");
				displayWallet(id);
				t2.setText("");
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(477, 200, 117, 34);
		panel.add(btnNewButton);
		
		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.PLAIN, 14));
		t3.setColumns(10);
		t3.setBounds(640, 605, 226, 25);
		panel.add(t3);
		
		JButton btnNewButton_1 = new JButton("구매");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 구매페이지 이동 기능 필요
				BasketPageUI basketPage = new BasketPageUI();
				try {
					basketPage.open(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f.dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(900, 600, 117, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String basketBook = t3.getText();
				BasketDAO dao = new BasketDAO();
				dao.deleteBasket(basketBook, id);     // 아이디
				JOptionPane.showMessageDialog(null, "삭제 완료");
				panel.remove(scrollPane);  // 모델 객체 사용해도 됨
				panel.repaint();
				displayBasket(id);     // 아이디
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(1055, 600, 117, 34);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("뒤로가기");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPageUI mainPage = new MainPageUI();
				mainPage.open(id);
				f.dispose();
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setBounds(1030, 53, 117, 34);
		panel.add(btnNewButton_3);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		displayWallet(id);
	}

	private static void displayWallet(String id) {
		MemberDAO dao = new MemberDAO();
		int wallet = dao.myWallet(id);     // 아이디
		t1.setText(String.valueOf(wallet));
	}
	
	private static void displayBasket(String id) {
		head = new String[] { "책 번호", "책 이름", "저자", "출간일", "가격" };
		BasketDAO dao = new BasketDAO();
		ArrayList<BookVO> list = dao.list(id);     // 아이디

		data = new String[list.size()][5];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 5; j++) {
				data[i][0] = list.get(i).getBookId();
				data[i][1] = list.get(i).getBookName();
				data[i][2] = list.get(i).getBookWriter();
				data[i][3] = list.get(i).getBookDate();
				data[i][4] = String.valueOf(list.get(i).getBookPrice());
			}
		}
		table = new JTable(data, head);
		table.setPreferredScrollableViewportSize(new Dimension(1100, 600));
		
		table.setFillsViewportHeight(true);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 326, 1160, 249);
		panel.add(scrollPane);
		panel.updateUI();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = table.getSelectedRow();

				int colNo = table.getSelectedColumn();
				
				if (rowNo < 0) {
					return;
				}

				Object bookId = table.getModel().getValueAt(rowNo, 0);
				t3.setText((String) bookId);
			}
		});
	}
}