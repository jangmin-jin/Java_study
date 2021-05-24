package day_028;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeEx02 {

	public static void main(String[] args) {
		
		// csv파일 reading을 위한 reader 선언
		BufferedReader getAddress = null;
		
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
			
			getAddress = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			String data = null;
			
			int count = 1;
			while( (data = getAddress.readLine() ) != null) {
				String arr[] = data.split(",");
				String sql = String.format("insert into zipcode2 values('%s', '%s', '%s', '%s', '%s', '%s', %s)", 
								arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6] );
				
				count += stmt.executeUpdate(sql);
			}
			System.out.println("처리 결과 : " + count);
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (FileNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(stmt != null) try {stmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
			if(getAddress!=null) try { getAddress.close(); } catch (IOException e) {};
		}
	}
}