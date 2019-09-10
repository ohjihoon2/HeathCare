package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mycom.system.AdminSystem;
import com.mycom.vo.MemberVO;

public class AdminUI extends JFrame implements ActionListener{
	StartUI startui;
	AdminSystem system = new AdminSystem();
	
	public static final int MAIN = 0;   //msgPanel
	public static final int MEMBER = 1; //jpReg
	public static final int LECTURE = 2;	//outputPanel
	
	
	int status = 0;
	
	//����������
	JFrame jf;
	JPanel p_AdmMain, p_AdmMenu, p_AdmTitle;
	JLabel l_AdmTitle;
	JTextArea ta_AdmMain;
	JTextField tf;
	JButton b_AdmMember, b_AdmLecture;
	ArrayList<MemberVO> list;
	//member ���� ��
	JPanel p_MemMain, p_MemSearch, p_MemResult, p_MemBtn;
	JLabel l_MemCno;
	JTextField tf_MemCno;
	JButton b_Search, b_SearchAll, b_MemUpdate, b_MemDelete, b_LecUpdate, b_LecDelete;
	JScrollPane scroll_Mem;

	DefaultTableModel dtm_Mem;
	JTable t_Mem;
	
	String[] memInfo = {"ȸ����ȣ", "�̸�"," ����", "��ȭ��ȣ", "����", "������", "��������", "GX�ڵ�", "GX����", "GXȽ��", "GX��ȿ�Ⱓ", "BMI", "FAT", "PBF", "WHR", "S_WEIGHT", "GYM_PRICE"};
	//Lecture ���� ��
	JPanel p_LecMain, p_LecResult, p_LecBtn;
//	JButton b_LecUpdate, b_LecDelete;
	JScrollPane scroll_Lec;
	DefaultTableModel dtm_Lec;
	JTable t_Lec;
	String[] lecInfo = {"�����ڵ�", "�����"," �ݾ�"};
	AdminUI ui;
	
	public AdminUI(StartUI startui) {		
		this.startui = startui;
		System.out.println("Status=" + getStatus());		
		//1. ȭ�鱸��
		jf = new JFrame();
		p_AdmMain = new JPanel();
		p_AdmMenu = new JPanel();
		p_AdmTitle = new JPanel();
		
		l_AdmTitle = new JLabel("**********   HealthCare ������ ������      **********");
		
		b_AdmMember = new JButton("ȸ       ��");
		b_AdmLecture = new JButton("��       ��");
	
		ta_AdmMain = new JTextArea("�����ڴ� �ݰ����ϴ�.",28, 80);
		
		l_AdmTitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		p_AdmTitle.add(l_AdmTitle);
		

		//menu�г� 
		p_AdmMenu.setLayout(new GridLayout(10,1));
		
		p_AdmMenu.add(b_AdmMember);
		p_AdmMenu.add(b_AdmLecture);
		
		
		//�����г�
		p_AdmMain.add(ta_AdmMain);
		
		startui.jf.getContentPane().add(p_AdmTitle,BorderLayout.NORTH);
		startui.jf.getContentPane().add(p_AdmMenu,BorderLayout.WEST);
		startui.jf.getContentPane().add(p_AdmMain,BorderLayout.CENTER);
		
		startui.jf.setSize(1000,600);
		startui.jf.setVisible(true);
		
		startui.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. �̺�Ʈ ����
		b_AdmMember.addActionListener(this);
		b_AdmLecture.addActionListener(this);

	}
	
	//Method
	/** ȭ�� status  setter, getter  ***/
	public static void setStatus(int status) { 
		status = status;
	}
	public int getStatus() { 
		return status; 
	}
	
	/** ȭ�� Panel ����Ī �޼ҵ� ***/
	public void switchingPanel(int status) {
		switch(status) {
		case 0 :
			p_AdmMain.setVisible(false);
			break;
		case 1: 
			p_MemMain.setVisible(false);
			break;
		case 2: 
			p_LecMain.setVisible(false);
			break;
		}
	}
	
	
	
	
	public void memberManageForm() {
		list = system.getMember(dtm_Mem);
		Vector<String> colList = new Vector<String>();
		colList.add("ȸ����ȣ");  
		colList.add("�̸�");
		colList.add("����");
		colList.add("��ȭ��ȣ");
		colList.add("����");
		colList.add("������");
		colList.add("��������");
		colList.add("GX�ڵ�");
		colList.add("GX����");
		colList.add("GXȽ��");
		colList.add("GX��ȿ�Ⱓ");
		colList.add("BMI");
		colList.add("FAT");
		colList.add("PBF");
		colList.add("WHR");
		colList.add("ǥ��ü��");
		colList.add("�ｺ����");
		
		dtm_Mem = new DefaultTableModel(colList,0);	
		
		for(MemberVO vo : list) {
			Vector<String> v = new Vector<String>();
			v.add(String.valueOf(vo.getCno()));
			v.add(vo.getName());
			v.add(vo.getGender());
			v.add(vo.getPhone());
			v.add(vo.getBirth_date());
			v.add(vo.getStart_date());
			v.add(vo.getEnd_date());
			v.add(vo.getGx_code());
			v.add(String.valueOf(vo.getGx_price()));
			v.add(String.valueOf(vo.getGx_count()));
			v.add(vo.getGx_validity());
			v.add(vo.getBmi());
			v.add(vo.getFat());
			v.add(vo.getPbf());
			v.add(vo.getWhr());
			v.add(vo.getS_weight());
			v.add(String.valueOf(vo.getGym_price()));
			
			dtm_Mem.addRow(v);
		}	
		
		
		
		status = AdminUI.MEMBER;
		
//		p_MemMain = new JPanel(new GridLayout(3,1));
		p_MemMain = new JPanel(new BorderLayout());
		p_MemSearch = new JPanel();
		p_MemResult = new JPanel();
		p_MemBtn = new JPanel();
		
		l_MemCno = new JLabel("�˻��� ȸ����ȣ�� �Է����ּ���");
		tf_MemCno = new JTextField(10);		
		b_Search = new JButton("��    ��");
		b_SearchAll = new JButton("�� ü �� ��");
		b_MemUpdate = new JButton("��    ��");
		b_MemDelete = new JButton("��    ��");
		
		t_Mem= new JTable(dtm_Mem); 
		t_Mem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll_Mem= new JScrollPane(t_Mem);
        //getcolumn�� ���° �÷�����, setPreferredWidth �÷� ���� ���� ����
        t_Mem.getColumnModel().getColumn(0).setPreferredWidth(100);
        t_Mem.getColumnModel().getColumn(1).setPreferredWidth(50);
		
//		
//		dtm_Mem = new DefaultTableModel(memInfo, 0);
//		t_Mem= new JTable(dtm_Mem); 
//        scroll_Mem= new JScrollPane(t_Mem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        
        //��ũ�� ũ��
//        scroll_Mem.setBounds(0,30,800,200);
        scroll_Mem.setBounds(30,30,800,350);
        
        p_MemResult.setBounds(0,0,1000,1000);
        p_MemResult.setLayout(null);
//        p_AdmMemberMain.setLayout(null);
        
		p_MemSearch.add(tf_MemCno);
		p_MemSearch.add(b_Search);
		p_MemSearch.add(b_SearchAll);
		
		p_MemResult.add(scroll_Mem);
		
		p_MemBtn.add(b_MemUpdate);
		p_MemBtn.add(b_MemDelete);
		
		p_MemMain.add(p_MemSearch, BorderLayout.NORTH);
		p_MemMain.add(p_MemResult, BorderLayout.CENTER);
		p_MemMain.add(p_MemBtn, BorderLayout.SOUTH);
		
//		p_AdmSearch.setSize(600,300);
		p_MemMain.setVisible(true);
		
		startui.jf.getContentPane().add(p_MemMain,BorderLayout.CENTER);
//		system.getMember(dtm_Mem);
		
		
//		if(tf_MemCno.getText() == "") {
//			system.getMember(dtm_Mem);
//		}else {
//			if(tf_MemCno.getText() == "") {
//				JOptionPane.showMessageDialog(null,"���� ������ �Դϴ�.");
//			}else {
//				int cno = Integer.parseInt(tf_MemCno.getText());
//				system.searchData(dtm_Mem, cno);
//			}
//		}
		//��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø��� or �˻����̺� �ø���
	
        
		//�˻� �̺�Ʈ ����
		b_Search.addActionListener(this);
		b_SearchAll.addActionListener(this);
		b_MemUpdate.addActionListener(this);
		b_MemDelete.addActionListener(this);
		
	}

	public void lectureManageForm() {
		status = AdminUI.LECTURE;
		p_LecMain = new JPanel(new BorderLayout());
		p_LecResult = new JPanel();
		p_LecBtn = new JPanel();
		
		b_LecUpdate = new JButton("��    ��");
		b_LecDelete = new JButton("��    ��");
		
		dtm_Lec = new DefaultTableModel(lecInfo, 0);
		t_Lec= new JTable(dtm_Lec); 
        scroll_Lec= new JScrollPane(t_Lec, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        //��ũ�� ũ��
        scroll_Lec.setBounds(30,68,800,350);
        
        p_LecResult.setBounds(0,0,1000,1000);
        
        p_LecResult.setLayout(null);
//        p_AdmMemberMain.setLayout(null);
        
		p_LecResult.add(scroll_Lec);
		
		p_LecBtn.add(b_LecUpdate);
		p_LecBtn.add(b_LecDelete);
		
		p_LecMain.add(p_LecResult);
		p_LecMain.add(p_LecBtn);
		
//		p_AdmSearch.setSize(600,300);
		p_LecMain.setVisible(true);
		
		
		p_LecMain.add(p_LecResult, BorderLayout.CENTER);
		p_LecMain.add(p_LecBtn, BorderLayout.SOUTH);
		
		
		startui.jf.getContentPane().add(p_LecMain,BorderLayout.CENTER);
		
		//��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
        system.getLecture(dtm_Lec);
		
        
		b_LecUpdate.addActionListener(this);
		b_LecDelete.addActionListener(this);
	}
	
	/**
	 * ������Ʈ
	 * @param sno
	 */
	public void setUpdateChange() {
		list = system.getMember(dtm_Mem);
		Vector<String> colList = new Vector<String>();
		colList.add("ȸ����ȣ");  
		colList.add("�̸�");
		colList.add("����");
		colList.add("��ȭ��ȣ");
		colList.add("����");
		colList.add("������");
		colList.add("��������");
		colList.add("GX�ڵ�");
		colList.add("GX����");
		colList.add("GXȽ��");
		colList.add("GX��ȿ�Ⱓ");
		colList.add("BMI");
		colList.add("FAT");
		colList.add("PBF");
		colList.add("WHR");
		colList.add("ǥ��ü��");
		colList.add("�ｺ����");
		
		dtm_Mem = new DefaultTableModel(colList,0);	
		
		for(MemberVO vo : list) {
			Vector<String> v = new Vector<String>();
			v.add(String.valueOf(vo.getCno()));
			v.add(vo.getName());
			v.add(vo.getGender());
			v.add(vo.getPhone());
			v.add(vo.getBirth_date());
			v.add(vo.getStart_date());
			v.add(vo.getEnd_date());
			v.add(vo.getGx_code());
			v.add(String.valueOf(vo.getGx_price()));
			v.add(String.valueOf(vo.getGx_count()));
			v.add(vo.getGx_validity());
			v.add(vo.getBmi());
			v.add(vo.getFat());
			v.add(vo.getPbf());
			v.add(vo.getWhr());
			v.add(vo.getS_weight());
			v.add(String.valueOf(vo.getGym_price()));
			
			dtm_Mem.addRow(v);
		}	
		//JTable�� ������ ������Ʈ �ϴ� �޼ҵ�
		t_Mem.setModel(dtm_Mem);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj ==b_AdmMember) {
			switchingPanel(getStatus());
			
			memberManageForm();
		}else if(obj == b_AdmLecture) {
			switchingPanel(getStatus());
			lectureManageForm();
		}else if(obj == b_Search){
			if(tf_MemCno.getText().trim().length()>0) {
				system.searchData(dtm_Mem, Integer.parseInt(tf_MemCno.getText().trim()));
				tf_MemCno.setText("");
				tf_MemCno.requestFocus();
				//ù�� ����
				if (dtm_Mem.getRowCount() > 0) {
					t_Mem.setRowSelectionInterval(0, 0);
				}
			}
//			
			
		}else if(obj == b_SearchAll) {
			//system.getMember(dtm_Mem);
			switchingPanel(getStatus());
			
			memberManageForm();
			
		}else if(obj == b_MemUpdate) {
			int row = t_Mem.getSelectedRow();
			
			MemberVO vo = list.get(row);
			new AdminMemUpdateUI(vo.getCno(),this);
			
		}else if(obj == b_MemDelete) {
			
			int row = t_Mem.getSelectedRow();
			MemberVO vo = list.get(row);
			
			int delConfirm = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?");
			
			if(delConfirm == 0) {
				
				boolean result = system.getAdminDelete(vo.getCno());
				
				if(result) {
					JOptionPane.showMessageDialog(null, "�����Ϸ�");
					setUpdateChange();
				}else {
					JOptionPane.showMessageDialog(null, "��������");
				}
			}
		}else if(obj == b_LecUpdate) {
			int row = t_Mem.getSelectedRow();
			
			MemberVO vo = list.get(row);
			new AdminMemUpdateUI(vo.getCno(),this);
			
		}else if(obj == b_LecDelete) {
			
			int row = t_Mem.getSelectedRow();
			MemberVO vo = list.get(row);
			
			int delConfirm = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?");
			
			if(delConfirm == 0) {
				
				boolean result = system.getAdminDelete(vo.getCno());
				
				if(result) {
					JOptionPane.showMessageDialog(null, "�����Ϸ�");
					setUpdateChange();
				}else {
					JOptionPane.showMessageDialog(null, "��������");
				}
			}
		}
		
	}
}
