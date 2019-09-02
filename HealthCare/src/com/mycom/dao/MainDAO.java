package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycom.vo.MainVO;

public class MainDAO {

	//field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url= "jdbc:oracle:thin:@127.0.0.1";
	String user= "HealthCare";
	String pass="1234";
	
	//constructor
	public MainDAO() {
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
	
	//4,5 단계 : 리스트 출력  - Equi Join 사용.
	public MainVO getListMainVO(String cno) {
		MainVO vo = new MainVO();
		String sql = "select m.cno, m.name, start_date, end_date, l.event_name from member m, lecture l where m.cno = l.cno and m.cno = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setStart_date(rs.getString(3));
				vo.setEnd_date(rs.getString(4));
				vo.setEvent_name(rs.getString(5));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	//종료
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		}catch(Exception e) {
			
		}
		
	}
	

}
