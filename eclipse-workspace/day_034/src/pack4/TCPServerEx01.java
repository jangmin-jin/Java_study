package pack4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 서버
public class TCPServerEx01 {

	public static void main(String[] args) {
		// 접속대기(java.net.ServerSocket -> 데이터 처리
		ServerSocket severSocket = null;
		Socket socket = null;
		
		try {
			// ServerSocket( 포트 번호 ) 설정
			severSocket = new ServerSocket( 7777 );
			
			// 클라이언트를 계속 실행시켜주고 싶다.
			while(true) {
				try {
					System.out.println("출력 서버가 준비되었습니다.");
					socket = severSocket.accept();
					System.out.println("클라이언트와 연결되었습니다.");
					
				} catch(IOException e) {
					System.out.println("에러 :" + e.getMessage());
				} finally {
					// 접속되고나서 처리하고 닫고, 다시 접속시도가 오면 오픈한다.
					if( socket != null ) try { socket.close(); } catch (IOException e) {}
				}
			}
			
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			if( severSocket != null ) try { severSocket.close(); } catch (IOException e) {}
		}
	}
}