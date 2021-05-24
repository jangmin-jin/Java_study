package day_028;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx05 {

	public static void main(String[] args) {
		
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			// 미완성 sql문 선언후 데이터 삽입
			// String sql = "select * from zipcode where dong=(?) limit 0, 10";
			String sql = "select * from zipcode where dong like (?) limit 0, 10";
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, "개포동");
			pstmt.setString(1, "개포%");

			// select 적용
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("zipcode"));
				System.out.println(rs.getString("dong"));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};		
		}
	}
}