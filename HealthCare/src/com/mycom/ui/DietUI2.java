package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.StringValueExp;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mycom.dao.DietDAO;
import com.mycom.system.DietSystem;
import com.mycom.vo.DietMemberVO;
import com.mycom.vo.DietSaveVO;


public class DietUI2 extends JFrame implements ActionListener {
	//Field
	DietUI ui;
	DietDAO dao = new DietDAO();
	JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	
	JLabel l_Diettitle,l_DietDwNO, l_DietCno, l_Dietdate,l_Dietdate2, l_DietName,l_DietName2, l_Dietsex,l_Dietsex2, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietCl_Dietcalorie2,l_DietRl_Dietcalorie
	       ,l_DietRl_Dietcalorie2,l_Dietcalorie,l_Dietcalorie2,l_Dietbad,l_Dietgood;
	JTextArea ta_Dietlist, ta_DietRecord;
	
	JTextField tf_Dietcalorie,tf_DietDiet, tf_Dietweight, tf_Diettargetweight;
	
	JButton b_DietResult, b_DietSave, b_DietReset, b_DietBack;
	
	JScrollPane s_Dietscroll;

	DietSystem system = new DietSystem();
	public static DietMemberVO vo = new DietMemberVO();
	
	DefaultTableModel d_Dietdt;
	JTable j_DIettable;
	
	// ��ũ�� ��� ����
	String[] name = {"��ȣ","��ǰ�̸�","����(kcal)","��¥"};
	int Selectsum = 0;
	int Csum = 0;
	int kcal=0;
	
	//Constructor
	public DietUI2(DietUI ui) {
		this.ui = ui;
		
		
		p_Dietall = new JPanel();
		
		p_Dieta1 = new JPanel();
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_Dieta1.setBorder(b1);

		p_Dieta2 = new JPanel();
		p_Dieta2_1 = new JPanel();
		
 
		
		d_Dietdt = new DefaultTableModel(name, 0);
		j_DIettable = new JTable(d_Dietdt); 
        s_Dietscroll = new JScrollPane(j_DIettable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        j_DIettable.getColumnModel().getColumn(0).setPreferredWidth(50);
        j_DIettable.getColumnModel().getColumn(1).setPreferredWidth(200);
        //���̺� �÷� ���α��� ����
        
		//ta_Dietlist = new JTextArea();
		
		//p_Dieta2_2 = new JPanel();
		
		p_Dieta3 = new JPanel();
		LineBorder b3 = new LineBorder(Color.BLACK,1); 
		p_Dieta3.setBorder(b3);
		
//		l_Diettitle = new JLabel("����",JLabel.CENTER);
//		l_Diettitle.setFont(new Font("�������",Font.BOLD,25));
		l_DietCno = new JLabel();
		l_DietCno.setText(Integer.toString(DietUI.mvo.getCNO()));
		l_DietCno.setFont(new Font("�������",Font.BOLD,16));
		
		l_DietDwNO = new JLabel();
		l_DietCno.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietdate = new JLabel("��¥  :   ");
		l_Dietdate.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietdate2 = new JLabel();
		//l_Dietdate2.setText(DietUI.mvo.getNAME());
		l_Dietdate2.setFont(new Font("�������",Font.BOLD,16));
		
		l_DietName = new JLabel("ȸ��  :   ");
		l_DietName.setFont(new Font("�������",Font.BOLD,16));
		
		l_DietName2 = new JLabel();
		l_DietName2.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietsex = new JLabel("����  :   ");
		
		l_Dietsex.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietsex2 = new JLabel();
		l_Dietsex2.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietweight = new JLabel("ü��(Kg)");
		l_Dietweight.setFont(new Font("�������",Font.BOLD,16));
		
		l_Diettargetweight = new JLabel("��ǥü��(Kg)");
		l_Diettargetweight.setFont(new Font("�������",Font.BOLD,16));
		
		
		l_Dietdl_Dietcalorie = new JLabel("���߰��׸�");
		l_Dietdl_Dietcalorie.setFont(new Font("�������",Font.BOLD,17));
		
//		l_Dietdietname = new JLabel("����ã��");
//		l_Dietdietname.setFont(new Font("�������",Font.BOLD,16));
		
		l_DietCl_Dietcalorie = new JLabel("������Į�θ�" +"   -");
		l_DietCl_Dietcalorie.setFont(new Font("�������",Font.BOLD,22));
		
		l_DietCl_Dietcalorie2 = new JLabel();
		l_DietCl_Dietcalorie2.setFont(new Font("�������",Font.BOLD,22));
//		tf_Dietcalorie = new JTextField("kcal");
//		tf_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
		
		l_DietRl_Dietcalorie = new JLabel("����Į�θ�"+"  =");
		l_DietRl_Dietcalorie.setFont(new Font("�������",Font.BOLD,22));
		
		l_DietRl_Dietcalorie2 = new JLabel();
		l_DietRl_Dietcalorie2.setFont(new Font("�������",Font.BOLD,22));
		
		l_Dietcalorie = new JLabel("Į�θ�");
		l_Dietcalorie.setFont(new Font("�������",Font.BOLD,22));
		
		l_Dietcalorie2 = new JLabel();
		l_Dietcalorie2.setFont(new Font("�������",Font.BOLD,22));
		
		l_Dietbad = new JLabel();
		l_Dietbad.setFont(new Font("�������",Font.BOLD,16));
		l_Dietbad.setForeground(Color.DARK_GRAY);
		
		l_Dietgood = new JLabel();
		l_Dietgood.setFont(new Font("�������",Font.BOLD,16));
		l_Dietgood.setForeground(Color.DARK_GRAY);
		
		//tf_DietDiet = new JTextField();
//		jtfl_Dietdate = new JTextField();
//		jtfl_DietName = new JTextField();
//		jtfSex = new JTextField();
		
		tf_Dietweight = new JTextField();
		tf_Dietweight.setHorizontalAlignment(tf_Dietweight.CENTER); 
		
		tf_Diettargetweight = new JTextField();
		tf_Diettargetweight.setHorizontalAlignment(tf_Diettargetweight.CENTER); 
		
		b_DietResult = new JButton("Į�θ����");
		b_DietSave = new JButton("����");
		//b_DietReset = new JButton("���");
		b_DietBack = new JButton("�ڷΰ���");
		
		p_Dieta1.setBounds(0,50,980,200);
		p_Dieta1.setBackground(Color.WHITE);
		l_DietDwNO.setBounds(150,20,100,30);
		l_Dietdate.setBounds(200,50,100,30);
		l_Dietdate2.setBounds(250,50,100,30);
		l_DietName.setBounds(200,90,430,30);
		l_DietName2.setBounds(250,90,100,30);
		l_Dietsex.setBounds(200,130,430,30);
		l_Dietsex2.setBounds(250,130,100,30);
		l_Dietweight.setBounds(550,50,430,20);
		tf_Dietweight.setBounds(542,80,80,80);
		l_Diettargetweight.setBounds(650,50,430,20);
		tf_Diettargetweight.setBounds(657,80,80,80);
		
		p_Dieta2.setBounds(0,260,1000,480);
		p_Dieta2.setBackground(Color.WHITE);
		l_Dietdl_Dietcalorie.setBounds(50,10,420,30);
		//l_Dietdietname.setBounds(200,30,100,30);
		//tf_DietDiet.setBounds(270,30,200,30);
		
		
		s_Dietscroll.setBounds(50,50,900,200);
//		p_Dieta2_2.setBounds(0,10,200,500);
//		p_Dieta2_2.setBackground(Color.red);
		
		p_Dieta3.setBounds(0,750,980,100);
		p_Dieta3.setBackground(Color.WHITE);
		l_DietCl_Dietcalorie.setBounds(270,300,200,30);
		l_DietCl_Dietcalorie2.setBounds(145,300,300,30);
		//tf_Dietcalorie.setBounds(350,10,200,30);
		l_DietRl_Dietcalorie.setBounds(440,300,200,30);
		l_DietRl_Dietcalorie2.setBounds(380,300,300,30);
		l_Dietcalorie.setBounds(590,300,200,30);
		l_Dietcalorie2.setBounds(610,300,300,30);
		l_Dietbad.setBounds(440,350,300,30);
		l_Dietgood.setBounds(440,350,300,30);
		b_DietResult.setBounds(830,300,100,30);
		
		b_DietSave.setBounds(400,30,60,30);
		//b_DietReset.setBounds(460,30,60,30);
		b_DietBack.setBounds(520,30,100,30);
		
		
		p_Dieta1.add(l_DietDwNO);
		p_Dieta1.add(l_Dietdate);
		p_Dieta1.add(l_Dietdate2);
		p_Dieta1.add(l_DietName);
		p_Dieta1.add(l_DietName2);
		p_Dieta1.add(l_Dietsex);
		p_Dieta1.add(l_Dietsex2);
		p_Dieta1.add(l_Dietweight);
		p_Dieta1.add(tf_Dietweight);
		p_Dieta1.add(l_Diettargetweight);
		p_Dieta1.add(tf_Diettargetweight);
		p_Dietall.add(p_Dieta1);
		
		p_Dieta2.add(l_Dietdl_Dietcalorie);
		//p_Dieta2.add(l_Dietdietname);
		//p_Dieta2.add(tf_DietDiet);
		//scroll.add(p_Dieta2_2);
		p_Dieta2.add(s_Dietscroll);
		p_Dieta2.add(l_DietCl_Dietcalorie);
		p_Dieta2.add(l_DietCl_Dietcalorie2);
		//p_Dieta3.add(tf_Dietcalorie);
		p_Dieta2.add(l_DietRl_Dietcalorie);
		p_Dieta2.add(l_DietRl_Dietcalorie2);
		p_Dieta2.add(l_Dietcalorie);
		p_Dieta2.add(l_Dietcalorie2);
		p_Dieta2.add(l_Dietbad);
		p_Dieta2.add(l_Dietgood);
		p_Dieta2.add(b_DietResult);
		p_Dietall.add(p_Dieta2);
		
		
		p_Dieta3.add(b_DietSave);
		//p_Dieta3.add(b_DietReset);
		p_Dieta3.add(b_DietBack);
		p_Dietall.add(p_Dieta3);
		
		p_Dieta1.setLayout(null);
		p_Dieta2.setLayout(null);
		p_Dieta2_1.setLayout(null);
		//p_Dieta2_2.setLayout(null);
		p_Dieta3.setLayout(null);
		p_Dietall.setLayout(null);
		
		//getContentPane().add(l_Diettitle,BorderLayout.NORTH);
		ui.jf.getContentPane().add(p_Dietall,BorderLayout.CENTER);
		p_Dietall.setSize(1000,1000);
		p_Dietall.setVisible(true);
		
		//�̺�Ʈ ���
		b_DietResult.addActionListener(this);
		b_DietSave.addActionListener(this);
		//b_DietReset.addActionListener(this);
		b_DietBack.addActionListener(this);		
		//b_DietChoice.addActionListener(this);		
		
		//��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
        dao.getInsertList2(d_Dietdt);
        //tf_DietDiet.requestFocus();
        //ù���� ����.
        if (d_Dietdt.getRowCount() > 0) {
            j_DIettable.setRowSelectionInterval(0, 0);
        }
        
       
      getWeight();
	}
	
	
	/** ������ ��� **/
	public void getWeight() {
		//���糯¥�� String ������ �����
	    SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
	    		
	    Date time = new Date();
	    		
	    String time1 = format1.format(time);
	    
	    vo = dao.getResultWeight(DietUI.mvo.getCNO(),time1);
	    
	    l_DietDwNO.setText(Integer.toString(vo.getDW_NO()));
	    l_Dietdate2.setText(vo.getDW_DATE());
	    l_DietName2.setText(vo.getNAME());
	    l_Dietsex2.setText(vo.getGENDER());
	    tf_Dietweight.setText(vo.getDW_WEIGHT());
	    tf_Diettargetweight.setText(vo.getDW_TARGETWEIGHT());
	}
	 
	
	
	//���̺� �˻��� Į�θ� ���� ��
	  public int getSum() {
      	int rowsCount =  j_DIettable.getRowCount();
      	int sum = 0;
      	
      	for(int i=0; i<rowsCount;i++) {
      		sum = sum + Integer.parseInt(String.valueOf(j_DIettable.getValueAt(i, 2)));
      		
      	}
      	return sum;
      }
	
	  /** Į�θ� good,bad �������ϱ� **/
	  public void enableButton(int checkResult) {
			
			if(checkResult == 1) {
				//System.out.println("��� �޴� ����");
				l_Dietgood.setText("�� ���߾��~");
				l_Dietgood.setForeground(Color.GREEN);
				
				
			}else if(checkResult == 2) {
				l_Dietbad.setText("���� Į�θ� �ʰ�!!");
				l_Dietbad.setForeground(Color.RED);
				
			}
		}

	
	//�̺�Ʈ ó��
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b_DietResult) {
			
			//Į�θ� ���
			if(vo.getGENDER().equals("M")) {
				Selectsum = getSum();
				Csum = Selectsum - DietSystem.MENKCAL;
	 			
				l_DietCl_Dietcalorie.setText("");
				l_DietCl_Dietcalorie2.setText(Integer.toString(getSum())+"kcal(������Į�θ�)");
				
				l_DietRl_Dietcalorie.setText("");
				l_DietRl_Dietcalorie2.setText("- "+Integer.toString(DietSystem.MENKCAL)+"kcal(����Į�θ�)");
				
				l_Dietcalorie.setText("");
				l_Dietcalorie2.setText("= "+Integer.toString(Csum)+"kcal(Į�θ�)");
				
				kcal = Csum;
				int checkResult = system.kcalCheck(kcal);
				enableButton(checkResult);
				
			}else if(vo.getGENDER().equals("F")) {
				Selectsum = getSum();
				Csum = Selectsum - DietSystem.GIRLKCAL;
	 			
				l_DietCl_Dietcalorie.setText("");
				l_DietCl_Dietcalorie2.setText(Integer.toString(getSum())+"kcal(������Į�θ�)");
				
				l_DietRl_Dietcalorie.setText("");
				l_DietRl_Dietcalorie2.setText("- "+Integer.toString(DietSystem.GIRLKCAL)+"kcal(����Į�θ�)");
				
				l_Dietcalorie.setText("");
				l_Dietcalorie2.setText("= "+Integer.toString(Csum)+"kcal(Į�θ�)");
				
				kcal = Csum;
				int checkResult = system.kcalCheck(kcal);
				enableButton(checkResult);
			}
			
//			if() {
//			l_DietRl_Dietcalorie.setText("2222");
//			}else {
//				
//			}
			
		//������ �߰��ؾ��� Į�θ� ��갪 ���(kcal)�� ��
        }else if(ae.getSource() == b_DietSave) {
        	//tf_Dietcalorie.setText();
        	if(vo.getGENDER().equals("M")) {
        		DietSaveVO dsvo = new DietSaveVO();
        		dsvo.setDS_SelectKcal(getSum());
            	dsvo.setDS_RECOMMEND(DietSystem.MENKCAL);
            	dsvo.setDS_RESULTKCAL(kcal);
            	dsvo.setDW_NO(vo.getDW_NO());
            	
            	boolean result = system.registDiet(dsvo);
            	
            	if(result) {
            		JOptionPane.showMessageDialog(null, "��ϿϷ�");
            		
            		//�߰���Ų �Ĵܵ� ����
            		int val = dao.getDeleteList2();
            		if(val != 0) {
            			JOptionPane.showMessageDialog(null, "����Ʈ�����Ϸ�");
            		}else {
            			JOptionPane.showMessageDialog(null, "����Ʈ��������");
            		}
            		
            		
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "��� �ȵ���");
            		
			
            	}
				
			}else if(vo.getGENDER().equals("F")) {
				DietSaveVO dsvo = new DietSaveVO();
				dsvo.setDS_SelectKcal(getSum());
            	dsvo.setDS_RECOMMEND(DietSystem.GIRLKCAL);
            	dsvo.setDS_RESULTKCAL(kcal);
            	dsvo.setDW_NO(vo.getDW_NO());
            	
            	boolean result = system.registDiet(dsvo);
            	
            	if(result) {
            		JOptionPane.showMessageDialog(null, "��ϿϷ�");
            		
            		
            		//�߰���Ų �Ĵܵ� ����
            		int val = dao.getDeleteList2();
            		if(val != 0) {
            			JOptionPane.showMessageDialog(null, "����Ʈ�����Ϸ�");
            		}else {
            			JOptionPane.showMessageDialog(null, "����Ʈ��������");
            		}
            		
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "��� �ȵ���");
            		
			
            	}
			}
        		
            	
        }else if(ae.getSource() == b_DietBack ) {
        	ui.flag=false;
    	    ui.flag2=false;
    	    
        	int rowsCount =  j_DIettable.getRowCount();
        	//�߰���Ų �Ĵܵ� ����
        	
        	if(rowsCount>0) {
        			dao.getDeleteList2();
        			p_Dietall.setVisible(false);
    	        	ui.p_Dietall.setVisible(true);
    	        	//new DietUI();
    	        	
        	}
        	else {
        		p_Dietall.setVisible(false);
	        	ui.p_Dietall.setVisible(true);
        	}
        	
        }
			
	}
	
}
