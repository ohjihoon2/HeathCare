package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mycom.dao.LectureDAO;
import com.mycom.vo.LectureVO;



public class LectureUI extends JFrame implements ActionListener{
	
    //field
	MainScreenUI mainui;
	StartUI startui;
	JFrame jf;
	
    JPanel p_gx_main,p_gx_top, p_gx_main2, p_gx_left, p_gx_right, p_gx_pn4, p_gx_l_gx_info, p_gx_name, p_gx_lecture, p_gx_l_gx_times, p_gx_l_gx_limit, p_gx_blank;
    JLabel l_gx_uno, l_gx_info, l_gx_uname, l_gx_lecture, l_gx_times, l_gx_limit;
    JButton b_gx_extension, b_back;
    JTextField jtf_gx_uname, jtf2, jtf_gx_times, jtf_gx_limit;
    
    ImageIcon ic_gx_uimg, ic_gx_topimg;
    JLabel ic_gx_uimgBox, ic_gx_topimgBox;
    
    //constructor
    public LectureUI(MainScreenUI mainui, StartUI startui) {
    	this.mainui = mainui;
    	this.startui = startui;
    	
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
        b_back = new JButton("돌아가기");
             
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
        p_gx_pn4.add(b_gx_extension);
        p_gx_pn4.add(b_back);
        
        p_gx_main.setSize(1000,600);
        p_gx_main.setVisible(true);
        
        startui.jf.getContentPane().add(p_gx_main, BorderLayout.CENTER);
        
        b_gx_extension.addActionListener(this);
        b_back.addActionListener(this);     
    } 
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == b_back) {	//회원가입 완료
			p_gx_main.setVisible(false);
			mainui.p_sc_total.setVisible(true);
			
		}else if(obj == b_gx_extension) {//수강등록
			new RegistLecture();
		
		}
		
	}
    
   
}

class RegistLecture extends JFrame implements ActionListener{
	//field
		JPanel jp;
		JLabel jl_cno, jl_name, jl_lecture_name, jl_count;
		JTextField jtf_cno, jtf_name, jtf_lecture_name, jtf_count;
		JButton btn_reg, btn_cancel;
		JComboBox jcb_lecture_name, jcb_count;//->vector데이터로 들어감
		
		//constructor
		public RegistLecture() {
			jp= new JPanel(new GridLayout(5,2));
			jl_cno=new JLabel("회원번호");
			jl_name = new JLabel("회 원 명");
			jl_lecture_name = new JLabel("수 강 명");
			jl_count = new JLabel("수강연장");
			
			jtf_cno = new JTextField(20);
			jtf_name = new JTextField(20);
			jtf_lecture_name = new JTextField(20);
			jtf_count = new JTextField(20);
			
			btn_reg = new JButton("등    록");
			btn_cancel = new JButton("취    소");
			
			Vector lecturenameList = new Vector();
			lecturenameList.add("선택하세요");
			lecturenameList.add("요가");
			lecturenameList.add("줌바");
			lecturenameList.add("스피닝");
			jcb_lecture_name = new JComboBox(lecturenameList);
			
			Vector extensionList = new Vector();
			extensionList.add("선택하세요");
			extensionList.add("10회");
			extensionList.add("20회");
			jcb_count = new JComboBox(extensionList);
			
			jp.add(jl_cno); jp.add(jtf_cno);
			jp.add(jl_name); jp.add(jtf_name);
			jp.add(jl_lecture_name); jp.add(jcb_lecture_name);
			jp.add(jl_count); jp.add(jcb_count);
			jp.add(btn_reg); jp.add(btn_cancel);
			
			getContentPane().add(jp);
			setSize(500,500);
			setVisible(true);
			
			//이벤트 호출
			btn_reg.addActionListener(this);
			
		}
		
		//method
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == btn_reg) {//String과 int타입 맞추기 ; Integer.parseInt(), String.valueOf();
				//vo 생성 : 데이터					
				String extention = (String)jcb_count.getSelectedItem();
								
				int count = 0;
				if(extention.equals("10회"))	count =10;
				else if(extention.equals("20회"))	count = 20;
				
				LectureVO uvo = new LectureVO();
				
				uvo.setCno(Integer.parseInt(jl_cno.getText()));
				uvo.setName(jtf_name.getText());
				uvo.setEvent_name((String)jcb_lecture_name.getSelectedItem());
				uvo.setCount(count);
				
				
				//dao 생성: DB 연결 -> 등록
				LectureDAO dao = new LectureDAO();
				int result = dao.getResultUpdate(uvo);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null, "등록 성공");
				}else {
					JOptionPane.showMessageDialog(null, "등록 실패");
				}
				
			}else if(obj==btn_cancel) {
				JOptionPane.showMessageDialog(null, "등록 취소");
				jtf_cno.setText("");
				jtf_name.setText("");
				jcb_lecture_name.setSelectedIndex(0);
				jcb_count.setSelectedIndex(0);
				jtf_cno.requestFocus();
			}
		}
	
				
}