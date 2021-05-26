package day_030;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx01 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn =null;
		
		try {
			Class.forName( "org.mariadb.jdbc.Driver" );
			conn = DriverManager.getConnection( url, user, password );
			
			// 데이터베이스 정보
			DatabaseMetaData dmd = conn.getMetaData();
			
			// 어떤 데이터베이스와 연결되는지 확인 가능하다.
			System.out.println( dmd.getDatabaseProductName() );
			System.out.println( dmd.getDatabaseProductVersion() );
			System.out.println( dmd.getDriverName() );
			System.out.println( dmd.getDriverVersion() );
			
			// 어디에 연결되어있는지 확인 가능하다.
			System.out.println( dmd.getURL() );
			System.out.println( dmd.getUserName() );
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if( conn != null ) try{ conn.close(); } catch( SQLException e ) {}
		}
	}
}