package com.mycom.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
import javax.swing.JTextArea;

public class InbodyUI extends JFrame implements ActionListener {


   // Field
   MainScreenUI mainui;
   StartUI startui;
   JFrame jf;
   JPanel p_InbMain, p_InbCb, p_InbMain_img;
   JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight, l_InbPbf_bodyfat, l_InbPbf_weight, l_InbWhr_waist,
   l_InbWhr_butt, l_InbReBMI, l_InbReWe, l_InbRePBF, l_InbReFat, l_InbReWHR;
   TextField tf_InbBmi_height, tf_InbBmi_weight, tf_InbPbf_bodyfat,  tf_InbPbf_weight, tf_InbWhr_waist, tf_InbWhr_butt;
   JRadioButton cb_InbM, cb_InbW;
   JButton b_InbEnter, b_InbReset, b_InbMain, b_InbReg;
   ImageIcon icon;
   double height, weight, BMI, bweight, PBF, WHR, waist, butt;
   Vector age;
   JComboBox ageBox;
   JTextArea a_InbRe;
   String result, result2;

   // UI ����
   public InbodyUI(MainScreenUI mainui,StartUI startui) {
      this.mainui = mainui;
      this.startui = startui;

      setLocation(400, 100);
      icon = new ImageIcon("image/ht22.jpg");

      p_InbMain = new JPanel() {
         public void paintComponent(Graphics g) {
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
      l_InbMsg.setFont(new Font("�������", Font.BOLD, 16));
      /////////////////// üũ�ڽ�////////////////////////

      p_InbCb = new JPanel();
      cb_InbM = new JRadioButton("����");
      cb_InbW = new JRadioButton("����");

      age=new Vector();
      age.add("����");
      age.add("19��~29��");
      age.add("30��~39��");
      age.add("40��~49��");
      age.add("50��~59��");
      age.add("60�� �̻�");

      ageBox=new JComboBox(age);


      ButtonGroup group = new ButtonGroup();
      group.add(cb_InbM);
      group.add(cb_InbW);

      Enumeration<AbstractButton> enums = group.getElements();

      int gibonCode = 0;

      while(enums.hasMoreElements()) {
         AbstractButton ab = enums.nextElement();
         JRadioButton jb = (JRadioButton)ab;

         if(jb.isSelected())     
            gibonCode = Integer.parseInt(jb.getText().trim());

      }


      a_InbRe = new JTextArea();
      a_InbRe.setFont(new Font("�������",Font.BOLD,17));
      a_InbRe.append(" ====== �ιٵ� �˻� ��� ====== \n");


      //////////////// BMI ���� ///////////////////////
      l_InbBmi_height = new JLabel("Ű(cm) :");
      l_InbBmi_height.setFont(new Font("�������", Font.BOLD, 16));
      l_InbBmi_weight = new JLabel("������(kg) :");
      l_InbBmi_weight.setFont(new Font("�������", Font.BOLD, 16));

      tf_InbBmi_height = new TextField();
      tf_InbBmi_weight = new TextField();

      ///////////////// ü����� /////////////////////////
      l_InbPbf_bodyfat = new JLabel("ü����(kg) :");
      l_InbPbf_bodyfat.setFont(new Font("�������", Font.BOLD, 16));
      l_InbPbf_weight = new JLabel("������(kg) :");
      l_InbPbf_weight.setFont(new Font("�������", Font.BOLD, 15));

      tf_InbPbf_bodyfat = new TextField();
      tf_InbPbf_weight = new TextField();

      ///////////////// ��������� ///////////////////////
      l_InbWhr_waist = new JLabel("�㸮�ѷ�(cm) :");
      l_InbWhr_waist.setFont(new Font("�������", Font.BOLD, 16));
      l_InbWhr_butt = new JLabel("�����̵ѷ�(cm) :");
      l_InbWhr_butt.setFont(new Font("�������", Font.BOLD, 16));

      tf_InbWhr_waist = new TextField();
      tf_InbWhr_butt = new TextField();

      /////////////// üũ, �ٽ��Է� ��ư /////////////////////
      b_InbEnter = new JButton("üũ");
      b_InbReset = new JButton("�ٽ��Է�");
      b_InbReg = new JButton("���");
      b_InbMain = new JButton("����");


      ///////////////////////////////////////////////////////////////////////////////////
      l_InbMsg.setBounds(110, 60, 450, 20);

      cb_InbM.setBounds(210, 130, 60, 30);
      cb_InbM.setBackground(new Color(88, 175, 192));
      cb_InbW.setBounds(270, 130, 60, 30);
      cb_InbW.setBackground(new Color(88, 175, 192));

      ageBox.setBounds(360,130,80,30);
      ageBox.setBackground(Color.WHITE);

      l_InbBmi_height.setBounds(150, 200, 60, 30);
      l_InbBmi_weight.setBounds(350, 200, 90, 30);
      tf_InbBmi_height.setBounds(220, 200, 50, 30);
      tf_InbBmi_weight.setBounds(440, 200, 50, 30);

      l_InbPbf_bodyfat.setBounds(130, 270, 90, 50);
      l_InbPbf_weight.setBounds(350, 290, 80, 15);
      tf_InbPbf_bodyfat.setBounds(220, 280, 50, 30);
      tf_InbPbf_weight.setBounds(440, 280, 50, 30);

      l_InbWhr_waist.setBounds(110, 370, 110, 25);
      l_InbWhr_butt.setBounds(310, 370, 130, 25);
      tf_InbWhr_waist.setBounds(220, 370, 50, 30);
      tf_InbWhr_butt.setBounds(440, 370, 50, 30);

      b_InbEnter.setBounds(180, 450, 60, 25);
      b_InbReset.setBounds(250, 450, 90, 25);
      b_InbReg.setBounds(350,450,60,25);
      b_InbMain.setBounds(420, 450, 60, 25);


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
      p_InbMain.add(l_InbPbf_weight);
      p_InbMain.add(tf_InbPbf_bodyfat);
      p_InbMain.add(tf_InbPbf_weight);

      p_InbMain.add(l_InbWhr_waist);
      p_InbMain.add(l_InbWhr_butt);
      p_InbMain.add(tf_InbWhr_waist);
      p_InbMain.add(tf_InbWhr_butt);

      p_InbMain.add(b_InbEnter);
      p_InbMain.add(b_InbReset);
      p_InbMain.add(b_InbReg);
      p_InbMain.add(b_InbMain);

      p_InbMain.add(a_InbRe);


      // �̺�Ʈ �ڵ鷯 ����
      b_InbEnter.addActionListener(this);
      b_InbReset.addActionListener(this);
      b_InbReg.addActionListener(this);
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



   /**�̺�Ʈ ó��**/
   public void actionPerformed(ActionEvent ae) {

      //////////////////// BMI ���////////////////////////////////////
      String s = ae.getActionCommand();

      if (s.equals("üũ")) {

         if(!tf_InbBmi_height.getText().equals("") && !tf_InbBmi_height.getText().equals(null)) {

            // �������� Ű���� int������ �ٲ�
            height = Double.valueOf(tf_InbBmi_height.getText()).doubleValue();

            // ǥ��ü�߰��            
            double S_weight = (height - 100) * 0.9;

            // Ű���� cm�� Ű�� m�� �ٲ�
            height = height / 100;
            weight = Double.valueOf(tf_InbBmi_weight.getText()).doubleValue();

            // BMI ���
            BMI = Math.round(weight / (height * height));

            // �񸸵� ��� 
            double Fat = BMI;

            String Fat_Result = "";

            if (Fat < 20.0) {
               Fat_Result = "��ü��";                   
            }else if (20.0 <= Fat && Fat < 25.0) {
               Fat_Result = "����";
            }else if (25.0 <= Fat && Fat < 30.0) {
               Fat_Result = "��ü��";
            }else if (Fat <= 30.0) {
               Fat_Result = "��";
            }




            /////////////////////////// ü����� ���/////////////////////////////////////    
            // ���� : ü����(kg) / ü��(kg) X 100%

            weight = Double.valueOf(tf_InbPbf_weight.getText()).doubleValue();
            bweight = Double.valueOf(tf_InbPbf_bodyfat.getText()).doubleValue();

            PBF = Math.round((bweight / weight) * 100); 

            if(cb_InbM.isSelected()) {
               if(ageBox.getSelectedItem().equals("19��~29��")) {
                  if(PBF<15) result = "�ſ� ���";
                  else if(15.1<=PBF && PBF<=18.5) result = "���";
                  else if(18.6<=PBF&& PBF<=24.3) result = "����";
                  else if(18.6<=PBF&& PBF<=24.3) result = "����";

               } else if(ageBox.getSelectedItem().equals("30��~39��")) {
                  if(PBF<18) result = "�ſ� ���";
                  else if(18.1<=PBF && PBF<=20.5) result = "���";
                  else if(18.6<=PBF&& PBF<=24.3) result = "����";
                  else if(PBF>=26.1) result = "����";

               } else if(ageBox.getSelectedItem().equals("40��~49��")) {
                  if(PBF<=20.2) result = "�ſ� ���";
                  else if(20.3<=PBF && PBF<=24.8) result = "���";
                  else if(24.9<=PBF&& PBF<=27.5) result = "����";
                  else if(PBF>=27.6) result = "����";

               } else if(ageBox.getSelectedItem().equals("50��~59��")) {
                  if(PBF<=22.3) result = "�ſ� ���";
                  else if(22.4<=PBF && PBF<=25.1) result = "���";
                  else if(25.1<=PBF&& PBF<=29.2) result = "����";
                  else if(PBF>=29.3) result = "����";

               } else if(ageBox.getSelectedItem().equals("60�� �̻�")) {
                  if(PBF<=22.5) result = "�ſ� ���";
                  else if(22.6<=PBF && PBF<=25.5) result = "���";
                  else if(25.6<=PBF&& PBF<=29.7) result = "����";
                  else if(PBF>=29.8) result = "����";
               }
            }

            if(cb_InbW.isSelected()) {
               if(ageBox.getSelectedItem().equals("19��~29��")) {
                  if(PBF<20) result = "�ſ� ���";
                  else if(20.1<=PBF && PBF<23.4) result = "���";
                  else if(23.5<=PBF&& PBF<29.7) result = "����";
                  else if(PBF>29.8) result = "����";

               } else if(ageBox.getSelectedItem().equals("30��~39��")) {
                  if(PBF<22) result = "�ſ� ���";
                  else if(22.1<=PBF && PBF<25.4) result = "���";
                  else if(25.5<=PBF&& PBF<31.4) result = "����";
                  else if(PBF>34.5) result = "����";

               } else if(ageBox.getSelectedItem().equals("40��~49��")) {
                  if(PBF<25.2) result = "�ſ� ���";
                  else if(25.3<=PBF && PBF<27.8) result = "���";
                  else if(27.9<=PBF&& PBF<34) result = "����";
                  else if(PBF>34.1) result = "����";

               } else if(ageBox.getSelectedItem().equals("50��~59��")) {
                  if(PBF<28.8) result = "�ſ� ���";
                  else if(28.9<=PBF && PBF<32.2) result = "���";
                  else if(32.3<=PBF&& PBF<37.2) result = "����";
                  else if(PBF>37.3) result = "����";

               } else if(ageBox.getSelectedItem().equals("60�� �̻�")) {
                  if(PBF<29.1) result = "�ſ� ���";
                  else if(29.2<=PBF && PBF<32.8) result = "���";
                  else if(32.8<=PBF&& PBF<37.9) result = "����";
                  else if(PBF>38) result = "����";
               }


            }


            /////////////// ��������� ��� /////////////////////////////////////////////////////
            // ��������� (Waist-Hip Ratio) - ���ο� �ִ� ������ ���� (������ �ѷ��� �㸮�ѷ��� ����)
            // ���� : �㸮�ѷ�(cm) / �����̵ѷ�(cm)

            if (s.equals("üũ")) {
               waist = Double.valueOf(tf_InbWhr_waist.getText()).doubleValue();
               butt = Double.valueOf(tf_InbWhr_butt.getText()).doubleValue();
               WHR = Math.round(waist / butt);

               if(cb_InbM.isSelected()) {
                  if(0.86<=WHR && WHR<=0.99) result2 = "�������";
                  else if(WHR>=1.0) result2 = "���κ�";
                  else if(WHR<=0.85) result2 = "������";
               } 
               if(cb_InbW.isSelected()) {
                  if(0.76<=WHR && WHR<=0.89)  result2 = "�������";
                  else if(WHR>=0.9) result2 = "���κ�";
                  else if(WHR<=0.75) result2 = "������";
               }
            }

            // ��� ���                
            a_InbRe.setText(" ====== �ιٵ� �˻� ��� ====== \n"+"\n"+ "  BMI : " + BMI+"\n"+ "  ǥ��ü�� : "+  S_weight + "\n" 
                  + "  �񸸵� : " + Fat_Result+"\n"+"  ü����� : " +PBF+" "+ result + "\n" +"  ��������� : " +WHR +" "+ result2 );


         }else {
            a_InbRe.setText("��ü ������ �Է��ϼ��� ^^");
         }

      }else if(s.equals("����")) {
         p_InbMain.setVisible(false);
         mainui.p_sc_total.setVisible(true);
      } 


   }   
}





