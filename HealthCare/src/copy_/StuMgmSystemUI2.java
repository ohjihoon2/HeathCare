package copy_;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StuMgmSystemUI2 {
	//Field
	
	Regist reg_class=null;
	
	public static final int MAIN = 0;   //msgPanel
	public static final int REGIST = 1; //jpReg
	public static final int LIST = 2;	//outputPanel
	public static final int SEARCH = 3;	//searchPanel
	public static final int UPDATE = 4;	//updatePanel
	
	static int status = 0;
	
	StuMgmSystem system = new StuMgmSystem();
	
	JFrame jf;
	JPanel msgPanel;
	Panel btnPanel;
	Label title, startMsg;
	JButton btnReg, btnOutput, btnExit, btnSearch;	
	
	//����� field
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jpReg;
	Label lbl1, lbl2, lbl3, lbl4, lbl5;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	JButton btnRegOK, btnRegCancel;
	
	//����� field
	JPanel outputPanel;
	JTextArea jtaList;
	
	//�˻���
	JPanel searchPanel, searchContentP, searchResultP;
	JLabel lblSno;
	JTextField jtfSno;
	JTextArea jtaSearch;
	JButton btnUpdate, btnDelete;
	
	//������
	JPanel updatePanel;
	JButton btnUpdateOK, btnUpdateCancel;
		
	//Constructor
	public StuMgmSystemUI2() {		
		setStatus(MAIN);
		
		//1. ȭ�鱸��
		jf = new JFrame("�л�����ý���");
		msgPanel = new JPanel();
		btnPanel = new Panel();
		title = new Label("**********   �л� ���� �ý���      **********");
		startMsg = new Label("�ݰ����ϴ�. �л���� �ý��� ���� ȭ�� �Դϴ�.");
		btnSearch = new JButton("��       ��");
		btnReg = new JButton("��       ��");
		btnOutput = new JButton("��      ��");
		btnExit = new JButton("��      ��");
	
		title.setAlignment(Label.CENTER);
		startMsg.setAlignment(Label.CENTER);
		msgPanel.add(startMsg);
		
		btnPanel.setLayout(new GridLayout(10,1));
		
		btnPanel.add(btnReg);
		btnPanel.add(btnOutput);
		btnPanel.add(btnSearch);
		btnPanel.add(btnExit);
		
		jf.getContentPane().add(title,BorderLayout.NORTH);
		jf.getContentPane().add(btnPanel,BorderLayout.WEST);
		jf.getContentPane().add(msgPanel,BorderLayout.CENTER);
		
		jf.setSize(850,400);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. �̺�Ʈ ����
		StuMgmEvent sme = new StuMgmEvent();
		btnReg.addActionListener(sme);
		btnOutput.addActionListener(sme);
		btnSearch.addActionListener(sme);
		btnExit.addActionListener(sme);

	}
	
	//Method
	/** ȭ�� status  setter, getter  ***/
	public static void setStatus(int status) { status = status; }
	public int getStatus() { return status; }
	
	
	/** ȭ�� Panel ����Ī �޼ҵ� ***/
	public void switchingPanel(int status) {
System.out.println("status=" + status);		
		switch(status) {
		case 0 :
			msgPanel.setVisible(false);
			break;
		case 1 :
			reg_class.visible();
			break;
		case 2: 
			outputPanel.setVisible(false);
			break;
		case 3:
			searchPanel.setVisible(false);
			break;
		case 4:
			updatePanel.setVisible(false);
			break;
		default:
		}
	}
	
	//���� ��� ��
	public void scoreRegForm() {
		setStatus(REGIST);
		
		//1. ��� ȭ�鱸��
		jpReg = new JPanel(new GridLayout(6,1));
		jp1 = new JPanel(); jp2 = new JPanel();
		jp3 = new JPanel(); jp4 = new JPanel();
		jp5 = new JPanel(); jp6 = new JPanel();
	
		lbl1 = new Label("�й�"); lbl2 = new Label("�̸�");
		lbl3 = new Label("����"); lbl4 = new Label("����");
		lbl5 = new Label("����");
		
		jtf1 = new JTextField(20); jtf2 = new JTextField(20);
		jtf3 = new JTextField(20); jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		
		btnRegOK = new JButton("��ϿϷ�");
		btnRegCancel = new JButton("������");
		
		/*jp1.add(lbl1);	jp1.add(jtf1);*/
		jp2.add(lbl2);	jp2.add(jtf2);
		jp3.add(lbl3);	jp3.add(jtf3);
		jp4.add(lbl4);	jp4.add(jtf4);
		jp5.add(lbl5);	jp5.add(jtf5);
		jp6.add(btnRegOK); jp6.add(btnRegCancel);
				
		jpReg.add(jp1);	jpReg.add(jp2);	jpReg.add(jp3);
		jpReg.add(jp4);	jpReg.add(jp5);	jpReg.add(jp6);
		
		
		jtf3.setText("0"); jtf4.setText("0");
		jtf5.setText("0");
		
		//msgPanel.setVisible(false);
		jpReg.setSize(200,300);
		jpReg.setVisible(true);
		
		jf.getContentPane().add(jpReg,BorderLayout.CENTER);
		
		//2. ��� �̺�Ʈ ����
		btnRegOK.addActionListener(new StuMgmEvent());
		btnRegCancel.addActionListener(new StuMgmEvent());
	}
	
	/** ������ **/
	public void updateForm(String sno) {
		//System.out.println(sname);
		setStatus(UPDATE);
		
		//1. ��� ȭ�鱸��
		updatePanel = new JPanel(new GridLayout(6,1));
		jp1 = new JPanel(); jp2 = new JPanel();
		jp3 = new JPanel(); jp4 = new JPanel();
		jp5 = new JPanel(); jp6 = new JPanel();
	
		lbl1 = new Label("�й�"); lbl2 = new Label("�̸�");
		lbl3 = new Label("����"); lbl4 = new Label("����");
		lbl5 = new Label("����");
		
		jtf1 = new JTextField(20); jtf2 = new JTextField(20);
		jtf3 = new JTextField(20); jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		
		btnUpdateOK = new JButton("�����Ϸ�");
		btnUpdateCancel = new JButton("�������");
		
		jp1.add(lbl1);	jp1.add(jtf1);
		jp2.add(lbl2);	jp2.add(jtf2);
		jp3.add(lbl3);	jp3.add(jtf3);
		jp4.add(lbl4);	jp4.add(jtf4);
		jp5.add(lbl5);	jp5.add(jtf5);
		jp6.add(btnUpdateOK); jp6.add(btnUpdateCancel);
				
		updatePanel.add(jp1);	updatePanel.add(jp2);	
		updatePanel.add(jp3);	updatePanel.add(jp4);	
		updatePanel.add(jp5);	updatePanel.add(jp6);		
		
		jtf3.setText("0"); jtf4.setText("0");
		jtf5.setText("0");
		
		updatePanel.setSize(200,300);
		updatePanel.setVisible(true);
		
		StuVO vo = system.searchData(sno);
		jtf1.setText(vo.getSno());
		jtf1.setEditable(false);
		jtf2.setText(vo.getSname());
		jtf3.setText(String.valueOf(vo.getSkor()));
		jtf4.setText(String.valueOf(vo.getSeng()));
		jtf5.setText(String.valueOf(vo.getSmath()));		
		
		jf.getContentPane().add(updatePanel,BorderLayout.CENTER);
		
		//2. �����Ϸ�/������� �̺�Ʈ ����
		btnUpdateOK.addActionListener(new StuMgmEvent());
		btnUpdateCancel.addActionListener(new StuMgmEvent());
	}
	
	
	
	//���� ��� ��
	public void scoreOutputForm(){
		setStatus(LIST);
		
		outputPanel = new JPanel();
		jtaList = new JTextArea(20,20);
		
		outputPanel.add(jtaList);
		//jpReg.setVisible(false);
		outputPanel.setVisible(true);
		
		jf.getContentPane().add(outputPanel, BorderLayout.CENTER);
	}
	
	
	//�˻� ��
	public void searchForm() {
		setStatus(SEARCH);
		
		searchPanel = new JPanel(new GridLayout(4,1));
		searchContentP = new JPanel();
		searchResultP = new JPanel();
		JPanel searchBtnPanel = new JPanel();
		lblSno = new JLabel("�˻��� �й��� �Է����ּ���");
		jtfSno = new JTextField(20);		
		jtaSearch = new JTextArea(20,20);
		btnUpdate = new JButton("��    ��");
		btnDelete = new JButton("��    ��");
		
		searchContentP.add(lblSno);
		searchContentP.add(jtfSno);
		searchResultP.add(jtaSearch);
		searchBtnPanel.add(btnUpdate);
		searchBtnPanel.add(btnDelete);
		
		searchPanel.add(searchContentP);
		searchPanel.add(searchResultP);
		searchPanel.add(searchBtnPanel);
		
		searchPanel.setVisible(true);
		
		jf.getContentPane().add(searchPanel,BorderLayout.CENTER);
		
		//�˻� �̺�Ʈ ����
		jtfSno.addActionListener(new StuMgmEvent());
		jtfSno.requestFocus();
		btnUpdate.addActionListener(new StuMgmEvent());
		btnDelete.addActionListener(new StuMgmEvent());
	}	
	
	
	
	//��� �� üũ
	public boolean regFormCheck(String formName) {
		boolean result = false;
		
		if(formName.equals("search")) {
			if(jtfSno.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�˻��� �̸��� �Է����ּ���");
				jtfSno.requestFocus();
			}else {
				result = true;
			}
		}else if(formName.equals("regist")) {
			/*if(jtf1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���");
				jtf1.requestFocus();
			}else*/ if(jtf2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���");
				jtf2.requestFocus();
			
			}else {
				result = true;
			}
		}
		
		return result;
	}
	
	
	//3. �̺�Ʈ ó�� Ŭ���� : Inner class
	class StuMgmEvent implements ActionListener{

		//�׼��̺�Ʈ ó�� �޼ҵ�
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == btnReg) {
				switchingPanel(getStatus());
				//scoreRegForm();  //����� ȣ��
				Regist ts = new Regist(jf);
				System.out.println("1. Regist Ŭ���� ����");
			}else if(obj == btnOutput) {
				switchingPanel(getStatus());
				scoreOutputForm();	//����� ȣ��
				
				ArrayList<StuVO> list = system.getList();
				
				jtaList.append("��ȣ\t�й�\t�̸�\t����\t����\t����\t����\t���\n");
				for(StuVO vo : list) {	
					if(vo != null) {
						jtaList.append(vo.getRno()+"\t");
						jtaList.append(vo.getSno()+"\t");
						jtaList.append(vo.getSname()+"\t");
						jtaList.append(vo.getSkor()+"\t");
						jtaList.append(vo.getSeng()+"\t");
						jtaList.append(vo.getSmath()+"\t");
						jtaList.append(vo.getStot()+"\t");
						jtaList.append(vo.getSavg()+"\n");	
					}
				}
				
			}else if(obj == btnExit) {
				JOptionPane.showMessageDialog(null, "�ý����� ����˴ϴ�.");
				system.close();
				System.exit(0);
			}else if(obj == btnRegOK) {
				
				//1. ���� ���� ��ȿ�� üũ -- true
				boolean checkResult = regFormCheck("regist");
				if(checkResult) {
					//2. StuVO ��ü�� �Է��� �����͸� ��Ƽ� -- ��Ͽ�û
					StuVO vo = new StuVO();
					/*vo.setSno(jtf1.getText());*/
					vo.setSname(jtf2.getText());
					vo.setSkor(Integer.parseInt(jtf3.getText()));
					vo.setSeng(Integer.parseInt(jtf4.getText()));
					vo.setSmath(Integer.parseInt(jtf5.getText()));
					
					boolean regResult = system.regist(vo);
					if(regResult) {
						JOptionPane.showMessageDialog(null, "��ϿϷ�");
					}else {
						JOptionPane.showMessageDialog(null, "��Ͻ���");
					}
				}				
				
			}else if(obj == btnRegCancel) {
				JOptionPane.showMessageDialog(null, "������");
			}else if(obj == btnSearch) {
				switchingPanel(getStatus());
				searchForm();
			}else if(obj == jtfSno) {							
				jtaSearch.setText("");
				
				if(regFormCheck("search")) {
					StuVO vo = system.searchData(jtfSno.getText().trim());
					
					jtaSearch.append("�й�\t�̸�\t����\t����\t����\t����\t���\n");
					
					if(vo != null) {
						jtaSearch.append(vo.getSno()+"\t");
						jtaSearch.append(vo.getSname()+"\t");
						jtaSearch.append(vo.getSkor()+"\t");
						jtaSearch.append(vo.getSeng()+"\t");
						jtaSearch.append(vo.getSmath()+"\t");
						jtaSearch.append(vo.getStot()+"\t");
						jtaSearch.append(vo.getSavg()+"\n");						
					}else {
						
					}					
				}				
				
			}else if(obj == btnUpdate) {				
				if(regFormCheck("search")) {
					switchingPanel(getStatus());
					updateForm(jtfSno.getText().trim());
				}
			}else if(obj == btnDelete) {
				int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?");
				
				if(result == 0) {
					
					boolean result2 = system.delete(jtfSno.getText().trim());
					if(result2) {
						JOptionPane.showMessageDialog(null, "���� �Ϸ�");
					}else {
						JOptionPane.showMessageDialog(null, "���� ����");
					}
				}

			}else if(obj == btnUpdateOK) {
				//���ο� ������(StuVO)
				StuVO uvo = new StuVO();
				uvo.setSno(jtf1.getText().trim());				
				uvo.setSname(jtf2.getText().trim());
				uvo.setSkor(Integer.parseInt(jtf3.getText().trim()));
				uvo.setSeng(Integer.parseInt(jtf4.getText().trim()));
				uvo.setSmath(Integer.parseInt(jtf5.getText().trim()));
				
				boolean result = system.update(uvo);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");
				}else {
					JOptionPane.showMessageDialog(null, "���� ����");
				}
				
			}
			
		}//actionPerformed method
	}//StuMgmEvent class
	
}//StuMgmSystemUI2 class










