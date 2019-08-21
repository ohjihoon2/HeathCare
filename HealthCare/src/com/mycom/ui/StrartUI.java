package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import copy_.Regist;
import copy_.StuMgmSystemUI2;

public class StrartUI extends JFrame implements ActionListener{
	
	/**
	 * 메인페이지
	 */
	MainScreenUI main_calss = null;
	DietUI diet_class = null;
	//Field
	public static final int LOGIN = 0;
	public static final int REGIST = 1;
	public static final int MAIN = 2;
	public static final int LECTURE = 3; 
	public static final int DIET = 4; 
	public static final int INBODY= 5; 
	
	static int status =0;
	
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
    public StrartUI() {
    	jf = new JFrame();
		setStatus(LOGIN);
		System.out.println("logStatus = "+status);
		//1. 화면구성
		// 패널 초기화 
		
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
//	public void LoginUI(JFrame jf){
//		jf = new JFrame();
//		this.jf = jf;
//		setStatus(LOGIN);
//		System.out.println("logStatus = "+status);
//		//1. 화면구성
//		// 패널 초기화 
//		
//		p_LogMain = new JPanel(new GridLayout(3,1));
//		
//		p_LogLogin = new JPanel();
//		p_LogBtn = new JPanel();
//		p_LogNum = new JPanel(); 
//		
//		b_Log1 = new JButton("1"); 
//		b_Log2 = new JButton("2"); 
//		b_Log3 = new JButton("3");
//		b_Log4 = new JButton("4");
//		b_Log5 = new JButton("5");
//		b_Log6 = new JButton("6");
//		b_Log7 = new JButton("7");
//		b_Log8 = new JButton("8");
//		b_Log9 = new JButton("9");
//
//		b_LogLogin = new JButton("로그인");
//		b_LogCreate = new JButton("회원가입");
//
////		p_LogMain.setLayout(null);
//
//		l_Logid = new JLabel("ID : ");
//		tf_LogId = new JTextField(20);
//		
//		p_LogLogin.add(l_Logid);
//		p_LogLogin.add(tf_LogId);
//		
//		p_LogNum.setLayout(new GridLayout(4,3));
//
//		p_LogNum.add(b_Log1);
//		p_LogNum.add(b_Log2);
//		p_LogNum.add(b_Log3);
//		p_LogNum.add(b_Log4);
//		p_LogNum.add(b_Log5);
//		p_LogNum.add(b_Log6);
//		p_LogNum.add(b_Log7);
//		p_LogNum.add(b_Log8);
//		p_LogNum.add(b_Log9);
//		
//		p_LogBtn.add(b_LogLogin);
//		p_LogBtn.add(b_LogCreate);
//		
//		p_LogMain.add(p_LogLogin);		
//		p_LogMain.add(p_LogNum);		
//		p_LogMain.add(p_LogBtn);		
//		
////		jf.getContentPane().add(title, BorderLayout.NORTH);
////		jf.getContentPane().add(p_RegBtn, BorderLayout.WEST);
////		jf.getContentPane().add(msgPanel, BorderLayout.CENTER);
//		jf.getContentPane().add(p_LogMain, BorderLayout.CENTER);
//		
//		jf.setSize(1000,600);
////		p_LogNum.setSize(600, 400);
////		p_LogNum.setBounds(200,200,350,200);
//		jf.setLocation(500	, 20);
//		jf.setVisible(true);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		//2. 이벤트 핸들러 정의
//		b_LogLogin.addActionListener(this);
//		b_LogCreate.addActionListener(this);
//	}
	
	public void LoginUI() {
		setStatus(LOGIN);
		System.out.println("logStatus = "+status);
		//1. 화면구성
		// 패널 초기화 

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

		p_LogMain.setSize(1000,600);
		p_LogMain.setVisible(true);

		jf.getContentPane().add(p_LogMain, BorderLayout.CENTER);

		//2. 이벤트 핸들러 정의
		b_LogLogin.addActionListener(this);
		b_LogCreate.addActionListener(this);
	}
	//Method

	
	
	//Method
	
	/**
	 * 화면 status setter, getter
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	/**
	 * 화면 Panel 스위칭 메소드
	 */
	public void switchingPanel(int status) {
		System.out.println("status=" + status);	
		switch(status) {
		case 0 : 
			p_LogMain.setVisible(false);
			break;
		case 1 :
			p_RegMain.setVisible(false);
			break;
		case 2 :
			main_calss.turnoff();
			break;
		default : 
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == b_LogCreate) {
			System.out.println("회원가입 클릭");
			switchingPanel(getStatus());
			new RegistUI(jf);
		}else if (obj == b_LogLogin) {
			switchingPanel(getStatus());
			System.out.println("로그인 클릭");
			new MainScreenUI(jf);
			System.out.println("main 생성");
		}
	}
}











