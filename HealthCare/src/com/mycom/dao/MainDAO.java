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
	
	//String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
	String user = "HealthCare";
	String pass = "1234";
	
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
	
	//인바디정보리스트출력
	public MainVO getInbodyVO(int cno) {
		MainVO vo = new MainVO();
		String sql = "select bmi, fat, pbf, whr, s_weight "
					+ " from member where cno = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setBmi(rs.getDouble(1));
				vo.setFat(rs.getDouble(2));
				vo.setPbf(rs.getDouble(3));
				vo.setWhr(rs.getDouble(4));
				vo.setS_weight(rs.getDouble(5));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println("dao.cno:"+cno);		
		
		return vo;
	}
	
	
	//4,5 단계 : 회원정보리스트 출력  - Equi Join 사용.
	public MainVO getResultMainVO(int cno) {
		MainVO vo = new MainVO();
		String sql = "select cno, name, to_char(start_date,'yyyy-mm-dd'), to_char(end_date,'yyyy-mm-dd'), l.gx_name, m.gx_count, m.gx_price "
					+ " from member m, lecture l where m.gx_code = l.gx_code and cno = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setStart_date(rs.getString(3));
				vo.setEnd_date(rs.getString(4));
				vo.setGx_code(rs.getString(5));
				vo.setGx_count(rs.getInt(6));
				vo.setGx_price(rs.getInt(7));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println("dao.cno:"+cno);		
		
		return vo;
	}
	
	//update
	public int update(int cno) {
		int result = 0;
		String sql="update member set gx_count=gx_count-1 where cno=?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, cno);
			
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
			
		}
		
	}
	

}
