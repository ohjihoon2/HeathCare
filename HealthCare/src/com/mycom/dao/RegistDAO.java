package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mycom.vo.ClientVO;

public class RegistDAO {

	//Field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url="jdbc:oracle:thin:@127.0.0.1:1521";
	String user= "HealthCare";
	String pass ="1234";
	
	//Constructor
	public RegistDAO() {
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
	
	/**
	 * 4~5�ܰ� : ������ �߰� 
	 */
	public int getClientInsert(ClientVO vo) {
		int result =0;
//		getStatement();
		String sql = "INSERT INTO client VALUES(seq_member.nextval,?,?,?,?,?,?,?,?,?,?)";
		getPreparedStatement(sql);
		System.out.println("3�ܰ� ����~");
		
		try {
			
			//������ �����ϱ����� ����ǥ �ڸ��� �ϳ��ϳ� �־��ִ� ������ �ʿ��ϴ�.
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getGender());	
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, vo.getDivision());
			pstmt.setString(6, vo.getCreated_date());
			pstmt.setString(7, vo.getBirth_date());
			pstmt.setString(8, vo.getEvent_name());
			pstmt.setString(9, vo.getStart_date());
			pstmt.setString(10, vo.getEnd_date());
			
			
			
			// api ���� �ŰԺ����� ���µ� ������ �ȶߴ����� 
			// result = pstmt.executeUpdate(sql); �� statement �� ����ϱ� ������ �Ű����� sql�� �־ ������ ���� ����. ������ Ʋ�������̴�.
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4�ܰ� ����");
		}
		return result;
	}
	
//	/**
//	 * 4~5�ܰ� : ������ ���� 
//	 */
//	public int getUpdate(ClientVO vo) {
//		int result = 0;
//		String sql = "update stu set skor = ?, seng = ?, smath =? where sno = ?";
//		getPreparedStatement(sql);
//		System.out.println("3�ܰ� ����~");
//		try {
//			pstmt.setInt(1, vo.getSkor());
//			pstmt.setInt(2, vo.getSeng());
//			pstmt.setInt(3, vo.getSmath());
//			pstmt.setString(4, vo.getSno());
//			result = pstmt.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("4�ܰ� ����");
//		}
//		return result;
//	}
	
//	/**
//	 * 4~5�ܰ� : ������ ���� 
//	 */
//	public int getDelete(String sno) {
//		int result = 0;
//		String sql = "delete from stu where sno =upper(?)";
//		getPreparedStatement(sql);
//		System.out.println("3�ܰ� ����");
//
//		try {
//			pstmt.setString(1, sno);
//			result = pstmt.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("4�ܰ� ����");
//		}
//		return result;
//	}
	
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
