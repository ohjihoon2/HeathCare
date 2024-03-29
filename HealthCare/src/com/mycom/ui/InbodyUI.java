package com.mycom.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.mycom.dao.InbodyDAO;
import com.mycom.system.InbodySystem;
import com.mycom.vo.InbodyVO;
import com.mycom.*;

public class InbodyUI extends JFrame implements ActionListener {


	// Field
	MainScreenUI mainui;
	StartUI startui;
	JFrame jf;
	JPanel p_InbMain, p_InbCb, p_InbMain_img;
	JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight, l_InbPbf_bodyfat, l_InbWhr_waist,
	l_InbWhr_butt, l_InbReBMI, l_InbReWe, l_InbRePBF, l_InbReFat, l_InbReWHR;
	TextField tf_InbBmi_height, tf_InbBmi_weight, tf_InbPbf_bodyfat,  tf_InbPbf_weight, tf_InbWhr_waist, tf_InbWhr_butt;
	JRadioButton cb_InbM, cb_InbW;
	JButton b_InbEnter, b_InbSave, b_InbMain;
	ImageIcon icon;
	double height, weight, BMI, bweight, FAT, PBF, WHR, waist, butt, S_weight;
	Vector age;
	JComboBox ageBox;
	JTextArea a_InbRe;
	String result, result2, Fat_Result;
	InbodySystem system;
	InbodyDAO dao;
	InbodyVO ivo;
	JRadioButton[] gender = new JRadioButton[2];

	// UI 구성
	public InbodyUI(MainScreenUI mainui,StartUI startui) {

		system = new InbodySystem();

		this.mainui = mainui;
		this.startui = startui;

		setLocation(400, 100);
		icon = new ImageIcon("image/ht70.jpg");

		p_InbMain = new JPanel() {
			public void paintComponent(Graphics g) {

			// 이미지 전체 사이즈
			Dimension d = getSize();
			g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);

			setOpaque(false); 

			super.paintComponent(g);
			
			}
		};

		p_InbMain.setLayout(null);

		/**
		 * 왼쪽
		 **/

		l_InbMsg = new JLabel("*** 신체정보를 입력하시고 아래의 체크버튼을 누르세요 ***");
		l_InbMsg.setFont(new Font("나눔고딕", Font.BOLD, 16));

		/////////////////// 체크박스////////////////////////

		p_InbCb = new JPanel();
		cb_InbM = new JRadioButton("남자");
		cb_InbW = new JRadioButton("여자");		

		age=new Vector();
		age.add("연령");
		age.add("19세~29세");
		age.add("30세~39세");
		age.add("40세~49세");
		age.add("50세~59세");
		age.add("60세 이상");

		ageBox=new JComboBox(age);


		ButtonGroup group = new ButtonGroup();
		gender[0] = new JRadioButton("남자");
		gender[1] = new JRadioButton("여자");
		group.add(gender[0]);
		group.add(gender[1]);

		if(StartUI.vo.getGender().equals("M")) {
			cb_InbM.setSelected(true);
		}else if(StartUI.vo.getGender().equals("F")) {
			cb_InbW.setSelected(true);
		}

		group.add(cb_InbM);
		group.add(cb_InbW);



		/**
		 * 오른쪽
		 **/

		a_InbRe = new JTextArea();
		a_InbRe.setFont(new Font("나눔고딕",Font.BOLD,17));
		a_InbRe.append(" ====== 인바디 검사 결과 ====== \n");

		//////////////// BMI 측정 ///////////////////////
		l_InbBmi_height = new JLabel("키(cm) :");
		l_InbBmi_height.setFont(new Font("나눔고딕", Font.BOLD, 16));
		l_InbBmi_weight = new JLabel("몸무게(kg) :");
		l_InbBmi_weight.setFont(new Font("나눔고딕", Font.BOLD, 16));

		tf_InbBmi_height = new TextField();
		tf_InbBmi_weight = new TextField();

		///////////////// 체지방률 /////////////////////////
		l_InbPbf_bodyfat = new JLabel("체지방(kg) :");
		l_InbPbf_bodyfat.setFont(new Font("나눔고딕", Font.BOLD, 16));

		tf_InbPbf_bodyfat = new TextField();
		tf_InbPbf_weight = new TextField();

		///////////////// 복부지방률 ///////////////////////
		l_InbWhr_waist = new JLabel("허리둘레(cm) :");
		l_InbWhr_waist.setFont(new Font("나눔고딕", Font.BOLD, 16));
		l_InbWhr_butt = new JLabel("엉덩이둘레(cm) :");
		l_InbWhr_butt.setFont(new Font("나눔고딕", Font.BOLD, 16));

		tf_InbWhr_waist = new TextField();
		tf_InbWhr_butt = new TextField();

		/////////////// 체크, 다시입력 버튼 /////////////////////
		b_InbEnter = new JButton("체크");
		b_InbSave = new JButton("저장");
		b_InbMain = new JButton("메인");


		///////////////////////////////////////////////////////////////////////////////////
		l_InbMsg.setBounds(110, 60, 450, 20);

		cb_InbM.setBounds(210, 130, 60, 30);
		cb_InbM.setBackground(new Color(223, 229, 229));
		cb_InbW.setBounds(270, 130, 60, 30);
		cb_InbW.setBackground(new Color(223, 229, 229));

		ageBox.setBounds(360,130,80,30);
		ageBox.setBackground(Color.WHITE);

		l_InbBmi_height.setBounds(150, 200, 60, 30);
		l_InbBmi_weight.setBounds(350, 200, 90, 30);
		tf_InbBmi_height.setBounds(220, 200, 50, 30);
		tf_InbBmi_weight.setBounds(440, 200, 50, 30);

		l_InbWhr_waist.setBounds(110, 290, 110, 25);
		l_InbWhr_butt.setBounds(310, 290, 130, 25);
		tf_InbWhr_waist.setBounds(220, 290, 50, 30);
		tf_InbWhr_butt.setBounds(440, 290, 50, 30);

		l_InbPbf_bodyfat.setBounds(130, 360, 90, 50);
		tf_InbPbf_bodyfat.setBounds(220, 370, 50, 30);

		b_InbEnter.setBounds(220, 450, 60, 25);
		b_InbSave.setBounds(290, 450, 60, 25);
		b_InbMain.setBounds(360, 450, 60, 25);

		a_InbRe.setBounds(600, 200, 280, 210);
		a_InbRe.setBackground(Color.WHITE);

		p_InbMain.add(l_InbMsg);
		p_InbMain.setBackground(Color.white);

		p_InbMain.add(cb_InbM);
		p_InbMain.add(cb_InbW);

		p_InbMain.add(ageBox);

		p_InbMain.add(l_InbBmi_height);
		p_InbMain.add(l_InbBmi_weight);
		p_InbMain.add(tf_InbBmi_height);
		p_InbMain.add(tf_InbBmi_weight);

		p_InbMain.add(l_InbPbf_bodyfat);
		p_InbMain.add(tf_InbPbf_bodyfat);
		p_InbMain.add(tf_InbPbf_weight);

		p_InbMain.add(l_InbWhr_waist);
		p_InbMain.add(l_InbWhr_butt);
		p_InbMain.add(tf_InbWhr_waist);
		p_InbMain.add(tf_InbWhr_butt);

		p_InbMain.add(b_InbEnter);
		p_InbMain.add(b_InbSave);
		p_InbMain.add(b_InbMain);

		p_InbMain.add(a_InbRe);

		// 이벤트 핸들러 정의
		b_InbEnter.addActionListener(this);
		b_InbSave.addActionListener(this);
		b_InbMain.addActionListener(this);

		p_InbMain.setSize(1000, 600);
		p_InbMain.setVisible(true);
		setTitle("인바디 프로그램");

		startui.jf.getContentPane().add(p_InbMain);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void turnoff() {
		System.out.println("Inbody 화면 turnoff");
		p_InbMain.setVisible(false);
	}

	
	/**이벤트 처리**/
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		if(obj == b_InbSave) {

			StartUI.vo.setBmi(String.valueOf(StartUI.vo.getBmi()));
			StartUI.vo.setS_weight(String.valueOf(StartUI.vo.getS_weight()));
			StartUI.vo.setFat(String.valueOf(StartUI.vo.getFat()));
			StartUI.vo.setPbf(String.valueOf(StartUI.vo.getPbf()));
			StartUI.vo.setWhr(String.valueOf(StartUI.vo.getWhr()));

			ivo = new InbodyVO();

			System.out.println("bmi = "+BMI);
			System.out.println("S_weight = "+S_weight);

			ivo.setBMI(String.valueOf(BMI));
			ivo.setS_weight(String.valueOf(S_weight));
			ivo.setFAT(String.valueOf(FAT));
			ivo.setPBF(String.valueOf(PBF));			
			ivo.setWHR(String.valueOf(WHR));	


			//			System.out.println("vo2222;;;" + ivo);
			int result = system.getResultUpdate(ivo, StartUI.vo.getCno());

			if(result != 0) {
				JOptionPane.showMessageDialog(null, "저장");
			}else {
				JOptionPane.showMessageDialog(null, "저장실패");
			}
		}

		//////////////////// BMI 계산////////////////////////////////////
		String s = ae.getActionCommand();

		if (s.equals("체크")) {

			if(!tf_InbBmi_height.getText().equals("") && !tf_InbBmi_height.getText().equals(null)) {

				// 문자형인 키값을 int형으로 바꿈
				height = Double.valueOf(tf_InbBmi_height.getText()).doubleValue();

				// 표준체중계산    		  
				S_weight =Math.round(height - 100) * 0.9;

				// 키값을 cm인 키를 m로 바꿈
				height = height / 100;
				weight = Double.valueOf(tf_InbBmi_weight.getText()).doubleValue();

				// BMI 계산
				BMI = Math.round(weight / (height * height));

				// 비만도 계산 
				FAT = BMI;

				if (FAT < 20.0) {
					Fat_Result = "저체중";    	        	 
				}else if (20.0 <= FAT && FAT < 25.0) {
					Fat_Result = "정상";
				}else if (25.0 <= FAT && FAT < 30.0) {
					Fat_Result = "과체중";
				}else if (FAT <= 30.0) {
					Fat_Result = "비만";
				}


				/////////////////////////// 체지방률 계산/////////////////////////////////////    
				// 계산법 : 체지방(kg) / 체중(kg) X 100%

				weight = Double.valueOf(tf_InbBmi_weight.getText()).doubleValue();
				bweight = Double.valueOf(tf_InbPbf_bodyfat.getText()).doubleValue();

				PBF = Math.round((bweight / weight) * 100); 

				if(cb_InbM.isSelected()) {
					if(ageBox.getSelectedItem().equals("19세~29세")) {
						if(PBF<15) result = "매우 우수";
						else if(15.1<=PBF && PBF<=18.5) result = "우수";
						else if(18.6<=PBF&& PBF<=24.3) result = "보통";
						else if(18.6<=PBF&& PBF<=24.3) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("30세~39세")) {
						if(PBF<18) result = "매우 우수";
						else if(18.1<=PBF && PBF<=20.5) result = "우수";
						else if(18.6<=PBF&& PBF<=24.3) result = "보통";
						else if(PBF>=26.1) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("40세~49세")) {
						if(PBF<=20.2) result = "매우 우수";
						else if(20.3<=PBF && PBF<=24.8) result = "우수";
						else if(24.9<=PBF&& PBF<=27.5) result = "보통";
						else if(PBF>=27.6) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("50세~59세")) {
						if(PBF<=22.3) result = "매우 우수";
						else if(22.4<=PBF && PBF<=25.1) result = "우수";
						else if(25.1<=PBF&& PBF<=29.2) result = "보통";
						else if(PBF>=29.3) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("60세 이상")) {
						if(PBF<=22.5) result = "매우 우수";
						else if(22.6<=PBF && PBF<=25.5) result = "우수";
						else if(25.6<=PBF&& PBF<=29.7) result = "보통";
						else if(PBF>=29.8) result = "나쁨";
					}
				
				}

				if(cb_InbW.isSelected()) {
					if(ageBox.getSelectedItem().equals("19세~29세")) {
						if(PBF<20) result = "매우 우수";
						else if(20.1<=PBF && PBF<23.4) result = "우수";
						else if(23.5<=PBF&& PBF<29.7) result = "보통";
						else if(PBF>29.8) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("30세~39세")) {
						if(PBF<22) result = "매우 우수";
						else if(22.1<=PBF && PBF<25.4) result = "우수";
						else if(25.5<=PBF&& PBF<31.4) result = "보통";
						else if(PBF>34.5) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("40세~49세")) {
						if(PBF<25.2) result = "매우 우수";
						else if(25.3<=PBF && PBF<27.8) result = "우수";
						else if(27.9<=PBF&& PBF<34) result = "보통";
						else if(PBF>34.1) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("50세~59세")) {
						if(PBF<28.8) result = "매우 우수";
						else if(28.9<=PBF && PBF<32.2) result = "우수";
						else if(32.3<=PBF&& PBF<37.2) result = "보통";
						else if(PBF>37.3) result = "나쁨";

					} else if(ageBox.getSelectedItem().equals("60세 이상")) {
						if(PBF<29.1) result = "매우 우수";
						else if(29.2<=PBF && PBF<32.8) result = "우수";
						else if(32.8<=PBF&& PBF<37.9) result = "보통";
						else if(PBF>38) result = "나쁨";
					}

				}

				/////////////// 복부지방률 계산 /////////////////////////////////////////////////////
				// 복부지방률 (Waist-Hip Ratio) - 복부에 있는 지방의 비율 (엉덩이 둘레와 허리둘레의 비율)
				// 계산법 : 허리둘레(cm) / 엉덩이둘레(cm)

				if (s.equals("체크")) {
					waist = Double.valueOf(tf_InbWhr_waist.getText()).doubleValue();
					butt = Double.valueOf(tf_InbWhr_butt.getText()).doubleValue();

					System.out.println("waist;;;" + waist);
					System.out.println("butt;;;" + butt);
					double a =  waist / butt;
					WHR = Math.round(a*100d)/100d;

					System.out.println("WHR;;;" + WHR);

					if(cb_InbM.isSelected()) {
						if(0.86<=WHR && WHR<=0.99) result2 = "정상범위";
						else if(WHR>=1.0) result2 = "복부비만";
						else if(WHR<=0.85) result2 = "사지비만";
					} 
					if(cb_InbW.isSelected()) {
						if(0.76<=WHR && WHR<=0.89)  result2 = "정상범위";
						else if(WHR>=0.9) result2 = "복부비만";
						else if(WHR<=0.75) result2 = "사지비만";
					}
				}

				// 계산 결과    	         
				a_InbRe.setText(" ====== 인바디 검사 결과 ====== \n\n"+ "  BMI : " + BMI+"\n"+ "  표준체중 : "+  S_weight + "\n" 
						+ "  비만도 : " + Fat_Result+"\n"+"  체지방률 : " +PBF+" "+ result + "\n" +"  복부지방률 : " +WHR +" "+ result2 );


			}else {
				a_InbRe.setText("신체 정보를 입력하세요 ^^");
			}

		}else if(s.equals("메인")) {
			p_InbMain.setVisible(false);
			
//			mainui.p_sc_total.setVisible(true);
			new MainScreenUI(startui);
		} 


	}   
}






