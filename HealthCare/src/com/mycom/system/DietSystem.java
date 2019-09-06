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
	//다이어트 식단 전체 출력
	public void getList(DefaultTableModel t_model) {
		dao.getList(t_model);
	}
	
	//다이어트 식단 검색
	public void getDietSearch(DefaultTableModel t_model, String name) {
		dao.getResultDietSearch(t_model,name);
	}
	
	//몸무메 등록
	public boolean registWeight(DietMemberVO mvo2) {
		boolean result = false;
		
		int val = dao.getInsertWeigth(mvo2);
		if(val != 0) {
			result = true;
		}
		
		return result;
	}
	
	//회원정보 출력
	public DietMemberVO MemberInfo(int cno) {
		
		DietMemberVO mvo = dao.getMemberInfo(cno);
		
		return mvo;
	}
	
	//칼로리 계산
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
	
	//개인일지 저장(회원정보,몸무게,칼로리)
	public boolean registDiet(DietSaveVO dsvo) {
		boolean result = false;
		
		int val = dao.getInsertDiet(dsvo);
		if(val != 0) {
			result = true;
		}
		
		return result;
	}
	
	//개인일지 저장 출력
	public ArrayList<DietSaveVO> getDietList(int cno) {
		
		ArrayList<DietSaveVO> list = dao.getResultDiet(cno);
		
		
		return list;
	}	

}
