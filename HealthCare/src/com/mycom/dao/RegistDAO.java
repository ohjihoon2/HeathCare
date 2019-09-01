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
	String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String user= "HealthCare";
	String pass ="1234";
	
	int cno;
	//Constructor
	public RegistDAO() {
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
	
	/**
	 * 4~5단계 : 데이터 추가 
	 */
	public int getClientInsert(MemberVO vo) {
		int result =0;
//		getStatement();
		String sql = "INSERT INTO member(cno, name, gender, address, phone, division, birth_date, gx_code, start_date, end_date) VALUES(seq_member.nextval,?,UPPER(?),?,?,1,?,?,?,?)";
		getPreparedStatement(sql);
		System.out.println("3단계 성공~");
		
		try {
			
			//쿼리를 실행하기전에 물음표 자리에 하나하나 넣어주는 매핑이 필요하다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());	
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getBirth_date());
			pstmt.setString(6, vo.getGx_code());
			pstmt.setString(7, vo.getStart_date());
			pstmt.setString(8, vo.getEnd_date());
			
			// api 에는 매게변수가 없는데 오류가 안뜨는이유 
			// result = pstmt.executeUpdate(sql); 는 statement 를 상속하기 때문에 매개변수 sql을 넣어도 오류가 뜨지 않음. 하지만 틀린구문이다.
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4단계 문제");
		}
		return result;
	}
	
	/** 4~5 단계 : 로그인 정보 vo에 값 넣기 **/
	public int searchCno() {
		
		String sql = "SELECT * FROM(select cno, name ,rank() over(order by created_date desc) AS RK from member) WHERE RK =1";
		getPreparedStatement(sql);	//3단계 호출
		
		try {
			rs = pstmt.executeQuery();
			cno = 0;
			if(rs.next()) {			
				cno = rs.getInt(1);
			}
		}catch(Exception e) {		
			e.printStackTrace();
		}
		return cno;
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
