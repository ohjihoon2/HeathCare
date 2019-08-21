import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginUI extends JFrame implements ActionListener{
	
	//Field
	public static final int LOGIN = 0;
	public static final int REGIST = 1;
	public static final int MAIN = 2;
	public static final int GX = 3; 
	public static final int DIET = 4; 
	public static final int INBODY= 5; 
	int status =0;
	
	
	//�α��� Field
	JFrame jf;
	JPanel p_LogMain, p_LogLogin , p_LogBtn, p_LogNum; 
	JLabel l_Logid;
	JTextField tf_LogId;
	JButton b_LogLogin, b_LogCreate, b_Log1, b_Log2, b_Log3, b_Log4, b_Log5, b_Log6, b_Log7, b_Log8, b_Log9;
	
	
	//ȸ������ Field
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegAddress, l_RegContact, l_RegRole, l_RegCreated_date, l_RegBirth, l_RegTerm, l_RegEvent, l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegAddress, tf_RegContact, tf_RegRole, tf_RegCreated_date, tf_RegBirth, tf_RegTerm, tf_RegEvent, tf_RegStart_date, tf_RegEnd_date;
	JButton b_RegNext, b_RegCancel;
		
	
	//���ν�ũ�� field
	JPanel p_sc_total, p_sc_top, p_sc_infobox,p_sc_btnbox,p_sc_uno,p_sc_time,p_sc_picture,p_sc_l_sc_locker,p_sc_sysdate;
	JButton b_sc_lecture, b_sc_inbody, b_sc_personal,b_sc_chatting;
	JLabel l_sc_topimgbox, l_sc_uno, l_sc_time, l_sc_ubox, l_sc_locker,l_sc_sysdate;
	JTextArea jta_sc_uno, jta_sc_limit, jta_sc_locker; 
	ImageIcon ic_sc_timg, ic_sc_uimg;
    
	
	//���� field
    JPanel p_gx_main,p_gx_top, p_gx_main2, p_gx_left, p_gx_right, p_gx_pn4, p_gx_l_gx_info, p_gx_name, p_gx_lecture, p_gx_l_gx_times, p_gx_l_gx_limit, p_gx_blank;
    JLabel l_gx_uno, l_gx_info, l_gx_uname, l_gx_lecture, l_gx_times, l_gx_limit;
    JButton b_gx_extension;
    JTextField jtf_gx_uname, jtf2, jtf_gx_times, jtf_gx_limit;
    ImageIcon ic_gx_uimg, ic_gx_topimg;
    JLabel ic_gx_uimgBox, ic_gx_topimgBox;
    
    
    //�������� field
    JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	JLabel l_Diettitle, l_Dietdate, l_l_Dietdietname, l_Dietsex, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietRl_Dietcalorie,l_Dietcalorie,l_Dietbad,l_Dietgood;
	JTextArea ta_Dietlist, ta_DietRecord;
	JTextField tf_DietDiet, tf_Dietweight, tf_Diettargetweight;
	JButton b_DietSearch, b_DietSave, b_DietReset, b_DietBack, b_DietChoice;
	JScrollPane s_Dietscroll;
    
	
    //�ιٵ� Field
   
    JPanel p_InbMain, p_InbCb;
    JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight,l_InbPbf_bodyfat,l_InbPbf_weight,l_InbWhr_waist,l_InbWhr_butt,
           l_InbReBMI, l_InbReWe,l_InbRePBF,l_InbReWHR;
    TextField tf_InbBmi_height, tf_InbBmi_weight,tf_InbPbf_bodyfat,tf_InbPbf_weight,tf_InbWhr_waist,tf_InbWhr_butt,
            tf_InbReBMI,tf_InbReWe,tf_InbRePBF,tf_InbReWHR;
    JRadioButton cb_InbM, cb_InbW;
    JButton b_InbEnter, b_InbReset, b_InbMain;
    
	/**
	 * �α��� 
	 */
	//Constructor
    public LoginUI() {
    	jf = new JFrame();
    	StartUI();
    }
    
    //Method
	public void StartUI(){
		
		setStatus(LOGIN);
		//1. ȭ�鱸��
		// �г� �ʱ�ȭ 
		
		p_LogMain = new JPanel(new GridLayout(3,1));
		
		p_LogLogin = new JPanel();
		p_LogBtn = new JPanel();
		p_LogNum = new JPanel(); 
		
		b_Log1 = new JButton("1"); 
		b_Log2 = new JButton("2"); 
		b_Log3 = new JButton("3");
		b_Log4 = new JButton("4");
		b_Log5 = new JButton("5");
		b_Log6 = new JButton("6");
		b_Log7 = new JButton("7");
		b_Log8 = new JButton("8");
		b_Log9 = new JButton("9");

		b_LogLogin = new JButton("�α���");
		b_LogCreate = new JButton("ȸ������");

//		p_LogMain.setLayout(null);

		l_Logid = new JLabel("ID : ");
		tf_LogId = new JTextField(20);
		
		p_LogLogin.add(l_Logid);
		p_LogLogin.add(tf_LogId);
		
		p_LogNum.setLayout(new GridLayout(4,3));

		p_LogNum.add(b_Log1);
		p_LogNum.add(b_Log2);
		p_LogNum.add(b_Log3);
		p_LogNum.add(b_Log4);
		p_LogNum.add(b_Log5);
		p_LogNum.add(b_Log6);
		p_LogNum.add(b_Log7);
		p_LogNum.add(b_Log8);
		p_LogNum.add(b_Log9);
		
		p_LogBtn.add(b_LogLogin);
		p_LogBtn.add(b_LogCreate);
		
		p_LogMain.add(p_LogLogin);		
		p_LogMain.add(p_LogNum);		
		p_LogMain.add(p_LogBtn);		
		
//		jf.getContentPane().add(title, BorderLayout.NORTH);
//		jf.getContentPane().add(p_RegBtn, BorderLayout.WEST);
//		jf.getContentPane().add(msgPanel, BorderLayout.CENTER);
		jf.getContentPane().add(p_LogMain, BorderLayout.CENTER);
		
		jf.setSize(1000,600);
//		p_LogNum.setSize(600, 400);
//		p_LogNum.setBounds(200,200,350,200);
		jf.setLocation(500	, 20);
		jf.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//2. �̺�Ʈ �ڵ鷯 ����
		b_LogLogin.addActionListener(this);
		b_LogCreate.addActionListener(this);
	}
	
	//Method

	/**
	 * ȸ������
	 */
	public void SignUpUI(){
		setStatus(REGIST);
		//Constructor
			//1. ȭ�鱸��
			// �г� �ʱ�ȭ 
			
		p_RegMain = new JPanel(new GridLayout(3,1));
//			p_RegMain = new JPanel();
		
		p_RegTitle = new JPanel();
		p_RegBoard = new JPanel(new GridLayout(10,2));
		p_RegBtn = new JPanel();
		
		b_RegNext = new JButton("����");
		b_RegCancel = new JButton("���");
		
		l_RegTitle = new JLabel("ȸ������");
		
		l_RegName = new JLabel("ȸ����");
		l_RegAddress = new JLabel("�ּ�");
		l_RegContact = new JLabel("����ó");
		l_RegRole = new JLabel("����");
		l_RegCreated_date = new JLabel("ȸ��������");
		l_RegBirth = new JLabel("�������");
		l_RegTerm = new JLabel("��û�Ⱓ");
		l_RegEvent = new JLabel("����");
		l_RegStart_date = new JLabel("������");
		l_RegEnd_date = new JLabel("��������");
		
		
		tf_RegName = new JTextField(10);
		tf_RegAddress = new JTextField(10);
		tf_RegContact = new JTextField(10);
		tf_RegRole = new JTextField(10);
		tf_RegCreated_date = new JTextField(10);
		tf_RegBirth = new JTextField(10);
		tf_RegTerm = new JTextField(10);
		tf_RegEvent = new JTextField(10);
		tf_RegStart_date = new JTextField(10);
		tf_RegEnd_date = new JTextField(10);
		
		l_RegTitle.setHorizontalAlignment(0);
		p_RegTitle.add(l_RegTitle);
		
		p_RegBoard.add(l_RegName); p_RegBoard.add(tf_RegName);
		p_RegBoard.add(l_RegAddress); p_RegBoard.add(tf_RegAddress);
		p_RegBoard.add(l_RegContact); p_RegBoard.add(tf_RegContact);
		p_RegBoard.add(l_RegRole); p_RegBoard.add(tf_RegRole);
		p_RegBoard.add(l_RegCreated_date); p_RegBoard.add(tf_RegCreated_date);
		p_RegBoard.add(l_RegBirth); p_RegBoard.add(tf_RegBirth);
		p_RegBoard.add(l_RegTerm); p_RegBoard.add(tf_RegTerm);
		p_RegBoard.add(l_RegEvent); p_RegBoard.add(tf_RegEvent);
		p_RegBoard.add(l_RegStart_date); p_RegBoard.add(tf_RegStart_date);
		p_RegBoard.add(l_RegEnd_date); p_RegBoard.add(tf_RegEnd_date);
		
		p_RegBtn.add(b_RegNext);
		p_RegBtn.add(b_RegCancel);
		
		
		p_RegMain.add(p_RegTitle);		
		p_RegMain.add(p_RegBoard);		
		p_RegMain.add(p_RegBtn);		
		
//			setTitle("ȸ������");
//			getContentPane().add(p_RegMain, BorderLayout.CENTER);
		p_RegMain.setSize(1000,600);
		p_RegMain.setVisible(true);
//			setBounds(200,200,350,200);
//			setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//			jpReg.setVisible(true);
//				
		jf.getContentPane().add(p_RegMain, BorderLayout.CENTER);
		
		//2. �̺�Ʈ �ڵ鷯 ����
		b_RegNext.addActionListener(this);
		b_RegCancel.addActionListener(this);
	}
	/**
	 * ����������
	 */
	public void MainScreenUI() {
		setStatus(MAIN);
		p_sc_total = new JPanel();
		p_sc_total.setLayout(new BorderLayout());
		p_sc_top = new JPanel();
		p_sc_infobox = new JPanel(new GridLayout(2,2));
		p_sc_btnbox = new JPanel(new GridLayout(4,1));
		p_sc_uno = new JPanel();
		p_sc_time = new JPanel();
		p_sc_picture = new JPanel();
		p_sc_l_sc_locker = new JPanel();
		p_sc_sysdate = new JPanel();
	  
	  
		b_sc_lecture = new JButton("����");
		b_sc_lecture.setFont(new Font("����", Font.BOLD, 40));
		b_sc_inbody = new JButton("�ιٵ�");
		b_sc_inbody.setFont(new Font("����", Font.BOLD, 40));
		b_sc_personal = new JButton("��������");
		b_sc_personal.setFont(new Font("����", Font.BOLD, 40));
		b_sc_chatting = new JButton("ä��");
		b_sc_chatting.setFont(new Font("����", Font.BOLD, 40));
	  
	  
		ic_sc_timg = new ImageIcon("image/top.png");
		l_sc_topimgbox = new JLabel(ic_sc_timg);
	  
	  
		ic_sc_uimg = new ImageIcon("image/client.png");
		l_sc_ubox = new JLabel(ic_sc_uimg);
		  
	  
		l_sc_uno = new JLabel("ȸ����ȣ");
		l_sc_uno.setFont(new Font("����", Font.BOLD, 30));
		jta_sc_uno = new JTextArea(8,25);
	
		l_sc_time = new JLabel("�ｺ�� �̿�Ⱓ");
		l_sc_time.setFont(new Font("����", Font.BOLD, 30));
		jta_sc_limit = new JTextArea(8,25);
	  
	  
		l_sc_locker = new JLabel("��Ŀ �̿�Ⱓ");
		l_sc_locker.setFont(new Font("����", Font.BOLD, 30));
		jta_sc_locker = new JTextArea(8,25);
	  
		l_sc_sysdate = new JLabel("2019-08-20");
	  
		p_sc_top.add(l_sc_topimgbox);
		p_sc_infobox.add(p_sc_uno); p_sc_infobox.add(p_sc_time); p_sc_infobox.add(p_sc_picture); p_sc_infobox.add(p_sc_l_sc_locker);
		p_sc_btnbox.add(b_sc_lecture);
		p_sc_btnbox.add(b_sc_inbody);
		p_sc_btnbox.add(b_sc_personal);
		p_sc_btnbox.add(b_sc_chatting);
		p_sc_btnbox.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
		b_sc_lecture.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		b_sc_inbody.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		b_sc_personal.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		b_sc_chatting.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
	  
	
		p_sc_uno.add(l_sc_uno); p_sc_uno.add(jta_sc_uno);
		p_sc_uno.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p_sc_time.add(l_sc_time); p_sc_time.add(jta_sc_limit);
	  	p_sc_time.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
	  	p_sc_picture.add(l_sc_ubox);
	  	p_sc_picture.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
	  	p_sc_l_sc_locker.add(l_sc_locker); p_sc_l_sc_locker.add(jta_sc_locker);
	  	p_sc_l_sc_locker.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
	  	p_sc_total.add(p_sc_top,BorderLayout.NORTH);
	  	p_sc_total.add(p_sc_infobox, BorderLayout.CENTER);
	  	p_sc_total.add(p_sc_btnbox,BorderLayout.EAST);
	  	p_sc_total.add(p_sc_sysdate,BorderLayout.SOUTH);
	  
	  	jf.getContentPane().add(p_sc_total,BorderLayout.CENTER);
	
	  
	  	setTitle("����ȭ��"); 
	  	p_sc_total.setSize(1000,600);
	  	p_sc_total.setVisible(true);
	  	setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	
	    //2. �̺�Ʈ �ڵ鷯 ����
	  	b_sc_lecture.addActionListener(this);
	  	b_sc_inbody.addActionListener(this);
	  	b_sc_personal.addActionListener(this);
	  	b_sc_chatting.addActionListener(this);
	  	
      
	}	
	/**
	 * ���� UI
	 */
	public void LectureUI() {
		setStatus(GX);
        p_gx_main = new JPanel();
        p_gx_main.setLayout(new BorderLayout());
        p_gx_top = new JPanel();    
        p_gx_main2 = new JPanel(new GridLayout(1,2));
        p_gx_left = new JPanel(new GridLayout(2,1));
        p_gx_right = new JPanel();
        p_gx_pn4 = new JPanel();
        p_gx_l_gx_info = new JPanel();
        p_gx_name = new JPanel();
        p_gx_lecture = new JPanel();
        p_gx_l_gx_times = new JPanel();
        p_gx_l_gx_limit = new JPanel();
        p_gx_blank = new JPanel();
        

        jtf_gx_uname = new JTextField(30);
        jtf2 = new JTextField(30);
        jtf_gx_times = new JTextField(30);
        jtf_gx_limit = new JTextField(30);
        l_gx_uno = new JLabel("ȸ����ȣ    7805");
        l_gx_info = new JLabel("[  �� ��  �� ��  ]") ;
        l_gx_uname = new JLabel("ȸ�� �̸�");
        l_gx_lecture = new JLabel("������");
        l_gx_times = new JLabel("���� ���� Ƚ��");
        l_gx_limit = new JLabel("��ȿ �Ⱓ");
        b_gx_extension = new JButton("���� ��û");
             
        l_gx_uno.setBackground(Color.black);
        l_gx_uno.setFont(new Font("����", Font.BOLD, 50));
        l_gx_info.setFont(new Font("����", Font.BOLD, 20));
        
        ic_gx_topimg = new ImageIcon("image/top.png");
        ic_gx_topimgBox = new JLabel(ic_gx_topimg);
        
        
        ic_gx_uimg = new ImageIcon("image/ȸ��.png");
        ic_gx_uimgBox = new JLabel(ic_gx_uimg);

       
        p_gx_main.add("North", p_gx_top);
        p_gx_main.add("Center", p_gx_main2);
        
        
        p_gx_top.add(ic_gx_topimgBox);
        p_gx_main2.add(p_gx_left); p_gx_main2.add(p_gx_right);
        p_gx_left.add(l_gx_uno);  p_gx_left.add(ic_gx_uimgBox);
        
   
        p_gx_l_gx_info.add(l_gx_info);
        p_gx_name.add(l_gx_uname); p_gx_name.add(jtf_gx_uname);
        p_gx_lecture.add(l_gx_lecture); p_gx_lecture.add(jtf2);
        p_gx_l_gx_times.add(l_gx_times); p_gx_l_gx_times.add(jtf_gx_times);
        p_gx_l_gx_limit.add(l_gx_limit); p_gx_l_gx_limit.add(jtf_gx_limit);
        p_gx_right.setLayout(new GridLayout(7,1));
        
        p_gx_right.add(p_gx_blank);
        p_gx_right.add(p_gx_l_gx_info); p_gx_right.add(p_gx_name); p_gx_right.add(p_gx_lecture);
        p_gx_right.add(p_gx_l_gx_times); p_gx_right.add(p_gx_l_gx_limit);
        p_gx_right.add(p_gx_pn4, BorderLayout.SOUTH);
        p_gx_pn4.add(b_gx_extension, BorderLayout.EAST);
        

        jf.getContentPane().add(p_gx_main, BorderLayout.CENTER);
        
        setTitle("����"); 
        p_gx_main.setSize(1000,900);
        p_gx_main.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     
    } 

	/**
	 * �������� UI
	 */
	public void DietUI() {
		setTitle("��������");
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
		
		l_Diettitle = new JLabel("��������",JLabel.CENTER);
		l_Diettitle.setFont(new Font("�������",Font.BOLD,25));
		
		l_Dietdate = new JLabel("��¥  :   " +"sysl_Dietdate"+"�����");
		l_Dietdate.setFont(new Font("�������",Font.BOLD,16));
		
		l_l_Dietdietname = new JLabel("ȸ��  :   "+"l_l_Dietdietname"+"ȫ�浿");
		l_l_Dietdietname.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietsex = new JLabel("����  :   "+"Mgender"+"��,��");
		l_Dietsex.setFont(new Font("�������",Font.BOLD,16));
		
		l_Dietweight = new JLabel("ü��(Kg)");
		l_Dietweight.setFont(new Font("�������",Font.BOLD,16));
		
		l_Diettargetweight = new JLabel("��ǥü��(Kg)");
		l_Diettargetweight.setFont(new Font("�������",Font.BOLD,16));
		
		
		l_Dietdl_Dietcalorie = new JLabel("���Ϸ� ���� Į�θ�");
		l_Dietdl_Dietcalorie.setFont(new Font("�������",Font.BOLD,17));
		
		l_Dietdietname = new JLabel("����ã��");
		l_Dietdietname.setFont(new Font("�������",Font.BOLD,16));
		
		l_DietCl_Dietcalorie = new JLabel("������Į�θ�"+"  -");
		l_DietCl_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
		
		l_DietRl_Dietcalorie = new JLabel("����Į�θ�"+"  =");
		l_DietRl_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
		
		l_Dietcalorie = new JLabel("Į�θ�");
		l_Dietcalorie.setFont(new Font("�������",Font.BOLD,18));
		
		l_Dietbad = new JLabel("OOOKcal�ʰ�");
		l_Dietbad.setFont(new Font("�������",Font.BOLD,14));
		l_Dietbad.setForeground(Color.RED);
		
		l_Dietgood = new JLabel("l_Dietgood");
		l_Dietgood.setFont(new Font("�������",Font.BOLD,14));
		l_Dietgood.setForeground(Color.GREEN);
		
		tf_DietDiet = new JTextField();
//		jtfl_Dietdate = new JTextField();
//		jtfl_l_Dietdietname = new JTextField();
//		jtfSex = new JTextField();
		
		tf_Dietweight = new JTextField("Kg");
		tf_Dietweight.setHorizontalAlignment(tf_Dietweight.CENTER); 
		
		tf_Diettargetweight = new JTextField("Kg");
		tf_Diettargetweight.setHorizontalAlignment(tf_Diettargetweight.CENTER); 
		
		b_DietSearch = new JButton("�˻�");
		b_DietSave = new JButton("����");
		b_DietReset = new JButton("���");
		b_DietBack = new JButton("����");
		
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
		p_Dietall.setSize(1000,1000);
		p_Dietall.setVisible(true);
		
		//�̺�Ʈ ���
		b_DietSearch.addActionListener(this);
		b_DietSave.addActionListener(this);
		b_DietReset.addActionListener(this);
		b_DietBack.addActionListener(this);		
		b_DietChoice.addActionListener(this);		
	}
	
	public void Inbody() {
		setStatus(INBODY);	
		setTitle("�ιٵ� ���α׷�");
		setLayout(new GridLayout(1, 2));

		p_InbMain = new JPanel();
		p_InbMain.setLayout(null);

		/**
		 * ����
		 **/

		l_InbMsg = new JLabel("*** ��ü������ �Է��Ͻð� �Ʒ��� üũ��ư�� �������� ***");
		l_InbMsg.setFont(new Font("�������",Font.BOLD,14));
		///////////////////üũ�ڽ�////////////////////////

		p_InbCb = new JPanel();
		cb_InbM = new JRadioButton("����");
		cb_InbW = new JRadioButton("����");

		ButtonGroup group = new ButtonGroup();
		group.add(cb_InbM); group.add(cb_InbW);
		p_InbCb.add(cb_InbM);p_InbCb.add(cb_InbW);
		
		//////////////// BMI ���� ///////////////////////      
		l_InbBmi_height = new JLabel("Ű(cm) :");
		l_InbBmi_height.setFont(new Font("�������",Font.BOLD,15));
		l_InbBmi_weight = new JLabel("������(kg) :");
		l_InbBmi_weight.setFont(new Font("�������",Font.BOLD,15));

		tf_InbBmi_height = new TextField();
		tf_InbBmi_weight = new TextField();

		///////////////// ü����� /////////////////////////
		l_InbPbf_bodyfat = new JLabel("ü����(kg) :");
		l_InbPbf_bodyfat.setFont(new Font("�������",Font.BOLD,15));
		l_InbPbf_weight = new JLabel("������(kg) :");
		l_InbPbf_weight.setFont(new Font("�������",Font.BOLD,15));

		tf_InbPbf_bodyfat = new TextField();
		tf_InbPbf_weight = new TextField();

		///////////////// ��������� ///////////////////////
		l_InbWhr_waist = new JLabel("�㸮�ѷ�(cm) :");
		l_InbWhr_waist.setFont(new Font("�������",Font.BOLD,15));
		l_InbWhr_butt = new JLabel("�����̵ѷ�(cm) :");
		l_InbWhr_butt.setFont(new Font("�������",Font.BOLD,15));

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
		l_InbReBMI.setFont(new Font("�������",Font.BOLD,15));
		l_InbReWe = new JLabel("ǥ��ü��(kg) :");
		l_InbReWe.setFont(new Font("�������",Font.BOLD,15));
		tf_InbReBMI = new TextField();
		tf_InbReWe = new TextField();

		l_InbRePBF = new JLabel("ü����� :");
		l_InbRePBF.setFont(new Font("�������",Font.BOLD,15));
		tf_InbRePBF = new TextField();

		l_InbReWHR = new JLabel("��������� :");
		l_InbReWHR.setFont(new Font("�������",Font.BOLD,15));
		tf_InbReWHR = new TextField();


		l_InbMsg.setBounds(100,60,400,20);

		cb_InbM.setBounds(180,130,70,30);   
		cb_InbW.setBounds(260,130,70,30);

		l_InbBmi_height.setBounds(90,200,60,30);      
		l_InbBmi_weight.setBounds(270,200,80,30);
		tf_InbBmi_height.setBounds(150,200,50,30);   
		tf_InbBmi_weight.setBounds(355,200,50,30);

		l_InbPbf_bodyfat.setBounds(70,270,80,50);   
		l_InbPbf_weight.setBounds(270,290,80,15);
		tf_InbPbf_bodyfat.setBounds(150,280,50,30);      
		tf_InbPbf_weight.setBounds(355,280,50,30);

		l_InbWhr_waist.setBounds(50,370,100,25);
		l_InbWhr_butt.setBounds(240,370,110,25);
		tf_InbWhr_waist.setBounds(150,370,50,30);      
		tf_InbWhr_butt.setBounds(355,370,50,30);

		b_InbEnter.setBounds(150,450,60,25);
		b_InbReset.setBounds(220,450,90,25);
		b_InbMain.setBounds(320,450,60,25);

		l_InbReBMI.setBounds(550,200,120,25);
		l_InbReWe.setBounds(750,200,100,25);      
		tf_InbReBMI.setBounds(670,200,50,30);   
		tf_InbReWe.setBounds(850,200,50,30);

		l_InbRePBF.setBounds(590,280,80,25);
		tf_InbRePBF.setBounds(670,280,50,30);   

		l_InbReWHR.setBounds(580,370,80,25);   
		tf_InbReWHR.setBounds(670,370,50,30);



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

		p_InbMain.add(l_InbReWHR);
		p_InbMain.add(tf_InbReWHR);


		//�̺�Ʈ �ڵ鷯 ���� 
		b_InbEnter.addActionListener(this);
		b_InbReset.addActionListener(this);
		b_InbMain.addActionListener(this);

		p_InbMain.setSize(1000,600);
		p_InbMain.setVisible(true);

		jf.getContentPane().add(p_InbMain);

		//	      p_InbMain.setLayout(null);
		//	      pan1.setLayout(null);
		//	      pan2.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}
	
	
	//Method
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// TODO Auto-generated method stub
		if(obj == b_LogCreate) {
			System.out.println("ȸ������ Ŭ��");
			switchingPanel(getStatus());
			SignUpUI();
		}else if (obj == b_LogLogin) {
			System.out.println("�α��� Ŭ��");
			switchingPanel(getStatus());
			MainScreenUI();
		}else if(obj == b_RegCancel) {
			System.out.println("��� Ŭ��");
			switchingPanel(getStatus());
			StartUI();
		}else if(obj == b_RegCancel) {
			//ȸ������ - ���� ��ư
			System.out.println("���� Ŭ��");
//			switchingPanel(getStatus());
//			StartUI();
		}else if(obj == b_sc_lecture) {
			System.out.println("���� Ŭ��");
			switchingPanel(getStatus());
			LectureUI();
		}else if(obj == b_sc_inbody) {
			System.out.println("�ιٵ� Ŭ��");
			switchingPanel(getStatus());
			Inbody();
		}else if(obj == b_sc_personal) {
			System.out.println("��������");
//			switchingPanel(getStatus());
			new DietUI();
			
		}else if(obj == b_DietBack) {
			System.out.println("��������");
//			switchingPanel(getStatus());
			MainScreenUI();
			
		}else if(obj == b_sc_chatting) {
			System.out.println("ä�� Ŭ��");
//			switchingPanel(getStatus());
//			StartUI();
		}
	}
	/**
	 * ȭ�� status setter, getter
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	/**
	 * ȭ�� Panel ����Ī �޼ҵ�
	 */
	public void switchingPanel(int status) {
		switch(status) {
		case 0 : 
			p_LogMain.setVisible(false);
			break;
		case 1 :
			p_RegMain.setVisible(false);
			break;
		case 2 :
			p_sc_total.setVisible(false);
			break;
		case 3 :
			p_gx_main.setVisible(false);
			break;
//		case 4 :
//			p_InbMain.setVisible(false);
//			break;
		case 5 :
			p_InbMain.setVisible(false);
			break;
			default : 
		}
	}
		
}











