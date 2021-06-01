package pack2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 서버
public class TCPServerEx01 {

	public static void main(String[] args) {
		// 접속대기(java.net.ServerSocket -> 데이터 처리
		ServerSocket severSocket = null;
		Socket socket = null;
		
		// 데이터를 쓰기위한 변수
		BufferedWriter bw = null;
		
		try {
			// ServerSocket( 포트 번호 ) 설정
			severSocket = new ServerSocket( 7777 );
			System.out.println("출력 서버가 준비되었습니다.");
			socket = severSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
			// 출력
			// OutputStreamWriter : 다국어 처리를 위한 구문을 붙여야한다.
			// OutputStream은 다국어 처리가 안되니까요.
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("Hello Client" + "\n");
			
			System.out.println("전송 완료");
			
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			// 닫는 순서를 무조건 맞추어 주어야 한다.
			if( bw != null ) try { bw.close(); } catch (IOException e) {}
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
			if( severSocket != null ) try { severSocket.close(); } catch (IOException e) {}
		}
	}
}