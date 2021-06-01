package pack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

// 클라이언트
public class TCPClientEx01 {

	public static void main(String[] args) {
		Socket socket = null;
		
		// 데이터를 읽기위한 변수
		BufferedReader br = null;
		
		try {
			System.out.println("서버와 연결중 입니다.");
			// Socket( "ID", 연결번호 ) 연결 설정
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결되었습니다.");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("msg : " + br.readLine());
			
			
		} catch (UnknownHostException e) {
			System.out.println("에러 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			// 닫는 순서를 무조건 맞추어 주어야 한다.
			if( br != null ) try { br.close(); } catch (IOException e) {}
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
		}
	}
}