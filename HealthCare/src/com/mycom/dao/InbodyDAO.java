package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.mycom.ui.StartUI;
import com.mycom.vo.InbodyVO;

public class InbodyDAO {

	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
	String user = "HealthCare";
	String pass = "1234";


	//Constructor
	public InbodyDAO() {


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url,user,pass);

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("1~2단계 오류");
		}
	}


	//Method

	/** PreparedStatement 객체 생성 **/
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//하나의 inbody결과 출력
	public InbodyVO getResultVO(String sql) {
		InbodyVO vo = new InbodyVO();

		try {
			rs = stmt.executeQuery(sql);

			while(rs.next()) {				

				vo.setBMI(rs.getString(1));
				vo.setS_weight(rs.getString(2));
				vo.setFAT(rs.getString(3));
				vo.setPBF(rs.getString(4));
				vo.setWHR(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;	  

	}


	/**종료 **/
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getResultUpdate(InbodyVO ivo, int cno) {
		int result = 0;
		//getStatement();
		String sql = "UPDATE MEMBER SET BMI = ?, S_weight = ?, FAT=?, PBF = ?, WHR = ? where cno ="+cno;

		getPreparedStatement(sql);
		try {
			pstmt.setString(1, ivo.getBMI());
			pstmt.setString(2, ivo.getS_weight());
			pstmt.setString(3, ivo.getFAT());
			pstmt.setString(4, ivo.getPBF());
			pstmt.setString(5, ivo.getWHR());

			result = pstmt.executeUpdate();	

		}catch(Exception e) {e.printStackTrace();}		

		return result;
	}



}//class

