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
import javax.swing.JTextField;

import com.mycom.system.RegistSystem;
import com.mycom.vo.ClientVO;

public class RegistUI extends JFrame implements ActionListener{
	RegistSystem system = new RegistSystem();
	StartUI startui;
	
	//Field
	JFrame jf;
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegSex, l_RegAddress, l_RegPhone, l_RegDivision, l_RegCreated_date, l_RegBirth_date, l_RegEvent_name,  l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegSex, tf_RegAddress, tf_RegPhone, tf_RegDivision, tf_RegCreated_date, tf_RegBirth_date, tf_RegEvent_name,  tf_RegStart_date, tf_RegEnd_date;
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
		l_RegSex = new JLabel("����");
		l_RegAddress = new JLabel("�ּ�");
		l_RegPhone = new JLabel("����ó");
		l_RegDivision = new JLabel("����");
		l_RegCreated_date = new JLabel("ȸ��������");
		l_RegBirth_date = new JLabel("�������");
		l_RegEvent_name = new JLabel("����");
		l_RegStart_date = new JLabel("������");
		l_RegEnd_date = new JLabel("��������");
		
	
		tf_RegName = new JTextField(10);
		tf_RegSex = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegPhone = new JTextField(10);
		tf_RegDivision = new JTextField(10);
		tf_RegCreated_date = new JTextField(10);
		tf_RegBirth_date = new JTextField(10);
		tf_RegEvent_name = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		l_RegTitle.setHorizontalAlignment(0);
		p_RegTitle.add(l_RegTitle);
		
		p_RegBoard.add(l_RegName); p_RegBoard.add(tf_RegName);
		p_RegBoard.add(l_RegSex); p_RegBoard.add(tf_RegSex);
		p_RegBoard.add(l_RegAddress); p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(l_RegPhone); p_RegBoard.add(tf_RegPhone);
		p_RegBoard.add(l_RegDivision); p_RegBoard.add(tf_RegDivision);
		p_RegBoard.add(l_RegCreated_date); p_RegBoard.add(tf_RegCreated_date);
		p_RegBoard.add(l_RegBirth_date); p_RegBoard.add(tf_RegBirth_date);
		p_RegBoard.add(l_RegEvent_name); p_RegBoard.add(tf_RegEvent_name);
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
			result = true;
			tf_RegName.requestFocus();
		}else if(tf_RegAddress.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���");
			result = true;
			tf_RegAddress.requestFocus();
		}
		
		return result;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == b_RegSave) {	//ȸ������ �Ϸ�
			//ȸ������ --> VO ���� --> DAO ---> DB 
			if(regFormCheck()) {
				//2. StuVO ��ü�� �Է��� �����͸� ��Ƽ� -- ��Ͽ�û
				ClientVO vo = new ClientVO();
				vo.setName(tf_RegName.getText());
				vo.setSex(Integer.parseInt(tf_RegSex.getText()));
				vo.setAddress(tf_RegAddress.getText());
				vo.setPhone(tf_RegPhone.getText());
				vo.setDivision(Integer.parseInt(tf_RegDivision.getText()));
				vo.setCreated_date(tf_RegCreated_date.getText());
				vo.setBirth_date(tf_RegBirth_date.getText());
				vo.setEvent_name(tf_RegEvent_name.getText());
				vo.setStart_date(tf_RegStart_date.getText());
				vo.setEnd_date(tf_RegEnd_date.getText());
				
				boolean regResult = system.regist(vo);
				if(regResult) {
					JOptionPane.showMessageDialog(null, "��ϿϷ�");
					
				}else {
					JOptionPane.showMessageDialog(null, "��Ͻ���");
				}
			}
				
		}else if(obj == b_RegCancel) { //�ٽþ���
			//�ʵ� �ʱ�ȭ
		}else if(obj == b_RegExit) {  //������
			//ȸ������ - ���� ��ư		
			p_RegMain.setVisible(false);
			startui.p_LogMain.setVisible(true);
		}
		
	}
}











