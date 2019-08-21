package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import copy_.StuMgmSystemUI2;


public class MainScreenUI implements ActionListener {
//  Like this yo      @@@@@@@@@@@@@@@@@@@@@@
	JFrame jf;
	LectureUI Lecture_class = null;
	InbodyUI Inbody_class =null;
//  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	JPanel p_sc_total, p_sc_top, p_sc_infobox,p_sc_btnbox,p_sc_uno,p_sc_time,p_sc_picture,p_sc_l_sc_locker,p_sc_sysdate;
	JButton b_sc_lecture, b_sc_inbody, b_sc_personal,b_sc_chatting;
	JLabel l_sc_topimgbox, l_sc_uno, l_sc_time, l_sc_ubox, l_sc_locker,l_sc_sysdate;
	JTextArea jta_sc_uno, jta_sc_limit, jta_sc_locker; 
	ImageIcon ic_sc_timg, ic_sc_uimg;
	
	
	public static final int LECTURE = 3; 
	public static final int DIET = 4; 
	public static final int INBODY= 5; 
	
	static int status =2;

		//  Like this yo      @@@@@@@@@@@@@@@@@@@@@@
	//constructor
	public MainScreenUI(JFrame jf) {
		StrartUI.status = StrartUI.MAIN;
		System.out.println("MainStatus = "+StrartUI.status);
		this.jf = jf;
		//       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//1.메인 화면 구성
		p_sc_total = new JPanel();
		p_sc_total.setLayout(new BorderLayout());
		p_sc_top = new JPanel();
		p_sc_infobox = new JPanel(new GridLayout(2,2));
		p_sc_btnbox = new JPanel(new GridLayout(4,1));
		p_sc_uno = new JPanel();
		p_sc_time = new JPanel();
		p_sc_picture = new JPanel();
		p_sc_l_sc_locker = new JPanel();
		p_sc_sysdate = new JPanel();


		b_sc_lecture = new JButton("수강");
		b_sc_lecture.setFont(new Font("돋움", Font.BOLD, 40));
		b_sc_inbody = new JButton("인바디");
		b_sc_inbody.setFont(new Font("돋움", Font.BOLD, 40));
		b_sc_personal = new JButton("개인일지");
		b_sc_personal.setFont(new Font("돋움", Font.BOLD, 40));
		b_sc_chatting = new JButton("채팅");
		b_sc_chatting.setFont(new Font("돋움", Font.BOLD, 40));


		ic_sc_timg = new ImageIcon("image/top.png");
		l_sc_topimgbox = new JLabel(ic_sc_timg);


		ic_sc_uimg = new ImageIcon("image/client.png");
		l_sc_ubox = new JLabel(ic_sc_uimg);


		l_sc_uno = new JLabel("회원번호");
		l_sc_uno.setFont(new Font("돋움", Font.BOLD, 30));
		jta_sc_uno = new JTextArea(8,25);

		l_sc_time = new JLabel("헬스장 이용기간");
		l_sc_time.setFont(new Font("돋움", Font.BOLD, 30));
		jta_sc_limit = new JTextArea(8,25);


		l_sc_locker = new JLabel("락커 이용기간");
		l_sc_locker.setFont(new Font("돋움", Font.BOLD, 30));
		jta_sc_locker = new JTextArea(8,25);

		l_sc_sysdate = new JLabel("2019-08-20");

		p_sc_top.add(l_sc_topimgbox);
		p_sc_infobox.add(p_sc_uno); p_sc_infobox.add(p_sc_time); p_sc_infobox.add(p_sc_picture); p_sc_infobox.add(p_sc_l_sc_locker);
		p_sc_btnbox.add(b_sc_lecture);
		p_sc_btnbox.add(b_sc_inbody);
		p_sc_btnbox.add(b_sc_personal);
		p_sc_btnbox.add(b_sc_chatting);
		p_sc_btnbox.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
		b_sc_lecture.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		b_sc_inbody.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		b_sc_personal.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		b_sc_chatting.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));


		p_sc_uno.add(l_sc_uno); p_sc_uno.add(jta_sc_uno);
		p_sc_uno.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p_sc_time.add(l_sc_time); p_sc_time.add(jta_sc_limit);
		p_sc_time.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		p_sc_picture.add(l_sc_ubox);
		p_sc_picture.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		p_sc_l_sc_locker.add(l_sc_locker); p_sc_l_sc_locker.add(jta_sc_locker);
		p_sc_l_sc_locker.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		p_sc_total.add(p_sc_top,BorderLayout.NORTH);
		p_sc_total.add(p_sc_infobox, BorderLayout.CENTER);
		p_sc_total.add(p_sc_btnbox,BorderLayout.EAST);
		p_sc_total.add(p_sc_sysdate,BorderLayout.SOUTH);

		jf.getContentPane().add(p_sc_total,BorderLayout.CENTER);

		p_sc_total.setSize(1000,600);
		p_sc_total.setVisible(true);
		
//		//2. 이벤트 핸들러 정의
		b_sc_lecture.addActionListener(this);
		b_sc_inbody.addActionListener(this);
		b_sc_personal.addActionListener(this);
		b_sc_chatting.addActionListener(this);

	}
	
	//  Like this yo      @@@@@@@@@@@@@@@@@@@@@@
	public void turnoff() {
		System.out.println("main 화면 turnoff");
		p_sc_total.setVisible(false);
	}
	//       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
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
		case 2 :
			turnoff();
			break;
		case 3 :
			Lecture_class.turnoff();
			break;
		case 4 :
			Inbody_class.turnoff();
			break;
			default : 
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == b_sc_lecture) {
			System.out.println("수강 클릭");
			switchingPanel(getStatus());
			Lecture_class = new LectureUI(jf);
		}else if(obj == b_sc_inbody) {
			System.out.println("인바디 클릭");
			switchingPanel(getStatus());
			Inbody_class = new InbodyUI(jf);
		}else if(obj == b_sc_personal) {
			System.out.println("개인일지");
			new DietUI();
		}else if(obj == b_sc_chatting) {
			System.out.println("채팅 클릭");
	//		switchingPanel(getStatus());
	//		StartUI();
		}
		
	}
	
	
}