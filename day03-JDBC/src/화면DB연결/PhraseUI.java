package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class PhraseUI {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setTitle("글귀 게시판");
		f.setSize(350, 800);

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		JButton top = new JButton("글귀 게시판");

		JLabel l1 = new JLabel("게시판 번호");
		JLabel l2 = new JLabel("회원ID");
		JLabel l3 = new JLabel("게시판 제목");
		JLabel l4 = new JLabel("책ID");
		JLabel l5 = new JLabel("게시판 내용");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);

		JButton b1 = new JButton("게시판 작성");
		JButton b2 = new JButton("게시판 수정");
		JButton b3 = new JButton("게시판 삭제");
		JButton b4 = new JButton("게시판 검색");

		f.getContentPane().setBackground(Color.green);

		Font font = new Font("고딕", Font.BOLD, 30);
		top.setFont(font);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(f, "게시판 번호는 필수 입력 사항입니다.");
					
				}else {
					int no = Integer.parseInt(t1.getText());
					String id = t2.getText();
					String title = t3.getText();
					int book = Integer.parseInt(t4.getText());
					String content = t5.getText();


//					PhraseDAO dao = new PhraseDAO();
//					PhraseVO bag = new PhraseVO();
	//
//					bag.setNo(no);
//					bag.setId(id);
//					bag.setTitle(title);
//					bag.setBook(book);
//					bag.setContent(content);
	//
//					int result = dao.insert(bag);
	//
//					if (result == 1) {
//						JOptionPane.showMessageDialog(f, "게시글 작성 성공");
//					} else {
//						JOptionPane.showMessageDialog(f, "게시글 작성 실패. 재입력해주세요.");
//					}
//					t1.setText("");
//					t2.setText("");
//					t3.setText("");
//					t4.setText("");
//					t5.setText("");
				}
			
			} // action
		});// b1



		f.add(top);
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(l5);
		f.add(t5);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}