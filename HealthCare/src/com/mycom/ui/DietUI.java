package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractCellEditor;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.mycom.dao.DietDAO;
import com.mycom.system.DietSystem;
import com.mycom.vo.DietMemberVO;
import com.mycom.vo.DietSelectVO;


public class DietUI extends JFrame implements ActionListener {
	//Field
	JFrame jf;
	JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	
	JLabel l_Diettitle, l_DietmemNo,l_DietmemNo2, l_l_Dietdietname,l_l_Dietdietname2, l_Dietsex,l_Dietsex2, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietRl_Dietcalorie,l_Dietcalorie,l_Dietbad,l_Dietgood;
	
	JTextArea ta_Dietlist, ta_DietRecord;
	
	JTextField tf_DietCno,tf_DietDiet, tf_DWNO,tf_Dietweight, tf_Diettargetweight;
	
	JButton b_DietSearch,b_DietWeight , b_DietNext, b_DietReset, b_ResultDiet;
	
	JScrollPane s_Dietscroll;

	DietSystem system = new DietSystem();
	
	DefaultTableModel d_Dietdt;
	JTable j_DIettable;
	 boolean flag = false;
	 boolean flag2 = false;
	// ��ũ�� ��� ����
	String[] name = {"��ȣ","��ǰ�̸�","1ȸ������(g)",	"����(kcal)",	"ź��ȭ��(g)","�ܹ���(g)","����(g)","���(g)","��Ʈ��(mg)","����"};
	public static DietMemberVO mvo = new DietMemberVO(); 
	public static DietMemberVO mvo2 = new DietMemberVO(); 
	int cno;
	
	//Constructor
	public DietUI(int cno) {
		this.cno = cno;
		
		
		
		jf = new JFrame();
		p_Dietall = new JPanel();
		
		p_Dieta1 = new JPanel();
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_Dieta1.setBorder(b1);

		p_Dieta2 = new JPanel();
		p_Dieta2_1 = new JPanel();
		
 
		
		d_Dietdt = new DefaultTableModel(name, 0);
		j_DIettable = new JTable(d_Dietdt); 
        s_Dietscroll = new JScrollPane(j_DIettable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        j_DIettable.getColumnModel().getColumn(9).setCellRenderer(new TableCell());
        //table���� column�� �ҷ��� �� ���� �Ӽ��� �������ش�
        j_DIettable.getColumnModel().getColumn(9).setCellEditor(new TableCell());
        //table���� column�� �ҷ��� �� Ȱ��ȭ�Ҽ� �ְ�, �����Ҽ� �ְ� �����ش�
        
        j_DIettable.getColumnModel().getColumn(0).setPreferredWidth(50);
        j_DIettable.getColumnModel().getColumn(1).setPreferredWidth(200);
        //���̺� �÷� ���α��� ����
        
		//ta_Dietlist = new JTextArea();
		
		//p_Dieta2_2 = new JPanel();
		
		p_Dieta3 = new JPanel();
		LineBorder b3 = new LineBorder(Color.BLACK,1); 
		p_Dieta3.setBorder(b3);
		
		l_Diettitle = new JLabel("��������",JLabel.CENTER);
		l_Diettitle.setFont(new Font("�������",Font.BOLD,25));
		
		l_DietmemNo = new JLabel("ȸ����ȣ :");
		l_DietmemNo.setFont(new Font("�������",Font.BOLD,16));
		
		l_DietmemNo2 = new JLabel();
		l_DietmemNo2.setFont(new Font("�������",Font.BOLD,16));
		
		l_l_Dietdietname = new JLabel("ȸ��  :");
		l_l_Dietdietname.setFont(new Font("�������",Font.BOLD,16));
		
		l_l_Dietdietname2 = new JLabel();
		l_l_Dietdietname2.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietsex = new JLabel("����  :");
		l_Dietsex.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietsex2 = new JLabel();
		l_Dietsex2.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietweight = new JLabel("ü��(Kg)");
		l_Dietweight.setFont(new Font("�������",Font.BOLD,16));
		
		l_Diettargetweight = new JLabel("��ǥü��(Kg)");
		l_Diettargetweight.setFont(new Font("�������",Font.BOLD,16));
		
		
		l_Dietdl_Dietcalorie = new JLabel("���Ϸ� ���� Į�θ�");
		l_Dietdl_Dietcalorie.setFont(new Font("�������",Font.BOLD,17));
		
		l_Dietdietname = new JLabel("����ã��");
		l_Dietdietname.setFont(new Font("�������",Font.BOLD,16));
		
//		l_DietCl_Dietcalorie = new JLabel("������Į�θ�"+"  -");
//		l_DietCl_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
//		
//		l_DietRl_Dietcalorie = new JLabel("����Į�θ�"+"  =");
//		l_DietRl_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
//		
//		l_Dietcalorie = new JLabel("Į�θ�");
//		l_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
//		
//		l_Dietbad = new JLabel("OOOKcal�ʰ�");
//		l_Dietbad.setFont(new Font("�������",Font.BOLD,14));
//		l_Dietbad.setForeground(Color.RED);
//		
//		l_Dietgood = new JLabel("l_Dietgood");
//		l_Dietgood.setFont(new Font("�������",Font.BOLD,14));
//		l_Dietgood.setForeground(Color.GREEN);
		//tf_DietCno = new JTextField(20);
		tf_DietDiet = new JTextField();
//		jtfl_DietmemNo = new JTextField();
//		jtfl_l_Dietdietname = new JTextField();
//		jtfSex = new JTextField();
		tf_DWNO = new JTextField();
		
		tf_Dietweight = new JTextField();
		tf_Dietweight.setHorizontalAlignment(tf_Dietweight.CENTER); 
		
		tf_Diettargetweight = new JTextField();
		tf_Diettargetweight.setHorizontalAlignment(tf_Diettargetweight.CENTER); 
		
		b_DietWeight = new JButton("���");
		b_DietSearch = new JButton("�˻�");
		b_DietNext = new JButton("����");
		b_DietReset = new JButton("���");
		b_ResultDiet = new JButton("���� �Ĵ�");
		
		p_Dieta1.setBounds(0,50,980,200);
		p_Dieta1.setBackground(Color.WHITE);
		//tf_DietCno.setBounds(200,20,100,30);
		l_DietmemNo.setBounds(200,50,100,30);
		l_DietmemNo2.setBounds(270,50,100,30);
		l_l_Dietdietname.setBounds(200,90,100,30);
		l_l_Dietdietname2.setBounds(250,90,100,30);
		l_Dietsex.setBounds(200,130,100,30);
		l_Dietsex2.setBounds(250,130,100,30);
		l_Dietweight.setBounds(550,50,430,20);
		tf_Dietweight.setBounds(542,80,80,80);
		l_Diettargetweight.setBounds(650,50,430,20);
		tf_Diettargetweight.setBounds(657,80,80,80);
		b_DietWeight.setBounds(750,80,80,80);
		
		p_Dieta2.setBounds(0,260,1000,480);
		p_Dieta2.setBackground(Color.WHITE);
		l_Dietdl_Dietcalorie.setBounds(200,0,420,30);
		l_Dietdietname.setBounds(200,30,100,30);
		tf_DietDiet.setBounds(270,30,200,30);
		b_DietSearch.setBounds(480,30,60,30);
		
		s_Dietscroll.setBounds(50,70,900,400);
//		p_Dieta2_2.setBounds(0,10,200,500);
//		p_Dieta2_2.setBackground(Color.red);
		
		p_Dieta3.setBounds(0,750,980,150);
		p_Dieta3.setBackground(Color.WHITE);
//		l_DietCl_Dietcalorie.setBounds(350,10,200,30);
//		l_DietRl_Dietcalorie.setBounds(480,10,200,30);
//		l_Dietcalorie.setBounds(610,10,200,30);
//		l_Dietbad.setBounds(420,40,200,30);
//		l_Dietgood.setBounds(520,40,200,30);
		b_DietNext.setBounds(400,60,60,30);
		b_DietReset.setBounds(480,60,60,30);
		b_ResultDiet.setBounds(560,60,100,30);
		
		//p_Dieta1.add(tf_DietCno);
		p_Dieta1.add(l_DietmemNo);
		p_Dieta1.add(l_DietmemNo2);
		p_Dieta1.add(l_l_Dietdietname);
		p_Dieta1.add(l_l_Dietdietname2);
		p_Dieta1.add(l_Dietsex);
		p_Dieta1.add(l_Dietsex2);
		p_Dieta1.add(l_Dietweight);
		p_Dieta1.add(tf_Dietweight);
		p_Dieta1.add(l_Diettargetweight);
		p_Dieta1.add(tf_Diettargetweight);
		p_Dieta1.add(b_DietWeight);
		p_Dietall.add(p_Dieta1);
		
		p_Dieta2.add(l_Dietdl_Dietcalorie);
		p_Dieta2.add(l_Dietdietname);
		p_Dieta2.add(tf_DietDiet);
		
		//scroll.add(p_Dieta2_2);
		p_Dieta2.add(s_Dietscroll);
		p_Dieta2.add(b_DietSearch);
		p_Dietall.add(p_Dieta2);
		
//		p_Dieta3.add(l_DietCl_Dietcalorie);
//		p_Dieta3.add(l_DietRl_Dietcalorie);
//		p_Dieta3.add(l_Dietcalorie);
//		p_Dieta3.add(l_Dietbad);
//		p_Dieta3.add(l_Dietgood);
		p_Dieta3.add(b_DietNext);
		p_Dieta3.add(b_DietReset);
		p_Dieta3.add(b_ResultDiet);
		p_Dietall.add(p_Dieta3);
		
		p_Dieta1.setLayout(null);
		p_Dieta2.setLayout(null);
		p_Dieta2_1.setLayout(null);
		//p_Dieta2_2.setLayout(null);
		p_Dieta3.setLayout(null);
		p_Dietall.setLayout(null);
		
		jf.getContentPane().add(l_Diettitle,BorderLayout.NORTH);
		jf.getContentPane().add(p_Dietall,BorderLayout.CENTER);
		jf.setSize(1000,1000);
		jf.setVisible(true);
		
		//�̺�Ʈ ���
		b_DietWeight.addActionListener(this);
		//tf_DietCno.addActionListener(this);
		b_DietSearch.addActionListener(this);
		b_DietNext.addActionListener(this);
		b_DietReset.addActionListener(this);
		b_ResultDiet.addActionListener(this);		
		//b_DietChoice.addActionListener(this);		
		
		//��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
        system.getList(d_Dietdt);
        tf_DietDiet.requestFocus();
        //ù���� ����.
        if (d_Dietdt.getRowCount() > 0) {
            j_DIettable.setRowSelectionInterval(0, 0);
            
        }
        
//  
      getMember();
	}
	
	public void getMember() {
		mvo = system.MemberInfo(cno);
		
		if(mvo != null) {
			l_DietmemNo2.setText(Integer.toString(mvo.getCNO()));
			l_l_Dietdietname2.setText(mvo.getNAME());
			l_Dietsex2.setText(mvo.getGENDER());
		}
	}
	
	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
		 
        JButton b_DietChoice;
         
        public TableCell() {
            // TODO Auto-generated constructor stub
        	b_DietChoice = new JButton("�߰�");
             
        	b_DietChoice.addActionListener(e -> {
        		//DietVO ����: ������
        		DietSelectVO vo = new DietSelectVO();
        		vo.setDSF_NO((Integer.parseInt(String.valueOf(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 0)))));
        		vo.setDSF_NAME((String.valueOf(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 1))));
        		vo.setDSF_CALORIE((Integer.parseInt(String.valueOf(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 3)))));
        		//vo.setF_NAME(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 1)+", ");
        		//vo.setF_CALORIE((Integer.parseInt((String) j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 3))));
                System.out.print(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 0)+", ");
                System.out.print(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 1)+", ");
                System.out.println(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 3));
                
                //DietDAO�� ���� DB ���� ---> ���
                DietDAO dao = new DietDAO();
                int result = dao.getResultInseret(vo);
                
                if(result != 0) {
                	JOptionPane.showMessageDialog(null, "��ϼ���");
                	flag2 = true;
                }else {
                	JOptionPane.showMessageDialog(null, "��Ͻ���");
                }
            });
         
        }
         
        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            return b_DietChoice;
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            // TODO Auto-generated method stub
            return b_DietChoice;
        }
	}
	
	

	
	
	
	//�̺�Ʈ ó��
	public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			
		 if(obj == b_DietWeight) {
			
			
			 if(!tf_Dietweight.getText().equals("")&&!tf_Diettargetweight.getText().equals("")) {
	        	int w = Integer.parseInt(tf_Dietweight.getText());
	        	int tw = Integer.parseInt(tf_Diettargetweight.getText());
	        	if(w<=tw) {
	        		/**DB���� ����� �����ʿ�**/
	        		JOptionPane.showMessageDialog(null, "���� ü�ߺ��� ��ǥ ü���� ���� �Է��ϼ���");
	        	}
	        	else {
	        		//���糯¥�� String ������ �����
	    	        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
	    	        		
	    	        Date time = new Date();
	    	        		
	    	        String time1 = format1.format(time);
	    	        
	    			mvo2 = new DietMemberVO();
	    			mvo2.setDW_WEIGHT(tf_Dietweight.getText().trim());
	    			mvo2.setDW_TARGETWEIGHT(tf_Diettargetweight.getText().trim());
	    			mvo2.setDW_DATE(time1);
	    			mvo2.setCNO(mvo.getCNO());
	            	
	            	
	            	boolean result = system.registWeight(mvo2);
	            	
	        		if(result) {
		        		JOptionPane.showMessageDialog(null, "������ ���");
		        		flag = true;
		        	}else {
		        		JOptionPane.showMessageDialog(null, "������ ��� �ȵ���");
		        		
		        	}
	        	}
        	}
			 else {
				 JOptionPane.showMessageDialog(null, "�����Ը� �Է��ϼ���");
			 }
        }
		/** ���̾�Ʈ �Ĵ� �˻�**/
		else if(obj == b_DietSearch) {
			system.getDietSearch(d_Dietdt,tf_DietDiet.getText().trim());
			tf_DietDiet.setText("");
			tf_DietDiet.requestFocus();
            if (d_Dietdt.getRowCount() > 0)
            	j_DIettable.setRowSelectionInterval(0, 0);
            
        }else if(obj == b_DietNext) {
        	/** Ȯ���� �������� �ʿ�**/
        	System.out.println(flag);
        	
        		if(!tf_Dietweight.getText().equals("")&&!tf_Diettargetweight.getText().equals("")) {
        			//������ ���
        			if(flag) {
        				if(flag2) {
	                		p_Dietall.setVisible(false);
	                		new DietUI2(this);
	                		tf_Dietweight.setText("");
	                		tf_Diettargetweight.setText("");
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "������ �߰����ּ���");
        				}
        			}else {
        				JOptionPane.showMessageDialog(null, "������ ����� ��������");
        			}
        			
        		}else {
        			JOptionPane.showMessageDialog(null, "�����Ը� �Է��ϼ���");
        		}
        	
        	
        } else if(obj == b_ResultDiet) {
        	p_Dietall.setVisible(false);
        	new DietUI3(this);
        	
        }else if(obj == b_DietReset) {
        	jf.setVisible(false);
        }
		
		
			
	}
	
}
