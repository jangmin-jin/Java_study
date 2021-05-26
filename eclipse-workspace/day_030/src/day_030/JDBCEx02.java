package day_030;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCEx02 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			conn = DriverManager.getConnection( url, user, password );
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// select 시 상태를 확인 하기위한 ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// 컬럼의 갯수를 확인 할 수 있다.
			System.out.println( rsmd.getColumnCount() );
			for(int i=1; i<rsmd.getColumnCount(); i++) {
				System.out.printf("%-15s", rsmd.getColumnName(i) );
				System.out.printf("%-7s", rsmd.getColumnTypeName(i) );
				System.out.printf("(%2s)", rsmd.getPrecision(i) );
				System.out.printf("%7s", rsmd.getScale(i) );
				System.out.printf("%7s", rsmd.isNullable(i) +"\n");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
	}
}