import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainUI extends JFrame implements ActionListener{
	//Field
	JPanel p_main, p_login , p_btn, jp_num; 
	JLabel lid;
	JTextField tfId;
	JButton btnLogin, btnCreate, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
	
	//Constructor
	public MainUI(){
		//1. 화면구성
		// 패널 초기화 
		
		p_main = new JPanel(new GridLayout(3,1));
		p_login = new JPanel();
		p_btn = new JPanel();
		jp_num = new JPanel(); 
		
		jb1 = new JButton("1"); 
		jb2 = new JButton("2"); 
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb5 = new JButton("5");
		jb6 = new JButton("6");
		jb7 = new JButton("7");
		jb8 = new JButton("8");
		jb9 = new JButton("9");

		btnLogin = new JButton("로그인");
		btnCreate = new JButton("회원가입");
		

		p_main.setLayout(null);

		lid = new JLabel("ID : ");
		tfId = new JTextField(20);
		
		
		p_login.add(lid);
		p_login.add(tfId);
		
		jp_num.setLayout(new GridLayout(4,3));

		jp_num.add(jb1);
		jp_num.add(jb2);
		jp_num.add(jb3);
		jp_num.add(jb4);
		jp_num.add(jb5);
		jp_num.add(jb6);
		jp_num.add(jb7);
		jp_num.add(jb8);
		jp_num.add(jb9);
		
		p_btn.add(btnLogin);
		p_btn.add(btnCreate);
		
		p_main.add(p_login);		
		p_main.add(jp_num);		
		p_main.add(p_btn);		
		
		
		getContentPane().add(p_main);
		
		setSize(1000,1000);
//		jp_num.setSize(600, 400);
		jp_num.setBounds(200,200,350,200);
		setLocation(300, 200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//2. 이벤트 핸들러 정의
		btnLogin.addActionListener(this);
		btnCreate.addActionListener(this);
	}
	
	//Method

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("회원가입")) {
			new SignUpUI();
		}
		
		
		
	}
}











