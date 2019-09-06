package com.mycom.system;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mycom.dao.DietDAO;
import com.mycom.vo.DietMemberVO;
import com.mycom.vo.DietSaveVO;

public class DietSystem {
	//Field
	public static final int MENKCAL = 2500;
	public static final int GIRLKCAL = 2200;
	public static final int GOOD = 0;
	public static final int BAD = 1;
	
	DietDAO dao;
	
	//Constructor
	public DietSystem() {
		dao = new DietDAO();
	}
	
	//Method
	//���̾�Ʈ �Ĵ� ��ü ���
	public void getList(DefaultTableModel t_model) {
		dao.getList(t_model);
	}
	
	//���̾�Ʈ �Ĵ� �˻�
	public void getDietSearch(DefaultTableModel t_model, String name) {
		dao.getResultDietSearch(t_model,name);
	}
	
	//������ ���
	public boolean registWeight(DietMemberVO mvo2) {
		boolean result = false;
		
		int val = dao.getInsertWeigth(mvo2);
		if(val != 0) {
			result = true;
		}
		
		return result;
	}
	
	//ȸ������ ���
	public DietMemberVO MemberInfo(int cno) {
		
		DietMemberVO mvo = dao.getMemberInfo(cno);
		
		return mvo;
	}
	
	//Į�θ� ���
	public int kcalCheck(int kcal) {
		int result = 0;
		
		if(kcal <= GOOD) {
			result = 1;
		}
		else if(kcal >= BAD) {
			result = 2;
		}
		
		return result;
	}
	
	//�������� ����(ȸ������,������,Į�θ�)
	public boolean registDiet(DietSaveVO dsvo) {
		boolean result = false;
		
		int val = dao.getInsertDiet(dsvo);
		if(val != 0) {
			result = true;
		}
		
		return result;
	}
	
	//�������� ���� ���
	public ArrayList<DietSaveVO> getDietList(int cno) {
		
		ArrayList<DietSaveVO> list = dao.getResultDiet(cno);
		
		
		return list;
	}	

}
