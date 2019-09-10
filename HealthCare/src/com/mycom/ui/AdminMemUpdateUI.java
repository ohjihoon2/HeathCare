package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mycom.dao.AdminDAO;
import com.mycom.system.RegistSystem;
import com.mycom.vo.MemberVO;

public class AdminMemUpdateUI extends JFrame implements ActionListener{
	RegistSystem system = new RegistSystem();
	StartUI startui;
	AdminDAO dao = new AdminDAO();
	//Field
	JFrame jf;
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn, p_RegGender, p_RegCode, p_RegTerm; 
	JRadioButton rb_RegMen, rb_RegWomen, rb_RegEndDate, rb_RegCODE1, rb_RegCODE2, rb_RegCODE3, rb_RegCODE4, rb_RegTerm1, rb_RegTerm2, rb_RegTerm3, rb_RegTerm4 ;
	JLabel l_RegTitle, l_RegName, l_RegGender, l_RegAddress, l_RegPhone, l_RegBirth_date, l_RegGx_code,  l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegGender, tf_RegAddress, tf_RegPhone, tf_RegBirth_date, tf_RegGx_code,  tf_RegStart_date, tf_RegEnd_date;
	JRadioButton rd_RegEnd_date;
	JButton b_RegSave, b_RegCancel, b_RegExit;
	ButtonGroup group1,group2,group3;
	AdminUI ui;
	int cno;
	
	//Constructor
	public AdminMemUpdateUI(int cno, AdminUI ui){	
		this.ui = ui;
		
		//1. 화면구성
		// 패널 초기화 
		this.cno = cno;
		
		MemberVO cvo = dao.getMember(cno);
		
		jf = new JFrame();
		p_RegMain = new JPanel();
		
		p_RegTitle = new JPanel();
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_RegTitle.setBorder(b1);
		
		p_RegBoard = new JPanel();
		LineBorder b2 = new LineBorder(Color.BLACK,2);
		p_RegBoard.setBorder(b2);
		
		p_RegBtn = new JPanel();
		p_RegGender = new JPanel();
		p_RegCode = new JPanel();
		p_RegTerm = new JPanel();
		
		b_RegSave = new JButton("수정완료");
		b_RegCancel = new JButton("다시쓰기");
		b_RegExit = new JButton("나가기");
		
		l_RegTitle = new JLabel("회원정보수정");
		l_RegTitle.setFont(new Font("나눔고딕",Font.BOLD,26));
		
		l_RegName = new JLabel("회원명");
		l_RegName.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegGender = new JLabel("성별");
		l_RegGender.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegAddress = new JLabel("주소");
		l_RegAddress.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegPhone = new JLabel("연락처");
		l_RegPhone.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegBirth_date = new JLabel("생년월일");
		l_RegBirth_date.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegGx_code = new JLabel("종목");
		l_RegGx_code.setFont(new Font("나눔고딕",Font.BOLD,18));
		
//		l_RegStart_date = new JLabel("시작일");
//		l_RegStart_date.setFont(new Font("나눔고딕",Font.BOLD,18));
		
//		l_RegEnd_date = new JLabel("헬스기간");
//		l_RegEnd_date.setFont(new Font("나눔고딕",Font.BOLD,18));
	
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
		
		tf_RegName = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegPhone = new JTextField(10);
		tf_RegBirth_date = new JTextField(10);
		tf_RegGx_code = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		/**리스트에서 정보 가져오기**/
		tf_RegName.setText(cvo.getName());
		
		//성별
		if(cvo.getGender().equals("M")) {
			rb_RegMen.setSelected(true);
		}else if (cvo.getGender().equals("F")){
			rb_RegWomen.setSelected(true);
		}
		
		tf_RegAddress.setText(cvo.getAddress());
		tf_RegPhone.setText(cvo.getPhone());
		tf_RegBirth_date.setText(cvo.getBirth_date());
		
		//종목
		if(cvo.getGx_code().equals("100")) {
			rb_RegCODE1.setSelected(true);
			
		}else if (cvo.getGx_code().equals("101")){
			rb_RegCODE2.setSelected(true);
			
		}else if (cvo.getGx_code().equals("102")){
			rb_RegCODE3.setSelected(true);
			
		}else if (cvo.getGx_code().equals("103")){
			rb_RegCODE4.setSelected(true);
		}
		
		
		
		
		p_RegTitle.setBounds(0,0,980,70);
		p_RegTitle.setBackground(Color.WHITE);
		l_RegTitle.setBounds(420,20,200,30);
		
		p_RegBoard.setBounds(0,90,980,380);
		p_RegBoard.setBackground(Color.WHITE);
		l_RegName.setBounds(300,30,100,20);
		l_RegGender.setBounds(300,80,100,20);
		l_RegAddress.setBounds(300,130,100,20);
		l_RegPhone.setBounds(300,180,100,20);
		l_RegBirth_date.setBounds(300,230,100,20);
		l_RegGx_code.setBounds(300,280,100,20);
		//l_RegEnd_date.setBounds(300,330,100,20);
		
		rb_RegMen.setBounds(400,75,50,30);
		rb_RegWomen.setBounds(450,75,50,30);
		
		rb_RegCODE1.setBounds(400,275,100,30);
		rb_RegCODE2.setBounds(500,275,100,30);
		rb_RegCODE3.setBounds(600,275,100,30);
		rb_RegCODE4.setBounds(700,275,100,30);
		
		rb_RegTerm1.setBounds(400,325,100,30);
		rb_RegTerm2.setBounds(500,325,100,30);
		rb_RegTerm3.setBounds(600,325,100,30);
		rb_RegTerm4.setBounds(700,325,100,30);
		
		tf_RegName.setBounds(400,30,300,20);
		tf_RegAddress.setBounds(400,130,300,20);
		tf_RegPhone.setBounds(400,180,300,20);
		tf_RegBirth_date.setBounds(400,230,300,20);
		
		p_RegBtn.setBounds(0,480,980,70);
		b_RegSave.setBounds(320,15,100,30);
		b_RegCancel.setBounds(450,15,100,30);
		b_RegExit.setBounds(580,15,100,30);
		
		p_RegTitle.add(l_RegTitle);
		p_RegMain.add(p_RegTitle);
		
		p_RegBoard.add(l_RegName);
		p_RegBoard.add(l_RegGender);
		p_RegBoard.add(l_RegAddress);
		p_RegBoard.add(l_RegPhone);
		p_RegBoard.add(l_RegBirth_date);
		p_RegBoard.add(l_RegGx_code);
		//p_RegBoard.add(l_RegStart_date);
		//p_RegBoard.add(l_RegEnd_date);
		
		p_RegBoard.add(tf_RegName);
		p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(tf_RegPhone);
		p_RegBoard.add(tf_RegBirth_date);
		//p_RegBoard.add(tf_RegGx_code);
		//p_RegBoard.add(tf_RegStart_date);
		//p_RegBoard.add(tf_RegEnd_date);
		
		group1 = new ButtonGroup();
		group1.add(rb_RegMen);
		group1.add(rb_RegWomen);
		
		p_RegBoard.add(rb_RegMen);
		p_RegBoard.add(rb_RegWomen);
		
		group2 = new ButtonGroup();
		group2.add(rb_RegCODE1);
		group2.add(rb_RegCODE2);
		group2.add(rb_RegCODE3);
		group2.add(rb_RegCODE4);
		
		p_RegBoard.add(rb_RegCODE1);
		p_RegBoard.add(rb_RegCODE2);
		p_RegBoard.add(rb_RegCODE3);
		p_RegBoard.add(rb_RegCODE4);
		
//		group3 = new ButtonGroup();
//		group3.add(rb_RegTerm1);
//		group3.add(rb_RegTerm2);
//		group3.add(rb_RegTerm3);
//		group3.add(rb_RegTerm4);
//		
//		p_RegBoard.add(rb_RegTerm1);
//		p_RegBoard.add(rb_RegTerm2);
//		p_RegBoard.add(rb_RegTerm3);
//		p_RegBoard.add(rb_RegTerm4);
//		
		p_RegMain.add(p_RegBoard);
		
		
		p_RegBtn.add(b_RegSave);
		p_RegBtn.add(b_RegCancel);
		p_RegBtn.add(b_RegExit);
		p_RegMain.add(p_RegBtn);
		
		

		p_RegTitle.setLayout(null);
		p_RegBoard.setLayout(null);
		p_RegBtn.setLayout(null);
		p_RegGender.setLayout(null);
		p_RegCode.setLayout(null);
		p_RegTerm.setLayout(null);
		p_RegMain.setLayout(null);
		jf.setSize(1000,600);
		jf.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().add(p_RegMain, BorderLayout.CENTER);
		
		//2. 이벤트 핸들러 정의
		b_RegSave.addActionListener(this);
		b_RegCancel.addActionListener(this);
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
		/** 수정완료 **/
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
				
				vo.setCno(cno);
				
				int result = dao.getResultUpdate(vo);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "수정완료");
					jf.setVisible(false);
					ui.setUpdateChange();
				}else {
					JOptionPane.showMessageDialog(null, "등록실패");
				}
			}
		}else if(obj == b_RegCancel) { //다시쓰기
			//필드 초기화
			tf_RegName.setText("");
			group1.clearSelection();
			tf_RegAddress.setText("");
			tf_RegPhone.setText("");
			tf_RegBirth_date.setText("");
			group2.clearSelection();
			//group3.clearSelection();
			
			tf_RegName.requestFocus();
		}else if(obj == b_RegExit) {  //나가기
			//회원가입 - 다음 버튼		
			jf.setVisible(false);
			
		}
		
	}
}











