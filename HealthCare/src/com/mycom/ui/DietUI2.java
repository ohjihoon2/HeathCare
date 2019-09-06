package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.StringValueExp;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mycom.dao.DietDAO;
import com.mycom.system.DietSystem;
import com.mycom.vo.DietMemberVO;
import com.mycom.vo.DietSaveVO;


public class DietUI2 extends JFrame implements ActionListener {
	//Field
	DietUI ui;
	DietDAO dao = new DietDAO();
	JPanel p_Dietall, p_Dieta1, p_Dieta2, p_Dieta2_1, p_Dieta2_2, p_Dieta3;
	
	JLabel l_Diettitle,l_DietDwNO, l_DietCno, l_Dietdate,l_Dietdate2, l_DietName,l_DietName2, l_Dietsex,l_Dietsex2, l_Dietweight, l_Diettargetweight,
	       l_Dietdietname,l_Dietdl_Dietcalorie,l_DietCl_Dietcalorie,l_DietCl_Dietcalorie2,l_DietRl_Dietcalorie
	       ,l_DietRl_Dietcalorie2,l_Dietcalorie,l_Dietcalorie2,l_Dietbad,l_Dietgood;
	JTextArea ta_Dietlist, ta_DietRecord;
	
	JTextField tf_Dietcalorie,tf_DietDiet, tf_Dietweight, tf_Diettargetweight;
	
	JButton b_DietResult, b_DietSave, b_DietReset, b_DietBack;
	
	JScrollPane s_Dietscroll;

	DietSystem system = new DietSystem();
	public static DietMemberVO vo = new DietMemberVO();
	
	DefaultTableModel d_Dietdt;
	JTable j_DIettable;
	
	// 스크롤 페널 생성
	String[] name = {"번호","식품이름","열량(kcal)","날짜"};
	int Selectsum = 0;
	int Csum = 0;
	int kcal=0;
	
	//Constructor
	public DietUI2(DietUI ui) {
		this.ui = ui;
		
		
		p_Dietall = new JPanel();
		
		p_Dieta1 = new JPanel();
		LineBorder b1 = new LineBorder(Color.BLACK,1); 
		p_Dieta1.setBorder(b1);

		p_Dieta2 = new JPanel();
		p_Dieta2_1 = new JPanel();
		
 
		
		d_Dietdt = new DefaultTableModel(name, 0);
		j_DIettable = new JTable(d_Dietdt); 
        s_Dietscroll = new JScrollPane(j_DIettable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        j_DIettable.getColumnModel().getColumn(0).setPreferredWidth(50);
        j_DIettable.getColumnModel().getColumn(1).setPreferredWidth(200);
        //테이블 컬럼 가로길이 조정
        
		//ta_Dietlist = new JTextArea();
		
		//p_Dieta2_2 = new JPanel();
		
		p_Dieta3 = new JPanel();
		LineBorder b3 = new LineBorder(Color.BLACK,1); 
		p_Dieta3.setBorder(b3);
		
//		l_Diettitle = new JLabel("ㄴㄴ",JLabel.CENTER);
//		l_Diettitle.setFont(new Font("나눔고딕",Font.BOLD,25));
		l_DietCno = new JLabel();
		l_DietCno.setText(Integer.toString(DietUI.mvo.getCNO()));
		l_DietCno.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_DietDwNO = new JLabel();
		l_DietCno.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietdate = new JLabel("날짜  :   ");
		l_Dietdate.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietdate2 = new JLabel();
		//l_Dietdate2.setText(DietUI.mvo.getNAME());
		l_Dietdate2.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_DietName = new JLabel("회원  :   ");
		l_DietName.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_DietName2 = new JLabel();
		l_DietName2.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietsex = new JLabel("성별  :   ");
		
		l_Dietsex.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietsex2 = new JLabel();
		l_Dietsex2.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Dietweight = new JLabel("체중(Kg)");
		l_Dietweight.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_Diettargetweight = new JLabel("목표체중(Kg)");
		l_Diettargetweight.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		
		l_Dietdl_Dietcalorie = new JLabel("·추가항목");
		l_Dietdl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,17));
		
//		l_Dietdietname = new JLabel("음식찾기");
//		l_Dietdietname.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		l_DietCl_Dietcalorie = new JLabel("선택한칼로리" +"   -");
		l_DietCl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,22));
		
		l_DietCl_Dietcalorie2 = new JLabel();
		l_DietCl_Dietcalorie2.setFont(new Font("나눔고딕",Font.BOLD,22));
//		tf_Dietcalorie = new JTextField("kcal");
//		tf_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,18));
		
		l_DietRl_Dietcalorie = new JLabel("권장칼로리"+"  =");
		l_DietRl_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,22));
		
		l_DietRl_Dietcalorie2 = new JLabel();
		l_DietRl_Dietcalorie2.setFont(new Font("나눔고딕",Font.BOLD,22));
		
		l_Dietcalorie = new JLabel("칼로리");
		l_Dietcalorie.setFont(new Font("나눔고딕",Font.BOLD,22));
		
		l_Dietcalorie2 = new JLabel();
		l_Dietcalorie2.setFont(new Font("나눔고딕",Font.BOLD,22));
		
		l_Dietbad = new JLabel();
		l_Dietbad.setFont(new Font("나눔고딕",Font.BOLD,16));
		l_Dietbad.setForeground(Color.DARK_GRAY);
		
		l_Dietgood = new JLabel();
		l_Dietgood.setFont(new Font("나눔고딕",Font.BOLD,16));
		l_Dietgood.setForeground(Color.DARK_GRAY);
		
		//tf_DietDiet = new JTextField();
//		jtfl_Dietdate = new JTextField();
//		jtfl_DietName = new JTextField();
//		jtfSex = new JTextField();
		
		tf_Dietweight = new JTextField();
		tf_Dietweight.setHorizontalAlignment(tf_Dietweight.CENTER); 
		
		tf_Diettargetweight = new JTextField();
		tf_Diettargetweight.setHorizontalAlignment(tf_Diettargetweight.CENTER); 
		
		b_DietResult = new JButton("칼로리계산");
		b_DietSave = new JButton("저장");
		//b_DietReset = new JButton("취소");
		b_DietBack = new JButton("뒤로가기");
		
		p_Dieta1.setBounds(0,50,980,200);
		p_Dieta1.setBackground(Color.WHITE);
		l_DietDwNO.setBounds(150,20,100,30);
		l_Dietdate.setBounds(200,50,100,30);
		l_Dietdate2.setBounds(250,50,100,30);
		l_DietName.setBounds(200,90,430,30);
		l_DietName2.setBounds(250,90,100,30);
		l_Dietsex.setBounds(200,130,430,30);
		l_Dietsex2.setBounds(250,130,100,30);
		l_Dietweight.setBounds(550,50,430,20);
		tf_Dietweight.setBounds(542,80,80,80);
		l_Diettargetweight.setBounds(650,50,430,20);
		tf_Diettargetweight.setBounds(657,80,80,80);
		
		p_Dieta2.setBounds(0,260,1000,480);
		p_Dieta2.setBackground(Color.WHITE);
		l_Dietdl_Dietcalorie.setBounds(50,10,420,30);
		//l_Dietdietname.setBounds(200,30,100,30);
		//tf_DietDiet.setBounds(270,30,200,30);
		
		
		s_Dietscroll.setBounds(50,50,900,200);
//		p_Dieta2_2.setBounds(0,10,200,500);
//		p_Dieta2_2.setBackground(Color.red);
		
		p_Dieta3.setBounds(0,750,980,100);
		p_Dieta3.setBackground(Color.WHITE);
		l_DietCl_Dietcalorie.setBounds(270,300,200,30);
		l_DietCl_Dietcalorie2.setBounds(145,300,300,30);
		//tf_Dietcalorie.setBounds(350,10,200,30);
		l_DietRl_Dietcalorie.setBounds(440,300,200,30);
		l_DietRl_Dietcalorie2.setBounds(380,300,300,30);
		l_Dietcalorie.setBounds(590,300,200,30);
		l_Dietcalorie2.setBounds(610,300,300,30);
		l_Dietbad.setBounds(440,350,300,30);
		l_Dietgood.setBounds(440,350,300,30);
		b_DietResult.setBounds(830,300,100,30);
		
		b_DietSave.setBounds(400,30,60,30);
		//b_DietReset.setBounds(460,30,60,30);
		b_DietBack.setBounds(520,30,100,30);
		
		
		p_Dieta1.add(l_DietDwNO);
		p_Dieta1.add(l_Dietdate);
		p_Dieta1.add(l_Dietdate2);
		p_Dieta1.add(l_DietName);
		p_Dieta1.add(l_DietName2);
		p_Dieta1.add(l_Dietsex);
		p_Dieta1.add(l_Dietsex2);
		p_Dieta1.add(l_Dietweight);
		p_Dieta1.add(tf_Dietweight);
		p_Dieta1.add(l_Diettargetweight);
		p_Dieta1.add(tf_Diettargetweight);
		p_Dietall.add(p_Dieta1);
		
		p_Dieta2.add(l_Dietdl_Dietcalorie);
		//p_Dieta2.add(l_Dietdietname);
		//p_Dieta2.add(tf_DietDiet);
		//scroll.add(p_Dieta2_2);
		p_Dieta2.add(s_Dietscroll);
		p_Dieta2.add(l_DietCl_Dietcalorie);
		p_Dieta2.add(l_DietCl_Dietcalorie2);
		//p_Dieta3.add(tf_Dietcalorie);
		p_Dieta2.add(l_DietRl_Dietcalorie);
		p_Dieta2.add(l_DietRl_Dietcalorie2);
		p_Dieta2.add(l_Dietcalorie);
		p_Dieta2.add(l_Dietcalorie2);
		p_Dieta2.add(l_Dietbad);
		p_Dieta2.add(l_Dietgood);
		p_Dieta2.add(b_DietResult);
		p_Dietall.add(p_Dieta2);
		
		
		p_Dieta3.add(b_DietSave);
		//p_Dieta3.add(b_DietReset);
		p_Dieta3.add(b_DietBack);
		p_Dietall.add(p_Dieta3);
		
		p_Dieta1.setLayout(null);
		p_Dieta2.setLayout(null);
		p_Dieta2_1.setLayout(null);
		//p_Dieta2_2.setLayout(null);
		p_Dieta3.setLayout(null);
		p_Dietall.setLayout(null);
		
		//getContentPane().add(l_Diettitle,BorderLayout.NORTH);
		ui.jf.getContentPane().add(p_Dietall,BorderLayout.CENTER);
		p_Dietall.setSize(1000,1000);
		p_Dietall.setVisible(true);
		
		//이벤트 등록
		b_DietResult.addActionListener(this);
		b_DietSave.addActionListener(this);
		//b_DietReset.addActionListener(this);
		b_DietBack.addActionListener(this);		
		//b_DietChoice.addActionListener(this);		
		
		//모든레코드를 검색하여 DefaultTableModle에 올리기
        dao.getInsertList2(d_Dietdt);
        //tf_DietDiet.requestFocus();
        //첫번행 선택.
        if (d_Dietdt.getRowCount() > 0) {
            j_DIettable.setRowSelectionInterval(0, 0);
        }
        
       
      getWeight();
	}
	
	
	/** 몸무게 출력 **/
	public void getWeight() {
		//현재날짜를 String 값으로 만들기
	    SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
	    		
	    Date time = new Date();
	    		
	    String time1 = format1.format(time);
	    
	    vo = dao.getResultWeight(DietUI.mvo.getCNO(),time1);
	    
	    l_DietDwNO.setText(Integer.toString(vo.getDW_NO()));
	    l_Dietdate2.setText(vo.getDW_DATE());
	    l_DietName2.setText(vo.getNAME());
	    l_Dietsex2.setText(vo.getGENDER());
	    tf_Dietweight.setText(vo.getDW_WEIGHT());
	    tf_Diettargetweight.setText(vo.getDW_TARGETWEIGHT());
	}
	 
	
	
	//테이블 검색한 칼로리 누적 합
	  public int getSum() {
      	int rowsCount =  j_DIettable.getRowCount();
      	int sum = 0;
      	
      	for(int i=0; i<rowsCount;i++) {
      		sum = sum + Integer.parseInt(String.valueOf(j_DIettable.getValueAt(i, 2)));
      		
      	}
      	return sum;
      }
	
	  /** 칼로리 good,bad 나오게하기 **/
	  public void enableButton(int checkResult) {
			
			if(checkResult == 1) {
				//System.out.println("모든 메뉴 선택");
				l_Dietgood.setText("참 잘했어요~");
				l_Dietgood.setForeground(Color.GREEN);
				
				
			}else if(checkResult == 2) {
				l_Dietbad.setText("권장 칼로리 초과!!");
				l_Dietbad.setForeground(Color.RED);
				
			}
		}

	
	//이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b_DietResult) {
			
			//칼로리 계산
			if(vo.getGENDER().equals("M")) {
				Selectsum = getSum();
				Csum = Selectsum - DietSystem.MENKCAL;
	 			
				l_DietCl_Dietcalorie.setText("");
				l_DietCl_Dietcalorie2.setText(Integer.toString(getSum())+"kcal(선택한칼로리)");
				
				l_DietRl_Dietcalorie.setText("");
				l_DietRl_Dietcalorie2.setText("- "+Integer.toString(DietSystem.MENKCAL)+"kcal(권장칼로리)");
				
				l_Dietcalorie.setText("");
				l_Dietcalorie2.setText("= "+Integer.toString(Csum)+"kcal(칼로리)");
				
				kcal = Csum;
				int checkResult = system.kcalCheck(kcal);
				enableButton(checkResult);
				
			}else if(vo.getGENDER().equals("F")) {
				Selectsum = getSum();
				Csum = Selectsum - DietSystem.GIRLKCAL;
	 			
				l_DietCl_Dietcalorie.setText("");
				l_DietCl_Dietcalorie2.setText(Integer.toString(getSum())+"kcal(선택한칼로리)");
				
				l_DietRl_Dietcalorie.setText("");
				l_DietRl_Dietcalorie2.setText("- "+Integer.toString(DietSystem.GIRLKCAL)+"kcal(권장칼로리)");
				
				l_Dietcalorie.setText("");
				l_Dietcalorie2.setText("= "+Integer.toString(Csum)+"kcal(칼로리)");
				
				kcal = Csum;
				int checkResult = system.kcalCheck(kcal);
				enableButton(checkResult);
			}
			
//			if() {
//			l_DietRl_Dietcalorie.setText("2222");
//			}else {
//				
//			}
			
		//음식을 추가해야지 칼로리 계산값 결과(kcal)이 들어감
        }else if(ae.getSource() == b_DietSave) {
        	//tf_Dietcalorie.setText();
        	if(vo.getGENDER().equals("M")) {
        		DietSaveVO dsvo = new DietSaveVO();
        		dsvo.setDS_SelectKcal(getSum());
            	dsvo.setDS_RECOMMEND(DietSystem.MENKCAL);
            	dsvo.setDS_RESULTKCAL(kcal);
            	dsvo.setDW_NO(vo.getDW_NO());
            	
            	boolean result = system.registDiet(dsvo);
            	
            	if(result) {
            		JOptionPane.showMessageDialog(null, "등록완료");
            		
            		//추가시킨 식단들 삭제
            		int val = dao.getDeleteList2();
            		if(val != 0) {
            			JOptionPane.showMessageDialog(null, "리스트삭제완료");
            		}else {
            			JOptionPane.showMessageDialog(null, "리스트삭제실패");
            		}
            		
            		
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "등록 안됐음");
            		
			
            	}
				
			}else if(vo.getGENDER().equals("F")) {
				DietSaveVO dsvo = new DietSaveVO();
				dsvo.setDS_SelectKcal(getSum());
            	dsvo.setDS_RECOMMEND(DietSystem.GIRLKCAL);
            	dsvo.setDS_RESULTKCAL(kcal);
            	dsvo.setDW_NO(vo.getDW_NO());
            	
            	boolean result = system.registDiet(dsvo);
            	
            	if(result) {
            		JOptionPane.showMessageDialog(null, "등록완료");
            		
            		
            		//추가시킨 식단들 삭제
            		int val = dao.getDeleteList2();
            		if(val != 0) {
            			JOptionPane.showMessageDialog(null, "리스트삭제완료");
            		}else {
            			JOptionPane.showMessageDialog(null, "리스트삭제실패");
            		}
            		
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "등록 안됐음");
            		
			
            	}
			}
        		
            	
        }else if(ae.getSource() == b_DietBack ) {
        	ui.flag=false;
    	    ui.flag2=false;
    	    
        	int rowsCount =  j_DIettable.getRowCount();
        	//추가시킨 식단들 삭제
        	
        	if(rowsCount>0) {
        			dao.getDeleteList2();
        			p_Dietall.setVisible(false);
    	        	ui.p_Dietall.setVisible(true);
    	        	//new DietUI();
    	        	
        	}
        	else {
        		p_Dietall.setVisible(false);
	        	ui.p_Dietall.setVisible(true);
        	}
        	
        }
			
	}
	
}
