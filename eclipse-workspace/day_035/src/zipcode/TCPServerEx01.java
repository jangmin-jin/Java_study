package zipcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 서버
public class TCPServerEx01 {

	public static void main(String[] args) {
		// 서버소켓 생성
		ServerSocket severSocket = null;
		Socket socket = null;
		
		// 읽고, 쓰고
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		// Database 연결을 위한 정의
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// Database 연결을 위한 인터페이스 호출
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// ServerSocket( 포트 번호 ) 설정
			severSocket = new ServerSocket( 7777 );
			
			// 나는 서버를 계속 실행시켜주고 싶다. (반복실시)
			while(true) {
				try {
					System.out.println("서버 준비완료.");
					socket = severSocket.accept();
					System.out.println("클라이언트 연결 완료.");
					
					br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					
					String dong = br.readLine();
					
					// 계속 연결해야 하니까 안에 넣어준다.
					Class.forName("org.mariadb.jdbc.Driver");
					conn = DriverManager.getConnection(url, user, password);
					
					String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dong+"%");
					
					rs = pstmt.executeQuery();
					
					StringBuffer sbResult = new StringBuffer();
					while(rs.next()) {
						String address = String.format("[%s] %s %s %s %s %s", 
								rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
								rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"));
						sbResult.append(address + ":");
					}
					
					// 서버에서 디버깅해보고
					// System.out.println(sbResult.toString());
					
					// 클라이언트에게 던진다.
					bw.write(sbResult.toString() + "\n");
					bw.flush();
					System.out.println("전송완료");
					
				} catch(IOException e) {
					System.out.println("에러 :" + e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("에러 : " + e.getMessage());
				} catch (SQLException e) {
					System.out.println("에러 : " + e.getMessage());
				}
				finally {
					if( rs != null ) try { rs.close(); } catch (SQLException e) {}
					if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
					if( conn != null ) try { conn.close(); } catch (SQLException e) {}
					
					if( br != null) try { br.close(); } catch (IOException e) {}
					if( bw != null) try { bw.close(); } catch (IOException e) {}
					
					if( socket != null ) try { socket.close(); } catch (IOException e) {}
				}
			}
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		}  finally {
			if( severSocket != null ) try { severSocket.close(); } catch (IOException e) {}
		}
	}
}