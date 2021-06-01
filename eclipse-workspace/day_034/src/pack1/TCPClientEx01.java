package pack1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// 클라이언트
public class TCPClientEx01 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			System.out.println("서버와 연결중 입니다.");
			// Socket( "ID", 연결번호 )
			// 서버를 안킨 상태로 실행시키면 Connection refused: connect 에러가 난다.
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