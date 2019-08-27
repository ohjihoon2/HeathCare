package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistUI extends JFrame implements ActionListener{
	StartUI startui;

	//Field
	JFrame jf;
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegAddress, l_RegContact, l_RegRole, l_RegCreated_date, l_RegBirth, l_RegTerm, l_RegEvent, l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegAddress, tf_RegContact, tf_RegRole, tf_RegCreated_date, tf_RegBirth, tf_RegTerm, tf_RegEvent, tf_RegStart_date, tf_RegEnd_date;
	JButton b_RegSave, b_RegCancel, b_RegExit;
	
	//Constructor
	public RegistUI(StartUI startui){	
		//1. 화면구성
		// 패널 초기화 
		this.startui = startui;
		
		p_RegMain = new JPanel(new GridLayout(3,1));
		
		p_RegTitle = new JPanel();
		p_RegBoard = new JPanel(new GridLayout(10,2));
		p_RegBtn = new JPanel();
		
		b_RegSave = new JButton("완료");
		b_RegCancel = new JButton("다시쓰기");
		b_RegExit = new JButton("나가기");
		
		l_RegTitle = new JLabel("회원가입");
		
		l_RegName = new JLabel("회원명");
		l_RegAddress = new JLabel("주소");
		l_RegContact = new JLabel("연락처");
		l_RegRole = new JLabel("구분");
		l_RegCreated_date = new JLabel("회원가입일");
		l_RegBirth = new JLabel("생년월일");
		l_RegTerm = new JLabel("신청기간");
		l_RegEvent = new JLabel("종목");
		l_RegStart_date = new JLabel("시작일");
		l_RegEnd_date = new JLabel("마지막일");
		
		
		tf_RegName = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegContact = new JTextField(10);
		tf_RegRole = new JTextField(10);
		tf_RegCreated_date = new JTextField(10);
		tf_RegBirth = new JTextField(10);
		tf_RegTerm = new JTextField(10);
		tf_RegEvent = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		l_RegTitle.setHorizontalAlignment(0);
		p_RegTitle.add(l_RegTitle);
		
		p_RegBoard.add(l_RegName); p_RegBoard.add(tf_RegName);
		p_RegBoard.add(l_RegAddress); p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(l_RegContact); p_RegBoard.add(tf_RegContact);
		p_RegBoard.add(l_RegRole); p_RegBoard.add(tf_RegRole);
		p_RegBoard.add(l_RegCreated_date); p_RegBoard.add(tf_RegCreated_date);
		p_RegBoard.add(l_RegBirth); p_RegBoard.add(tf_RegBirth);
		p_RegBoard.add(l_RegTerm); p_RegBoard.add(tf_RegTerm);
		p_RegBoard.add(l_RegEvent); p_RegBoard.add(tf_RegEvent);
		p_RegBoard.add(l_RegStart_date); p_RegBoard.add(tf_RegStart_date);
		p_RegBoard.add(l_RegEnd_date); p_RegBoard.add(tf_RegEnd_date);
		
		p_RegBtn.add(b_RegSave);
		p_RegBtn.add(b_RegCancel);
		p_RegBtn.add(b_RegExit);
		
		
		p_RegMain.add(p_RegTitle);		
		p_RegMain.add(p_RegBoard);		
		p_RegMain.add(p_RegBtn);		
		
//			setTitle("회원가입");
//			getContentPane().add(p_RegMain, BorderLayout.CENTER);
		p_RegMain.setSize(1000,600);
		p_RegMain.setVisible(true);
//			setBounds(200,200,350,200);
//			setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startui.jf.getContentPane().add(p_RegMain, BorderLayout.CENTER);
		
		//2. 이벤트 핸들러 정의
		b_RegSave.addActionListener(this);
		b_RegCancel.addActionListener(this);
		b_RegExit.addActionListener(this);
	}

	//Method
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == b_RegSave) {	//회원가입 완료
			//회원정보 --> VO 생성 --> DAO ---> DB 
			
		}else if(obj == b_RegCancel) { //다시쓰기
			//필드 초기화
		}else if(obj == b_RegExit) {  //나가기
			//회원가입 - 다음 버튼		
			p_RegMain.setVisible(false);
			startui.p_LogMain.setVisible(true);
		}
		
	}
}











