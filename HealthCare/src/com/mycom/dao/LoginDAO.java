package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mycom.vo.ClientVO;


public class LoginDAO {

	//Field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url="jdbc:oracle:thin:@127.0.0.1:1521";
	String user= "HealthCare";
	String pass ="1234";
	
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
	public int  getResultLogin(String cno) {
		System.out.println("dao cno = "+cno);
		int result = 0;
		String sql = "select count(*) from client where cno=?";
		getPreparedStatement(sql);	//3�ܰ� ȣ��
		
		try {
			pstmt.setString(1, cno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {			
				result = rs.getInt(1);
			}
			System.out.println("result =" + result);
		}catch(Exception e) {		
			e.printStackTrace();
		}
		return result;
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
	
	/**
	 * �α��� üũ
	 * @param sid
	 * @param spass
	 * @return
	 */
	public int getResultLogin(String sid, String spass) {
		int result = 0;
		
		String sql = "SELECT COUNT(*) FROM STU_MEMBER WHERE SID=? AND SPASS=?";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, spass);
			
			// query�� select �̱� ������ resultSet���� �޾ƾ� �� 
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
