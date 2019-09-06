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

public class RegistUI extends JFrame implements ActionListener{
	RegistSystem system = new RegistSystem();
	StartUI startui;
	
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
	public RegistUI(StartUI startui){	
		//1. ȭ�鱸��
		// �г� �ʱ�ȭ 
		this.startui = startui;
		
		p_RegMain = new JPanel(new GridLayout(3,1));
		
		p_RegTitle = new JPanel();
		p_RegBoard = new JPanel(new GridLayout(10,2));
		p_RegBtn = new JPanel();
		p_RegGender = new JPanel();
		p_RegCode = new JPanel();
		p_RegTerm = new JPanel();
		
		b_RegSave = new JButton("�Ϸ�");
		b_RegCancel = new JButton("�ٽþ���");
		b_RegExit = new JButton("������");
		
		l_RegTitle = new JLabel("ȸ������");
		
		l_RegName = new JLabel("ȸ����");
		l_RegGender = new JLabel("����");
		l_RegAddress = new JLabel("�ּ�");
		l_RegPhone = new JLabel("����ó");
		l_RegBirth_date = new JLabel("�������");
		l_RegGx_code = new JLabel("����");
		l_RegStart_date = new JLabel("������");
		l_RegEnd_date = new JLabel("�ｺ�Ⱓ");
	
		tf_RegName = new JTextField(10);
		
		rb_RegMen = new JRadioButton("��");
		rb_RegWomen= new JRadioButton("��");
		
		rb_RegCODE1 = new JRadioButton("�ｺ");
		rb_RegCODE2 = new JRadioButton("�䰡");
		rb_RegCODE3 = new JRadioButton("�ܹ�");
		rb_RegCODE4 = new JRadioButton("���Ǵ�");
		
		rb_RegTerm1 = new JRadioButton("1����");
		rb_RegTerm2 = new JRadioButton("3����");
		rb_RegTerm3 = new JRadioButton("6����");
		rb_RegTerm4 = new JRadioButton("12����");
		
		tf_RegAddress = new JTextField(10);
		tf_RegPhone = new JTextField(10);
		tf_RegBirth_date = new JTextField(10);
		tf_RegGx_code = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
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
		p_RegBtn.add(b_RegCancel);
		p_RegBtn.add(b_RegExit);
		
		
		p_RegMain.add(p_RegTitle);		
		p_RegMain.add(p_RegBoard);		
		p_RegMain.add(p_RegBtn);		
		
//			setTitle("ȸ������");
//			getContentPane().add(p_RegMain, BorderLayout.CENTER);
		p_RegMain.setSize(1000,600);
		p_RegMain.setVisible(true);
//			setBounds(200,200,350,200);
//			setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startui.jf.getContentPane().add(p_RegMain, BorderLayout.CENTER);
		
		//2. �̺�Ʈ �ڵ鷯 ����
		b_RegSave.addActionListener(this);
		b_RegCancel.addActionListener(this);
		b_RegExit.addActionListener(this);
	}
	
	
	//Method
	public boolean regFormCheck() {
		boolean result = false;
		
		if(tf_RegName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���");
			tf_RegName.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == b_RegSave) {	//ȸ������ �Ϸ�
			//ȸ������ --> VO ���� --> DAO ---> DB 
			if(regFormCheck()) {
				//2. MemberVO ��ü�� �Է��� �����͸� ��Ƽ� -- ��Ͽ�û
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
				
				boolean regResult = system.regist(vo);
//				int sno = system.
				System.out.println(regResult);
				if(regResult) {
					JOptionPane.showMessageDialog(null, "��ϿϷ�\nȸ������ ��ȣ�� "+system.searchSno(vo.getName())+" �Դϴ�.");
					p_RegMain.setVisible(false);
					startui.p_LogMain.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "��Ͻ���");
				}
			}
		}else if(obj == b_RegCancel) { //�ٽþ���
			//�ʵ� �ʱ�ȭ
			tf_RegName.setText("");
			group1.clearSelection();
			tf_RegAddress.setText("");
			tf_RegPhone.setText("");
			tf_RegBirth_date.setText("");
			group2.clearSelection();
			group3.clearSelection();
			
			tf_RegName.requestFocus();
		}else if(obj == b_RegExit) {  //������
			//ȸ������ - ���� ��ư		
			p_RegMain.setVisible(false);
			startui.p_LogMain.setVisible(true);
		}
		
	}
}











