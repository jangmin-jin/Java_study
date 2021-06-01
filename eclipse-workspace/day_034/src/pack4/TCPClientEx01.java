package pack4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// 클라이언트
public class TCPClientEx01 {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			System.out.println("서버와 연결중 입니다.");
			// Socket( "ID", 연결번호 ) 연결 설정
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결되었습니다.");
			

		} catch (UnknownHostException e) {
			System.out.println("에러 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
		}
	}
}