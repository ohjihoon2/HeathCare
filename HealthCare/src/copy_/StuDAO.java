package copy_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StuDAO {

	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "scott";
	String pass = "tiger";
	
	//Constructor : 1~2 단계
	public StuDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("1단계 성공~");
			
			conn = DriverManager.getConnection(url,user,pass);
System.out.println("2단계 성공~");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//Method
	/** 3단계 : Statement 객체 생성 **/
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
	public ArrayList<StuVO> getList(){
		ArrayList<StuVO> list = new ArrayList<StuVO>();
		String sql = "select rownum, sno,sname,skor,seng,smath,"
				+ "stot,savg from (select sno,sname,skor,seng,smath,"
				+ "					stot,trunc(savg,2) savg"
				+ "		           from stu order by sno)";
		getPreparedStatement(sql);
		System.out.println("Preparedstatement 실행 테스트~~");
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StuVO vo = new StuVO();
				vo.setRno(rs.getInt(1));
				vo.setSno(rs.getString(2));
				vo.setSname(rs.getString(3));
				vo.setSkor(rs.getInt(4));
				vo.setSeng(rs.getInt(5));
				vo.setSmath(rs.getInt(6));
				vo.setStot(rs.getDouble(7));
				vo.setSavg(rs.getDouble(8));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/** 4~5 단계 : 하나의 row 출력 **/
	public StuVO  getListVO(String sno) {
		StuVO vo = new StuVO();
		String sql = "select * from stu where sno=upper(?)";
		getPreparedStatement(sql);	//3단계 호출
		
		try {
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {			
				vo.setSno(rs.getString(1));
				vo.setSname(rs.getString(2));
				vo.setSkor(rs.getInt(3));
				vo.setSeng(rs.getInt(4));
				vo.setSmath(rs.getInt(5));
				vo.setStot(rs.getDouble(6));
				vo.setSavg(rs.getDouble(7));			
			}
			
		}catch(Exception e) {		e.printStackTrace();	}
		
		return vo;
	}
	
	/** 4~5 단계 : 데이터 추가 **/
	public int getResultInsert(StuVO vo) {
		int result = 0;
		//getStatement();
		String sql = "insert into stu values("
				+ "'SIST_' || SEQU_STU.NEXTVAL,?,?,?,?,?,?)";
	
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getSname());
			pstmt.setInt(2, vo.getSkor());
			pstmt.setInt(3, vo.getSeng());
			pstmt.setInt(4, vo.getSmath());
			pstmt.setDouble(5, vo.getStot());
			pstmt.setDouble(6, vo.getSavg());
			
			result = pstmt.executeUpdate();	
			
		}catch(Exception e) {e.printStackTrace();}		
		
		return result;
	}
	
	/** 4~5 단계 : 데이터 수정 **/
	public int getResultUpdate(StuVO uvo) {
		int result = 0;
		String sql = "update stu "
				+ " set skor=?,"
				+ " seng=?,"
				+ " smath=?"
				+ " where sno=upper(?)";

		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, uvo.getSkor());
			pstmt.setInt(2, uvo.getSeng());
			pstmt.setInt(3, uvo.getSmath());
			pstmt.setString(4, uvo.getSno());
			
			result = pstmt.executeUpdate();
		
		}catch(Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	
	/** 4~5 단계 : 데이터 삭제 **/
	public int getResultDelete(String sno) {
		int result = 0;
		String sql = "delete from stu where sno=upper(?)";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sno);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	
	/** 6단계 : 종료 **/
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			System.out.println("DB 연동 종료~");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	/** 로그인 체크 **/
	public int getResultLogin(String sid, String spass) {
		int result = 0;
		String sql = "SELECT COUNT(*) FROM STU_MEMBER WHERE SID=? AND SPASS=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, spass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}				
			System.out.println("result =" + result);
		}catch(Exception e) {e.printStackTrace();}
		
		return result;
	}

}











