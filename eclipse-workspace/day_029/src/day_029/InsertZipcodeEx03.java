package day_029;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertZipcodeEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			br = new BufferedReader( new FileReader( "./zipcode_seoul_utf8_type2.csv" ) );
			
			String sentence = null;
			int count = 1;
			while( ( sentence = br.readLine() ) != null ) {
				String[] addresses = sentence.split( "," );
				String sql = String.format("insert into zipcode values ('%s', '%s', '%s', '%s', '%s', '%s', %s)", 
						addresses[0], addresses[1], addresses[2], addresses[3],
						addresses[4], addresses[5], addresses[6] );
				
				count += stmt.executeUpdate(sql);
			}
			
			System.out.println( "결과 : " + count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			if( br != null ) try { br.close(); } catch(IOException e) {};
			
			if( stmt != null ) try { stmt.close(); } catch(SQLException e) {};
			if( conn != null ) try { conn.close(); } catch(SQLException e) {};
		}
	}
}