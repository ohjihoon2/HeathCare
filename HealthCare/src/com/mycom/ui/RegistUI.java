package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistUI extends JFrame implements ActionListener{
	StartUI startui;

	//Field
	JFrame jf;
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegAddress, l_RegContact, l_RegRole, l_RegCreated_date, l_RegBirth, l_RegTerm, l_RegEvent, l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegAddress, tf_RegContact, tf_RegRole, tf_RegCreated_date, tf_RegBirth, tf_RegTerm, tf_RegEvent, tf_RegStart_date, tf_RegEnd_date;
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
		l_RegAddress = new JLabel("�ּ�");
		l_RegContact = new JLabel("����ó");
		l_RegRole = new JLabel("����");
		l_RegCreated_date = new JLabel("ȸ��������");
		l_RegBirth = new JLabel("�������");
		l_RegTerm = new JLabel("��û�Ⱓ");
		l_RegEvent = new JLabel("����");
		l_RegStart_date = new JLabel("������");
		l_RegEnd_date = new JLabel("��������");
		
		
		tf_RegName = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegContact = new JTextField(10);
		tf_RegRole = new JTextField(10);
		tf_RegCreated_date = new JTextField(10);
		tf_RegBirth = new JTextField(10);
		tf_RegTerm = new JTextField(10);
		tf_RegEvent = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		l_RegTitle.setHorizontalAlignment(0);
		p_RegTitle.add(l_RegTitle);
		
		p_RegBoard.add(l_RegName); p_RegBoard.add(tf_RegName);
		p_RegBoard.add(l_RegAddress); p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(l_RegContact); p_RegBoard.add(tf_RegContact);
		p_RegBoard.add(l_RegRole); p_RegBoard.add(tf_RegRole);
		p_RegBoard.add(l_RegCreated_date); p_RegBoard.add(tf_RegCreated_date);
		p_RegBoard.add(l_RegBirth); p_RegBoard.add(tf_RegBirth);
		p_RegBoard.add(l_RegTerm); p_RegBoard.add(tf_RegTerm);
		p_RegBoard.add(l_RegEvent); p_RegBoard.add(tf_RegEvent);
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
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == b_RegSave) {	//ȸ������ �Ϸ�
			//ȸ������ --> VO ���� --> DAO ---> DB 
			
		}else if(obj == b_RegCancel) { //�ٽþ���
			//�ʵ� �ʱ�ȭ
		}else if(obj == b_RegExit) {  //������
			//ȸ������ - ���� ��ư		
			p_RegMain.setVisible(false);
			startui.p_LogMain.setVisible(true);
		}
		
	}
}











