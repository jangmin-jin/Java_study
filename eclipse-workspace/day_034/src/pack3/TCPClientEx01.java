package pack3;

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
		
		// 데이터를 읽고 쓰기위한 변수 선언
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			System.out.println("서버와 연결중 입니다.");
			// Socket( "ID", 연결번호 ) 연결 설정
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결되었습니다.");
			
			// 서버에 데이터를 쓰고 / 다시 넘어온 값을 읽는다.
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 테이터 쓰기
			bw.write("Hello Server" + "\n");
			bw.flush();
			
			System.out.println("전송 완료");
			
			System.out.println("서버에서 보낸 메세지 : " + br.readLine());
			
			
		} catch (UnknownHostException e) {
			System.out.println("에러 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			// 닫는 순서를 무조건 맞추어 주어야 한다.
			if( br != null ) try { br.close(); } catch (IOException e) {}
			if( bw != null ) try { bw.close(); } catch (IOException e) {}
			
			// 소켓이 나중에 닫힐 수 있게만 해주면 된다.
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
		}
	}
}