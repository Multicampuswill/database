package book;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SignInUI {
	private static JTextField t1;
	private static JTextField t2;

	public static void main(String[] args) {
		JFrame	f = new JFrame();
		f.setSize(1200, 700);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uD310\uB9E4");
		lblNewLabel.setBounds(472, 27, 449, 172);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 40));
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID      :");
		lblNewLabel_1.setBounds(311, 227, 204, 93);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PWD    :");
		lblNewLabel_1_1.setBounds(295, 358, 204, 93);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		f.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(596, 246, 325, 62);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		JPasswordField t2 = new JPasswordField();
		t2.setBounds(596, 377, 325, 62);
		t2.setColumns(10);
		f.getContentPane().add(t2);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(215, 521, 325, 62);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = t1.getText();
				String pwd = t2.getText();
				
				//DAO의 one(id) 호출해서 검색결과 받아오기
				MemberDAO dao = new MemberDAO();
				MemberVO bag = new MemberVO();
				bag.setId(id);
				bag.setPwd(pwd);
				int result = dao.signin(bag);
				
				if (result==1) {
					JOptionPane.showMessageDialog(f, "로그인 성공");
					if (id.equals("manager")) {
						AdminPageUI adminPage = new AdminPageUI();
						adminPage.open();
						f.dispose();
					} else {
						MainPageUI mainPage = new MainPageUI();
						mainPage.open(id);
						f.dispose();
					}
				} else {JOptionPane.showMessageDialog(f, "아이디 또는 비밀번호를 잘못 입력했습니다.");
				
				t1.setText(null);
				t2.setText(null);
				}
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		f.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(596, 521, 325, 62);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpUI.open();
			}
		});
		btnSignUp.setFont(new Font("굴림", Font.BOLD, 12));
		f.getContentPane().add(btnSignUp);
		f.setVisible(true);

	}
}
