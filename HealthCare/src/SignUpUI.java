import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpUI extends JFrame implements ActionListener{
	LoginUI ui;
	
	//Field
	JFrame frame;
	JPanel mainPanel, titlePanel, boardPanel, btnPanel; 
	JLabel jTitle, jName, jAddress, jContact, jRole, jCreated_date, jBirth, jTerm, jEvent, jStart_date, jEnd_date;
	JTextField tfName, tfAddress, tfContact, tfRole, tfCreated_date, tfBirth, tfTerm, tfEvent, tfStart_date, tfEnd_date;
	JButton btnNext, btnCancel;
	
	//Constructor
	public void SignUpUI(){
		ui.setStatus(LoginUI.REGIST);
		//Constructor
			//1. 화면구성
			// 패널 초기화 
			
			mainPanel = new JPanel(new GridLayout(3,1));
//			mainPanel = new JPanel();
			
			titlePanel = new JPanel();
			boardPanel = new JPanel(new GridLayout(10,2));
			btnPanel = new JPanel();
			
			btnNext = new JButton("다음");
			btnCancel = new JButton("취소");
			
			jTitle = new JLabel("회원가입");
			
			jName = new JLabel("회원명");
			jAddress = new JLabel("주소");
			jContact = new JLabel("연락처");
			jRole = new JLabel("구분");
			jCreated_date = new JLabel("회원가입일");
			jBirth = new JLabel("생년월일");
			jTerm = new JLabel("신청기간");
			jEvent = new JLabel("종목");
			jStart_date = new JLabel("시작일");
			jEnd_date = new JLabel("마지막일");
			
			
			tfName = new JTextField(10);
			tfAddress = new JTextField(10);
			tfContact = new JTextField(10);
			tfRole = new JTextField(10);
			tfCreated_date = new JTextField(10);
			tfBirth = new JTextField(10);
			tfTerm = new JTextField(10);
			tfEvent = new JTextField(10);
			tfStart_date = new JTextField(10);
			tfEnd_date = new JTextField(10);
			
			jTitle.setHorizontalAlignment(0);
			titlePanel.add(jTitle);
			
			boardPanel.add(jName); boardPanel.add(tfName);
			boardPanel.add(jAddress); boardPanel.add(tfAddress);
			boardPanel.add(jContact); boardPanel.add(tfContact);
			boardPanel.add(jRole); boardPanel.add(tfRole);
			boardPanel.add(jCreated_date); boardPanel.add(tfCreated_date);
			boardPanel.add(jBirth); boardPanel.add(tfBirth);
			boardPanel.add(jTerm); boardPanel.add(tfTerm);
			boardPanel.add(jEvent); boardPanel.add(tfEvent);
			boardPanel.add(jStart_date); boardPanel.add(tfStart_date);
			boardPanel.add(jEnd_date); boardPanel.add(tfEnd_date);
			
			btnPanel.add(btnNext);
			btnPanel.add(btnCancel);
			
			
			mainPanel.add(titlePanel);		
			mainPanel.add(boardPanel);		
			mainPanel.add(btnPanel);		
			
//			setTitle("회원가입");
//			getContentPane().add(mainPanel, BorderLayout.CENTER);
			mainPanel.setSize(800 ,600);
			mainPanel.setVisible(true);
//			setBounds(200,200,350,200);
//			setLocation(300, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
//			jpReg.setVisible(true);
//			
			ui.jf.getContentPane().add(mainPanel, BorderLayout.CENTER);

			//2. 이벤트 핸들러 정의
			btnNext.addActionListener(this);
			btnCancel.addActionListener(this);
		}
	
	//Method

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}











