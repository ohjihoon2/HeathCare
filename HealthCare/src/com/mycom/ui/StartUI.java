package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mycom.system.LoginSystem;
import com.mycom.vo.MemberVO;

import javafx.scene.layout.Background;


public class StartUI extends JFrame implements ActionListener{
	
	/**
	 * ����������
	 */
	MainScreenUI main_calss = null;
	DietUI diet_class = null;
	public static MemberVO vo = new MemberVO();
	
	//Field
	boolean result = false;
	
	//�α��� Field
	JFrame jf;
	JPanel p_LogMain, p_LogLogin , p_LogBtn, p_LogNum, p_LogChoice; 
	JLabel l_Logid;
	JRadioButton rb_LogMember, rb_LogAdmin;
	JTextField tf_LogId;
	JButton b_LogLogin, b_LogCreate, b_Log0, b_Log1, b_Log2, b_Log3, b_Log4, b_Log5, b_Log6, b_Log7, b_Log8, b_Log9, b_LogStar, b_LogRe;
	StringBuffer sb;
	ImageIcon ic_gx_topimg,ic_gx_topimg2,ic_gx_topimg3;
    JLabel ic_gx_yogaBox,ic_gx_yogaBox2,ic_gx_yogaBox3;
	
	//ȸ������ Field
	/**
	 * �α��� 
	 */
	//Constructor
    public StartUI() {   	
		//1. ȭ�鱸��
		// �г� �ʱ�ȭ 
    	jf = new JFrame();
    	
		p_LogMain = new JPanel();
		
		p_LogChoice = new JPanel();
		p_LogLogin = new JPanel();
		p_LogBtn = new JPanel();
		p_LogNum = new JPanel(); 
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_LogNum.setBorder(b1);
		
		rb_LogMember = new JRadioButton("ȸ��");
		rb_LogAdmin = new JRadioButton("������");
 
		b_Log1 = new JButton("1"); 
		b_Log2 = new JButton("2"); 
		b_Log3 = new JButton("3");
		b_Log4 = new JButton("4");
		b_Log5 = new JButton("5");
		b_Log6 = new JButton("6");
		b_Log7 = new JButton("7");
		b_Log8 = new JButton("8");
		b_Log9 = new JButton("9");
		b_LogStar = new JButton("*"); 
		b_Log0 = new JButton("0");
		b_LogRe = new JButton("����"); 

		b_LogLogin = new JButton("�α���");
		b_LogCreate = new JButton("ȸ������");

		
		sb = new StringBuffer();
		
		l_Logid = new JLabel("ID : ");
		tf_LogId = new JTextField(20);
		
		tf_LogId.setText(sb.toString());
		
		ButtonGroup group = new ButtonGroup();
		group.add(rb_LogMember);
		group.add(rb_LogAdmin);
		
		rb_LogMember.setBackground(new Color(255,255,255));
	
		rb_LogAdmin.setBackground(new Color(255,255,255));
		ic_gx_topimg = new ImageIcon("image/logo3.jpg");
		ic_gx_yogaBox = new JLabel(ic_gx_topimg); 
		
		ic_gx_topimg2 = new ImageIcon("image/start.png");
		ic_gx_yogaBox2 = new JLabel(ic_gx_topimg2);
		
		ic_gx_topimg3 = new ImageIcon("image/start2.png");
		ic_gx_yogaBox3 = new JLabel(ic_gx_topimg3);
		
		ic_gx_yogaBox.setBounds(0,0,1000,90);
		ic_gx_yogaBox2.setBounds(700,85,200,200);
		ic_gx_yogaBox3.setBounds(0,150,300,500);
		
		p_LogNum.setBounds(300,120,400,420);
		rb_LogMember.setBounds(130,10,80,20);
		rb_LogAdmin.setBounds(210,10,80,20);
		
		l_Logid.setBounds(70,50,100,30);
		tf_LogId.setBounds(100,50,200,30);
		
		b_Log1.setBounds(50,120,100,50);
		b_Log2.setBounds(150,120,100,50);
		b_Log3.setBounds(250,120,100,50);
		b_Log4.setBounds(50,170,100,50);
		b_Log5.setBounds(150,170,100,50);
		b_Log6.setBounds(250,170,100,50);
		b_Log7.setBounds(50,220,100,50);
		b_Log8.setBounds(150,220,100,50);
		b_Log9.setBounds(250,220,100,50);
		b_Log0.setBounds(150,270,100,50);
		b_LogStar.setBounds(50,270,100,50);
		b_LogRe.setBounds(250,270,100,50);
		b_LogLogin.setBounds(90,360,90,30);
		b_LogCreate.setBounds(220,360,90,30);
		
		p_LogMain.add(ic_gx_yogaBox);
		p_LogMain.add(ic_gx_yogaBox2);
		p_LogMain.add(ic_gx_yogaBox3);
		
		
		p_LogNum.add(l_Logid);
		p_LogNum.add(tf_LogId);
		p_LogNum.add(rb_LogMember);
		p_LogNum.add(rb_LogAdmin);
		
		p_LogNum.add(b_Log1);
		p_LogNum.add(b_Log2);
		p_LogNum.add(b_Log3);
		p_LogNum.add(b_Log4);
		p_LogNum.add(b_Log5);
		p_LogNum.add(b_Log6);
		p_LogNum.add(b_Log7);
		p_LogNum.add(b_Log8);
		p_LogNum.add(b_Log9);
		p_LogNum.add(b_LogStar);
		p_LogNum.add(b_Log0);
		p_LogNum.add(b_LogRe);
		p_LogNum.add(b_LogLogin);
		p_LogNum.add(b_LogCreate);
		
		p_LogMain.add(p_LogNum);
		
	
		
		
		
		jf.getContentPane().add(p_LogMain, BorderLayout.CENTER);
		
		jf.setSize(1000,600);
//		p_LogNum.setSize(600, 400);
//		p_LogNum.setBounds(200,200,350,200);
		jf.setLocation(500	, 20);
		
		p_LogNum.setLayout(null);
		p_LogMain.setLayout(null);
		
		p_LogChoice.setBackground(Color.WHITE);
		p_LogLogin.setBackground(Color.WHITE);
		p_LogNum.setBackground(Color.WHITE);
		p_LogBtn.setBackground(Color.WHITE);
		jf.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//2. �̺�Ʈ �ڵ鷯 ����
		b_LogLogin.addActionListener(this);
		b_LogCreate.addActionListener(this);
		b_Log1.addActionListener(this);
		b_Log2.addActionListener(this);
		b_Log3.addActionListener(this);
		b_Log4.addActionListener(this);
		b_Log5.addActionListener(this);
		b_Log6.addActionListener(this);
		b_Log7.addActionListener(this);
		b_Log8.addActionListener(this);
		b_Log9.addActionListener(this);
		b_Log0.addActionListener(this);
		b_LogStar.addActionListener(this);
		b_LogRe.addActionListener(this);
		
    }
    
	//Method	
    public boolean regFormCheck() {
		boolean result = false;
		
		if(tf_LogId.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "���̵� ��ȣ�� �Է����ּ���");
			tf_LogId.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}    
    
    
    /**
     * �α���
     */
    public void login() {
    	
    	if(regFormCheck()) {
    		LoginSystem system = new LoginSystem();
    		int result = system.loginCheck(Integer.parseInt(tf_LogId.getText().trim()));
    		System.out.println("result = "+ result);
    		if(result == 1 && !rb_LogAdmin.isSelected()) {
    			
    			JOptionPane.showMessageDialog(null, "�α��� ����");
    			p_LogMain.setVisible(false);
    			System.out.println("div = " +vo.getDivision());
    			new MainScreenUI(this);
    			
    		}else if(result == 2 && rb_LogAdmin.isSelected()) {
    			JOptionPane.showMessageDialog(null, "�α��� ����");
//    			p_LogMain.setVisible(false);
    			System.out.println("div = " +vo.getDivision());
    			p_LogMain.setVisible(false); 
    			new AdminUI(this);
    			
    		}else if(result ==0){
    			JOptionPane.showMessageDialog(null, "�α��� ����");
    			tf_LogId.setText("");
    			sb.delete(0, sb.length());
    			tf_LogId.requestFocus();
    		}
    		
    	}
    }
    
    
    
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == b_LogCreate) {
			//ȸ������
			p_LogMain.setVisible(false); 
			new RegistUI(this);
		}else if (obj == b_LogLogin) {
			//�α���
				login();
		}else if(obj == b_Log0) {
			sb.append(0);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log1) {
			sb.append(1);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log2) {
			sb.append(2);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log3) {
			sb.append(3);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log4) {
			sb.append(4);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log5) {
			sb.append(5);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log6) {
			sb.append(6);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log7) {
			sb.append(7);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log8) {
			sb.append(8);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_Log9) {
			sb.append(9);
			tf_LogId.setText(sb.toString());
		}else if(obj == b_LogRe) {
			tf_LogId.setText("");
			sb.delete(0, sb.length());
		}
		
	}
	
	
	
}











