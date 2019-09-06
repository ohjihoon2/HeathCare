package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mycom.system.RegistSystem;
import com.mycom.vo.MemberVO;

public class AdminUpdateUI extends JFrame implements ActionListener{
	
	//Field
	JFrame jf;
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn, p_RegGender, p_RegCode, p_RegTerm; 
	JRadioButton rb_RegMen, rb_RegWomen, rb_RegEndDate, rb_RegCODE1, rb_RegCODE2, rb_RegCODE3, rb_RegCODE4, rb_RegTerm1, rb_RegTerm2, rb_RegTerm3, rb_RegTerm4 ;
	JLabel l_RegTitle, l_RegName, l_RegGender, l_RegAddress, l_RegPhone, l_RegBirth_date, l_RegGx_code,  l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegGender, tf_RegAddress, tf_RegPhone, tf_RegBirth_date, tf_RegGx_code,  tf_RegStart_date, tf_RegEnd_date;
	JRadioButton rd_RegEnd_date;
	JButton b_RegSave, b_RegCancel, b_RegExit;
	ButtonGroup group1,group2,group3;
	//Constructor
	public AdminUpdateUI(){	
		//1. 화면구성
		// 패널 초기화 
		jf = new JFrame();
		p_RegMain = new JPanel(new GridLayout(3,1));
		
		p_RegTitle = new JPanel();
		p_RegBoard = new JPanel(new GridLayout(20,2));
		p_RegBtn = new JPanel();
		p_RegGender = new JPanel();
		p_RegCode = new JPanel();
		p_RegTerm = new JPanel();
		
		b_RegSave = new JButton("완료");
		b_RegExit = new JButton("나가기");
		
		
		// 왼쪽
		l_RegTitle = new JLabel("회원가입");
		
		l_RegName = new JLabel("회원명");
		l_RegGender = new JLabel("성별");
		l_RegAddress = new JLabel("주소");
		l_RegPhone = new JLabel("연락처");
		l_RegBirth_date = new JLabel("생년월일");
		l_RegGx_code = new JLabel("종목");
		l_RegStart_date = new JLabel("시작일");
		l_RegEnd_date = new JLabel("헬스기간");
	
		
		// 오른쪽
		tf_RegName = new JTextField(10);
		
		rb_RegMen = new JRadioButton("남");
		rb_RegWomen= new JRadioButton("여");
		
		rb_RegCODE1 = new JRadioButton("헬스");
		rb_RegCODE2 = new JRadioButton("요가");
		rb_RegCODE3 = new JRadioButton("줌바");
		rb_RegCODE4 = new JRadioButton("스피닝");
		
		rb_RegTerm1 = new JRadioButton("1개월");
		rb_RegTerm2 = new JRadioButton("3개월");
		rb_RegTerm3 = new JRadioButton("6개월");
		rb_RegTerm4 = new JRadioButton("12개월");
		
		tf_RegAddress = new JTextField(10);
		tf_RegPhone = new JTextField(10);
		tf_RegBirth_date = new JTextField(10);
		tf_RegGx_code = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		
		//합치기
		l_RegTitle.setHorizontalAlignment(0);
		p_RegTitle.add(l_RegTitle);
		
		group1 = new ButtonGroup();
		group1.add(rb_RegMen);
		group1.add(rb_RegWomen);
		
		p_RegGender.add(rb_RegMen);
		p_RegGender.add(rb_RegWomen);
		
		group2 = new ButtonGroup();
		group2.add(rb_RegCODE1);
		group2.add(rb_RegCODE2);
		group2.add(rb_RegCODE3);
		group2.add(rb_RegCODE4);
		
		p_RegCode.add(rb_RegCODE1);
		p_RegCode.add(rb_RegCODE2);
		p_RegCode.add(rb_RegCODE3);
		p_RegCode.add(rb_RegCODE4);
		
		group3 = new ButtonGroup();
		group3.add(rb_RegTerm1);
		group3.add(rb_RegTerm2);
		group3.add(rb_RegTerm3);
		group3.add(rb_RegTerm4);
		
		p_RegTerm.add(rb_RegTerm1);
		p_RegTerm.add(rb_RegTerm2);
		p_RegTerm.add(rb_RegTerm3);
		p_RegTerm.add(rb_RegTerm4);
		
		p_RegBoard.add(l_RegName); p_RegBoard.add(tf_RegName);
		p_RegBoard.add(l_RegGender); p_RegBoard.add(p_RegGender);
		p_RegBoard.add(l_RegAddress); p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(l_RegPhone); p_RegBoard.add(tf_RegPhone);
		p_RegBoard.add(l_RegBirth_date); p_RegBoard.add(tf_RegBirth_date);
		p_RegBoard.add(l_RegGx_code); p_RegBoard.add(p_RegCode);
		p_RegBoard.add(l_RegEnd_date); p_RegBoard.add(p_RegTerm);
		
		
		p_RegBtn.add(b_RegSave);
		p_RegBtn.add(b_RegExit);
		
		
		p_RegMain.add(p_RegTitle);		
		p_RegMain.add(p_RegBoard);		
		p_RegMain.add(p_RegBtn);		
		
//			setTitle("회원가입");
//			getContentPane().add(p_RegMain, BorderLayout.CENTER);
		jf.setSize(1000,600);
		jf.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().add(p_RegMain, BorderLayout.CENTER);
		
		//2. 이벤트 핸들러 정의
		b_RegSave.addActionListener(this);
		b_RegExit.addActionListener(this);
	}
	
	
	//Method
	public boolean regFormCheck() {
		boolean result = false;
		
		if(tf_RegName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
			tf_RegName.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == b_RegSave) {	//회원가입 완료
			//회원정보 --> VO 생성 --> DAO ---> DB 
			if(regFormCheck()) {
				//2. MemberVO 객체에 입력한 데이터를 담아서 -- 등록요청
				MemberVO vo = new MemberVO();
				vo.setName(tf_RegName.getText());
				if(rb_RegMen.isSelected()) {
					vo.setGender("M");
				}else if(rb_RegWomen.isSelected()) {
					vo.setGender("F");
				}
				vo.setAddress(tf_RegAddress.getText());
				vo.setPhone(tf_RegPhone.getText());
				vo.setBirth_date(tf_RegBirth_date.getText());
				
				if(rb_RegCODE1.isSelected()) {
					vo.setGx_code("100");
				}else if(rb_RegCODE2.isSelected()) {
					vo.setGx_code("101");
				}else if(rb_RegCODE3.isSelected()) {
					vo.setGx_code("102");
				}else if(rb_RegCODE4.isSelected()) {
					vo.setGx_code("103");
				}
				
				
				if(rb_RegTerm1.isSelected()) {
					vo.setEnd_date("1");
					vo.setGym_price(50000);
				}else if(rb_RegTerm2.isSelected()) {
					vo.setEnd_date("3");
					vo.setGym_price(130000);
				}else if(rb_RegTerm3.isSelected()) {
					vo.setEnd_date("6");
					vo.setGym_price(250000);
				}else if(rb_RegTerm4.isSelected()) {
					vo.setEnd_date("12");
					vo.setGym_price(450000);
				}
//				
//				boolean regResult = system.regist(vo);
////				int sno = system.
//				System.out.println(regResult);
//				if(regResult) {
//					JOptionPane.showMessageDialog(null, "등록완료\n회원님은 번호는 "+system.searchSno(vo.getName())+" 입니다.");
//					p_RegMain.setVisible(false);
//					startui.p_LogMain.setVisible(true);
//				}else {
//					JOptionPane.showMessageDialog(null, "등록실패");
//				}
			}
		}else if(obj == b_RegExit) {  //나가기
			//회원가입 - 다음 버튼		
			p_RegMain.setVisible(false);
		}
		
	}
}











