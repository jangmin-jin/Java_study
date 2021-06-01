package pack6;

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
		// 서버소켓 생성
		ServerSocket severSocket = null;
		Socket socket = null;
		
		// 읽고, 쓰고
		BufferedReader br = null;
		BufferedWriter bw = null;
		
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
					
					// 클라이언트에서 넘어온 구구단 데이터를 받아 int로 형변환
					String msg = br.readLine();
					int dan = Integer.parseInt(msg);
					
					// 다시 msg에 쌓아준다.
					msg = "";
					for(int i=1; i<=9; i++) {
						msg += (String)(dan + " X " + i + " = " + (dan*i) + "\n");
					}
					
					// 서버에서 디버깅해보고
					System.out.println(msg);
					
					// 클라이언트에게 던진다.
					bw.write(msg + "\n");
					bw.flush();
					System.out.println("전송완료");
					
				} catch(IOException e) {
					System.out.println("에러 :" + e.getMessage());
				} finally {
					if( br != null) try { br.close(); } catch (IOException e) {}
					if( bw != null) try { bw.close(); } catch (IOException e) {}
					
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