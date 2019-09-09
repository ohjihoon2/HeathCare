package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycom.vo.LectureVO;

public class LectureDAO {
	//field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
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
	
	//회원vo리스트
	public LectureVO getResultVO(int cno) {
		LectureVO vo = new LectureVO();		
		String sql= "select cno, name, gx_name, m.gx_count, m.gx_price, to_char(gx_validity,'yyyy-mm-dd')" + 
				" from member m, lecture l where m.gx_code=l.gx_code and cno=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCno(rs.getInt(1));
				vo.setCname(rs.getString(2));
				vo.setGx_code(rs.getString(3));
				vo.setGx_count(rs.getInt(4));
				vo.setGx_price(rs.getInt(5));
				vo.setGx_validity(rs.getString(6));

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	
	
	//수강리스트 출력
	public ArrayList<LectureVO> getGXList() {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql="select gx_code, gx_name, gx_price from lecture where gx_code<>100";
		getPreparedStatement(sql);	
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LectureVO vo = new LectureVO();
				vo.setGx_code(rs.getString(1));
				vo.setGx_name(rs.getString(2));
				vo.setGx_price(rs.getInt(3));
				
				list.add(vo);
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//data Update
	public int getResultUpdate(LectureVO vo) {
		int result = 0;
		String sql = "update member set gx_code=?, gx_count=?, gx_price=?, gx_validity=add_months(sysdate,6) where cno=?";		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getGx_code());
			pstmt.setInt(2, vo.getGx_count());
			pstmt.setInt(3, vo.getGx_totprice());
			pstmt.setInt(4, vo.getCno());
			
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
