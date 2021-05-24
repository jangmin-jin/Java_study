package day_028;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZipcodeEx03 {

	public static void main(String[] args) {
		
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// Scanner로 입력 받기
		System.out.print( "동을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String searchWhat = sc.next();
		String checkLength[] = searchWhat.split("");
		
		// 글자수가 2글자 이상이여야 합니다.
		if( checkLength.length <2 ) {
			System.out.println( "두글자 이상을 입력하세요" );
			// scanner close
			sc.close();
			return;
		}else {
			// scanner close
			sc.close();
		}
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			String sql = "select * from zipcode where dong like '" + searchWhat + "%'" ;
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				System.out.printf("[%s] %s %s %s %s %s %s \n", 
						rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"), rs.getString("seq"));
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