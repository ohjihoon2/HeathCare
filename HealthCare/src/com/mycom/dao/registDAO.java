package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mycom.vo.ClientVO;

public class registDAO {

	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url="jdbc:oracle:thin:@127.0.0.1:1521";
	String user= "scott";
	String pass ="tiger";
	
	//Constructor
	public registDAO() {
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
	
//	/**
//	 * 4~5단계 : 전체 리스트 출력
//	 */
//	public ArrayList<StuVO> getList(){
//		ArrayList<StuVO> list = new ArrayList<StuVO>();
//		String sql = "select rownum, sno, sname, skor, seng, smath,stot, savg  "
//				+ " from (select  sno, sname, skor, seng, smath,stot, trunc(savg,2) savg from stu order by sno)";
//		//3단계
//		getPreparedStatement(sql);
//		try {
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				StuVO vo = new StuVO();
//				vo.setRno(rs.getInt(1));
//				vo.setSno(rs.getString(2));
//				vo.setSname(rs.getString(3));
//				vo.setSkor(rs.getInt(4));
//				vo.setSeng(rs.getInt(5));
//				vo.setSmath(rs.getInt(6));
//				vo.setStot(rs.getDouble(7));
//				vo.setSavg(rs.getDouble(8));
//				
//				//빠지면 null 이뜬다. 아무것도 안찍히면 list.add(vo) 의심해보라 --
//				list.add(vo);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
//	/**
//	 * 4~5단계 : 하나의 row 출력
//	 */
//	
//	public StuVO getListVO(String sno){
//		StuVO vo = new StuVO();
//		String sql ="select * from stu where sno=upper(?)";
//		//3단계
//		getPreparedStatement(sql);
//		try {
//			pstmt.setString(1, sno);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				vo.setSno(rs.getString(1));
//				vo.setSname(rs.getString(2));
//				vo.setSkor(rs.getInt(3));
//				vo.setSeng(rs.getInt(4));
//				vo.setSmath(rs.getInt(5));
//				vo.setStot(rs.getDouble(6));
//				vo.setSavg(rs.getDouble(7));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return vo;
//	}
	
	/**
	 * 4~5단계 : 데이터 추가 
	 */
	public int getClientInsert(ClientVO vo) {
		int result =0;
//		getStatement();
		String sql = "INSERT INTO STU VALUES('SIST_'||SEQU_STU.NEXTVAL,?,?,?,?,?,?)";
		
		getPreparedStatement(sql);
		System.out.println("3단계 성공~");
		
		try {
			//쿼리를 실행하기전에 물음표 자리에 하나하나 넣어주는 매핑이 필요하다.
			pstmt.setString(1, vo.getSname());
			pstmt.setInt(2, vo.getSkor());	
			pstmt.setInt(3, vo.getSeng());
			pstmt.setInt(4, vo.getSmath());
			pstmt.setDouble(5, vo.getStot());
			pstmt.setDouble(6, vo.getSavg());
			
			// api 에는 매게변수가 없는데 오류가 안뜨는이유 
			// result = pstmt.executeUpdate(sql); 는 statement 를 상속하기 때문에 매개변수 sql을 넣어도 오류가 뜨지 않음. 하지만 틀린구문이다.
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4단계 문제");
		}
		return result;
	}
	
	/**
	 * 4~5단계 : 데이터 수정 
	 */
	public int getUpdate(ClientVO vo) {
		int result = 0;
		String sql = "update stu set skor = ?, seng = ?, smath =? where sno = ?";
		getPreparedStatement(sql);
		System.out.println("3단계 성공~");
		try {
			pstmt.setInt(1, vo.getSkor());
			pstmt.setInt(2, vo.getSeng());
			pstmt.setInt(3, vo.getSmath());
			pstmt.setString(4, vo.getSno());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4단계 문제");
		}
		return result;
	}
	
	/**
	 * 4~5단계 : 데이터 삭제 
	 */
	public int getDelete(String sno) {
		int result = 0;
		String sql = "delete from stu where sno =upper(?)";
		getPreparedStatement(sql);
		System.out.println("3단계 성공");

		try {
			pstmt.setString(1, sno);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4단계 문제");
		}
		return result;
	}
	
	/**
	 * 6단계 : 종료
	 */
	
	public void close() {
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 로그인 체크
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
			
			// query가 select 이기 때문에 resultSet으로 받아야 함 
			
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
