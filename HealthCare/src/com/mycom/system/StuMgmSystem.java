package com.mycom.system;

import java.util.ArrayList;
import java.util.Scanner;


public class StuMgmSystem {
/*
	//Field
	StuDAO dao;
	
	ArrayList<ClientVO> stuList;
	ClientVO svo;
	//���� ����
	ClientVO stu;
	int count =0;
	
	//Constructor
	public StuMgmSystem() {
		dao = new StuDAO();
		
	}
		
	//Method
	*//**
	 * ����ϱ�  
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
		//dao ���� �������ָ� ��.
//		dao.getStatement();
		
		int val= dao.getResultInsert(vo);
		if(val != 0) {
			result = true;
		}
		return result;
	}
	*//**
	 * �л� ��ü LIST UI�� ��� 
	 * @return
	 *//*
	public ArrayList<ClientVO> getList(){
		ArrayList<ClientVO> list = dao.getList();
		
		return list;
	}
	
	*//**
	 * ������ �˻�
	 * @param sno
	 * @return
	 * @throws Exception
	 *//*
	public ClientVO searchData(String sno) throws Exception {
		ClientVO svo = dao.getListVO(sno);		
		
		return svo;
	}
	
	*//**
	 * �˻��� ������ ����
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
	 * �˻��� ������ �����ϱ�
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
	 * connection ����( ����) 
	 *//*
	public void close() {
		dao.close();
	}

	*//**
	 * �α���
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
