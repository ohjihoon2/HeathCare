import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


public class DietUI extends JFrame implements ActionListener {
	//Field
	JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	JLabel l_Diettitle, l_Dietdate, l_l_Dietdietname, l_Dietsex, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietRl_Dietcalorie,l_Dietcalorie,l_Dietbad,l_Dietgood;
	JTextArea ta_Dietlist, ta_DietRecord;
	JTextField tf_DietDiet, tf_Dietweight, tf_Diettargetweight;
	JButton b_DietSearch, b_DietSave, b_DietReset, b_DietBack, b_DietChoice;
	JScrollPane s_Dietscroll;
	
	//Constructor
	public DietUI() {
		setTitle("°³ÀÎÀÏÁö");
		p_Dietall = new JPanel();
		
		p_Dieta1 = new JPanel();
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_Dieta1.setBorder(b1);

		p_Dieta2 = new JPanel();
		p_Dieta2_1 = new JPanel();
		ta_Dietlist = new JTextArea();
		s_Dietscroll = new JScrollPane(ta_Dietlist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//p_Dieta2_2 = new JPanel();
		
		p_Dieta3 = new JPanel();
		LineBorder b3 = new LineBorder(Color.BLACK,1); 
		p_Dieta3.setBorder(b3);
		
		l_Diettitle = new JLabel("°³ÀÎÀÏÁö",JLabel.CENTER);
		l_Diettitle.setFont(new Font("³ª´®°íµñ",Font.BOLD,25));
		
		l_Dietdate = new JLabel("³¯Â¥  :   " +"sysl_Dietdate"+"³â¿ùÀÏ");
		l_Dietdate.setFont(new Font("³ª´®°íµñ",Font.BOLD,16));
		
		l_l_Dietdietname = new JLabel("È¸¿ø  :   "+"l_l_Dietdietname"+"È«±æµ¿");
		l_l_Dietdietname.setFont(new Font("³ª´®°íµñ",Font.BOLD,16));
		
		l_Dietsex = new JLabel("¼ºº°  :   "+"Mgender"+"³²,¿©");
		l_Dietsex.setFont(new Font("³ª´®°íµñ",Font.BOLD,16));
		
		l_Dietweight = new JLabel("Ã¼Áß(Kg)");
		l_Dietweight.setFont(new Font("³ª´®°íµñ",Font.BOLD,16));
		
		l_Diettargetweight = new JLabel("¸ñÇ¥Ã¼Áß(Kg)");
		l_Diettargetweight.setFont(new Font("³ª´®°íµñ",Font.BOLD,16));
		
		
		l_Dietdl_Dietcalorie = new JLabel("¡¤ÇÏ·ç ¼·Ãë Ä®·Î¸®");
		l_Dietdl_Dietcalorie.setFont(new Font("³ª´®°íµñ",Font.BOLD,17));
		
		l_Dietdietname = new JLabel("À½½ÄÃ£±â");
		l_Dietdietname.setFont(new Font("³ª´®°íµñ",Font.BOLD,16));
		
		l_DietCl_Dietcalorie = new JLabel("¼±ÅÃÇÑÄ®·Î¸®"+"  -");
		l_DietCl_Dietcalorie.setFont(new Font("³ª´®°íµñ",Font.BOLD,18));
		
		l_DietRl_Dietcalorie = new JLabel("±ÇÀåÄ®·Î¸®"+"  =");
		l_DietRl_Dietcalorie.setFont(new Font("³ª´®°íµñ",Font.BOLD,18));
		
		l_Dietcalorie = new JLabel("Ä®·Î¸®");
		l_Dietcalorie.setFont(new Font("³ª´®°íµñ",Font.BOLD,18));
		
		l_Dietbad = new JLabel("OOOKcalÃÊ°ú");
		l_Dietbad.setFont(new Font("³ª´®°íµñ",Font.BOLD,14));
		l_Dietbad.setForeground(Color.RED);
		
		l_Dietgood = new JLabel("l_Dietgood");
		l_Dietgood.setFont(new Font("³ª´®°íµñ",Font.BOLD,14));
		l_Dietgood.setForeground(Color.GREEN);
		
		tf_DietDiet = new JTextField();
//		jtfl_Dietdate = new JTextField();
//		jtfl_l_Dietdietname = new JTextField();
//		jtfSex = new JTextField();
		
		tf_Dietweight = new JTextField("Kg");
		tf_Dietweight.setHorizontalAlignment(tf_Dietweight.CENTER); 
		
		tf_Diettargetweight = new JTextField("Kg");
		tf_Diettargetweight.setHorizontalAlignment(tf_Diettargetweight.CENTER); 
		
		b_DietSearch = new JButton("°Ë»ö");
		b_DietSave = new JButton("ÀúÀå");
		b_DietReset = new JButton("Ãë¼Ò");
		b_DietBack = new JButton("¸ÞÀÎ");
		
		p_Dieta1.setBounds(0,50,980,200);
		p_Dieta1.setBackground(Color.WHITE);
		l_Dietdate.setBounds(200,50,430,30);
		l_l_Dietdietname.setBounds(200,90,430,30);
		l_Dietsex.setBounds(200,130,430,30);
		l_Dietweight.setBounds(550,50,430,20);
		tf_Dietweight.setBounds(542,80,80,80);
		l_Diettargetweight.setBounds(650,50,430,20);
		tf_Diettargetweight.setBounds(657,80,80,80);
		
		p_Dieta2.setBounds(0,260,1000,480);
		p_Dieta2.setBackground(Color.WHITE);
		l_Dietdl_Dietcalorie.setBounds(200,0,420,30);
		l_Dietdietname.setBounds(200,30,100,30);
		tf_DietDiet.setBounds(270,30,200,30);
		b_DietSearch.setBounds(480,30,60,30);
		
		s_Dietscroll.setBounds(200,70,600,400);
//		p_Dieta2_2.setBounds(0,10,200,500);
//		p_Dieta2_2.setBackground(Color.red);
		
		p_Dieta3.setBounds(0,750,980,150);
		p_Dieta3.setBackground(Color.WHITE);
		l_DietCl_Dietcalorie.setBounds(350,10,200,30);
		l_DietRl_Dietcalorie.setBounds(480,10,200,30);
		l_Dietcalorie.setBounds(610,10,200,30);
		l_Dietbad.setBounds(420,40,200,30);
		l_Dietgood.setBounds(520,40,200,30);
		b_DietSave.setBounds(400,80,60,30);
		b_DietReset.setBounds(480,80,60,30);
		b_DietBack.setBounds(560,80,60,30);
		
		
		p_Dieta1.add(l_Dietdate);
		p_Dieta1.add(l_l_Dietdietname);
		p_Dieta1.add(l_Dietsex);
		p_Dieta1.add(l_Dietweight);
		p_Dieta1.add(tf_Dietweight);
		p_Dieta1.add(l_Diettargetweight);
		p_Dieta1.add(tf_Diettargetweight);
		p_Dietall.add(p_Dieta1);
		
		p_Dieta2.add(l_Dietdl_Dietcalorie);
		p_Dieta2.add(l_Dietdietname);
		p_Dieta2.add(tf_DietDiet);
		
		//scroll.add(p_Dieta2_2);
		p_Dieta2.add(s_Dietscroll);
		p_Dieta2.add(b_DietSearch);
		p_Dietall.add(p_Dieta2);
		
		p_Dieta3.add(l_DietCl_Dietcalorie);
		p_Dieta3.add(l_DietRl_Dietcalorie);
		p_Dieta3.add(l_Dietcalorie);
		p_Dieta3.add(l_Dietbad);
		p_Dieta3.add(l_Dietgood);
		p_Dieta3.add(b_DietSave);
		p_Dieta3.add(b_DietReset);
		p_Dieta3.add(b_DietBack);
		p_Dietall.add(p_Dieta3);
		
		p_Dieta1.setLayout(null);
		p_Dieta2.setLayout(null);
		p_Dieta2_1.setLayout(null);
		//p_Dieta2_2.setLayout(null);
		p_Dieta3.setLayout(null);
		p_Dietall.setLayout(null);
		
		getContentPane().add(l_Diettitle,BorderLayout.NORTH);
		getContentPane().add(p_Dietall);
		setSize(1000,1000);
		setVisible(true);
		
		//ÀÌº¥Æ® µî·Ï
		b_DietSearch.addActionListener(this);
		b_DietSave.addActionListener(this);
		b_DietReset.addActionListener(this);
		b_DietBack.addActionListener(this);		
	}
	
	//À¯È¿¼º Ã¼Å©
	
	//ÀÌº¥Æ® Ã³¸®
	public void actionPerformed(ActionEvent ae) {
		
			
			
	}
}
