package com.mycom.system;

import java.util.ArrayList;

import com.mycom.dao.LectureDAO;
import com.mycom.vo.LectureVO;

public class LectureSystem {
	//field
	LectureDAO dao;
	
	//constructor
	public LectureSystem() {
		try {
			dao = new LectureDAO();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//method
	//수강메인페이지 회원정보 출력
	public LectureVO getListVO(int cno) {
		LectureVO vo = dao.getResultVO(cno);
		
		return vo;
	}
		

	//수강 등록 리스트 출력
	public ArrayList<LectureVO> uplistVO() {	
		ArrayList<LectureVO> list = dao.getGXList();
		
		return list;
	}
	
	
	//수강 업데이트
	public boolean update(LectureVO lvo){
		boolean result = false;
		
		int val = dao.getResultUpdate(lvo);
		if(val != 0) result = true;
		
		return result;
		
	}
	

	

}
