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
import javax.swing.table.TableRowSorter;

import com.mycom.system.AdminSystem;

public class AdminUI extends JFrame implements ActionListener{
	StartUI startui;
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
	JButton b_Search, b_SearchAll, b_Update, b_Delete;
	JScrollPane scroll_Mem;
	TableRowSorter sorter;

	DefaultTableModel dtm_Mem;
	JTable t_Mem;
	String[] memInfo = {"회원번호", "이름"," 성별", "전화번호", "생일", "시작일", "마지막일", "GX코드", "GX가격", "GX횟수", "GX유효기간", "BMI", "FAT", "PBF", "WHR"};
	//Lecture 관리 폼
	JPanel p_LecMain, p_LecResult, p_LecBtn;
//	JButton b_LecUpdate, b_LecDelete;
	JScrollPane scroll_Lec;
	DefaultTableModel dtm_Lec;
	JTable t_Lec;
	String[] lecInfo = {"종목코드", "종목명"," 금액"};
	
	public AdminUI(StartUI startui) {		
		//setStatus(MAIN);
		this.startui = startui;
//		status = AdminUI.MAIN;
		System.out.println("Status=" + getStatus());		
		//1. 화면구성
		jf = new JFrame();
		p_AdmMain = new JPanel();
		p_AdmMenu = new JPanel();
		p_AdmTitle = new JPanel();
		
		l_AdmTitle = new JLabel("**********   HealthCare 관리자 페이지      **********");
		
		b_AdmMember = new JButton("회       원");
		b_AdmLecture = new JButton("수       업");
	
		ta_AdmMain = new JTextArea("xx 관리자님 반갑습니다.",28, 80);
		
		l_AdmTitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		p_AdmTitle.add(l_AdmTitle);
		

		//menu패널 
		p_AdmMenu.setLayout(new GridLayout(10,1));
		
		p_AdmMenu.add(b_AdmMember);
		p_AdmMenu.add(b_AdmLecture);
		
		
		//메인패널
		p_AdmMain.add(ta_AdmMain);
		
		startui.jf.getContentPane().add(p_AdmTitle,BorderLayout.NORTH);
		startui.jf.getContentPane().add(p_AdmMenu,BorderLayout.WEST);
		startui.jf.getContentPane().add(p_AdmMain,BorderLayout.CENTER);
		
		startui.jf.setSize(1000,600);
		startui.jf.setVisible(true);
		
		startui.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		case 1: 
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
		
//		p_MemMain = new JPanel(new GridLayout(3,1));
		p_MemMain = new JPanel(new BorderLayout());
		p_MemSearch = new JPanel();
		p_MemResult = new JPanel();
		p_MemBtn = new JPanel();
		
		l_MemCno = new JLabel("검색할 회원번호를 입력해주세요");
		tf_MemCno = new JTextField(10);		
		b_Search = new JButton("검    색");
		b_SearchAll = new JButton("전 체 보 기");
		b_Update = new JButton("수    정");
		b_Delete = new JButton("삭    제");
		
		dtm_Mem = new DefaultTableModel(memInfo, 0);
		t_Mem= new JTable(dtm_Mem); 
        scroll_Mem= new JScrollPane(t_Mem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        
        //스크롤 크기
//        scroll_Mem.setBounds(0,30,800,200);
        scroll_Mem.setBounds(30,30,800,350);
        
        p_MemResult.setBounds(0,0,1000,1000);
        p_MemResult.setLayout(null);
//        p_AdmMemberMain.setLayout(null);
        
		p_MemSearch.add(tf_MemCno);
		p_MemSearch.add(b_Search);
		p_MemSearch.add(b_SearchAll);
		
		p_MemResult.add(scroll_Mem);
		
		p_MemBtn.add(b_Update);
		p_MemBtn.add(b_Delete);
		
		p_MemMain.add(p_MemSearch, BorderLayout.NORTH);
		p_MemMain.add(p_MemResult, BorderLayout.CENTER);
		p_MemMain.add(p_MemBtn, BorderLayout.SOUTH);
		
//		p_AdmSearch.setSize(600,300);
		p_MemMain.setVisible(true);
		
		startui.jf.getContentPane().add(p_MemMain,BorderLayout.CENTER);
		system.getMember(dtm_Mem);
		
		
//		if(tf_MemCno.getText() == "") {
//			system.getMember(dtm_Mem);
//		}else {
//			if(tf_MemCno.getText() == "") {
//				JOptionPane.showMessageDialog(null,"없는 데이터 입니다.");
//			}else {
//				int cno = Integer.parseInt(tf_MemCno.getText());
//				system.searchData(dtm_Mem, cno);
//			}
//		}
		//모든레코드를 검색하여 DefaultTableModle에 올리기 or 검색테이블 올리기
	
        
		//검색 이벤트 위임
		b_Search.addActionListener(this);
		b_SearchAll.addActionListener(this);
		b_Update.addActionListener(this);
		b_Delete.addActionListener(this);
	}

	public void lectureManageForm() {
		status = AdminUI.LECTURE;
		p_LecMain = new JPanel(new BorderLayout());
		p_LecResult = new JPanel();
		p_LecBtn = new JPanel();
		
		b_Update = new JButton("수    정");
		b_Delete = new JButton("삭    제");
		
		dtm_Lec = new DefaultTableModel(lecInfo, 0);
		t_Lec= new JTable(dtm_Lec); 
        scroll_Lec= new JScrollPane(t_Lec, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        //스크롤 크기
        scroll_Lec.setBounds(30,68,800,350);
        
        p_LecResult.setBounds(0,0,1000,1000);
        
        p_LecResult.setLayout(null);
//        p_AdmMemberMain.setLayout(null);
        
		p_LecResult.add(scroll_Lec);
		
		p_LecBtn.add(b_Update);
		p_LecBtn.add(b_Delete);
		
		p_LecMain.add(p_LecResult);
		p_LecMain.add(p_LecBtn);
		
//		p_AdmSearch.setSize(600,300);
		p_LecMain.setVisible(true);
		
		
		p_LecMain.add(p_LecResult, BorderLayout.CENTER);
		p_LecMain.add(p_LecBtn, BorderLayout.SOUTH);
		
		
		startui.jf.getContentPane().add(p_LecMain,BorderLayout.CENTER);
		
		//모든레코드를 검색하여 DefaultTableModle에 올리기
        system.getLecture(dtm_Lec);
		
        
		b_Update.addActionListener(this);
		b_Delete.addActionListener(this);
	}
	
	/**
	 * 업데이트
	 * @param sno
	 */
	public void updateForm(String sno) {
	
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
		}else if(obj == b_Search){
			if(tf_MemCno.getText().trim().length()>0) {
				system.searchData(dtm_Mem, Integer.parseInt(tf_MemCno.getText().trim()));
				tf_MemCno.setText("");
				tf_MemCno.requestFocus();
				//첫행 선택
				if (dtm_Mem.getRowCount() > 0) {
					t_Mem.setRowSelectionInterval(0, 0);
				}
			}
//			JOptionPane.showInternalMessageDialog(null, "검색");
//			sorter.setRowFilter(RowFilter.regexFilter(tf_MemCno.getText().trim()));
//			system.searchData(dtm_Lec, Integer.parseInt(tf_MemCno.getText().trim()));
//			tf_MemCno.setText("");
			
		}else if(obj == b_SearchAll) {
			system.getMember(dtm_Mem);
		}
		else if(obj == b_Update) {
			system.searchData(dtm_Mem, Integer.parseInt(tf_MemCno.getText().trim()));
			tf_MemCno.setText("");
			tf_MemCno.requestFocus();
			//첫행 선택
			if (dtm_Mem.getRowCount() > 0) {
				t_Mem.setRowSelectionInterval(0, 0);
			}
		}else if(obj == b_Delete) {
			System.out.println("b_Delete");
			
		}
		
	}
	
}
