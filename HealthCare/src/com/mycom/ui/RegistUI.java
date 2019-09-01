package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegGender, l_RegAddress, l_RegPhone, l_RegBirth_date, l_RegGx_code,  l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegGender, tf_RegAddress, tf_RegPhone, tf_RegBirth_date, tf_RegGx_code,  tf_RegStart_date, tf_RegEnd_date;
	JRadioButton rd_RegEnd_date;
	JButton b_RegSave, b_RegCancel, b_RegExit;
	
	//Constructor
	public RegistUI(StartUI startui){	
		//1. ȭ�鱸��
		// �г� �ʱ�ȭ 
		this.startui = startui;
		
		p_RegMain = new JPanel(new GridLayout(3,1));
		
		p_RegTitle = new JPanel();
		p_RegBoard = new JPanel(new GridLayout(10,2));
		p_RegBtn = new JPanel();
		
		b_RegSave = new JButton("�Ϸ�");
		b_RegCancel = new JButton("�ٽþ���");
		b_RegExit = new JButton("������");
		
		l_RegTitle = new JLabel("ȸ������");
		
		l_RegName = new JLabel("ȸ����");
		l_RegGender = new JLabel("����(M/F)");
		l_RegAddress = new JLabel("�ּ�");
		l_RegPhone = new JLabel("����ó");
		l_RegBirth_date = new JLabel("�������");
		l_RegGx_code = new JLabel("����");
		l_RegStart_date = new JLabel("������");
		l_RegEnd_date = new JLabel("��������");
		
	
		tf_RegName = new JTextField(10);
		tf_RegGender = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegPhone = new JTextField(10);
		tf_RegBirth_date = new JTextField(10);
		tf_RegGx_code = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		l_RegTitle.setHorizontalAlignment(0);
		p_RegTitle.add(l_RegTitle);
		
		p_RegBoard.add(l_RegName); p_RegBoard.add(tf_RegName);
		p_RegBoard.add(l_RegGender); p_RegBoard.add(tf_RegGender);
		p_RegBoard.add(l_RegAddress); p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(l_RegPhone); p_RegBoard.add(tf_RegPhone);
		p_RegBoard.add(l_RegBirth_date); p_RegBoard.add(tf_RegBirth_date);
		p_RegBoard.add(l_RegGx_code); p_RegBoard.add(tf_RegGx_code);
		p_RegBoard.add(l_RegStart_date); p_RegBoard.add(tf_RegStart_date);
		p_RegBoard.add(l_RegEnd_date); p_RegBoard.add(tf_RegEnd_date);
		
		
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
				vo.setGender(tf_RegGender.getText());
				vo.setAddress(tf_RegAddress.getText());
				vo.setPhone(tf_RegPhone.getText());
				vo.setBirth_date(tf_RegBirth_date.getText());
				vo.setGx_code(tf_RegGx_code.getText());
				vo.setStart_date(tf_RegStart_date.getText());
				vo.setEnd_date(tf_RegEnd_date.getText());
				
				boolean regResult = system.regist(vo);
//				int sno = system.
				System.out.println(regResult);
				if(regResult) {
					JOptionPane.showMessageDialog(null, "��ϿϷ�\nȸ������ ��ȣ�� "+system.searchSno()+" �Դϴ�.");
					p_RegMain.setVisible(false);
					startui.p_LogMain.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "��Ͻ���");
				}
			}
		}else if(obj == b_RegCancel) { //�ٽþ���
			//�ʵ� �ʱ�ȭ
			tf_RegName.setText("");
			tf_RegGender.setText("");
			tf_RegAddress.setText("");
			tf_RegPhone.setText("");
			tf_RegBirth_date.setText("");
			tf_RegGx_code.setText("");
			tf_RegStart_date.setText("");
			tf_RegEnd_date.setText("");
			
			tf_RegName.requestFocus();
		}else if(obj == b_RegExit) {  //������
			//ȸ������ - ���� ��ư		
			p_RegMain.setVisible(false);
			startui.p_LogMain.setVisible(true);
		}
		
	}
}











