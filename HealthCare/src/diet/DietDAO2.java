package diet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.*;

public class DietDAO2 {
	
	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "scott";
	String pass = "tiger";
	
	//Constructor
	public DietDAO2() {
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
	

}
