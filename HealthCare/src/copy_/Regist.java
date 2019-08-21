package copy_;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Regist {
	JFrame jf;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jpReg;
	Label lbl1, lbl2, lbl3, lbl4, lbl5;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	JButton btnRegOK, btnRegCancel;
	
	
	public Regist(JFrame jf) {
		//StuMgmSystemUI2.setStatus(StuMgmSystemUI2.REGIST);
		StuMgmSystemUI2.status = StuMgmSystemUI2.REGIST;
		System.out.println("2. Regist 폼");
		this.jf = jf;
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
			//btnRegOK.addActionListener(new StuMgmEvent());
			//btnRegCancel.addActionListener(new StuMgmEvent());
	}
	
	public void visible() {
		System.out.println("reg 클래스 visible");
		jpReg.setVisible(false);
	}
	
	
}
