package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mycom.dao.LectureDAO;
import com.mycom.system.LectureSystem;
import com.mycom.vo.LectureVO;


public class LectureUI extends JFrame implements ActionListener{
	
    //field
	MainScreenUI mainui;
	StartUI startui;
	JFrame jf;
	
	
    JPanel p_gx_main,p_gx_top, p_gx_main2, p_gx_left, p_gx_right, p_gx_btn, p_gx_cno,
    		p_gx_info, p_gx_cname, p_gx_gxname, p_gx_count, p_gx_validity, p_gx_blank;
    JLabel l_gx_cno, l_gx_info, l_gx_cname, l_gx_gxname, l_gx_count, l_gx_validity;
    JButton b_gx_regist, b_back;
    JTextField jtf_gx_cno, jtf_gx_cname, jtf_gx_gxname, jtf_gx_validity;
    static JTextField jtf_gx_count;
   
    ImageIcon ic_gx_uimg, ic_gx_topimg;
    JLabel ic_gx_uimgBox, ic_gx_topimgBox;
 //, l_gx_uname , jtf_gx_uname
   
    
    //constructor
    public LectureUI(MainScreenUI mainui, StartUI startui) {
    	this.mainui = mainui;
    	this.startui = startui;
    	
        p_gx_main = new JPanel();
        p_gx_main.setLayout(new BorderLayout());
        p_gx_top = new JPanel();    
        p_gx_main2 = new JPanel(new GridLayout(1,2));
        p_gx_left = new JPanel(new GridLayout(2,1));
        p_gx_cno = new JPanel();
        p_gx_right = new JPanel();
        p_gx_btn = new JPanel();
        p_gx_info = new JPanel();
        p_gx_cname = new JPanel();
        p_gx_gxname = new JPanel();
        p_gx_count = new JPanel();
        p_gx_validity = new JPanel();
        p_gx_blank = new JPanel();
        
        
        l_gx_info = new JLabel("[  �� ��  �� ��  ]") ;
        l_gx_cno = new JLabel("ȸ����ȣ ");
        jtf_gx_cno = new JTextField(20);
        l_gx_cname = new JLabel("ȸ���̸� ");
        jtf_gx_cname = new JTextField(20);
        l_gx_gxname = new JLabel("������");
        jtf_gx_gxname = new JTextField(30);
        l_gx_count = new JLabel("���� ���� Ƚ��");
        jtf_gx_count = new JTextField(30);
        l_gx_validity = new JLabel("��ȿ �Ⱓ");
        jtf_gx_validity = new JTextField(30);
        b_gx_regist = new JButton("���� ��û");
        b_back = new JButton("���ư���");
             
        l_gx_cno.setBackground(Color.black);
        l_gx_cno.setFont(new Font("����", Font.BOLD, 50));
        l_gx_info.setFont(new Font("����", Font.BOLD, 20));
        
        ic_gx_topimg = new ImageIcon("image/top.png");
        ic_gx_topimgBox = new JLabel(ic_gx_topimg);
        
        
        ic_gx_uimg = new ImageIcon("image/ȸ��.png");
        ic_gx_uimgBox = new JLabel(ic_gx_uimg);

       
        p_gx_main.add("North", p_gx_top);
        p_gx_main.add("Center", p_gx_main2);
        
        
        p_gx_top.add(ic_gx_topimgBox);
        p_gx_main2.add(p_gx_left); p_gx_main2.add(p_gx_right);
        p_gx_cno.add(l_gx_cno);  p_gx_cno.add(jtf_gx_cno);
        p_gx_left.add(p_gx_cno);  
        p_gx_left.add(ic_gx_uimgBox);
   
        p_gx_info.add(l_gx_info);
        p_gx_cname.add(l_gx_cname); p_gx_cname.add(jtf_gx_cname);
        p_gx_gxname.add(l_gx_gxname); p_gx_gxname.add(jtf_gx_gxname);
        p_gx_count.add(l_gx_count); p_gx_count.add(jtf_gx_count);
        p_gx_validity.add(l_gx_validity); p_gx_validity.add(jtf_gx_validity);
        
        p_gx_right.setLayout(new GridLayout(7,1));      
        p_gx_right.add(p_gx_blank);
        p_gx_right.add(p_gx_info); p_gx_right.add(p_gx_cname); p_gx_right.add(p_gx_gxname);
        p_gx_right.add(p_gx_count); p_gx_right.add(p_gx_validity);
        p_gx_right.add(p_gx_btn, BorderLayout.SOUTH);
        p_gx_btn.add(b_gx_regist);
        p_gx_btn.add(b_back);
        
        p_gx_main.setSize(1000,600);
        p_gx_main.setVisible(true);
        
        startui.jf.getContentPane().add(p_gx_main, BorderLayout.CENTER);
        
        b_gx_regist.addActionListener(this);
        b_back.addActionListener(this);  
        
        
        //ȭ�鿡 ȸ������ ����ֱ�
        LectureSystem system = new LectureSystem();        
        LectureVO vo = system.getListVO(Integer.parseInt(startui.tf_LogId.getText().trim()));
        
        if(vo != null) {
        	jtf_gx_cno.setText(String.valueOf(vo.getCno()));
        	jtf_gx_cname.setText(vo.getCname());
        	jtf_gx_gxname.setText(vo.getGx_code());
        	jtf_gx_count.setText(String.valueOf(vo.getGx_count()));
        	jtf_gx_validity.setText(String.valueOf(vo.getGx_validity()));
        	
        }
        
    } 
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == b_back) {	//ȸ������ �Ϸ�
			p_gx_main.setVisible(false);
			mainui.p_sc_total.setVisible(true);
			
		}else if(obj == b_gx_regist) {//�������
			//new RegistLecture(Integer.parseInt(jtf_gx_cno.getText()));
			new RegistLecture(StartUI.vo.getCno());
		
		}
		
	}
    
	
   
}

class RegistLecture extends JFrame implements ActionListener{
	//field
		JPanel jp;
		JLabel jl_gx_cno, jl_gx_list, jl_gx_name, jl_gx_count, jl_gx_totprice;
		JTextField jtf_gx_cno, jtf_gx_list,jtf_gx_name, jtf_gx_excount, jtf_gx_totprice;
		JTextArea jta_gx_list;
		JButton btn_reg, btn_calprice;
		JComboBox jcb_gxname, jcb_count;//->vector�����ͷ� ��
		
		LectureSystem system;
		
		//constructor
		public RegistLecture(int cno) {			
			jp = new JPanel(new GridLayout(6,2));
			jl_gx_cno=new JLabel("ȸ����ȣ");
			jtf_gx_cno = new JTextField(20);
			jtf_gx_cno.setText(Integer.toString(cno));
			
			jta_gx_list = new JTextArea(1,1);
			jl_gx_list = new JLabel("��������Ʈ");
			jtf_gx_list = new JTextField(20);
			
			jl_gx_name = new JLabel("�� �� ��");
			jtf_gx_name = new JTextField(20);
			
			jl_gx_count = new JLabel("���� Ƚ��");
			jtf_gx_excount = new JTextField(20);
			
			jl_gx_totprice = new JLabel("�� �ݾ�");
			jtf_gx_totprice = new JTextField(20);
			
			
			btn_reg = new JButton("  ��    ��  ");
			btn_calprice = new JButton("�ݾ� ��� Ȯ��");
			
			Vector lecturenameList = new Vector();
			lecturenameList.add("�����ϼ���");
			lecturenameList.add("�䰡(101)");
			lecturenameList.add("�ܹ�(102)");
			lecturenameList.add("���Ǵ�(103)");
			jcb_gxname = new JComboBox(lecturenameList);
			
			Vector extensionList = new Vector();
			extensionList.add("�����ϼ���");
			extensionList.add("5ȸ");
			extensionList.add("10ȸ");
			extensionList.add("20ȸ");
			jcb_count = new JComboBox(extensionList);
			
			jp.add(jl_gx_cno); jp.add(jtf_gx_cno);
			jp.add(jl_gx_list);jp.add(jta_gx_list);
//			jp.add(jl_gx_list);jp.add(jtf_gx_list);
			jp.add(jl_gx_name); jp.add(jcb_gxname);
			jp.add(jl_gx_count); jp.add(jcb_count);
			jp.add(jl_gx_totprice); jp.add(jtf_gx_totprice);
			jp.add(btn_reg); jp.add(btn_calprice);
			
			
			getContentPane().add(jp);
			setSize(500,500);
			setVisible(true);
			
			
			//��������Ʈ ���
			system = new LectureSystem();			
			ArrayList<LectureVO> list = system.uplistVO();	
			
			jta_gx_list.append("�����ڵ�\t������(GX)\t����(1ȸ��)\n");
			for(LectureVO vo : list) {
				if(vo != null) {
					jta_gx_list.append(vo.getGx_code()+"\t");
					jta_gx_list.append(vo.getGx_name()+"\t");
					jta_gx_list.append(vo.getGx_price()+"\n");

				}
			}
										
			
			//�̺�Ʈ ȣ��
			btn_reg.addActionListener(this);
			btn_calprice.addActionListener(this);
			
		}
		
		//��ȿ��üũ
		public boolean redFromCheck() {
			boolean result = false;
			
			if(jcb_gxname.getSelectedItem().equals("�������ּ���")) {
				JOptionPane.showMessageDialog(null, "������ ������ �ּ���");	
				
			}else if(jcb_count.getSelectedItem().equals("�������ּ���")){
				JOptionPane.showMessageDialog(null, "Ƚ���� ������ �ּ���");

			}else if(jtf_gx_totprice.getText().equals("")){
				JOptionPane.showMessageDialog(null, "�� �ݾ��� Ȯ���� �ּ���");

			}else {
				JOptionPane.showConfirmDialog(null, "���� ��� �Ͻðڽ��ϱ�?");
				result=true;
			}
			
			return result;
		}
		
		//method
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj==btn_calprice) {				
				JOptionPane.showMessageDialog(null, "�ݾ� ��� Ȯ��");
				
				String gxname = (String)jcb_gxname.getSelectedItem();			
				String gx_code = "";
				
				int gx_price =0;				
				if(gxname.equals("�䰡(101)"))	{
					gx_code ="101"; 
					gx_price =10000;
	
				}else if(gxname.equals("�ܹ�(102)")) {
					gx_code = "102";
					gx_price =10000;
				
				}else if(gxname.equals("���Ǵ�(103)")) {
					gx_code = "103";
					gx_price =12000;

				}		
				
				String extension = (String)jcb_count.getSelectedItem();
				
				int count = 0;
				if(extension.equals("5ȸ"))		count =5;
				else if(extension.equals("10ȸ"))	count = 10;
				else if(extension.equals("20ȸ"))	count = 20;
				
				jtf_gx_totprice.setText(String.valueOf(count*gx_price)); 
				

			}else if(obj == btn_reg) {//String�� intŸ�� ���߱� ; Integer.parseInt(), String.valueOf();
				//vo ���� : ������					
				LectureVO vo = new LectureVO();
				boolean check = redFromCheck();
				if(check) {
					String gxname = (String)jcb_gxname.getSelectedItem();	

					String gx_code = "";
					int gx_price =0;				
					if(gxname.equals("�䰡(101)")	){
						gx_code ="101"; 
						gx_price =10000;
		
					}else if(gxname.equals("�ܹ�(102)")) {
						gx_code = "102";
						gx_price =10000;
					
					}else if(gxname.equals("���Ǵ�(103)")) {
						gx_code = "103";
						gx_price =12000;

					}	

					String extension = (String)jcb_count.getSelectedItem();
					
					int count = 0;
					if(extension.equals("5ȸ"))		count =5;
					else if(extension.equals("10ȸ"))	count = 10;
					else if(extension.equals("20ȸ"))	count = 20;
							
					
					vo.setCno(Integer.parseInt(jtf_gx_cno.getText()));
					vo.setGx_code(gx_code);			
					vo.setGx_count(Integer.parseInt(LectureUI.jtf_gx_count.getText())+count);									
					vo.setGx_totprice(Integer.parseInt(jtf_gx_totprice.getText())+StartUI.vo.getGx_price());	
					
					
				}
		
				
				
				//dao ����: DB ���� -> ���
				boolean result = system.update(vo);			
				if(result) {
					JOptionPane.showMessageDialog(null, "��� ����");
					
				}else {
					JOptionPane.showMessageDialog(null, "��� ����");
				}
				
			}
		}
				
}