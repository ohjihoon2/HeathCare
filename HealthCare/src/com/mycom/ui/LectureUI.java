package com.mycom.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LectureUI extends JFrame implements ActionListener{
	
    //field
	MainScreenUI mainui;
	StartUI startui;
	JFrame jf;
	
    JPanel p_gx_main,p_gx_top, p_gx_main2, p_gx_left, p_gx_right, p_gx_pn4, p_gx_l_gx_info, p_gx_name, p_gx_lecture, p_gx_l_gx_times, p_gx_l_gx_limit, p_gx_blank;
    JLabel l_gx_uno, l_gx_info, l_gx_uname, l_gx_lecture, l_gx_times, l_gx_limit;
    JButton b_gx_extension, b_test;
    JTextField jtf_gx_uname, jtf2, jtf_gx_times, jtf_gx_limit;
    
    ImageIcon ic_gx_uimg, ic_gx_topimg;
    JLabel ic_gx_uimgBox, ic_gx_topimgBox;
    
    //constructor
    public LectureUI(MainScreenUI mainui, StartUI startui) {
    	this.mainui = mainui;
    	this.startui = startui;
    	
        p_gx_main = new JPanel();
        p_gx_main.setLayout(new BorderLayout());
        p_gx_top = new JPanel();    
        p_gx_main2 = new JPanel(new GridLayout(1,2));
        p_gx_left = new JPanel(new GridLayout(2,1));
        p_gx_right = new JPanel();
        p_gx_pn4 = new JPanel();
        p_gx_l_gx_info = new JPanel();
        p_gx_name = new JPanel();
        p_gx_lecture = new JPanel();
        p_gx_l_gx_times = new JPanel();
        p_gx_l_gx_limit = new JPanel();
        p_gx_blank = new JPanel();
        

        jtf_gx_uname = new JTextField(30);
        jtf2 = new JTextField(30);
        jtf_gx_times = new JTextField(30);
        jtf_gx_limit = new JTextField(30);
        l_gx_uno = new JLabel("ȸ����ȣ    7805");
        l_gx_info = new JLabel("[  �� ��  �� ��  ]") ;
        l_gx_uname = new JLabel("ȸ�� �̸�");
        l_gx_lecture = new JLabel("������");
        l_gx_times = new JLabel("���� ���� Ƚ��");
        l_gx_limit = new JLabel("��ȿ �Ⱓ");
        b_gx_extension = new JButton("���� ��û");
        b_test = new JButton("���ư���");
             
        l_gx_uno.setBackground(Color.black);
        l_gx_uno.setFont(new Font("����", Font.BOLD, 50));
        l_gx_info.setFont(new Font("����", Font.BOLD, 20));
        
        ic_gx_topimg = new ImageIcon("image/top.png");
        ic_gx_topimgBox = new JLabel(ic_gx_topimg);
        
        
        ic_gx_uimg = new ImageIcon("image/ȸ��.png");
        ic_gx_uimgBox = new JLabel(ic_gx_uimg);

       
        p_gx_main.add("North", p_gx_top);
        p_gx_main.add("Center", p_gx_main2);
        
        
        p_gx_top.add(ic_gx_topimgBox);
        p_gx_main2.add(p_gx_left); p_gx_main2.add(p_gx_right);
        p_gx_left.add(l_gx_uno);  p_gx_left.add(ic_gx_uimgBox);
        
   
        p_gx_l_gx_info.add(l_gx_info);
        p_gx_name.add(l_gx_uname); p_gx_name.add(jtf_gx_uname);
        p_gx_lecture.add(l_gx_lecture); p_gx_lecture.add(jtf2);
        p_gx_l_gx_times.add(l_gx_times); p_gx_l_gx_times.add(jtf_gx_times);
        p_gx_l_gx_limit.add(l_gx_limit); p_gx_l_gx_limit.add(jtf_gx_limit);
        p_gx_right.setLayout(new GridLayout(7,1));
        
        p_gx_right.add(p_gx_blank);
        p_gx_right.add(p_gx_l_gx_info); p_gx_right.add(p_gx_name); p_gx_right.add(p_gx_lecture);
        p_gx_right.add(p_gx_l_gx_times); p_gx_right.add(p_gx_l_gx_limit);
        p_gx_right.add(p_gx_pn4, BorderLayout.SOUTH);
        p_gx_pn4.add(b_gx_extension);
        p_gx_pn4.add(b_test);
        
        p_gx_main.setSize(1000,600);
        p_gx_main.setVisible(true);
        
        startui.jf.getContentPane().add(p_gx_main, BorderLayout.CENTER);
        
        b_test.addActionListener(this);     
    } 
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == b_test) {	//ȸ������ �Ϸ�
			p_gx_main.setVisible(false);
			mainui.p_sc_total.setVisible(true);
		}
		
	}
    
   
}