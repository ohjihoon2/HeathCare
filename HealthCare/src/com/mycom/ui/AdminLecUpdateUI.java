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
import com.mycom.vo.LectureVO;
import com.mycom.vo.MemberVO;

public class AdminLecUpdateUI extends JFrame implements ActionListener{
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
	String code;
	
	//Constructor
	public AdminLecUpdateUI(String code, AdminUI ui){	
		this.ui = ui;
		this.code = code;
		System.out.println(code);
		//1. 화면구성
		// 패널 초기화 
		
		LectureVO lvo = dao.getlecture(code);
		
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
		
		l_RegTitle = new JLabel("수업수정");
		l_RegTitle.setFont(new Font("나눔고딕",Font.BOLD,26));
		
		l_RegName = new JLabel("종목코드");
		l_RegName.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegAddress = new JLabel("종목명");
		l_RegAddress.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_RegPhone = new JLabel("금액");
		l_RegPhone.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		
		tf_RegName = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegPhone = new JTextField(10);
		
		
		/**리스트에서 정보 가져오기**/
		tf_RegName.setText(lvo.getGx_code());
		tf_RegName.setEditable(false);
		tf_RegAddress.setText(lvo.getGx_name());
		tf_RegPhone.setText(String.valueOf(lvo.getGx_price()));
		
		
		p_RegTitle.setBounds(0,0,980,70);
		p_RegTitle.setBackground(Color.WHITE);
		l_RegTitle.setBounds(440,20,200,30);
		
		p_RegBoard.setBounds(0,90,980,380);
		p_RegBoard.setBackground(Color.WHITE);
		l_RegName.setBounds(300,80,100,20);
		l_RegAddress.setBounds(300,180,100,20);
		l_RegPhone.setBounds(300,280,100,20);
		
		tf_RegName.setBounds(400,80,300,20);
		tf_RegAddress.setBounds(400,180,300,20);
		tf_RegPhone.setBounds(400,280,300,20);
		
		p_RegBtn.setBounds(0,480,980,70);
		b_RegSave.setBounds(320,15,100,30);
		b_RegCancel.setBounds(450,15,100,30);
		b_RegExit.setBounds(580,15,100,30);
		
		p_RegTitle.add(l_RegTitle);
		p_RegMain.add(p_RegTitle);
		
		p_RegBoard.add(l_RegName);
		p_RegBoard.add(l_RegAddress);
		p_RegBoard.add(l_RegPhone);
		
		p_RegBoard.add(tf_RegName);
		p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(tf_RegPhone);
		
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
		
		if(tf_RegAddress.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "종목명 입력해주세요");
			tf_RegAddress.requestFocus();
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
				LectureVO lvo = new LectureVO();
				
				lvo.setGx_name(tf_RegAddress.getText());
				lvo.setGx_price(Integer.parseInt(tf_RegPhone.getText()));
				lvo.setGx_code(code);
				
				int result = dao.getLectureUpdate(lvo);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "수정완료");
					jf.setVisible(false);
					ui.setUpdateChange2();
				}else {
					JOptionPane.showMessageDialog(null, "등록실패");
				}
			}
		}else if(obj == b_RegCancel) { //다시쓰기
			//필드 초기화
			tf_RegName.setText("");
			tf_RegAddress.setText("");
			tf_RegPhone.setText("");
			
			tf_RegName.requestFocus();
		}else if(obj == b_RegExit) {  //나가기
			//회원가입 - 다음 버튼		
			jf.setVisible(false);
			
		}
		
	}
}











