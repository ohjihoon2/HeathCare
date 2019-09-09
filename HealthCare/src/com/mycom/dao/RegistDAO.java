package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mycom.ui.StartUI;
import com.mycom.vo.MemberVO;

public class RegistDAO {

	//Field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
	String user = "HealthCare";
	String pass = "1234";
	
	int cno = 0;
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
	public int getMemberInsert(MemberVO vo) {
		int result =0;
//		getStatement();
		String sql = "INSERT INTO member(cno, name, gender, address, phone, division, created_date, birth_date, gx_code, start_date, end_date, gym_price) VALUES(seq_member.nextval,?,UPPER(?),?,?,1, sysdate,?,?,sysdate, add_months(sysdate,?),?)";
		getPreparedStatement(sql);
		System.out.println("3�ܰ� ����~");
		
		try {
			
			//������ �����ϱ����� ����ǥ �ڸ��� �ϳ��ϳ� �־��ִ� ������ �ʿ��ϴ�.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());	
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getBirth_date());
			pstmt.setString(6, vo.getGx_code());
			pstmt.setString(7, vo.getEnd_date());
			pstmt.setInt(8, vo.getGym_price());
			
			// api ���� �ŰԺ����� ���µ� ������ �ȶߴ����� 
			// result = pstmt.executeUpdate(sql); �� statement �� ����ϱ� ������ �Ű����� sql�� �־ ������ ���� ����. ������ Ʋ�������̴�.
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4�ܰ� ����");
		}
		return result;
	}
	
	/** 4~5 �ܰ� : �α��� ���� vo�� �� �ֱ� **/
	public int searchCno(String name) {
		/**
		 *  SELECT CNO 
			FROM (SELECT CNO FROM MEMBER
			WHERE NAME='?' 
			ORDER BY CREATED_DATE DESC)
			WHERE ROWNUM=1;
		 * 
		 */
		String sql = "SELECT cno FROM (select cno, name ,rank() over(PARTITION BY NAME order by created_date desc) AS RK from member) WHERE RK =1 AND NAME =?";
		getPreparedStatement(sql);	//3�ܰ� ȣ��
		
		try {
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {			
				cno = rs.getInt(1);
				System.out.println("dao.cno = "+cno);
			}
		}catch(Exception e) {		
			e.printStackTrace();
		}
		return cno;
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
