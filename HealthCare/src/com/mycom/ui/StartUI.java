package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartUI extends JFrame implements ActionListener{
	
	/**
	 * 메인페이지
	 */
	MainScreenUI main_calss = null;
	DietUI diet_class = null;
	
	//Field
	boolean result = false;
	
	//로그인 Field
	JFrame jf;
	JPanel p_LogMain, p_LogLogin , p_LogBtn, p_LogNum; 
	JLabel l_Logid;
	JTextField tf_LogId;
	JButton b_LogLogin, b_LogCreate, b_Log1, b_Log2, b_Log3, b_Log4, b_Log5, b_Log6, b_Log7, b_Log8, b_Log9;
	
	
	//회원가입 Field
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegAddress, l_RegContact, l_RegRole, l_RegCreated_date, l_RegBirth, l_RegTerm, l_RegEvent, l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegAddress, tf_RegContact, tf_RegRole, tf_RegCreated_date, tf_RegBirth, tf_RegTerm, tf_RegEvent, tf_RegStart_date, tf_RegEnd_date;
	JButton b_RegNext, b_RegCancel;
	
	/**
	 * 로그인 
	 */
	//Constructor
    public StartUI() {   	
		//1. 화면구성
		// 패널 초기화 
    	jf = new JFrame();
		p_LogMain = new JPanel(new GridLayout(3,1));
		
		p_LogLogin = new JPanel();
		p_LogBtn = new JPanel();
		p_LogNum = new JPanel(); 
		
		b_Log1 = new JButton("1"); 
		b_Log2 = new JButton("2"); 
		b_Log3 = new JButton("3");
		b_Log4 = new JButton("4");
		b_Log5 = new JButton("5");
		b_Log6 = new JButton("6");
		b_Log7 = new JButton("7");
		b_Log8 = new JButton("8");
		b_Log9 = new JButton("9");

		b_LogLogin = new JButton("로그인");
		b_LogCreate = new JButton("회원가입");

//		p_LogMain.setLayout(null);

		l_Logid = new JLabel("ID : ");
		tf_LogId = new JTextField(20);
		
		p_LogLogin.add(l_Logid);
		p_LogLogin.add(tf_LogId);
		
		p_LogNum.setLayout(new GridLayout(4,3));

		p_LogNum.add(b_Log1);
		p_LogNum.add(b_Log2);
		p_LogNum.add(b_Log3);
		p_LogNum.add(b_Log4);
		p_LogNum.add(b_Log5);
		p_LogNum.add(b_Log6);
		p_LogNum.add(b_Log7);
		p_LogNum.add(b_Log8);
		p_LogNum.add(b_Log9);
		
		p_LogBtn.add(b_LogLogin);
		p_LogBtn.add(b_LogCreate);
		
		p_LogMain.add(p_LogLogin);		
		p_LogMain.add(p_LogNum);		
		p_LogMain.add(p_LogBtn);		
		
//		jf.getContentPane().add(title, BorderLayout.NORTH);
//		jf.getContentPane().add(p_RegBtn, BorderLayout.WEST);
//		jf.getContentPane().add(msgPanel, BorderLayout.CENTER);
		jf.getContentPane().add(p_LogMain, BorderLayout.CENTER);
		
		jf.setSize(1000,600);
//		p_LogNum.setSize(600, 400);
//		p_LogNum.setBounds(200,200,350,200);
		jf.setLocation(500	, 20);
		jf.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//2. 이벤트 핸들러 정의
		b_LogLogin.addActionListener(this);
		b_LogCreate.addActionListener(this);
    }
      	
	//Method	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == b_LogCreate) {
			p_LogMain.setVisible(false); 
			new RegistUI(this);
		}else if (obj == b_LogLogin) {
			p_LogMain.setVisible(false);
			new MainScreenUI(this);
		}
	}
}











