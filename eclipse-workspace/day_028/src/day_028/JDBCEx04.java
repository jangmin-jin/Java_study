package day_028;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx04 {

	public static void main(String[] args) {
		
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		// Statement stmt = null;
		// 미리 준비된 statement
		PreparedStatement pstmt = null;
		
		try {
			// org.mariadb.jdbc.Driver
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			// 미완성 sql문 선언후 데이터 삽입
			String sql = "update dept2 set loc='서울' where deptno =(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "20");

			// 그냥 실행 시켜야 한다.
			int result = pstmt.executeUpdate();
			System.out.println( "성공 : " + result );
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};		
		}
	}
}