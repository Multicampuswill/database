package book;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminPageUI {
	static List list;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void open() {
		JFrame f = new JFrame();
		f.setSize(1200, 700);
		f.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("도서 관리 페이지");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblNewLabel.setBounds(36, 34, 330, 77);
		f.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 144, 591, 440);
		f.getContentPane().add(scrollPane_1);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "책 번호", "책 이름", "저자", "출간일", "가격" }));
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();

		JLabel lblNewLabel_1 = new JLabel("책 번호 :");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(680, 144, 145, 55);
		f.getContentPane().add(lblNewLabel_1);

		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.LEFT);
		t1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t1.setToolTipText("");
		t1.setBounds(837, 144, 276, 58);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("책 이름 :");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(680, 223, 145, 55);
		f.getContentPane().add(lblNewLabel_1_1);

		t2 = new JTextField();
		t2.setToolTipText("");
		t2.setHorizontalAlignment(SwingConstants.LEFT);
		t2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t2.setColumns(10);
		t2.setBounds(837, 223, 276, 58);
		f.getContentPane().add(t2);

		JLabel lblNewLabel_1_2 = new JLabel("저자 :");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(680, 303, 145, 55);
		f.getContentPane().add(lblNewLabel_1_2);

		t3 = new JTextField();
		t3.setToolTipText("");
		t3.setHorizontalAlignment(SwingConstants.LEFT);
		t3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t3.setColumns(10);
		t3.setBounds(837, 303, 276, 58);
		f.getContentPane().add(t3);

		JLabel lblNewLabel_1_3 = new JLabel("출간일 :");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(680, 383, 145, 55);
		f.getContentPane().add(lblNewLabel_1_3);

		t4 = new JTextField();
		t4.setToolTipText("");
		t4.setHorizontalAlignment(SwingConstants.LEFT);
		t4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t4.setColumns(10);
		t4.setBounds(837, 383, 276, 58);
		f.getContentPane().add(t4);

		JLabel lblNewLabel_1_4 = new JLabel("가격 :");
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(680, 461, 145, 55);
		f.getContentPane().add(lblNewLabel_1_4);

		t5 = new JTextField();
		t5.setToolTipText("");
		t5.setHorizontalAlignment(SwingConstants.LEFT);
		t5.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t5.setColumns(10);
		t5.setBounds(837, 461, 276, 58);
		f.getContentPane().add(t5);
		displayAll(model);

		JButton btnNewButton = new JButton("도서 추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookId = t1.getText();
				String bookName = t2.getText();
				String bookWriter = t3.getText();
				String bookDate = t4.getText();
				int bookPrice = Integer.parseInt(t5.getText());
				
				BookDAO dao = new BookDAO();
				
				try {
					dao.insert(bookId, bookName, bookWriter, bookDate, bookPrice);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				Eraser();
				model.setRowCount(0);
				displayAll(model);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(680, 529, 124, 55);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("도서 수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookId = t1.getText();
				String bookName = t2.getText();
				String bookWriter = t3.getText();
				String bookDate = t4.getText();
				int bookPrice = Integer.parseInt(t5.getText());

				BookDAO dao = new BookDAO();
				try {
					dao.update(bookId, bookName, bookWriter, bookDate, bookPrice);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				Eraser();
				model.setRowCount(0);
				displayAll(model);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(837, 529, 124, 55);
		f.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("도서 삭제");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookId = t1.getText();

				BookDAO dao = new BookDAO();
				try {
					dao.delete(bookId);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				Eraser();
				model.setRowCount(0);
				displayAll(model);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(989, 529, 124, 55);
		f.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("뒤로가기");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInUI signIn = new SignInUI();
				signIn.main(null);
				f.dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.setBounds(989, 56, 124, 55);
		f.getContentPane().add(btnNewButton_1_1);

		f.setVisible(true);
	}

	public static void Eraser() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
	}

	private static void displayAll(DefaultTableModel model) {
		BookDAO dao = new BookDAO();
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
	
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextField t5;
	private static JTable table_1;
}
