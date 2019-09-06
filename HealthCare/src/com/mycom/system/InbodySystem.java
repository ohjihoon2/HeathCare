package com.mycom.system;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.mycom.dao.InbodyDAO;
import com.mycom.vo.InbodyVO;

public class InbodySystem {

	//Field
	JButton b_InbEnter, b_InbSave, b_InbReg, b_InbMain;	
	JTextArea a_InbRe;
	InbodyDAO dao = new InbodyDAO();
	InbodyVO vo;
	String BMI, FAT, PBF, WHR, S_weight;


	/**이벤트 처리**/	
	//유효성 체크 메소드
	public boolean formCheck(String str) {
		boolean result = false;

		if(a_InbRe.getText().equals("")) {
			String msg = "*** 신체정보를 입력하시고 아래의 체크버튼을 누르세요  ***";
			JOptionPane.showMessageDialog(null, msg);
			a_InbRe.requestFocus();

		}else {
			result = true;
		}

		return result;
	}


	//이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		// 유효성체크 메소드 호출
		if (obj == b_InbReg) {
			InbodyDAO dao = new InbodyDAO();

			// DAO를 이용한 DB연동-VO			
			String sql = "SELECT BMI, S_WEIGHT, FAT, PBF, WHR FROM INBODY";


			if (vo != null) {
				a_InbRe.append(vo.getBMI() + "\t");
				a_InbRe.append(vo.getS_weight() + "\t");
				a_InbRe.append(vo.getFAT() + "\t");
				a_InbRe.append(vo.getPBF() + "\t");
				a_InbRe.append(vo.getWHR() + "\t");

			} else {
				JOptionPane.showMessageDialog(null, "");
			}
		}

	}


	public int getResultUpdate(InbodyVO ivo, int cno) {

		int result = dao.getResultUpdate(ivo, cno);

		return result;
	}



}
















