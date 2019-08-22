package com.mycom.system;

import java.util.ArrayList;
import java.util.Scanner;


public class StuMgmSystem {
/*
	//Field
	StuDAO dao;
	
	ArrayList<ClientVO> stuList;
	ClientVO svo;
	//파일 정의
	ClientVO stu;
	int count =0;
	
	//Constructor
	public StuMgmSystem() {
		dao = new StuDAO();
		
	}
		
	//Method
	*//**
	 * 등록하기  
	 * @param vo
	 * @return
	 *//*
	public boolean regist(ClientVO vo) {
		boolean result = false;
//		String sql = "INSERT INTO STU VALUES("
//				+ "'SIST_'||SEQU_STU.NEXTVAL,'"
//				+vo.getSname()+"',"
//				+vo.getSkor()+","
//				+vo.getSeng()+","
//				+vo.getSmath()+","
//				+vo.getStot()+","
//				+vo.getSavg()+ ")";
//		
		//dao 에서 설정해주면 됨.
//		dao.getStatement();
		
		int val= dao.getResultInsert(vo);
		if(val != 0) {
			result = true;
		}
		return result;
	}
	*//**
	 * 학생 전체 LIST UI로 출력 
	 * @return
	 *//*
	public ArrayList<ClientVO> getList(){
		ArrayList<ClientVO> list = dao.getList();
		
		return list;
	}
	
	*//**
	 * 데이터 검색
	 * @param sno
	 * @return
	 * @throws Exception
	 *//*
	public ClientVO searchData(String sno) throws Exception {
		ClientVO svo = dao.getListVO(sno);		
		
		return svo;
	}
	
	*//**
	 * 검색한 데이터 수정
	 * @param uvo
	 * @return
	 * @throws Exception
	 *//*
	public boolean updateData(ClientVO  vo) throws Exception{
		boolean result = false;
		int val = dao.getUpdate(vo);
		if(val != 0) {
			result = true;
		}
		return result;
	}
	
	*//**
	 * 검색한 데이터 삭제하기
	 *//*
	public boolean deleteData(String sno) {
		boolean result = false;
		int val = dao.getDelete(sno);
		System.out.println(val);
		if(val != 0) {
			result = true;
		}
		return result;
	}

	*//**
	 * connection 끊기( 종료) 
	 *//*
	public void close() {
		dao.close();
	}

	*//**
	 * 로그인
	 *//*
	public boolean loginCheck(String sid, String spass) {
		boolean result = false;
		int val = dao.getResultLogin(sid, spass);
		if(val !=0) {
			result = true;
		}
		
		return result;
	}*/

	
}
