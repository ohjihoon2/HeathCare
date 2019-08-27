package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycom.vo.LectureVO;

public class LectureDAO {
	//field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc.oracle.thin:@127.0.0.1:1521";
	String user = "HealthCare";
	String pass = "1234";
	
	//constructor
	public LectureDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	//3단계
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//4단계
	public void getResultSet() {
		try {
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//4,5 단계 : 리스트 출력
	public LectureVO getListLectureVO(String seq) {
		LectureVO vo = new LectureVO();
		
		String sql = "select * from main where cno = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1,seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString(1));
				vo.setEvent_name(rs.getString(2));
				vo.setCount(rs.getInt(3));
				vo.setValidity(rs.getString(4));
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vo;
	}
	//data insert
	public int getResultInsert(LectureVO vo) {
		int result = 0;
		
		String sql = "insert into lecture values(?,?,?,add_month(sysdate,6),?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, vo.getCno());
			pstmt.setString(2, vo.getEvent_name());
			pstmt.setInt(3, vo.getCount());
			pstmt.setString(4,  vo.getName());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//data Update
	public int getResultUpdate(LectureVO vo) {
		int result = 0;
		String sql = "update member set event_name=?, count=? where cno=?";		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getEvent_name());
			pstmt.setInt(2, vo.getCount());
			pstmt.setInt(3, vo.getCno());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//종료
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
