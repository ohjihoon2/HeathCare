package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycom.ui.StartUI;


public class LoginDAO {

	//Field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "HealthCare";
	String pass = "1234";
	
	//Constructor
	public LoginDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1�ܰ� ����~");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("2�ܰ� ����~");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	
	/**
	 * 3�ܰ� : PreparedStatement ��ü ����
	 */
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 4~5 �ܰ� : �ϳ��� row ��� - �α��� **/
	public int  getResultLogin(int cno) {
		System.out.println("dao cno = "+cno);
		int result = 0;
		String sql = "select count(*) from member where cno=?";
		getPreparedStatement(sql);	//3�ܰ� ȣ��
		
		try {
			pstmt.setInt(1, cno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {			
				result = rs.getInt(1);
			}
		}catch(Exception e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	/** 4~5 �ܰ� : �α��� ���� vo�� �� �ֱ� **/
	public void  setVO(int cno) {
		
		String sql = "select cno, name, gender, address, phone, division, birth_date, start_date, end_date from member where cno=?";
		getPreparedStatement(sql);	//3�ܰ� ȣ��
		
		try {
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();

			if(rs.next()) {			
				
				StartUI.vo.setCno(rs.getInt(1));
				StartUI.vo.setName(rs.getString(2));
				StartUI.vo.setGender(rs.getString(3));
				StartUI.vo.setAddress(rs.getString(4));
				StartUI.vo.setPhone(rs.getString(5));
				StartUI.vo.setDivision(rs.getInt(6));
				StartUI.vo.setBirth_date(rs.getString(7));
				StartUI.vo.setStart_date(rs.getString(8));
				StartUI.vo.setEnd_date(rs.getString(9));
				
			}
		}catch(Exception e) {		
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 6�ܰ� : ����
	 */
	
	public void close() {
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
