package pack3;

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
		
		// 데이터를 읽고 쓰기위한 변수 선언
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			// ServerSocket( 포트 번호 ) 설정
			severSocket = new ServerSocket( 7777 );
			System.out.println("출력 서버가 준비되었습니다.");
			socket = severSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
			// 클라이언트에서 넘어온 값을 읽고, 다시 출력한다.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 데이터 읽기
			String msg = br.readLine();
			System.out.println("클라이언트에서 보낸 메세지 : " + msg);
			
			// 데이터 쓰기
			bw.write(msg + "\n");
			bw.flush(); // 싹 비운다
			
			System.out.println("전송 완료");
			
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			// 닫는 순서를 무조건 맞추어 주어야 한다.
			if( br != null ) try { br.close(); } catch (IOException e) {}
			if( bw != null ) try { bw.close(); } catch (IOException e) {}
			
			// 소켓이 나중에 닫힐 수 있게만 해주면 된다.
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
			if( severSocket != null ) try { severSocket.close(); } catch (IOException e) {}
		}
	}
}