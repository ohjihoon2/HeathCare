package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycom.system.AdminSystem;


public class AdminUI extends JFrame implements ActionListener{

	AdminSystem system = new AdminSystem();
	
	public static final int MAIN = 0;   //msgPanel
	public static final int MEMBER = 1; //jpReg
	public static final int LECTURE = 2;	//outputPanel
	
	int status = 0;
	
	//메인페이지
	JFrame jf;
	JPanel p_AdmMain, p_AdmMenu, p_AdmTitle;
	JLabel l_AdmTitle;
	JTextArea ta_AdmMain;
	JTextField tf;
	JButton b_AdmMember, b_AdmLecture;
	
	//member 관리 폼
	JPanel p_MemMain, p_MemSearch, p_MemResult, p_MemBtn;
	JLabel l_MemCno;
	JTextField tf_MemCno;
	JButton b_MemUpdate, b_MemDelete;
	JScrollPane scroll_Mem;

	DefaultTableModel dtm_Mem;
	JTable t_Mem;
	String[] memInfo = {"회원번호", "이름"," 성별", "전화번호", "생일", "시작일", "마지막일", "GX코드", "GX가격", "GX횟수", "GX유효기간", "BMI", "FAT", "PBF", "WHR"};
	
	//Lecture 관리 폼
	JPanel p_LecMain, p_LecResult, p_LecBtn;
	JButton b_LecUpdate, b_LecDelete;
	JScrollPane scroll_Lec;
	DefaultTableModel dtm_Lec;
	JTable t_Lec;
	String[] lecInfo = {"종목코드", "종목명"," 금액"};
	
	public AdminUI() {		
		//setStatus(MAIN);
		 status = AdminUI.MAIN;
System.out.println("Status=" + getStatus());		
		//1. 화면구성
		jf = new JFrame();
		p_AdmMain = new JPanel();
		p_AdmMenu = new JPanel();
		
		l_AdmTitle = new JLabel("**********   HealthCare 관리자 페이지      **********");
		
		b_AdmMember = new JButton("회       원");
		b_AdmLecture = new JButton("수       업");
	
		ta_AdmMain = new JTextArea("xx 관리자님 반갑습니다.",28, 80);
		
		l_AdmTitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//		p_AdmTitle.add(l_AdmTitle);
		

		//menu패널 
		p_AdmMenu.setLayout(new GridLayout(10,1));
		
		p_AdmMenu.add(b_AdmMember);
		p_AdmMenu.add(b_AdmLecture);
		
		
		//메인패널
		p_AdmMain.add(ta_AdmMain);
		
		jf.getContentPane().add(l_AdmTitle,BorderLayout.NORTH);
		jf.getContentPane().add(p_AdmMenu,BorderLayout.WEST);
		jf.getContentPane().add(p_AdmMain,BorderLayout.CENTER);
		
		jf.setSize(1000,600);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. 이벤트 위임
		b_AdmMember.addActionListener(this);
		b_AdmLecture.addActionListener(this);

	}
	
	//Method
	/** 화면 status  setter, getter  ***/
	public static void setStatus(int status) { 
		status = status;
	}
	public int getStatus() { 
		return status; 
	}
	
	/** 화면 Panel 스위칭 메소드 ***/
	public void switchingPanel(int status) {
		switch(status) {
		case 0 :
			p_AdmMain.setVisible(false);
			break;
		case 1 :
			p_MemMain.setVisible(false);
			break;
		case 2: 
			p_LecMain.setVisible(false);
			break;
		}
	}
	
	public void memberManageForm() {
		System.out.println("MEMBER1="+getStatus());
		//setStatus(MEMBER);
		status = AdminUI.MEMBER;
		System.out.println("MEMBER2="+getStatus());
		
		p_MemMain = new JPanel(new GridLayout(3,1));
		p_MemSearch = new JPanel();
		p_MemResult = new JPanel();
		p_MemBtn = new JPanel();
		
		l_MemCno = new JLabel("검색할 회원번호를 입력해주세요");
		tf_MemCno = new JTextField(10);		
		b_MemUpdate = new JButton("수    정");
		b_MemDelete = new JButton("삭    제");
		
		dtm_Mem = new DefaultTableModel(memInfo, 0);
		t_Mem= new JTable(dtm_Mem); 
        scroll_Mem= new JScrollPane(t_Mem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        //스크롤 크기
        scroll_Mem.setBounds(0,30,800,200);
        
        p_MemResult.setBounds(0,0,1000,1000);
        
        p_MemResult.setLayout(null);
//        p_AdmMemberMain.setLayout(null);
        
		p_MemSearch.add(l_MemCno);
		p_MemSearch.add(tf_MemCno);
		
		p_MemResult.add(scroll_Mem);
		
		p_MemBtn.add(b_MemUpdate);
		p_MemBtn.add(b_MemDelete);
		
		p_MemMain.add(p_MemSearch);
		p_MemMain.add(p_MemResult);
		p_MemMain.add(p_MemBtn);
		
//		p_AdmSearch.setSize(600,300);
		p_MemMain.setVisible(true);
		
		jf.getContentPane().add(p_MemMain,BorderLayout.CENTER);
		
		//모든레코드를 검색하여 DefaultTableModle에 올리기
        system.getMember(dtm_Mem);
		
		//검색 이벤트 위임
		tf_MemCno.addActionListener(this);
//		tf_AdmCno.requestFocus();
		b_MemUpdate.addActionListener(this);
		b_MemDelete.addActionListener(this);
	}

	public void lectureManageForm() {
		System.out.println("lecture 1= "+getState());
//		setStatus(LECTURE);
		status = AdminUI.LECTURE;
		System.out.println("lecture 2= "+getState());
		p_LecMain = new JPanel(new GridLayout(2,1));
		p_LecResult = new JPanel();
		p_LecBtn = new JPanel();
		
		b_LecUpdate = new JButton("수    정");
		b_LecDelete = new JButton("삭    제");
		
		dtm_Lec = new DefaultTableModel(lecInfo, 0);
		t_Lec= new JTable(dtm_Lec); 
        scroll_Lec= new JScrollPane(t_Lec, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        //스크롤 크기
        scroll_Lec.setBounds(0,30,800,200);
        
        p_LecResult.setBounds(0,0,1000,1000);
        
        p_LecResult.setLayout(null);
//        p_AdmMemberMain.setLayout(null);
        
		p_LecResult.add(scroll_Lec);
		
		p_LecBtn.add(b_LecUpdate);
		p_LecBtn.add(b_LecDelete);
		
		p_LecMain.add(p_LecResult);
		p_LecMain.add(p_LecBtn);
		
//		p_AdmSearch.setSize(600,300);
		p_LecMain.setVisible(true);
		
		jf.getContentPane().add(p_LecMain,BorderLayout.CENTER);
		
		//모든레코드를 검색하여 DefaultTableModle에 올리기
        system.getLecture(dtm_Lec);
		
		b_LecUpdate.addActionListener(this);
		b_LecDelete.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj ==b_AdmMember) {
			switchingPanel(getStatus());
//			p_AdmMain.setVisible(false);
//			p_LecMain.setVisible(false);
			
			memberManageForm();
		}else if(obj == b_AdmLecture) {
			switchingPanel(getStatus());
//			p_AdmMain.setVisible(false);
//			p_MemMain.setVisible(false);
			lectureManageForm();
		}
		
	}
	
}
