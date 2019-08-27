package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mycom.dao.MainDAO;
import com.mycom.vo.MainVO;



public class MainScreenUI implements ActionListener {
	StartUI startui;
	
	LectureUI Lecture_class = null;
	InbodyUI Inbody_class =null;
	
	JPanel p_sc_total, p_sc_top, p_sc_infobox,p_sc_btnbox,p_sc_uno,p_sc_time,p_sc_picture,p_sc_l_sc_locker,p_sc_sysdate;
	JButton b_sc_lecture, b_sc_inbody, b_sc_personal,b_sc_chatting;
	JLabel l_sc_topimgbox, l_sc_uno, l_sc_time, l_sc_ubox, l_sc_locker,l_sc_sysdate;
	JTextArea jta_sc_uno, jta_sc_limit, jta_sc_limit2 , jta_sc_locker; 
	ImageIcon ic_sc_timg, ic_sc_uimg;
	
	//constructor
	public MainScreenUI(StartUI startui) {
		//1.���� ȭ�� ����
		this.startui = startui;
		
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


		b_sc_lecture = new JButton("����");
		b_sc_lecture.setFont(new Font("����", Font.BOLD, 40));
		b_sc_inbody = new JButton("�ιٵ�");
		b_sc_inbody.setFont(new Font("����", Font.BOLD, 40));
		b_sc_personal = new JButton("��������");
		b_sc_personal.setFont(new Font("����", Font.BOLD, 40));
		b_sc_chatting = new JButton("ä��");
		b_sc_chatting.setFont(new Font("����", Font.BOLD, 40));


		ic_sc_timg = new ImageIcon("image/top.png");
		l_sc_topimgbox = new JLabel(ic_sc_timg);


		ic_sc_uimg = new ImageIcon("image/client.png");
		l_sc_ubox = new JLabel(ic_sc_uimg);


		l_sc_uno = new JLabel("ȸ����ȣ");
		l_sc_uno.setFont(new Font("����", Font.BOLD, 30));
		jta_sc_uno = new JTextArea(8,25);
		jta_sc_uno.setFont(new Font("����", Font.BOLD, 20));

		l_sc_time = new JLabel("�ｺ�� �̿�Ⱓ");
		l_sc_time.setFont(new Font("����", Font.BOLD, 30));
		jta_sc_limit = new JTextArea(4,25);
		jta_sc_limit.setFont(new Font("����", Font.BOLD, 15));
		jta_sc_limit2 = new JTextArea(4,25);
		jta_sc_limit2.setFont(new Font("����", Font.BOLD, 15));


		l_sc_locker = new JLabel("��������");
		l_sc_locker.setFont(new Font("����", Font.BOLD, 30));
		jta_sc_locker = new JTextArea(8,25); //�������� or �ｺ 
		jta_sc_locker.setFont(new Font("����", Font.BOLD, 15));


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
		p_sc_time.add(l_sc_time); p_sc_time.add(jta_sc_limit); p_sc_time.add(jta_sc_limit2);
		p_sc_time.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		p_sc_picture.add(l_sc_ubox);
		p_sc_picture.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		p_sc_l_sc_locker.add(l_sc_locker); p_sc_l_sc_locker.add(jta_sc_locker);
		p_sc_l_sc_locker.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		p_sc_total.add(p_sc_top,BorderLayout.NORTH);
		p_sc_total.add(p_sc_infobox, BorderLayout.CENTER);
		p_sc_total.add(p_sc_btnbox,BorderLayout.EAST);
		p_sc_total.add(p_sc_sysdate,BorderLayout.SOUTH);
		
		startui.jf.getContentPane().add(p_sc_total,BorderLayout.CENTER);

		p_sc_total.setSize(1000,600);
		p_sc_total.setVisible(true);
		
		
//		//2. �̺�Ʈ �ڵ鷯 ����
		b_sc_lecture.addActionListener(this);
		b_sc_inbody.addActionListener(this);
		b_sc_personal.addActionListener(this);
		b_sc_chatting.addActionListener(this);
	
		//ȭ�鿡 ȸ������ ����ֱ�
		MainSystem system = new MainSystem();		
		MainVO vo = system.getListMainVO(startui.tf_LogId.getText().trim());
		
		if(vo != null) {
			jta_sc_uno.append(String.valueOf(vo.getCno()));
			jta_sc_limit.append(vo.getStart_date());
			jta_sc_limit2.append(vo.getEnd_date());
			if( vo.getEvent_name() != null && vo.getEvent_name() != "")
				jta_sc_locker.append(vo.getEvent_name());
			else 
				jta_sc_locker.append("�ｺ�常 �̿� ��");
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == b_sc_lecture) {
			p_sc_total.setVisible(false);
			new LectureUI(this, startui);
		}else if(obj == b_sc_inbody) {
			p_sc_total.setVisible(false);
			new InbodyUI(this, startui);
		}else if(obj == b_sc_personal) {
			System.out.println("��������");
			new DietUI();
		}else if(obj == b_sc_chatting) {
			System.out.println("ä�� Ŭ��");

		}
		
	}
	

	
}

class MainSystem{
	//Field
	MainDAO dao;
	
	//Constructor
	public MainSystem() {
		try {
			dao = new MainDAO();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//ȭ�� ���� ����
	public MainVO getListMainVO(String seq) {
		MainVO mvo = dao.getListMainVO(seq);
		
		return mvo;
	}
	
}