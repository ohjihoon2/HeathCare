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
	
	
	//로그인 Field
	JFrame jf;
	JPanel p_LogMain, p_LogLogin , p_LogBtn, p_LogNum; 
	JLabel l_Logid;
	JTextField tf_LogId;
	JButton b_LogLogin, b_LogCreate, b_Log1, b_Log2, b_Log3, b_Log4, b_Log5, b_Log6, b_Log7, b_Log8, b_Log9;
	
	
	//회원가입 Field
	JPanel p_RegMain, p_RegTitle, p_RegBoard, p_RegBtn; 
	JLabel l_RegTitle, l_RegName, l_RegAddress, l_RegContact, l_RegRole, l_RegCreated_date, l_RegBirth, l_RegTerm, l_RegEvent, l_RegStart_date, l_RegEnd_date;
	JTextField tf_RegName, tf_RegAddress, tf_RegContact, tf_RegRole, tf_RegCreated_date, tf_RegBirth, tf_RegTerm, tf_RegEvent, tf_RegStart_date, tf_RegEnd_date;
	JButton b_RegNext, b_RegCancel;
		
	
	//메인스크린 field
	JPanel p_sc_total, p_sc_top, p_sc_infobox,p_sc_btnbox,p_sc_uno,p_sc_time,p_sc_picture,p_sc_l_sc_locker,p_sc_sysdate;
	JButton b_sc_lecture, b_sc_inbody, b_sc_personal,b_sc_chatting;
	JLabel l_sc_topimgbox, l_sc_uno, l_sc_time, l_sc_ubox, l_sc_locker,l_sc_sysdate;
	JTextArea jta_sc_uno, jta_sc_limit, jta_sc_locker; 
	ImageIcon ic_sc_timg, ic_sc_uimg;
    
	
	//수강 field
    JPanel p_gx_main,p_gx_top, p_gx_main2, p_gx_left, p_gx_right, p_gx_pn4, p_gx_l_gx_info, p_gx_name, p_gx_lecture, p_gx_l_gx_times, p_gx_l_gx_limit, p_gx_blank;
    JLabel l_gx_uno, l_gx_info, l_gx_uname, l_gx_lecture, l_gx_times, l_gx_limit;
    JButton b_gx_extension;
    JTextField jtf_gx_uname, jtf2, jtf_gx_times, jtf_gx_limit;
    ImageIcon ic_gx_uimg, ic_gx_topimg;
    JLabel ic_gx_uimgBox, ic_gx_topimgBox;
    
    
    //개인일지 field
    JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	JLabel l_Diettitle, l_Dietdate, l_l_Dietdietname, l_Dietsex, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietRl_Dietcalorie,l_Dietcalorie,l_Dietbad,l_Dietgood;
	JTextArea ta_Dietlist, ta_DietRecord;
	JTextField tf_DietDiet, tf_Dietweight, tf_Diettargetweight;
	JButton b_DietSearch, b_DietSave, b_DietReset, b_DietBack, b_DietChoice;
	JScrollPane s_Dietscroll;
    
	
    //인바디 Field
   
    JPanel p_InbMain, p_InbCb;
    JLabel l_InbMsg, l_InbCb, l_InbBmi_height, l_InbBmi_weight,l_InbPbf_bodyfat,l_InbPbf_weight,l_InbWhr_waist,l_InbWhr_butt,
           l_InbReBMI, l_InbReWe,l_InbRePBF,l_InbReWHR;
    TextField tf_InbBmi_height, tf_InbBmi_weight,tf_InbPbf_bodyfat,tf_InbPbf_weight,tf_InbWhr_waist,tf_InbWhr_butt,
            tf_InbReBMI,tf_InbReWe,tf_InbRePBF,tf_InbReWHR;
    JRadioButton cb_InbM, cb_InbW;
    JButton b_InbEnter, b_InbReset, b_InbMain;
    
	/**
	 * 로그인 
	 */
	//Constructor
    public LoginUI() {
    	jf = new JFrame();
    	StartUI();
    }
    
    //Method
	public void StartUI(){
		
		setStatus(LOGIN);
		//1. 화면구성
		// 패널 초기화 
		
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

		b_LogLogin = new JButton("로그인");
		b_LogCreate = new JButton("회원가입");

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

		//2. 이벤트 핸들러 정의
		b_LogLogin.addActionListener(this);
		b_LogCreate.addActionListener(this);
	}
	
	//Method

	/**
	 * 회원가입
	 */
	public void SignUpUI(){
		setStatus(REGIST);
		//Constructor
			//1. 화면구성
			// 패널 초기화 
			
		p_RegMain = new JPanel(new GridLayout(3,1));
//			p_RegMain = new JPanel();
		
		p_RegTitle = new JPanel();
		p_RegBoard = new JPanel(new GridLayout(10,2));
		p_RegBtn = new JPanel();
		
		b_RegNext = new JButton("다음");
		b_RegCancel = new JButton("취소");
		
		l_RegTitle = new JLabel("회원가입");
		
		l_RegName = new JLabel("회원명");
		l_RegAddress = new JLabel("주소");
		l_RegContact = new JLabel("연락처");
		l_RegRole = new JLabel("구분");
		l_RegCreated_date = new JLabel("회원가입일");
		l_RegBirth = new JLabel("생년월일");
		l_RegTerm = new JLabel("신청기간");
		l_RegEvent = new JLabel("종목");
		l_RegStart_date = new JLabel("시작일");
		l_RegEnd_date = new JLabel("마지막일");
		
		
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
		
//			setTitle("회원가입");
//			getContentPane().add(p_RegMain, BorderLayout.CENTER);
		p_RegMain.setSize(1000,600);
		p_RegMain.setVisible(true);
//			setBounds(200,200,350,200);
//			setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//			jpReg.setVisible(true);
//				
		jf.getContentPane().add(p_RegMain, BorderLayout.CENTER);
		
		//2. 이벤트 핸들러 정의
		b_RegNext.addActionListener(this);
		b_RegCancel.addActionListener(this);
	}
	/**
	 * 메인페이지
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
	  
	  
		b_sc_lecture = new JButton("수강");
		b_sc_lecture.setFont(new Font("돋움", Font.BOLD, 40));
		b_sc_inbody = new JButton("인바디");
		b_sc_inbody.setFont(new Font("돋움", Font.BOLD, 40));
		b_sc_personal = new JButton("개인일지");
		b_sc_personal.setFont(new Font("돋움", Font.BOLD, 40));
		b_sc_chatting = new JButton("채팅");
		b_sc_chatting.setFont(new Font("돋움", Font.BOLD, 40));
	  
	  
		ic_sc_timg = new ImageIcon("image/top.png");
		l_sc_topimgbox = new JLabel(ic_sc_timg);
	  
	  
		ic_sc_uimg = new ImageIcon("image/client.png");
		l_sc_ubox = new JLabel(ic_sc_uimg);
		  
	  
		l_sc_uno = new JLabel("회원번호");
		l_sc_uno.setFont(new Font("돋움", Font.BOLD, 30));
		jta_sc_uno = new JTextArea(8,25);
	
		l_sc_time = new JLabel("헬스장 이용기간");
		l_sc_time.setFont(new Font("돋움", Font.BOLD, 30));
		jta_sc_limit = new JTextArea(8,25);
	  
	  
		l_sc_locker = new JLabel("락커 이용기간");
		l_sc_locker.setFont(new Font("돋움", Font.BOLD, 30));
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
	
	  
	  	setTitle("메인화면"); 
	  	p_sc_total.setSize(1000,600);
	  	p_sc_total.setVisible(true);
	  	setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	
	    //2. 이벤트 핸들러 정의
	  	b_sc_lecture.addActionListener(this);
	  	b_sc_inbody.addActionListener(this);
	  	b_sc_personal.addActionListener(this);
	  	b_sc_chatting.addActionListener(this);
	  	
      
	}	
	/**
	 * 강의 UI
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
        l_gx_uno = new JLabel("회원번호    7805");
        l_gx_info = new JLabel("[  수 강  정 보  ]") ;
        l_gx_uname = new JLabel("회원 이름");
        l_gx_lecture = new JLabel("수강명");
        l_gx_times = new JLabel("남은 수강 횟수");
        l_gx_limit = new JLabel("유효 기간");
        b_gx_extension = new JButton("연장 신청");
             
        l_gx_uno.setBackground(Color.black);
        l_gx_uno.setFont(new Font("돋움", Font.BOLD, 50));
        l_gx_info.setFont(new Font("돋움", Font.BOLD, 20));
        
        ic_gx_topimg = new ImageIcon("image/top.png");
        ic_gx_topimgBox = new JLabel(ic_gx_topimg);
        
        
        ic_gx_uimg = new ImageIcon("image/회원.png");
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
        
        setTitle("수강"); 
        p_gx_main.setSize(1000,900);
        p_gx_main.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     
    } 

	/**
	 * 개인일지 UI
	 */
	public void DietUI() {
		setTitle("개인일지");
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
		
		l_Diettitle = new JLabel("개인일지",JLabel.CENTER);
		l_Diettitle.setFont(new Font("나눔고딕",Font.BOLD,25));
		
		l_Dietdate = new JLabel("날짜  :   " +"sysl_Dietdate"+"년월일");
		l_Dietdate.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_l_Dietdietname = new JLabel("회원  :   "+"l_l_Dietdietname"+"홍길동");
		l_l_Dietdietname.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietsex = new JLabel("성별  :   "+"Mgender"+"남,여");
		l_Dietsex.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietweight = new JLabel("체중(Kg)");
		l_Dietweight.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Diettargetweight = new JLabel("목표체중(Kg)");
		l_Diettargetweight.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		
		l_Dietdl_Dietcalorie = new JLabel("·하루 섭취 칼로리");
		l_Dietdl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,17));
		
		l_Dietdietname = new JLabel("음식찾기");
		l_Dietdietname.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_DietCl_Dietcalorie = new JLabel("선택한칼로리"+"  -");
		l_DietCl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_DietRl_Dietcalorie = new JLabel("권장칼로리"+"  =");
		l_DietRl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_Dietcalorie = new JLabel("칼로리");
		l_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_Dietbad = new JLabel("OOOKcal초과");
		l_Dietbad.setFont(new Font("나눔고딕",Font.BOLD,14));
		l_Dietbad.setForeground(Color.RED);
		
		l_Dietgood = new JLabel("l_Dietgood");
		l_Dietgood.setFont(new Font("나눔고딕",Font.BOLD,14));
		l_Dietgood.setForeground(Color.GREEN);
		
		tf_DietDiet = new JTextField();
//		jtfl_Dietdate = new JTextField();
//		jtfl_l_Dietdietname = new JTextField();
//		jtfSex = new JTextField();
		
		tf_Dietweight = new JTextField("Kg");
		tf_Dietweight.setHorizontalAlignment(tf_Dietweight.CENTER); 
		
		tf_Diettargetweight = new JTextField("Kg");
		tf_Diettargetweight.setHorizontalAlignment(tf_Diettargetweight.CENTER); 
		
		b_DietSearch = new JButton("검색");
		b_DietSave = new JButton("저장");
		b_DietReset = new JButton("취소");
		b_DietBack = new JButton("메인");
		
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
		
		//이벤트 등록
		b_DietSearch.addActionListener(this);
		b_DietSave.addActionListener(this);
		b_DietReset.addActionListener(this);
		b_DietBack.addActionListener(this);		
		b_DietChoice.addActionListener(this);		
	}
	
	public void Inbody() {
		setStatus(INBODY);	
		setTitle("인바디 프로그램");
		setLayout(new GridLayout(1, 2));

		p_InbMain = new JPanel();
		p_InbMain.setLayout(null);

		/**
		 * 왼쪽
		 **/

		l_InbMsg = new JLabel("*** 신체정보를 입력하시고 아래의 체크버튼을 누르세요 ***");
		l_InbMsg.setFont(new Font("나눔고딕",Font.BOLD,14));
		///////////////////체크박스////////////////////////

		p_InbCb = new JPanel();
		cb_InbM = new JRadioButton("남자");
		cb_InbW = new JRadioButton("여자");

		ButtonGroup group = new ButtonGroup();
		group.add(cb_InbM); group.add(cb_InbW);
		p_InbCb.add(cb_InbM);p_InbCb.add(cb_InbW);
		
		//////////////// BMI 측정 ///////////////////////      
		l_InbBmi_height = new JLabel("키(cm) :");
		l_InbBmi_height.setFont(new Font("나눔고딕",Font.BOLD,15));
		l_InbBmi_weight = new JLabel("몸무게(kg) :");
		l_InbBmi_weight.setFont(new Font("나눔고딕",Font.BOLD,15));

		tf_InbBmi_height = new TextField();
		tf_InbBmi_weight = new TextField();

		///////////////// 체지방률 /////////////////////////
		l_InbPbf_bodyfat = new JLabel("체지방(kg) :");
		l_InbPbf_bodyfat.setFont(new Font("나눔고딕",Font.BOLD,15));
		l_InbPbf_weight = new JLabel("몸무게(kg) :");
		l_InbPbf_weight.setFont(new Font("나눔고딕",Font.BOLD,15));

		tf_InbPbf_bodyfat = new TextField();
		tf_InbPbf_weight = new TextField();

		///////////////// 복부지방률 ///////////////////////
		l_InbWhr_waist = new JLabel("허리둘레(cm) :");
		l_InbWhr_waist.setFont(new Font("나눔고딕",Font.BOLD,15));
		l_InbWhr_butt = new JLabel("엉덩이둘레(cm) :");
		l_InbWhr_butt.setFont(new Font("나눔고딕",Font.BOLD,15));

		tf_InbWhr_waist = new TextField();
		tf_InbWhr_butt = new TextField();


		/////////////// 체크, 다시입력 버튼 /////////////////////
		b_InbEnter = new JButton("체크");
		b_InbReset = new JButton("다시입력");
		b_InbMain = new JButton("메인");


		/**
		 * 오른쪽
		 **/

		l_InbReBMI = new JLabel("비만지수(BMI) :");
		l_InbReBMI.setFont(new Font("나눔고딕",Font.BOLD,15));
		l_InbReWe = new JLabel("표준체중(kg) :");
		l_InbReWe.setFont(new Font("나눔고딕",Font.BOLD,15));
		tf_InbReBMI = new TextField();
		tf_InbReWe = new TextField();

		l_InbRePBF = new JLabel("체지방률 :");
		l_InbRePBF.setFont(new Font("나눔고딕",Font.BOLD,15));
		tf_InbRePBF = new TextField();

		l_InbReWHR = new JLabel("복부지방률 :");
		l_InbReWHR.setFont(new Font("나눔고딕",Font.BOLD,15));
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


		//이벤트 핸들러 정의 
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
			System.out.println("회원가입 클릭");
			switchingPanel(getStatus());
			SignUpUI();
		}else if (obj == b_LogLogin) {
			System.out.println("로그인 클릭");
			switchingPanel(getStatus());
			MainScreenUI();
		}else if(obj == b_RegCancel) {
			System.out.println("취소 클릭");
			switchingPanel(getStatus());
			StartUI();
		}else if(obj == b_RegCancel) {
			//회원가입 - 다음 버튼
			System.out.println("다음 클릭");
//			switchingPanel(getStatus());
//			StartUI();
		}else if(obj == b_sc_lecture) {
			System.out.println("수강 클릭");
			switchingPanel(getStatus());
			LectureUI();
		}else if(obj == b_sc_inbody) {
			System.out.println("인바디 클릭");
			switchingPanel(getStatus());
			Inbody();
		}else if(obj == b_sc_personal) {
			System.out.println("개인일지");
//			switchingPanel(getStatus());
			new DietUI();
			
		}else if(obj == b_DietBack) {
			System.out.println("메인으로");
//			switchingPanel(getStatus());
			MainScreenUI();
			
		}else if(obj == b_sc_chatting) {
			System.out.println("채팅 클릭");
//			switchingPanel(getStatus());
//			StartUI();
		}
	}
	/**
	 * 화면 status setter, getter
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	/**
	 * 화면 Panel 스위칭 메소드
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











