package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mycom.vo.DietMemberVO;
import com.mycom.vo.DietSaveVO;
import com.mycom.vo.DietSelectVO;

public class DietDAO {
	
	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
	String user = "HealthCare";
	String pass = "1234";
	
	//Constructor
	public DietDAO() {
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
	/** 3단계 : Statement 객체 생서 **/
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 3단계 : PreparedStatement 객체 생성 **/
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 4~5 단계 : 전체 리스트 출력 **/
	public void getList(DefaultTableModel t_model) {
		String sql = "select * from food order by f_no asc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel에 있는 기존 데이터 지우기
			for(int i=0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			
			while(rs.next()) {
				   Object data[] = { 
						   rs.getInt(1), 
						   rs.getString(2),
	                       rs.getInt(3), 
	                       rs.getInt(4),
	                       rs.getInt(5),
	                       rs.getInt(6),
	                       rs.getInt(7),
	                       rs.getInt(8),
	                       rs.getInt(9)
	                        };
	 
	            t_model.addRow(data); //DefaultTableModel에 레코드 추가
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 다이어트 식단 검색 **/
	public void getResultDietSearch(DefaultTableModel t_model,String name){
		
		String sql = "select * from food where f_name like ?"
				+ " order by f_no asc";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			// DefaultTableModel에 있는 기존 데이터 지우기
			for(int i=0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			
			while(rs.next()) {
				   Object data[] = { 
						   rs.getInt(1), 
						   rs.getString(2),
	                       rs.getInt(3), 
	                       rs.getInt(4),
	                       rs.getInt(5),
	                       rs.getInt(6),
	                       rs.getInt(7),
	                       rs.getInt(8),
	                       rs.getInt(9)
	                        };
	 
	            t_model.addRow(data); //DefaultTableModel에 레코드 추가
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** 4~5 단계 : 검색 데이터 추가 **/
	public int getResultInseret(DietSelectVO vo) {
		int result = 0;
		
		String sql  = "insert into DietSelect values"
				+ " (SEQU_DietSelect.NEXTVAL,?,?,?,sysdate)";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1,vo.getDSF_NO());
			pstmt.setString(2,vo.getDSF_NAME());
			pstmt.setInt(3,vo.getDSF_CALORIE());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 4~5 단계 : 검색 저장 리스트 출력 **/
	public void getInsertList2(DefaultTableModel t_model) {
		String sql = "select DSF_NO,DSF_NAME,DSF_CALORIE,to_char(DS_DATE,'yyyy-mm-dd')  from DietSelect order by DS_NO asc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel에 있는 기존 데이터 지우기
			for(int i=0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			
			while(rs.next()) {
				   Object data[] = { 
						   rs.getInt(1),
	                       rs.getString(2), 
	                       rs.getInt(3),
	                       rs.getString(4)
	                      
	                       
	                        };
	 
	            t_model.addRow(data); //DefaultTableModel에 레코드 추가
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 검색 저장 리스트 출력 삭제 **/
	public int getDeleteList2() {
		int result = 0;
		
		String sql = "delete from DIETSELECT";
		//getStatement();
		getPreparedStatement(sql);
		
		try {
			result = pstmt.executeUpdate();
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	/**회정정보 출력**/
	public DietMemberVO getMemberInfo(int cno) {
		DietMemberVO mvo = new DietMemberVO();
		String sql="select * from member" 
				+ " where cno=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo.setCNO(rs.getInt(1));
				mvo.setNAME(rs.getString(2));
				mvo.setGENDER(rs.getString(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mvo;
	}
	
	/**몸무게 등록**/
	public int getInsertWeigth(DietMemberVO mvo2) {
		int result = 0;
		
		String sql = "insert into DietWeight values (SEQU_DIETWEIGHT.NEXTVAL,?,?,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mvo2.getDW_WEIGHT());
			pstmt.setString(2, mvo2.getDW_TARGETWEIGHT());
			pstmt.setString(3, mvo2.getDW_DATE());
			pstmt.setInt(4, mvo2.getCNO());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 몸무게 출력 **/
	public DietMemberVO getResultWeight(int cno, String time1) {
		DietMemberVO vo = new DietMemberVO();
		String sql = "select d.DW_NO, d.cno, m.name, m.GENDER, dw_weight, d.DW_TARGETWEIGHT, to_char(DW_DATE,'yyyy-MM-dd') "
				+" from dietweight d,member m"  
				+" where d.cno = m.cno"
				+" and d.cno = ?"
				+" and to_char(DW_DATE,'yyyy-MM-dd') = ?"
				+ " order by d.DW_NO desc";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			pstmt.setString(2, time1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setDW_NO(rs.getInt(1));
				vo.setCNO(rs.getInt(2));
				vo.setNAME(rs.getString(3));
				vo.setGENDER(rs.getString(4));
				vo.setDW_WEIGHT(rs.getString(5));
				vo.setDW_TARGETWEIGHT(rs.getString(6));
				vo.setDW_DATE(rs.getString(7));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
//	/** 몸무게 삭제 **/
//	public int getDeleteWeight(int dw_no) {
//		int result = 0;
//		
//		String sql = "delete from DietWeight where DW_NO=?";
//		//getStatement();
//		getPreparedStatement(sql);
//		System.out.println("dw_no="+dw_no);
//		try {
//			pstmt.setInt(1, dw_no);
//			
//			result = pstmt.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	
	/**개인일지 등록(회원정보,몸무게,칼로리)**/
	public int getInsertDiet(DietSaveVO dsvo) {
		int result = 0;
		
		String sql = "insert into DIETSAVE values (?,?,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, dsvo.getDS_SelectKcal());
			pstmt.setInt(2, dsvo.getDS_RECOMMEND());
			pstmt.setInt(3, dsvo.getDS_RESULTKCAL());
			pstmt.setInt(4, dsvo.getDW_NO());
			
			
			System.out.println( dsvo.getDS_SelectKcal());
			System.out.println( dsvo.getDS_RECOMMEND());
			System.out.println( dsvo.getDS_RESULTKCAL());
			System.out.println( dsvo.getDW_WEIGHT());
			System.out.println(dsvo.getCNO());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**개인일지 저장 출력 (회원정보,몸무게,칼로리)**/
	public ArrayList<DietSaveVO> getResultDiet(int cno) {
		ArrayList<DietSaveVO> list = new ArrayList<DietSaveVO>();
		
		String sql = "select rownum, DW_NO, CNO, NAME, DW_WEIGHT, DW_TARGETWEIGHT, DS_SELECTKCAL," 
				+ "     DS_RECOMMEND, DS_RESULTKCAL, to_char(DW_DATE,'yyyy-mm-dd')"
				+ "	  from(select ds.DW_NO,m.CNO,m.NAME, dw.DW_WEIGHT,dw.DW_TARGETWEIGHT," 
				+ "    ds.DS_SELECTKCAL,ds.DS_RECOMMEND,ds.DS_RESULTKCAL,dw.DW_DATE" 
				+ "    from DIETWEIGHT dw, MEMBER m, DIETSAVE ds"
				+ "    where dw.CNO = m.CNO" 
				+ "    AND  dw.DW_NO = ds.DW_NO"
				+ "    and dw.CNO = ?" 
				+ "    order by ds.DW_NO asc)";
		
		//getStatement();
		getPreparedStatement(sql);
		
		try {
			//rs = stmt.executeQuery(sql);
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DietSaveVO vo = new DietSaveVO();
				vo.setRNO(rs.getInt(1));
				vo.setDW_NO(rs.getInt(2));
				vo.setCNO(rs.getInt(3));
				vo.setNAME(rs.getString(4));
				vo.setDW_WEIGHT(rs.getString(5));
				vo.setDW_TARGETWEIGHT(rs.getString(6));
				vo.setDS_SelectKcal(rs.getInt(7));
				vo.setDS_RECOMMEND(rs.getInt(8));
				vo.setDS_RESULTKCAL(rs.getInt(9));
				vo.setDW_DATE(rs.getString(10));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/** 6단계 : 종료**/
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
