package day_028;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchZipcodeJava {

	public void printZipcode(String address) {
		
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			String sql = "select * from zipcode where dong like '" + address + "%'" ;
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
						PrintStream textArea;
//						textArea.append(rs.getString("zipcode") +"  ");
//						textArea.append(rs.getString("sido") +"  ");
//						textArea.append(rs.getString("gugun") +"  ");
//						textArea.append(rs.getString("dong") +"  ");
//						textArea.append(rs.getString("ri") +"  ");
//						textArea.append(rs.getString("bunji") +"  ");
//						textArea.append(rs.getString("seq") +"  \n");
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