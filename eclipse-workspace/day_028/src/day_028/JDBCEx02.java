package day_028;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx02 {

	public static void main(String[] args) {
		
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// org.mariadb.jdbc.Driver외워야함
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			String sql = String.format("insert into dept2 values (%s, '%s', '%s')", "10", "개발부", "서울");
			int result = stmt.executeUpdate(sql);
			
			System.out.println( "입력 성공 : " + result );
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(stmt != null) try {stmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};		
		}
	}
}