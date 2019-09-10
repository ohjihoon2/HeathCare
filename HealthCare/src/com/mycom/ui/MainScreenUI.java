package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mycom.dao.MainDAO;
import com.mycom.system.MainSystem;
import com.mycom.vo.MainVO;



public class MainScreenUI implements ActionListener {
	StartUI startui;
	MainSystem system = new MainSystem();
	MainDAO dao = new MainDAO();
	MainVO mainvo;
	
	
	LectureUI Lecture_class = null;
	InbodyUI Inbody_class =null;
	
	JPanel p_sc_total, p_sc_top, p_sc_center, p_sc_inbody, p_sc_infobox,
			p_bmi, p_fat, p_pbf, p_whr, p_weight, p_inbodytitle, p_blank,
			p_sc_btnbox,p_sc_uno,p_sc_time,p_sc_cname,p_sc_gx_name,p_sc_sysdate;
	JButton b_sc_lecture, b_sc_inbody, b_sc_personal,b_sc_chatting;
	JLabel l_sc_topimgbox, l_sc_uno, l_sc_cname, l_sc_time, l_sc_time2, l_sc_ubox, l_sc_gx_name, lb_inbodyresult, lb_info,
			l_sc_bmi, l_sc_fat, l_sc_pbf, l_sc_whr, l_sc_weight;
	JTextField jta_sc_uno, jta_sc_cname, jta_sc_limit, jta_sc_limit2, jta_sc_gx_name,
		jta_sc_bmi, jta_sc_fat, jta_sc_pbf,jta_sc_whr,jta_sc_weight;
	ImageIcon ic_sc_timg, ic_sc_uimg, ic_sc_inbodyground;
	
	//constructor
	public MainScreenUI(StartUI startui) {
		//1.¸ÞÀÎ È­¸é ±¸¼º
		this.startui = startui;
		
		p_sc_total = new JPanel();
		
		p_sc_total.setLayout(new BorderLayout());
		p_sc_top = new JPanel();
		p_sc_center = new JPanel(new GridLayout(1,2));
		p_sc_inbody = new JPanel(new GridLayout(7,1));

		p_sc_infobox = new JPanel(new GridLayout(5,1));
		p_sc_btnbox = new JPanel(new GridLayout(4,1,20,20));
		p_sc_uno = new JPanel();
		p_sc_time = new JPanel();
		p_sc_cname = new JPanel();
		p_sc_gx_name = new JPanel();
		p_sc_sysdate = new JPanel();
		p_inbodytitle = new JPanel();
		p_blank = new JPanel();

		b_sc_lecture = new JButton("¼ö°­(GX)");
		b_sc_lecture.setFont(new Font("±¼¸²", Font.BOLD, 30));
		b_sc_inbody = new JButton("ÀÎ ¹Ù µð");
		b_sc_inbody.setFont(new Font("±¼¸²", Font.BOLD, 30));
		b_sc_personal = new JButton("°³ÀÎÀÏÁö");
		b_sc_personal.setFont(new Font("±¼¸²", Font.BOLD, 30));
		b_sc_chatting = new JButton("Çï½º¿¬Àå");
		b_sc_chatting.setFont(new Font("±¼¸²", Font.BOLD, 30));
		
		
		p_bmi= new JPanel();
		p_fat= new JPanel(); 
		p_pbf= new JPanel();
		p_whr= new JPanel();
		p_weight= new JPanel();
		lb_inbodyresult = new JLabel("[ ÀÎ ¹Ù µð  °á °ú ]");
		l_sc_bmi = new JLabel("    B    M    I : ");
		l_sc_bmi.setFont(new Font("±¼¸²", Font.BOLD, 20));
		l_sc_fat = new JLabel("    ºñ     ¸¸     µµ : ");
		l_sc_fat.setFont(new Font("±¼¸²", Font.BOLD, 20));
		l_sc_pbf = new JLabel("    Ã¼  Áö  ¹æ  ·ü : ");
		l_sc_pbf.setFont(new Font("±¼¸²", Font.BOLD, 20));
		l_sc_whr = new JLabel("    º¹ ºÎ Áö ¹æ ·ü : ");
		l_sc_whr.setFont(new Font("±¼¸²", Font.BOLD, 20));
		l_sc_weight = new JLabel("    Ç¥  ÁØ  Ã¼  Áß : ");
		l_sc_weight.setFont(new Font("±¼¸²", Font.BOLD, 20));
		jta_sc_bmi = new JTextField(5);
		jta_sc_bmi.setFont(new Font("±¼¸²", Font.BOLD, 25));
		jta_sc_fat = new JTextField(5);
		jta_sc_fat.setFont(new Font("±¼¸²", Font.BOLD, 25));
		jta_sc_pbf = new JTextField(5);
		jta_sc_pbf.setFont(new Font("±¼¸²", Font.BOLD, 25));
		jta_sc_whr = new JTextField(5);
		jta_sc_whr.setFont(new Font("±¼¸²", Font.BOLD, 25));
		jta_sc_weight = new JTextField(5);
		jta_sc_weight.setFont(new Font("±¼¸²", Font.BOLD, 25));

		

		ic_sc_timg = new ImageIcon("image/logo3.jpg");
		l_sc_topimgbox = new JLabel(ic_sc_timg);

		lb_info = new JLabel("[ È¸ ¿ø  Á¤ º¸ ]");
		lb_info.setFont(new Font("°íµñ", Font.BOLD, 18));
		l_sc_uno = new JLabel("È¸¿ø ¹øÈ£");
		l_sc_uno.setFont(new Font("±¼¸²", Font.BOLD, 20));
		jta_sc_uno = new JTextField(10);
		jta_sc_uno.setFont(new Font("±¼¸²", Font.BOLD, 25));

		l_sc_cname = new JLabel("È¸¿ø ÀÌ¸§");
		l_sc_cname.setFont(new Font("±¼¸²", Font.BOLD, 20));
		jta_sc_cname = new JTextField(10);
		jta_sc_cname.setFont(new Font("±¼¸²", Font.BOLD, 25));
		
		l_sc_time = new JLabel("Çï½º ±â°£");
		l_sc_time.setFont(new Font("±¼¸²", Font.BOLD, 20));
		jta_sc_limit = new JTextField(10);
		jta_sc_limit.setFont(new Font("±¼¸²", Font.BOLD, 25));
		l_sc_time2 = new JLabel("¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
		jta_sc_limit2 = new JTextField(10);
		jta_sc_limit2.setFont(new Font("±¼¸²", Font.BOLD, 25));


		l_sc_gx_name = new JLabel("¼ö°­ ÀÌ¸§");
		l_sc_gx_name.setFont(new Font("±¼¸²", Font.BOLD, 20));
		jta_sc_gx_name = new JTextField(10); //¼ö°­Á¾¸ñ or Çï½º 
		jta_sc_gx_name.setFont(new Font("±¼¸²", Font.BOLD, 25));
		
		
		p_sc_top.add(l_sc_topimgbox);
		p_sc_center.add(p_sc_inbody); p_sc_center.add(p_sc_infobox);
		


		p_sc_inbody.add(p_inbodytitle);	p_sc_inbody.add(p_bmi);p_sc_inbody.add(p_fat);p_sc_inbody.add(p_pbf);p_sc_inbody.add(p_whr);p_sc_inbody.add(p_weight);
		p_inbodytitle.add(lb_inbodyresult, BorderLayout.SOUTH);
		lb_inbodyresult.setFont(new Font("°íµñ", Font.BOLD, 18));
		p_bmi.add(l_sc_bmi); p_bmi.add(jta_sc_bmi);
		p_fat.add(l_sc_fat); p_fat.add(jta_sc_fat);
		p_pbf.add(l_sc_pbf); p_pbf.add(jta_sc_pbf);
		p_whr.add(l_sc_whr); p_whr.add(jta_sc_whr);
		p_weight.add(l_sc_weight); p_weight.add(jta_sc_weight);
		
		p_sc_infobox.add(p_blank); p_sc_infobox.add(p_sc_uno); p_sc_infobox.add(p_sc_cname);
		p_sc_infobox.add(p_sc_time);  p_sc_infobox.add(p_sc_gx_name); p_blank.add(lb_info);
		p_sc_btnbox.add(b_sc_lecture);
		p_sc_btnbox.add(b_sc_inbody);
		p_sc_btnbox.add(b_sc_personal);
		p_sc_btnbox.add(b_sc_chatting);



		p_sc_uno.add(l_sc_uno); p_sc_uno.add(jta_sc_uno);
//		p_sc_uno.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		p_sc_cname.add(l_sc_cname); p_sc_cname.add(jta_sc_cname);
//		p_sc_name.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		p_sc_time.add(l_sc_time); p_sc_time.add(jta_sc_limit);p_sc_time.add(l_sc_time2); p_sc_time.add(jta_sc_limit2);
//		p_sc_time.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		p_sc_gx_name.add(l_sc_gx_name); p_sc_gx_name.add(jta_sc_gx_name);
//		p_sc_gx_name.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		p_sc_total.add(p_sc_top,BorderLayout.NORTH);
		p_sc_total.add(p_sc_center, BorderLayout.CENTER);
		p_sc_total.add(p_sc_btnbox,BorderLayout.EAST);
		p_sc_total.add(p_sc_sysdate,BorderLayout.SOUTH);
		
		startui.jf.getContentPane().add(p_sc_total,BorderLayout.CENTER);
		p_sc_total.getRootPane().setBackground(Color.WHITE);
		
		
		p_sc_inbody.setBackground(Color.WHITE);
		p_inbodytitle.setBackground(Color.WHITE);
		p_bmi.setBackground(Color.WHITE);
		p_fat.setBackground(Color.WHITE);
		p_pbf.setBackground(Color.WHITE);
		p_whr.setBackground(Color.WHITE);
		p_weight.setBackground(Color.WHITE);
		p_sc_top.setBackground(Color.WHITE);
		p_sc_center.setBackground(Color.WHITE);
		p_sc_btnbox.setBackground(Color.WHITE);
		p_sc_sysdate.setBackground(Color.WHITE);
		p_sc_infobox.setBackground(Color.WHITE);
		p_blank.setBackground(Color.WHITE);
		p_sc_uno.setBackground(Color.WHITE);
		p_sc_cname.setBackground(Color.WHITE);
		p_sc_time.setBackground(Color.WHITE);
		p_sc_gx_name.setBackground(Color.WHITE);
		
		p_sc_total.setSize(1000,600);
		p_sc_total.setVisible(true);
		
		
//		//2. ÀÌº¥Æ® ÇÚµé·¯ Á¤ÀÇ
		b_sc_lecture.addActionListener(this);
		b_sc_inbody.addActionListener(this);
		b_sc_personal.addActionListener(this);
		b_sc_chatting.addActionListener(this);
	
		//È­¸é¿¡ ÀÎ¹ÙµðÁ¤º¸ ¶ç¿öÁÖ±â
		MainVO inbodyvo = system.getListInbodyVO(StartUI.vo.getCno());
		if(inbodyvo != null) {
			jta_sc_bmi.setText(String.valueOf(inbodyvo.getBmi()));
			jta_sc_fat.setText(String.valueOf(inbodyvo.getFat()));
			jta_sc_pbf.setText(String.valueOf(inbodyvo.getPbf()));
			jta_sc_whr.setText(String.valueOf(inbodyvo.getWhr()));
			jta_sc_weight.setText(String.valueOf(inbodyvo.getS_weight()));
			
		}
		
		//È­¸é¿¡ È¸¿øÁ¤º¸ ¶ç¿öÁÖ±â
		mainvo = system.getListMainVO(StartUI.vo.getCno());			
		if(mainvo != null) {
			jta_sc_uno.setText(String.valueOf(mainvo.getCno()));
			jta_sc_cname.setText(mainvo.getName());
			jta_sc_limit.setText(mainvo.getStart_date());
			jta_sc_limit2.setText(mainvo.getEnd_date());	
			if(mainvo.getGx_code() != null && mainvo.getGx_code() != "") {
				jta_sc_gx_name.setText(mainvo.getGx_code());
			}else { 
				jta_sc_gx_name.setText("Çï½º¸¸ ÀÌ¿ë Áß");
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == b_sc_lecture) {
			p_sc_total.setVisible(false);
			if(mainvo.getGx_count()!=0)
				dao.update(StartUI.vo.getCno());
			new LectureUI(this, startui);
		}else if(obj == b_sc_inbody) {
			p_sc_total.setVisible(false);
			new InbodyUI(this, startui);
		}else if(obj == b_sc_personal) {
			new DietUI(startui.vo.getCno());
		}else if(obj == b_sc_chatting) {
			p_sc_total.setVisible(false);
			new GymExtentionUI(this, startui);

		}
		
	}
	

	
}


	
