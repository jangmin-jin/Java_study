package pack1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 서버
public class TCPServerEx01 {

	public static void main(String[] args) {
		// 접속대기(java.net.ServerSocket -> 데이터 처리
		ServerSocket severSocket = null;
		Socket socket = null;
		
		try {
			// 누군가 접속하면 소켓이 생성됨
			// ServerSocket( 포트 번호 )
			// 포트는 한대씩밖에 연결이 안되서 도중에 이클립스 강종되면 7777은 못씀
			// 사용중인 포트라고 에러가 뜸
			severSocket = new ServerSocket( 7777 );
			System.out.println("서버가 준비되었습니다.");
			socket = severSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
			if( severSocket != null ) try { severSocket.close(); } catch (IOException e) {}
		}
	}
}