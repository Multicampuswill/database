package book;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPageUI {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void open(String id) {
		JFrame f = new JFrame();
		f.setSize(1200, 700);
		f.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("메인 페이지");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblNewLabel.setBounds(36, 34, 330, 77);
		f.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("도서 판매 페이지");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellPageUI sellPage = new SellPageUI();
				sellPage.open(id);
				f.dispose();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 24));
		btnNewButton.setBounds(216, 158, 257, 61);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("마이 페이지");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPageUI myPage = new MyPageUI();
				myPage.open(id);
				f.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 24));
		btnNewButton_1.setBounds(689, 158, 257, 61);
		f.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("구매 페이지");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasketPageUI basketPage = new BasketPageUI();
				try {
					basketPage.open(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 24));
		btnNewButton_1_1.setBounds(216, 376, 257, 61);
		f.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("로그아웃");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignInUI signIn = new SignInUI();
				signIn.main(null);
				f.dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Dialog", Font.BOLD, 24));
		btnNewButton_1_1_1.setBounds(449, 560, 257, 61);
		f.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("정산 페이지");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuylistPageUI buylistPage = new BuylistPageUI();
				buylistPage.open(id);
				f.dispose();
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Dialog", Font.BOLD, 24));
		btnNewButton_1_1_2.setBounds(689, 376, 257, 61);
		f.getContentPane().add(btnNewButton_1_1_2);
		f.setVisible(true);
	}
}
