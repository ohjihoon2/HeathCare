package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.*;
import javax.swing.*;

public class InbodyUI extends JFrame implements ActionListener { 


	// Field
	JFrame jf;
	JPanel p_InbMain,cbPanel;
	JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight,l_InbPbf_bodyfat,l_InbPbf_weight,l_InbWhr_waist,l_InbWhr_butt,
	l_InbReBMI, l_InbReWe,l_InbRePBF,l_InbReWHR;
	TextField tf_InbBmi_height, tf_InbBmi_weight,tf_InbPbf_bodyfat,tf_InbPbf_weight,tf_InbWhr_waist,tf_InbWhr_butt,
	tf_InbReBMI,tf_InbReWe,tf_InbRePBF,tf_InbReWHR;
	JCheckBox cb_InbM, cb_InbW;
	JButton b_InbEnter, b_InbReset, b_InbMain;


	// UI ����
	public InbodyUI(JFrame jf) {
		MainScreenUI.status = MainScreenUI.INBODY;
		System.out.println("LectureStatus = "+MainScreenUI.status);
    	this.jf =jf;
    	
//		setLocation(400, 100);
		setLayout(new GridLayout(1, 2));


		p_InbMain = new JPanel();
		p_InbMain.setLayout(null);

		/**
		 * ����
		 **/
		//l_InbMsg = new JLabel("��ü������ �Է��Ͻð� �Ʒ��� üũ��ư�� ��������");

		l_InbMsg = new JLabel("*** ��ü������ �Է��Ͻð� �Ʒ��� üũ��ư�� �������� ***");
		l_InbMsg.setFont(new Font("�������",Font.BOLD,14));
		///////////////////üũ�ڽ�////////////////////////

		cbPanel = new JPanel();
		cb_InbM = new JCheckBox("����");
		cb_InbW = new JCheckBox("����");

		//////////////// BMI ���� ///////////////////////      
		l_InbBmi_height = new JLabel("Ű(cm) :");
		l_InbBmi_height.setFont(new Font("�������",Font.BOLD,15));
		l_InbBmi_weight = new JLabel("������(kg) :");
		l_InbBmi_weight.setFont(new Font("�������",Font.BOLD,15));

		tf_InbBmi_height = new TextField();
		tf_InbBmi_weight = new TextField();

		///////////////// ü����� /////////////////////////
		l_InbPbf_bodyfat = new JLabel("ü����(kg) :");
		l_InbPbf_bodyfat.setFont(new Font("�������",Font.BOLD,15));
		l_InbPbf_weight = new JLabel("������(kg) :");
		l_InbPbf_weight.setFont(new Font("�������",Font.BOLD,15));

		tf_InbPbf_bodyfat = new TextField();
		tf_InbPbf_weight = new TextField();

		///////////////// ��������� ///////////////////////
		l_InbWhr_waist = new JLabel("�㸮�ѷ�(cm) :");
		l_InbWhr_waist.setFont(new Font("�������",Font.BOLD,15));
		l_InbWhr_butt = new JLabel("�����̵ѷ�(cm) :");
		l_InbWhr_butt.setFont(new Font("�������",Font.BOLD,15));

		tf_InbWhr_waist = new TextField();
		tf_InbWhr_butt = new TextField();


		/////////////// üũ, �ٽ��Է� ��ư /////////////////////
		b_InbEnter = new JButton("üũ");
		b_InbReset = new JButton("�ٽ��Է�");
		b_InbMain = new JButton("����");


		/**
		 * ������
		 **/
		JPanel pan2 = new JPanel();

		l_InbReBMI = new JLabel("������(BMI) :");
		l_InbReBMI.setFont(new Font("�������",Font.BOLD,15));
		l_InbReWe = new JLabel("ǥ��ü��(kg) :");
		l_InbReWe.setFont(new Font("�������",Font.BOLD,15));
		tf_InbReBMI = new TextField();
		tf_InbReWe = new TextField();

		l_InbRePBF = new JLabel("ü����� :");
		l_InbRePBF.setFont(new Font("�������",Font.BOLD,15));
		tf_InbRePBF = new TextField();

		l_InbReWHR = new JLabel("��������� :");
		l_InbReWHR.setFont(new Font("�������",Font.BOLD,15));
		tf_InbReWHR = new TextField();


		///////////////////////////////////////////////////////////////////////////////////      
		l_InbMsg.setBounds(100,60,400,20);

		cb_InbM.setBounds(180,130,70,30);   
		cb_InbW.setBounds(260,130,70,30);

		l_InbBmi_height.setBounds(90,200,60,30);      
		l_InbBmi_weight.setBounds(270,200,80,30);
		tf_InbBmi_height.setBounds(150,200,50,30);   
		tf_InbBmi_weight.setBounds(355,200,50,30);

		l_InbPbf_bodyfat.setBounds(70,270,80,50);   
		l_InbPbf_weight.setBounds(270,290,80,15);
		tf_InbPbf_bodyfat.setBounds(150,280,50,30);      
		tf_InbPbf_weight.setBounds(355,280,50,30);

		l_InbWhr_waist.setBounds(50,370,100,25);
		l_InbWhr_butt.setBounds(240,370,110,25);
		tf_InbWhr_waist.setBounds(150,370,50,30);      
		tf_InbWhr_butt.setBounds(355,370,50,30);

		b_InbEnter.setBounds(150,450,60,25);
		b_InbReset.setBounds(220,450,90,25);
		b_InbMain.setBounds(320,450,60,25);

		l_InbReBMI.setBounds(550,200,120,25);
		l_InbReWe.setBounds(750,200,100,25);      
		tf_InbReBMI.setBounds(670,200,50,30);   
		tf_InbReWe.setBounds(850,200,50,30);

		l_InbRePBF.setBounds(590,280,80,25);
		tf_InbRePBF.setBounds(670,280,50,30);   

		l_InbReWHR.setBounds(580,370,80,25);   
		tf_InbReWHR.setBounds(670,370,50,30);



		p_InbMain.add(l_InbMsg);
		p_InbMain.setBackground(Color.LIGHT_GRAY);
		p_InbMain.add(cb_InbM);
		p_InbMain.add(cb_InbW);

		p_InbMain.add(l_InbBmi_height);      
		p_InbMain.add(l_InbBmi_weight);
		p_InbMain.add(tf_InbBmi_height);      
		p_InbMain.add(tf_InbBmi_weight);

		p_InbMain.add(l_InbPbf_bodyfat);
		p_InbMain.add(l_InbPbf_weight);
		p_InbMain.add(tf_InbPbf_bodyfat);
		p_InbMain.add(tf_InbPbf_weight);

		p_InbMain.add(l_InbWhr_waist);      
		p_InbMain.add(l_InbWhr_butt);
		p_InbMain.add(tf_InbWhr_waist);      
		p_InbMain.add(tf_InbWhr_butt);

		p_InbMain.add(b_InbEnter);      
		p_InbMain.add(b_InbReset);
		p_InbMain.add(b_InbMain);

		p_InbMain.add(l_InbReBMI);      
		p_InbMain.add(l_InbReWe);      
		p_InbMain.add(tf_InbReBMI);
		p_InbMain.add(tf_InbReWe);

		p_InbMain.add(l_InbRePBF);
		p_InbMain.add(tf_InbRePBF);

		p_InbMain.add(l_InbReWHR);
		p_InbMain.add(tf_InbReWHR);


		//�̺�Ʈ �ڵ鷯 ���� 
		b_InbEnter.addActionListener(this);
		b_InbReset.addActionListener(this);
		b_InbMain.addActionListener(this);


		p_InbMain.setSize(1000,600);
		p_InbMain.setVisible(true);
		setTitle("�ιٵ� ���α׷�");
		
		jf.getContentPane().add(p_InbMain);

		//      p_InbMain.setLayout(null);
		//      pan1.setLayout(null);
		//      pan2.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}
	
	public void turnoff() {
		System.out.println("Inbody ȭ�� turnoff");
		p_InbMain.setVisible(false);
	}

	public void actionPerformed(ActionEvent arg0) {

	}

}      


   