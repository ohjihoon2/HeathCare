package com.mycom.dao;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.vo.GymExtentionVO;
import com.mycom.vo.MainVO;


public class GymExtentionDAO {
	//field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
	String user = "HealthCare";
	String pass = "1234";
	
	
	//constructor
	public GymExtentionDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn  = DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//헬스,GX 리스트 출력
	public ArrayList<GymExtentionVO> getResultList() {
		ArrayList<GymExtentionVO> list = new ArrayList<GymExtentionVO>();
		String sql="SELECT MONTH, ORIGPRICE, SALEPRICE, SAVEPRICE FROM GYM_EXTENTION";
		getPreparedStatement(sql);	
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				GymExtentionVO vo = new GymExtentionVO();
				vo.setMonth(rs.getString(1));
				vo.setOrigprice(rs.getInt(2));
				vo.setSaleprice(rs.getInt(3));
				vo.setSaveprice(rs.getInt(4));
				
				list.add(vo);
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//data Update 1개월
	public int getResultUpdate(int cno, int month, int price) {
		int result = 0;
		String sql = "update member set end_date=add_months(end_date,"+ month +"), gym_price=nvl(gym_price,0)+"+price+" where cno=?";		
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	

}
