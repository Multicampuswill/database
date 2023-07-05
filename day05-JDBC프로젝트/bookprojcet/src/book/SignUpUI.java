package book;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpUI {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;

	public static void open() {
		JFrame	f = new JFrame();
		f.setSize(1200, 700);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 40));
		lblNewLabel.setBounds(449, 26, 449, 172);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID    :");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1.setBounds(275, 172, 204, 93);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PWD    :");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(240, 381, 204, 93);
		f.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(449, 191, 325, 62);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(449, 299, 325, 62);
		f.getContentPane().add(t2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NAME    :");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(230, 278, 204, 93);
		f.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("PWD \uD655\uC778   :");
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1_1_2.setBounds(190, 494, 204, 93);
		f.getContentPane().add(lblNewLabel_1_1_2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(449, 400, 325, 62);
		f.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(449, 513, 325, 62);
		f.getContentPane().add(t4);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();	
				MemberDAO dao = new MemberDAO();
				MemberVO bag = new MemberVO();
				bag.setId(id);
				int result = dao.signup(bag);
				
				if (result==1) {
					JOptionPane.showMessageDialog(f, "사용 불가능한 ID입니다.");
					t1.setText(null);
				} else JOptionPane.showMessageDialog(f, "사용 가능한 ID입니다.");
			}
		});
		btnNewButton.setBounds(834, 200, 143, 42);
		f.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = t1.getText();
				String name = t2.getText();
				String pwd = t3.getText();
				String pwd2 = t4.getText();
				
				MemberDAO dao2 = new MemberDAO();
				MemberVO bag2 = new MemberVO();
				bag2.setId(id);
				int result = dao2.signup(bag2);
				
				if (pwd.equals(pwd2) && result == 0) {
					MemberDAO dao = new MemberDAO();
					MemberVO bag = new MemberVO();
					bag.setId(id);
					bag.setPwd(pwd);
					bag.setName(name);
					dao.insert(bag);
					JOptionPane.showMessageDialog(f, "회원가입이 완료되었습니다. \n 로그인 후 이용해주세요.");
					f.setVisible(false);
				} else if (!pwd.equals(pwd2) && result == 0) {
					JOptionPane.showMessageDialog(f, "비밀번호가 일치하지 않습니다.");
					t4.setText(null);
				} else if (pwd.equals(pwd2) && result == 1 ) {
					JOptionPane.showMessageDialog(f, "ID 중복체크 진행해주세요.");
					t1.setText(null);
				} else {
					JOptionPane.showMessageDialog(f, "ID 중복체크 진행해주세요.");
					t1.setText(null);
					JOptionPane.showMessageDialog(f, "비밀번호가 일치하지 않습니다.");
					t4.setText(null);
				}
			}
		});
		btnSignUp.setBounds(449, 597, 143, 42);
		f.getContentPane().add(btnSignUp);
		f.setVisible(true);

	}

	
}
