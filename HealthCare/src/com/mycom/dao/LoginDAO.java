package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
			System.out.println("1단계 성공~");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("2단계 성공~");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	
	/**
	 * 3단계 : PreparedStatement 객체 생성
	 */
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 4~5 단계 : 하나의 row 출력 - 로그인 **/
	public int  getResultLogin(String cno) {
		System.out.println("dao cno = "+cno);
		int result = 0;
		String sql = "select count(*) from member where cno=?";
		getPreparedStatement(sql);	//3단계 호출
		
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
	 * 6단계 : 종료
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
