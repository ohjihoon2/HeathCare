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
	
	//등록폼 field
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jpReg;
	Label lbl1, lbl2, lbl3, lbl4, lbl5;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	JButton btnRegOK, btnRegCancel;
	
	//출력폼 field
	JPanel outputPanel;
	JTextArea jtaList;
	
	//검색폼
	JPanel searchPanel, searchContentP, searchResultP;
	JLabel lblSno;
	JTextField jtfSno;
	JTextArea jtaSearch;
	JButton btnUpdate, btnDelete;
	
	//수정폼
	JPanel updatePanel;
	JButton btnUpdateOK, btnUpdateCancel;
		
	//Constructor
	public StuMgmSystemUI2() {		
		setStatus(MAIN);
		
		//1. 화면구성
		jf = new JFrame("학사관리시스템");
		msgPanel = new JPanel();
		btnPanel = new Panel();
		title = new Label("**********   학사 관리 시스템      **********");
		startMsg = new Label("반갑습니다. 학사관리 시스템 메인 화면 입니다.");
		btnSearch = new JButton("검       색");
		btnReg = new JButton("등       록");
		btnOutput = new JButton("출      력");
		btnExit = new JButton("종      료");
	
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
		
		//2. 이벤트 위임
		StuMgmEvent sme = new StuMgmEvent();
		btnReg.addActionListener(sme);
		btnOutput.addActionListener(sme);
		btnSearch.addActionListener(sme);
		btnExit.addActionListener(sme);

	}
	
	//Method
	/** 화면 status  setter, getter  ***/
	public static void setStatus(int status) { status = status; }
	public int getStatus() { return status; }
	
	
	/** 화면 Panel 스위칭 메소드 ***/
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
	
	//점수 등록 폼
	public void scoreRegForm() {
		setStatus(REGIST);
		
		//1. 등록 화면구성
		jpReg = new JPanel(new GridLayout(6,1));
		jp1 = new JPanel(); jp2 = new JPanel();
		jp3 = new JPanel(); jp4 = new JPanel();
		jp5 = new JPanel(); jp6 = new JPanel();
	
		lbl1 = new Label("학번"); lbl2 = new Label("이름");
		lbl3 = new Label("국어"); lbl4 = new Label("영어");
		lbl5 = new Label("수학");
		
		jtf1 = new JTextField(20); jtf2 = new JTextField(20);
		jtf3 = new JTextField(20); jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		
		btnRegOK = new JButton("등록완료");
		btnRegCancel = new JButton("등록취소");
		
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
		
		//2. 등록 이벤트 위임
		btnRegOK.addActionListener(new StuMgmEvent());
		btnRegCancel.addActionListener(new StuMgmEvent());
	}
	
	/** 수정폼 **/
	public void updateForm(String sno) {
		//System.out.println(sname);
		setStatus(UPDATE);
		
		//1. 등록 화면구성
		updatePanel = new JPanel(new GridLayout(6,1));
		jp1 = new JPanel(); jp2 = new JPanel();
		jp3 = new JPanel(); jp4 = new JPanel();
		jp5 = new JPanel(); jp6 = new JPanel();
	
		lbl1 = new Label("학번"); lbl2 = new Label("이름");
		lbl3 = new Label("국어"); lbl4 = new Label("영어");
		lbl5 = new Label("수학");
		
		jtf1 = new JTextField(20); jtf2 = new JTextField(20);
		jtf3 = new JTextField(20); jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		
		btnUpdateOK = new JButton("수정완료");
		btnUpdateCancel = new JButton("수정취소");
		
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
		
		//2. 수정완료/수정취소 이벤트 위임
		btnUpdateOK.addActionListener(new StuMgmEvent());
		btnUpdateCancel.addActionListener(new StuMgmEvent());
	}
	
	
	
	//점수 출력 폼
	public void scoreOutputForm(){
		setStatus(LIST);
		
		outputPanel = new JPanel();
		jtaList = new JTextArea(20,20);
		
		outputPanel.add(jtaList);
		//jpReg.setVisible(false);
		outputPanel.setVisible(true);
		
		jf.getContentPane().add(outputPanel, BorderLayout.CENTER);
	}
	
	
	//검색 폼
	public void searchForm() {
		setStatus(SEARCH);
		
		searchPanel = new JPanel(new GridLayout(4,1));
		searchContentP = new JPanel();
		searchResultP = new JPanel();
		JPanel searchBtnPanel = new JPanel();
		lblSno = new JLabel("검색할 학번을 입력해주세요");
		jtfSno = new JTextField(20);		
		jtaSearch = new JTextArea(20,20);
		btnUpdate = new JButton("수    정");
		btnDelete = new JButton("삭    제");
		
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
		
		//검색 이벤트 위임
		jtfSno.addActionListener(new StuMgmEvent());
		jtfSno.requestFocus();
		btnUpdate.addActionListener(new StuMgmEvent());
		btnDelete.addActionListener(new StuMgmEvent());
	}	
	
	
	
	//등록 폼 체크
	public boolean regFormCheck(String formName) {
		boolean result = false;
		
		if(formName.equals("search")) {
			if(jtfSno.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "검색할 이름을 입력해주세요");
				jtfSno.requestFocus();
			}else {
				result = true;
			}
		}else if(formName.equals("regist")) {
			/*if(jtf1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "학번을 입력해주세요");
				jtf1.requestFocus();
			}else*/ if(jtf2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
				jtf2.requestFocus();
			
			}else {
				result = true;
			}
		}
		
		return result;
	}
	
	
	//3. 이벤트 처리 클래스 : Inner class
	class StuMgmEvent implements ActionListener{

		//액션이벤트 처리 메소드
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == btnReg) {
				switchingPanel(getStatus());
				//scoreRegForm();  //등록폼 호출
				Regist ts = new Regist(jf);
				System.out.println("1. Regist 클래스 생성");
			}else if(obj == btnOutput) {
				switchingPanel(getStatus());
				scoreOutputForm();	//출력폼 호출
				
				ArrayList<StuVO> list = system.getList();
				
				jtaList.append("번호\t학번\t이름\t국어\t영어\t수학\t총점\t평균\n");
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
				JOptionPane.showMessageDialog(null, "시스템이 종료됩니다.");
				system.close();
				System.exit(0);
			}else if(obj == btnRegOK) {
				
				//1. 폼에 대한 유효성 체크 -- true
				boolean checkResult = regFormCheck("regist");
				if(checkResult) {
					//2. StuVO 객체에 입력한 데이터를 담아서 -- 등록요청
					StuVO vo = new StuVO();
					/*vo.setSno(jtf1.getText());*/
					vo.setSname(jtf2.getText());
					vo.setSkor(Integer.parseInt(jtf3.getText()));
					vo.setSeng(Integer.parseInt(jtf4.getText()));
					vo.setSmath(Integer.parseInt(jtf5.getText()));
					
					boolean regResult = system.regist(vo);
					if(regResult) {
						JOptionPane.showMessageDialog(null, "등록완료");
					}else {
						JOptionPane.showMessageDialog(null, "등록실패");
					}
				}				
				
			}else if(obj == btnRegCancel) {
				JOptionPane.showMessageDialog(null, "등록취소");
			}else if(obj == btnSearch) {
				switchingPanel(getStatus());
				searchForm();
			}else if(obj == jtfSno) {							
				jtaSearch.setText("");
				
				if(regFormCheck("search")) {
					StuVO vo = system.searchData(jtfSno.getText().trim());
					
					jtaSearch.append("학번\t이름\t국어\t영어\t수학\t총점\t평균\n");
					
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
				int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
				
				if(result == 0) {
					
					boolean result2 = system.delete(jtfSno.getText().trim());
					if(result2) {
						JOptionPane.showMessageDialog(null, "삭제 완료");
					}else {
						JOptionPane.showMessageDialog(null, "삭제 실패");
					}
				}

			}else if(obj == btnUpdateOK) {
				//새로운 데이터(StuVO)
				StuVO uvo = new StuVO();
				uvo.setSno(jtf1.getText().trim());				
				uvo.setSname(jtf2.getText().trim());
				uvo.setSkor(Integer.parseInt(jtf3.getText().trim()));
				uvo.setSeng(Integer.parseInt(jtf4.getText().trim()));
				uvo.setSmath(Integer.parseInt(jtf5.getText().trim()));
				
				boolean result = system.update(uvo);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "수정 완료");
				}else {
					JOptionPane.showMessageDialog(null, "수정 실패");
				}
				
			}
			
		}//actionPerformed method
	}//StuMgmEvent class
	
}//StuMgmSystemUI2 class










