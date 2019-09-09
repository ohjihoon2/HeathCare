package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycom.dao.LectureDAO;
import com.mycom.system.LectureSystem;
import com.mycom.vo.LectureVO;

public class LectureUI implements ActionListener{	
    //field
	MainScreenUI mainui;
	StartUI startui;	
	LectureSystem system = new LectureSystem();
	
    JPanel p_gx_main,p_gx_top, p_gx_main2, p_gx_left, p_gx_table, p_gx_picture, p_picture, p_button, p_gx_right, p_gx_btn, p_gx_cno,
    		p_gx_info, p_gx_cname, p_gx_gxname, p_gx_count, p_gx_validity, p_gx_blank1, p_gx_blank2;
    JLabel l_gx_cno, l_gx_info, l_gx_cname, l_gx_gxname, l_gx_count, l_gx_validity;
    JButton b_gx_regist, b_back;
    JTable table;
    JScrollPane js;
    ArrayList<LectureVO> list;
    DefaultTableModel jmodel= null;
    JTextField jtf_gx_cno, jtf_gx_cname, jtf_gx_gxname, jtf_gx_validity;
    static JTextField jtf_gx_count;
   
    ImageIcon ic_gx_topimg, ic_gx_yoga, ic_gx_zumba, ic_gx_spinning, ic_gx_yoga1, ic_gx_zumba1, ic_gx_spinning1;
    JLabel ic_gx_yogaBox, ic_gx_zumbaBox, ic_gx_spinningBox, ic_gx_topimgBox;

   
    
    //constructor
    public LectureUI(MainScreenUI mainui, StartUI startui) {
    	this.mainui = mainui;
    	this.startui = startui;
    	
    	//GX_table
    	list = system.uplistVO();
		
		Vector<String> columnList = new Vector<String>();
		columnList.add("GX�ڵ�");
		columnList.add("GX�̸�");
		columnList.add("GX����(ȸ��)");
		
		jmodel = new DefaultTableModel(columnList,0);
		for(LectureVO vo: list) {
			Vector<String> v = new Vector<String>();
			v.add(vo.getGx_code());
			v.add(vo.getGx_name());
			v.add(String.valueOf(vo.getGx_price()));
			
			jmodel.addRow(v);  
		}	
    	
        p_gx_main = new JPanel();
        p_gx_main.setLayout(new BorderLayout());
        p_gx_top = new JPanel();          
        p_gx_main2 = new JPanel(new GridLayout(1,2));
           
        p_gx_left = new JPanel(new GridLayout(7,1));
        p_gx_info = new JPanel();
        p_gx_cno = new JPanel();
        p_gx_cname = new JPanel();
        p_gx_gxname = new JPanel();
        p_gx_count = new JPanel();
        p_gx_validity = new JPanel();
        p_gx_blank1 = new JPanel();
        p_gx_blank2 = new JPanel();

        p_gx_btn = new JPanel();
        
        p_gx_right = new JPanel(new GridLayout(2,1));
        p_gx_table = new JPanel(new GridLayout(2,1));
        table = new JTable(jmodel); 
        js = new JScrollPane(table);
        p_gx_picture = new JPanel(new GridLayout(2,1));
        p_picture = new JPanel();
        p_button = new JPanel();
       //new GridLayout(1,3)
        
        l_gx_info = new JLabel("[  �� ��  �� ��  ]") ;
        l_gx_info.setFont(new Font("����", Font.BOLD, 20));
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
             
        
        ic_gx_topimg = new ImageIcon("image/gymlabel.png");
        ic_gx_topimgBox = new JLabel(ic_gx_topimg);        
//      ImageIcon img_icon = new ImageIcon(path);
//		Image img1 = img_icon.getImage();
//		Image img2 = img1.getScaledInstance(80, 55, Image.SCALE_DEFAULT);
//		ImageIcon img_icon2 = new ImageIcon(img2);
        
        
        ic_gx_yoga = new ImageIcon("image/yoga.jpg");
        Image img1 = ic_gx_yoga.getImage();
        Image yoga = img1.getScaledInstance(140,110, Image.SCALE_DEFAULT);
        ic_gx_yoga1 = new ImageIcon(yoga);
        ic_gx_yogaBox = new JLabel(ic_gx_yoga1);
        
        ic_gx_zumba = new ImageIcon("image/zumba.jpg");
        Image img2 = ic_gx_zumba.getImage();
        Image zumba = img2.getScaledInstance(140,110, Image.SCALE_DEFAULT);
        ic_gx_zumba1 = new ImageIcon(zumba);
        ic_gx_zumbaBox = new JLabel(ic_gx_zumba1);
        
        ic_gx_spinning = new ImageIcon("image/spinning.PNG");
        Image img3 = ic_gx_spinning.getImage();
        Image spinning = img3.getScaledInstance(140,110, Image.SCALE_DEFAULT);
        ic_gx_spinning1 = new ImageIcon(spinning);
        ic_gx_spinningBox = new JLabel(ic_gx_spinning1);

        
        p_gx_main.add("North", p_gx_top);
        p_gx_main.add("Center", p_gx_main2);
        
        
        
        p_gx_top.add(ic_gx_topimgBox);
        p_gx_main2.add(p_gx_left); p_gx_main2.add(p_gx_right);
        
        p_gx_info.add(l_gx_info);
        p_gx_cno.add(l_gx_cno);  p_gx_cno.add(jtf_gx_cno);
        p_gx_cname.add(l_gx_cname); p_gx_cname.add(jtf_gx_cname);
        p_gx_gxname.add(l_gx_gxname); p_gx_gxname.add(jtf_gx_gxname);
        p_gx_count.add(l_gx_count); p_gx_count.add(jtf_gx_count);
        p_gx_validity.add(l_gx_validity); p_gx_validity.add(jtf_gx_validity);
        
        p_gx_left.add(p_gx_blank1);
        p_gx_left.add(p_gx_info);
        p_gx_left.add(p_gx_cno); p_gx_left.add(p_gx_cname); p_gx_left.add(p_gx_gxname);
        p_gx_left.add(p_gx_count); p_gx_left.add(p_gx_validity);
        
        p_gx_right.add(p_gx_table);        
        p_gx_table.add(p_gx_blank2); 
        p_gx_table.add(js);
        p_gx_right.add(p_gx_picture);
        p_gx_picture.add(p_picture); p_gx_picture.add(p_button);
        p_picture.add(ic_gx_yogaBox);
        p_picture.add(ic_gx_zumbaBox);
        p_picture.add(ic_gx_spinningBox);
        p_button.add(p_gx_btn, BorderLayout.SOUTH);
        
        p_gx_btn.add(b_gx_regist);  p_gx_btn.add(b_back);
        
        p_gx_main.setSize(1000,600);
        p_gx_main.setVisible(true);
        
        startui.jf.getContentPane().add(p_gx_main);
        
        //�̺�Ʈ ó��
        b_gx_regist.addActionListener(this);
        b_back.addActionListener(this);  
        
        
        //ȭ�鿡 ȸ������ ����ֱ�
        LectureSystem system = new LectureSystem();        
        LectureVO vo = system.getListVO(StartUI.vo.getCno());
        
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
		
		if(obj == b_back) {	//���ư���
			p_gx_main.setVisible(false);
//			mainui.p_sc_total.setVisible(true);
			new MainScreenUI(startui);
			
		}else if(obj == b_gx_regist) {//���� ��û
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