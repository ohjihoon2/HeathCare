package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class InbodyUI extends JFrame implements ActionListener {

   BufferedImage img = null;
   // Field
   MainScreenUI mainui;
   StartUI startui;
   JFrame jf;
   JPanel p_InbMain, p_InbCb, p_InbMain_img;
   JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight, l_InbPbf_bodyfat, l_InbPbf_weight, l_InbWhr_waist,
         l_InbWhr_butt, l_InbReBMI, l_InbReWe, l_InbRePBF, l_InbReFat, l_InbReWHR;
   TextField tf_InbBmi_height, tf_InbBmi_weight, tf_InbPbf_bodyfat, tf_InbPbf_weight, tf_InbWhr_waist, tf_InbWhr_butt,
         tf_InbReBMI, tf_InbReWe, tf_InbReFat, tf_InbRePBF, tf_InbReWHR;
   JRadioButton cb_InbM, cb_InbW;
   JButton b_InbEnter, b_InbReset, b_InbMain;
   ImageIcon icon;
   double height, weight, BMI,PBF,WHR, bweight;

   // UI ����
   public InbodyUI(MainScreenUI mainui,StartUI startui) {
	  this.mainui = mainui;
      this.startui = startui;

      setLocation(400, 100);
      setLayout(new GridLayout(1, 2));
      icon = new ImageIcon("C:\\Users\\SIST\\Desktop\\gg\\ht18.jpg");

      p_InbMain = new JPanel() {
         public void paintComponent(Graphics g) {
            // �̹̺� ����������
            // g.drawImage(icon.getImage(),100, 100, null);
            // �̹��� ��ü ������
            Dimension d = getSize();
            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);

            setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����

            super.paintComponent(g);
         }
      };

      p_InbMain.setLayout(null);

      /**
       * ����
       **/

      l_InbMsg = new JLabel("*** ��ü������ �Է��Ͻð� �Ʒ��� üũ��ư�� �������� ***");
      l_InbMsg.setFont(new Font("�������", Font.BOLD, 14));
      /////////////////// üũ�ڽ�////////////////////////

      p_InbCb = new JPanel();
      cb_InbM = new JRadioButton("����");
      cb_InbW = new JRadioButton("����");

      ButtonGroup group = new ButtonGroup();
      group.add(cb_InbM);
      group.add(cb_InbW);
      p_InbCb.add(cb_InbM);
      p_InbCb.add(cb_InbW);

      //////////////// BMI ���� ///////////////////////
      l_InbBmi_height = new JLabel("Ű(cm) :");
      l_InbBmi_height.setFont(new Font("�������", Font.BOLD, 15));
      l_InbBmi_weight = new JLabel("������(kg) :");
      l_InbBmi_weight.setFont(new Font("�������", Font.BOLD, 15));

      tf_InbBmi_height = new TextField();
      tf_InbBmi_weight = new TextField();

      ///////////////// ü����� /////////////////////////
      l_InbPbf_bodyfat = new JLabel("ü����(kg) :");
      l_InbPbf_bodyfat.setFont(new Font("�������", Font.BOLD, 15));
      l_InbPbf_weight = new JLabel("������(kg) :");
      l_InbPbf_weight.setFont(new Font("�������", Font.BOLD, 15));

      tf_InbPbf_bodyfat = new TextField();
      tf_InbPbf_weight = new TextField();

      ///////////////// ��������� ///////////////////////
      l_InbWhr_waist = new JLabel("�㸮�ѷ�(cm) :");
      l_InbWhr_waist.setFont(new Font("�������", Font.BOLD, 15));
      l_InbWhr_butt = new JLabel("�����̵ѷ�(cm) :");
      l_InbWhr_butt.setFont(new Font("�������", Font.BOLD, 15));

      tf_InbWhr_waist = new TextField();
      tf_InbWhr_butt = new TextField();

      /////////////// üũ, �ٽ��Է� ��ư /////////////////////
      b_InbEnter = new JButton("üũ");
      b_InbReset = new JButton("�ٽ��Է�");
      b_InbMain = new JButton("����");

      /**
       * ������
       **/

      l_InbReBMI = new JLabel("������(BMI) :");
      l_InbReBMI.setFont(new Font("�������", Font.BOLD, 15));
      l_InbReWe = new JLabel("ǥ��ü��(kg) :");
      l_InbReWe.setFont(new Font("�������", Font.BOLD, 15));
      tf_InbReBMI = new TextField();
      tf_InbReWe = new TextField();

      l_InbRePBF = new JLabel("ü����� :");
      l_InbRePBF.setFont(new Font("�������", Font.BOLD, 15));
      tf_InbRePBF = new TextField();

      l_InbReFat = new JLabel("�񸸵� :");
      l_InbReFat.setFont(new Font("�������", Font.BOLD, 15));
      tf_InbReFat = new TextField();

      l_InbReWHR = new JLabel("��������� :");
      l_InbReWHR.setFont(new Font("�������", Font.BOLD, 15));
      tf_InbReWHR = new TextField();

      ///////////////////////////////////////////////////////////////////////////////////
      l_InbMsg.setBounds(70, 60, 400, 20);

      cb_InbM.setBounds(180, 130, 70, 30);
      cb_InbW.setBounds(260, 130, 70, 30);

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

      b_InbEnter.setBounds(140, 450, 60, 25);
      b_InbReset.setBounds(210, 450, 90, 25);
      b_InbMain.setBounds(310, 450, 60, 25);

      l_InbReBMI.setBounds(550, 200, 120, 25);
      l_InbReWe.setBounds(750, 200, 100, 25);
      tf_InbReBMI.setBounds(670, 200, 50, 30);
      tf_InbReWe.setBounds(850, 200, 50, 30);

      l_InbRePBF.setBounds(590, 280, 80, 25);
      tf_InbRePBF.setBounds(670, 280, 50, 30);

      l_InbReFat.setBounds(790, 280, 60, 25);
      tf_InbReFat.setBounds(850, 280, 50, 30);

      l_InbReWHR.setBounds(570, 370, 100, 25);
      tf_InbReWHR.setBounds(670, 370, 50, 30);

      p_InbMain.add(l_InbMsg);
      p_InbMain.setBackground(Color.white);
      p_InbMain.add(cb_InbM);
      p_InbMain.add(cb_InbW);

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

      p_InbMain.add(l_InbReBMI);
      p_InbMain.add(l_InbReWe);
      p_InbMain.add(tf_InbReBMI);
      p_InbMain.add(tf_InbReWe);

      p_InbMain.add(l_InbRePBF);
      p_InbMain.add(tf_InbRePBF);

      p_InbMain.add(l_InbReFat);
      p_InbMain.add(tf_InbReFat);

      p_InbMain.add(l_InbReWHR);
      p_InbMain.add(tf_InbReWHR);

      // �̺�Ʈ �ڵ鷯 ����
      b_InbEnter.addActionListener(this);
      b_InbReset.addActionListener(this);
      b_InbMain.addActionListener(this);

      p_InbMain.setSize(1000, 600);
      p_InbMain.setVisible(true);
      setTitle("�ιٵ� ���α׷�");

      startui.jf.getContentPane().add(p_InbMain);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   public void turnoff() {
      System.out.println("Inbody ȭ�� turnoff");
      p_InbMain.setVisible(false);
   }

   // �̺�Ʈ ó��
   public void actionPerformed(ActionEvent ae) {
      String s = ae.getActionCommand();
      
      ///////////////// BMI ���////////////////////////////////////
      if (s.equals("üũ")) {

         // �������� Ű���� int������ �ٲ�
         height = Double.valueOf(tf_InbBmi_height.getText()).doubleValue();
         // ǥ��ü�߰��
         double N_weight = (height - 100) * 0.9;

         // Ű���� cm�� Ű�� m�� �ٲ�
         height = height / 100;

         weight = Double.valueOf(tf_InbBmi_weight.getText()).doubleValue();

         // BMI ���
         BMI = Math.round(weight / (height * height));

         String re = tf_InbReBMI(BMI);
         // ��� ���
         tf_InbReBMI.setText("" + BMI);
         tf_InbReWe.setText("" + N_weight);

      } else {
         tf_InbBmi_height.setText("");
         tf_InbBmi_weight.setText("");
      }
      
      ///////////// �񸸵� ���//////////////////////////////////////////////////////
      // �񸸵� (Body Mass Index, Kg/��) - �񸸵��� �����ϴ� �������� ����
      // ���� : ü��(kg) / �����(��)
      if (s.equals("üũ")) {
         double Fat = BMI;
         String Fat_Result = "";
         if (Fat < 20)
            Fat_Result = "��ü��";
         else if (20 <= Fat && Fat < 25)
            Fat_Result = "����";
         else if (25 <= Fat && Fat < 30)
            Fat_Result = "��ü��";
         else if (Fat <= 30)
            Fat_Result = "��";
         tf_InbReFat.setText("" + Fat_Result);
      }else if(s.equals("����")) {
    	  p_InbMain.setVisible(false);
    	  mainui.p_sc_total.setVisible(true);
      }
   

      //////////////// ü����� ���/////////////////////////////////////////////////
      if (s.equals("üũ")) {
          bweight = Double.valueOf(tf_InbPbf_weight.getText()).doubleValue();
          
          weight = Double.valueOf(tf_InbPbf_weight.getText()).doubleValue();
          
          // BMI ���
          PBF = Math.round(bweight /  (weight * 100));         
          
          // String re = tf_InbRePBF(PBF);
                    
          // ��� ���
          tf_InbRePBF.setText("" + PBF);         
          } else {
          tf_InbRePBF.setText("");

      }

   }
      /////////////// ü����� ���/////////////////////////////////////////////////////
      // ü����� - ü�߿��� ü���淮�� �����ϴ� ����
       // ���� : ü����(kg) / ü��(kg) X 100%

   //   if (s.equals("üũ")) {

   ////����
   // if(PBF<20) 
   // PBF_Result="��ü��";
   // else if(20<=PBF && PBF<25)
   // PBF_Result="����";
   // else if(25<=PBF&& PBF<30)
   // PBF_Result="��ü��";
   // else if(PBF<=30)
   // PBF_Result="��";
   // return PBF_Result;
   
   ////����
   // if(PBF<20) 
   // PBF_Result="��ü��";
   // else if(20<=PBF && PBF<25)
   // PBF_Result="����";
   // else if(25<=PBF&& PBF<30)
   // PBF_Result="��ü��";
   // else if(PBF<=30)
   // PBF_Result="��";
   // return PBF_Result;
    // }

   // ��������� (Waist-Hip Ratio) - ���ο� �ִ� ������ ���� (������ �ѷ��� �㸮�ѷ��� ����)
   // ���� : �㸮�ѷ�(cm) / �����̵ѷ�(cm)
   //
    //   if (s.equals("üũ")) {
   ///����
   // if(WHR<20) //����
   // WHR_Result="����";
   // else if(20<=WHR && WHR<25)
   // WHR_Result="����";
   // else if(25<=WHR&& WHR<30)
   // WHR_Result="���";
   // else if(WHR<=30)
   // WHR_Result="�ſ���";
   // return WHR_Result;
   
   ////����
   // if(WHR<20) 
   // WHR_Result="��ü��";
   // else if(20<=WHR && WHR<25)
   // WHR_Result="����";
   // else if(25<=WHR&& WHR<30)
   // WHR_Result="��ü��";
   // else if(WHR<=30)
   // WHR_Result="���Դϴ�.";
   // return WHR_Result;
   // }

   private String tf_InbReBMI(double bMI) {

      return null;
   }

   public String Fat_Check(double Fat) {
      return null;
   }

}