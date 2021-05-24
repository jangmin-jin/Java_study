package day_028;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx01 {

	public static void main(String[] args) {
		
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		Statement stmt = null;
		
		// select 사용시 선언
		ResultSet rs = null;
		
		try {
			// org.mariadb.jdbc.Driver
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			String sql = "";
			int result = stmt.executeUpdate(sql);
			
			// select 사용시 선언
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(stmt != null) try {stmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};		
		}
	}
}