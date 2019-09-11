package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mycom.dao.DietDAO;
import com.mycom.system.DietSystem;
import com.mycom.vo.DietMemberVO;
import com.mycom.vo.DietSaveVO;


public class DietUI3 extends JFrame implements ActionListener {
	//Field
	DietUI ui;
	DietDAO dao = new DietDAO();
	JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	
	JLabel l_Diettitle,l_DietDwNO, l_DietCno, l_Dietdate,l_Dietdate2, l_DietName,l_DietName2, l_Dietsex,l_Dietsex2, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietRl_Dietcalorie,l_Dietcalorie,l_Dietbad,l_Dietgood;
	JTextArea ta_Dietlist, ta_DietRecord;
	
	JScrollPane s_Dietscroll;

	DefaultTableModel d_Dietdt;
	JTable j_DIettable;
	
	JButton b_DietResult, b_DietSave, b_DietReset, b_DietBack;
	

	DietSystem system = new DietSystem();
	DietMemberVO vo = new DietMemberVO();
	
	//Constructor
	public DietUI3(DietUI ui) {
		this.ui = ui;
		
		
		p_Dietall = new JPanel();
		
		p_Dieta1 = new JPanel();
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_Dieta1.setBorder(b1);

		p_Dieta2 = new JPanel();
		p_Dieta2_1 = new JPanel();
		
		
		int cno = DietUI.mvo.getCNO();
    	ArrayList<DietSaveVO> list = system.getDietList(cno);
    	Vector<String> colList = new Vector<String>();
    	colList.add("번호");
    	colList.add("회원번호");
    	colList.add("이름");
    	colList.add("몸무게");
    	colList.add("목표몸무게");
    	colList.add("선택칼로리");
    	colList.add("권장칼로리");
    	colList.add("칼로리");
    	colList.add("날짜");
		
    	d_Dietdt = new DefaultTableModel(colList,0);
    	
    	
		for(DietSaveVO vo: list) {
			Vector<String> v = new Vector<String>();
			
			v.add(String.valueOf(vo.getRNO()));
			v.add(String.valueOf(vo.getCNO()));
			v.add(vo.getNAME());
			v.add(vo.getDW_WEIGHT());
			v.add(vo.getDW_TARGETWEIGHT());
			v.add(String.valueOf(vo.getDS_SelectKcal()));
			v.add(String.valueOf(vo.getDS_RECOMMEND()));
			v.add(String.valueOf(vo.getDS_RESULTKCAL()));
			v.add(vo.getDW_DATE());
			
			d_Dietdt.addRow(v);
			}
		
		
		j_DIettable = new JTable(d_Dietdt);
		s_Dietscroll = new JScrollPane(j_DIettable);
		
		
		
		p_Dieta3 = new JPanel();
		LineBorder b3 = new LineBorder(Color.BLACK,1); 
		p_Dieta3.setBorder(b3);
		
		
		l_Dietdl_Dietcalorie = new JLabel("· 개인식단 저장 리스트");
		l_Dietdl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,17));
		
		
		
		b_DietBack = new JButton("뒤로가기");
		
		p_Dieta1.setBounds(0,50,980,600);
		p_Dieta1.setBackground(Color.WHITE);
		
		s_Dietscroll.setBounds(50,50,900,500);
		l_Dietdl_Dietcalorie.setBounds(10,10,420,30);
		//l_Dietdietname.setBounds(200,30,100,30);
		//tf_DietDiet.setBounds(270,30,200,30);
		
		
		
		b_DietBack.setBounds(430,35,100,30);
		p_Dieta3.setBounds(0,750,980,100);
		p_Dieta3.setBackground(Color.WHITE);
		
		
		p_Dieta1.add(l_Dietdl_Dietcalorie);
		p_Dieta1.add(s_Dietscroll);
		p_Dietall.add(p_Dieta1);
		
		
		p_Dieta3.add(b_DietBack);
		p_Dietall.add(p_Dieta3);
		
		p_Dieta1.setLayout(null);
		p_Dieta3.setLayout(null);
		p_Dietall.setLayout(null);
		
		ui.jf.getContentPane().add(p_Dietall,BorderLayout.CENTER);
		p_Dietall.setSize(1000,1000);
		p_Dietall.setVisible(true);
		
		//이벤트 등록
		b_DietBack.addActionListener(this);	
		
		
 
		
      
	}
       
	 

	
	//이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b_DietBack) {
        	p_Dietall.setVisible(false);
        	ui.p_Dietall.setVisible(true);
        	//new DietUI();
			
		    
        }
	}
	
}
