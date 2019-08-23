package com.mycom.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class InbodyUI extends JFrame implements ActionListener {

   BufferedImage img = null;
   // Field
   MainScreenUI mainui;
   StartUI startui;
   JFrame jf;
   JPanel p_InbMain, p_InbCb, p_InbMain_img;
   JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight, l_InbPbf_bodyfat, l_InbPbf_weight, l_InbWhr_waist,
         l_InbWhr_butt, l_InbReBMI, l_InbReWe, l_InbRePBF, l_InbReFat, l_InbReWHR;
   TextField tf_InbBmi_height, tf_InbBmi_weight, tf_InbPbf_bodyfat, tf_InbPbf_weight, tf_InbWhr_waist, tf_InbWhr_butt;
            // tf_InbReBMI, tf_InbReWe, tf_InbReFat, tf_InbRePBF, tf_InbReWHR
   JRadioButton cb_InbM, cb_InbW;
   JButton b_InbEnter, b_InbReset, b_InbMain;
   ImageIcon icon;
   double height, weight, BMI,PBF,WHR, bweight;
   Vector age;
   JComboBox ageBox;
   //JScrollPane s_Inbscroll;
   JTextArea a_InbRe;
   
   // UI 구성
   public InbodyUI(MainScreenUI mainui,StartUI startui) {
     this.mainui = mainui;
      this.startui = startui;

      setLocation(400, 100);
      setLayout(new GridLayout(1, 2));
      icon = new ImageIcon("C:\\Users\\SIST\\git\\HeathCare\\HealthCare\\image\\ht18.jpg");

      p_InbMain = new JPanel() {
         public void paintComponent(Graphics g) {
            // 이미비 원본사이즈
            // g.drawImage(icon.getImage(),100, 100, null);
            // 이미지 전체 사이즈
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);

            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절

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
      group.add(cb_InbM);
      group.add(cb_InbW);
      p_InbCb.add(cb_InbM);
      p_InbCb.add(cb_InbW);
      
      a_InbRe = new JTextArea();
      //s_Inbscroll = new JScrollPane(tf_InbRe, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

      //////////////// BMI 측정 ///////////////////////
      l_InbBmi_height = new JLabel("키(cm) :");
      l_InbBmi_height.setFont(new Font("나눔고딕", Font.BOLD, 15));
      l_InbBmi_weight = new JLabel("몸무게(kg) :");
      l_InbBmi_weight.setFont(new Font("나눔고딕", Font.BOLD, 15));

      tf_InbBmi_height = new TextField();
      tf_InbBmi_weight = new TextField();

      ///////////////// 체지방률 /////////////////////////
      l_InbPbf_bodyfat = new JLabel("체지방(kg) :");
      l_InbPbf_bodyfat.setFont(new Font("나눔고딕", Font.BOLD, 15));
      l_InbPbf_weight = new JLabel("몸무게(kg) :");
      l_InbPbf_weight.setFont(new Font("나눔고딕", Font.BOLD, 15));

      tf_InbPbf_bodyfat = new TextField();
      tf_InbPbf_weight = new TextField();

      ///////////////// 복부지방률 ///////////////////////
      l_InbWhr_waist = new JLabel("허리둘레(cm) :");
      l_InbWhr_waist.setFont(new Font("나눔고딕", Font.BOLD, 15));
      l_InbWhr_butt = new JLabel("엉덩이둘레(cm) :");
      l_InbWhr_butt.setFont(new Font("나눔고딕", Font.BOLD, 15));

      tf_InbWhr_waist = new TextField();
      tf_InbWhr_butt = new TextField();

      /////////////// 체크, 다시입력 버튼 /////////////////////
      b_InbEnter = new JButton("체크");
      b_InbReset = new JButton("다시입력");
      b_InbMain = new JButton("메인");

      /**
       * 오른쪽
       **/

      l_InbReBMI = new JLabel("<< 결 과 보 기 >>");
      l_InbReBMI.setFont(new Font("나눔고딕", Font.BOLD, 16));
      l_InbReWe = new JLabel("표준체중(kg) :");
      l_InbReWe.setFont(new Font("나눔고딕", Font.BOLD, 15));
      //tf_InbRe = new TextField();
      //tf_InbReWe = new TextField();

      l_InbRePBF = new JLabel("체지방률 :");
      l_InbRePBF.setFont(new Font("나눔고딕", Font.BOLD, 15));
     // tf_InbRePBF = new TextField();

      l_InbReFat = new JLabel("비만도 :");
      l_InbReFat.setFont(new Font("나눔고딕", Font.BOLD, 15));
      //tf_InbReFat = new TextField();

      l_InbReWHR = new JLabel("복부지방률 :");
      l_InbReWHR.setFont(new Font("나눔고딕", Font.BOLD, 15));
     // tf_InbReWHR = new TextField();

      ///////////////////////////////////////////////////////////////////////////////////
      l_InbMsg.setBounds(80, 60, 450, 20);

      cb_InbM.setBounds(160, 130, 60, 30);
      cb_InbM.setBackground(new Color(174,217,216));
      cb_InbW.setBounds(220, 130, 60, 30);
      cb_InbW.setBackground(new Color(174,217,216));
     
      ageBox.setBounds(310,130,80,30);
      ageBox.setBackground(Color.WHITE);
      
      l_InbBmi_height.setBounds(90, 200, 60, 30);
      l_InbBmi_weight.setBounds(270, 200, 80, 30);
      tf_InbBmi_height.setBounds(150, 200, 50, 30);
      tf_InbBmi_weight.setBounds(360, 200, 50, 30);

      l_InbPbf_bodyfat.setBounds(60, 270, 80, 50);
      l_InbPbf_weight.setBounds(270, 290, 80, 15);
      tf_InbPbf_bodyfat.setBounds(150, 280, 50, 30);
      tf_InbPbf_weight.setBounds(360, 280, 50, 30);

      l_InbWhr_waist.setBounds(50, 370, 100, 25);
      l_InbWhr_butt.setBounds(240, 370, 120, 25);
      tf_InbWhr_waist.setBounds(150, 370, 50, 30);
      tf_InbWhr_butt.setBounds(360, 370, 50, 30);

      b_InbEnter.setBounds(160, 450, 60, 25);
      b_InbReset.setBounds(230, 450, 90, 25);
      b_InbMain.setBounds(330, 450, 60, 25);

      //l_InbReBMI.setBounds(640, 130, 120, 25);
      //l_InbReWe.setBounds(750, 200, 100, 25);
      a_InbRe.setBounds(550, 180, 290, 230);
      a_InbRe.setBackground(Color.WHITE);
      //s_Inbscroll.setBounds(560, 180, 300, 230);
      
      
      //tf_InbReWe.setBounds(850, 200, 50, 30);

      //l_InbRePBF.setBounds(590, 280, 80, 25);
     // tf_InbRePBF.setBounds(670, 280, 50, 30);

      //l_InbReFat.setBounds(790, 280, 60, 25);
      //tf_InbReFat.setBounds(850, 280, 50, 30);

      //l_InbReWHR.setBounds(570, 370, 100, 25);
      //tf_InbReWHR.setBounds(670, 370, 50, 30);

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
      p_InbMain.add(l_InbPbf_weight);
      p_InbMain.add(tf_InbPbf_bodyfat);
      p_InbMain.add(tf_InbPbf_weight);

      p_InbMain.add(l_InbWhr_waist);
      p_InbMain.add(l_InbWhr_butt);
      p_InbMain.add(tf_InbWhr_waist);
      p_InbMain.add(tf_InbWhr_butt);

      p_InbMain.add(b_InbEnter);
      p_InbMain.add(b_InbReset);
      p_InbMain.add(b_InbMain);

      //p_InbMain.add(l_InbReBMI);
      //p_InbMain.add(l_InbReWe);
      p_InbMain.add(a_InbRe);
      //p_InbMain.add(s_Inbscroll);
      
      //p_InbMain.add(tf_InbReWe);

      //p_InbMain.add(l_InbRePBF);
      //p_InbMain.add(tf_InbRePBF);

      //p_InbMain.add(l_InbReFat);
      //p_InbMain.add(tf_InbReFat);

      //p_InbMain.add(l_InbReWHR);
      //p_InbMain.add(tf_InbReWHR);

      // 이벤트 핸들러 정의
      b_InbEnter.addActionListener(this);
      b_InbReset.addActionListener(this);
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

   // 이벤트 처리
   public void actionPerformed(ActionEvent ae) {
      String s = ae.getActionCommand();
      
      ///////////////// BMI 계산////////////////////////////////////
      if (s.equals("체크")) {

         // 문자형인 키값을 int형으로 바꿈
         height = Double.valueOf(tf_InbBmi_height.getText()).doubleValue();
         // 표준체중계산
         double N_weight = (height - 100) * 0.9;

         // 키값을 cm인 키를 m로 바꿈
         height = height / 100;

         weight = Double.valueOf(tf_InbBmi_weight.getText()).doubleValue();

         // BMI 계산
         BMI = Math.round(weight / (height * height));

         String re = tf_InbRe11(BMI);
         
         // 계산 결과
         a_InbRe.setText("" + BMI);
         a_InbRe.setText("" + N_weight);

      } else {
         tf_InbBmi_height.setText("");
         tf_InbBmi_weight.setText("");
      }
      
      ///////////// 비만도 계산//////////////////////////////////////////////////////
      // 비만도 (Body Mass Index, Kg/㎡) - 비만도를 판정하는 국제적인 기준
      // 계산법 : 체중(kg) / 신장²(㎡)
      if (s.equals("체크")) {
         double Fat = BMI;
         String Fat_Result = "";
         if (Fat < 20)
            Fat_Result = "저체중";
         else if (20 <= Fat && Fat < 25)
            Fat_Result = "정상";
         else if (25 <= Fat && Fat < 30)
            Fat_Result = "과체중";
         else if (Fat <= 30)
            Fat_Result = "비만";
        // a_InbRe.setText("" + Fat_Result);
    
      }else if(s.equals("메인")) {
         p_InbMain.setVisible(false);
         mainui.p_sc_total.setVisible(true);
      }
   

      //////////////// 체지방률 계산/////////////////////////////////////////////////
      // 체지방률 - 체중에서 체지방량이 차지하는 비율
      // 계산법 : 체지방(kg) / 체중(kg) X 100%
//      if (s.equals("체크")) {
//          bweight = Double.valueOf(tf_InbPbf_bodyfat.getText()).doubleValue();         
//          weight = Double.valueOf(tf_InbPbf_weight.getText()).doubleValue();
//          
//          // 체지방률 계산
//          double PBF = Math.round(bweight / (weight * 100));         
//          
//           String re =  tf_InbRe(PBF);
//                    
//          // 계산 결과
//           tf_InbRe.setText("" + PBF);         
//          } else {
//           tf_InbRe.setText("");

      }

//   }
   /////////////// 체지방률 계산222/////////////////////////////////////////////////////

   //if (s.equals("체크")) {

   //남자(19~29세)
   // if(PBF<15) 
   // PBF_Result="매우 우수";
   // else if(15.1<=PBF && PBF<18.5)
   // PBF_Result="우수";
   // else if(18.6<=PBF&& PBF<24.3)
   // PBF_Result="보통";
   // else if(PBF>24.4)
   // PBF_Result="나쁨";
   // return PBF_Result;
   
   //남자(30~39세)
   // if(PBF<18) 
   // PBF_Result="매우 우수";
   // else if(18.1<=PBF && PBF<20.5)
   // PBF_Result="우수";
   // else if(20.6<=PBF&& PBF<26)
   // PBF_Result="보통";
   // else if(PBF>26.1)
   // PBF_Result="나쁨";
   // return PBF_Result;
   
   //남자(40~49세)
   // if(PBF<20.2) 
   // PBF_Result="매우 우수";
   // else if(20.3<=PBF && PBF<24.8)
   // PBF_Result="우수";
   // else if(24.9<=PBF&& PBF<27.5)
   // PBF_Result="보통";
   // else if(PBF>27.6)
   // PBF_Result="나쁨";
   // return PBF_Result;
   
   //남자(50~59세)
   // if(PBF<22.3) 
   // PBF_Result="매우 우수";
   // else if(22.4<=PBF && PBF<25.1)
   // PBF_Result="우수";
   // else if(25.1<=PBF&& PBF<29.2)
   // PBF_Result="보통";
   // else if(PBF>29.3)
   // PBF_Result="나쁨";
   // return PBF_Result;
   
   //남자(60세 이상)
   // if(PBF<22.5) 
   // PBF_Result="매우 우수";
   // else if(22.6<=PBF && PBF<25.5)
   // PBF_Result="우수";
   // else if(25.6<=PBF&& PBF<29.7)
   // PBF_Result="보통";
   // else if(PBF>29.8)
   // PBF_Result="나쁨";
   // return PBF_Result;
   
   //여자(19~29세)
   // if(PBF<20) 
   // PBF_Result="매우 우수";
   // else if(20.1<=PBF && PBF<23.4)
   // PBF_Result="우수";
   // else if(23.5<=PBF&& PBF<29.7)
   // PBF_Result="보통";
   // else if(PBF>29.8)
   // PBF_Result="나쁨";
   // return PBF_Result;
    // }
   
   //여자(30~39세)
   // if(PBF<22) 
   // PBF_Result="매우 우수";
   // else if(22.1<=PBF && PBF<25.4)
   // PBF_Result="우수";
   // else if(25.5<=PBF&& PBF<31.4)
   // PBF_Result="보통";
   // else if(PBF>34.5)
   // PBF_Result="나쁨";
   // return PBF_Result;
    // }
   
   //여자(40~49세)
   // if(PBF<25.2) 
   // PBF_Result="매우 우수";
   // else if(25.3<=PBF && PBF<27.8)
   // PBF_Result="우수";
   // else if(27.9<=PBF&& PBF<34)
   // PBF_Result="보통";
   // else if(PBF>34.1)
   // PBF_Result="나쁨";
   // return PBF_Result;
    // }
   
   //여자(50~59세)
   // if(PBF<28.8) 
   // PBF_Result="매우 우수";
   // else if(28.9<=PBF && PBF<32.2)
   // PBF_Result="우수";
   // else if(32.3<=PBF&& PBF<37.2)
   // PBF_Result="보통";
   // else if(PBF>37.3)
   // PBF_Result="나쁨";
   // return PBF_Result;
    // }
   
   //여자(60세 이상)
   // if(PBF<29.1) 
   // PBF_Result="매우 우수";
   // else if(29.2<=PBF && PBF<32.8)
   // PBF_Result="우수";
   // else if(32.8<=PBF&& PBF<37.9)
   // PBF_Result="보통";
   // else if(PBF>38)
   // PBF_Result="나쁨";
   // return PBF_Result;
    // }
  

   // 복부지방률 (Waist-Hip Ratio) - 복부에 있는 지방의 비율 (엉덩이 둘레와 허리둘레의 비율)
   // 계산법 : 허리둘레(cm) / 엉덩이둘레(cm)
   //
   //if (s.equals("체크")) {
   //남자
   // if(0.86<=WHR && WHR<0.99)
   // WHR_Result="정상범위";
   // else if(WHR>1)
   // WHR_Result="복부비만";
   // else if(WHR<=0.85)
   // WHR_Result="사지비낭";   
   // return WHR_Result;
   
   //여자
   // if(0.76<=WHR && WHR<0.89) 
   // WHR_Result="정상범위";
   // else if(WHR>0.9)
   // WHR_Result="복부비만";
   // else if(WHR<=0.75)
   // WHR_Result="사지비낭";   
   // return WHR_Result;
   // }

   private String tf_InbRe11(double PBF) {
   
   return null;
}

private String tf_InbRe(double bMI) {

      return null;
   }

   public String tf_InbRe1(double Fat) {
      return null;
   }

}


