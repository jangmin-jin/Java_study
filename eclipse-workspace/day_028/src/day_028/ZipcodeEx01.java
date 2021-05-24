package day_028;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeEx01 {

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
			
			while( (data = getAddress.readLine() ) != null) {
				String arr[] = data.split(",");
				String zipcode = arr[0];
				String sido = arr[1];
				String gugun = arr[2];
				String dong = arr[3];
				String ri = arr[4];
				String bunji = arr[5];
				String seq = arr[6];
				
				String sql = String.format("insert into zipcode values('%s', '%s', '%s', '%s', '%s', '%s', %s)", zipcode, sido, gugun, dong, ri, bunji, seq );
				int result = stmt.executeUpdate(sql);
				
				System.out.println("입력 성공 : " + result);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) try {stmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
			if(getAddress!=null) try { getAddress.close(); } catch (IOException e) {};
		}
	}
}