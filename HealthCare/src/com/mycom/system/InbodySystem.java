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


	/**�̺�Ʈ ó��**/	
	//��ȿ�� üũ �޼ҵ�
	public boolean formCheck(String str) {
		boolean result = false;

		if(a_InbRe.getText().equals("")) {
			String msg = "*** ��ü������ �Է��Ͻð� �Ʒ��� üũ��ư�� ��������  ***";
			JOptionPane.showMessageDialog(null, msg);
			a_InbRe.requestFocus();

		}else {
			result = true;
		}

		return result;
	}


	//�̺�Ʈ ó��
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		// ��ȿ��üũ �޼ҵ� ȣ��
		if (obj == b_InbReg) {
			InbodyDAO dao = new InbodyDAO();

			// DAO�� �̿��� DB����-VO			
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
















