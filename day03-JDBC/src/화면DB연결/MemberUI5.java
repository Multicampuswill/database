package 화면DB연결;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.ws.handler.MessageContext.Scope;

import 자바DB연결.MemberDAO3;

public class MemberUI5 {

	public static void main(String[] args) {
		// 프로그램 시작하자 마자 db에서 데이터를 가지고 와서
		// 화면을 만들어주고 싶음.
		JFrame f = new JFrame();
		f.setSize(500, 700);
		JPanel p = new JPanel();
		
		MemberDAO3 dao = new MemberDAO3();
		ArrayList<MemberVO> list = dao.list(); // ArrayList<MemberVO>
		
		String[] header = {"아이디", "패스워드", "이름", "전화번호"};
		String[][] all = new String[list.size()][4];
		
		if (list.size() == 0) {
			System.out.println("검색결과 없음. ");
		} else {
			System.out.println("검색결과는 전체 " + list.size() + "개 입니다.");
			for (int i = 0; i < all.length; i++) { //13개의 가방,13개의 행  
				all[i][0] = list.get(i).getId();
				all[i][1] = list.get(i).getPw();
				all[i][2] = list.get(i).getName();
				all[i][3] = list.get(i).getTel();
			}
		}//else  
		
		String[][] all2 = new String[list.size()][4];
		
		if (list.size() == 0) {
			System.out.println("검색결과 없음. ");
		} else {
			System.out.println("검색결과는 전체 " + list.size() + "개 입니다.");
			for (int i = 0; i < all.length; i++) { //13개의 가방,13개의 행  
				all2[i][0] = list.get(i).getId() + 1;
				all2[i][1] = list.get(i).getPw() + 1;
				all2[i][2] = list.get(i).getName() + 1;
				all2[i][3] = list.get(i).getTel() + 1;
			}
		}//else  
		
		JButton b = new JButton("테이블 리프레쉬");
		b.setFont(new Font("궁서", 2, 30));
		JTable table = new JTable(all, header);
		JScrollPane scroll = new JScrollPane(table);
		
		//f.setLayout(new FlowLayout());
		f.add(p, BorderLayout.CENTER);
		p.add(b);
		p.add(scroll);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.remove(scroll);
				JTable table2 = new JTable(all2, header);
				JScrollPane scroll2 = new JScrollPane(table2);
				p.add(scroll2);
				p.updateUI();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				table.getModel().setValueAt("win", 0, 0);
				table.repaint();
			}
		});
		f.setVisible(true);
	}//main
}
