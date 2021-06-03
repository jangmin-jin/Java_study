package gugudan;

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
					
					// 시작단 : 끝단
					String msg = br.readLine();
					String[] dans = msg.split(":");
					
					int startDan = Integer.parseInt(dans[0]);
					int endDan = Integer.parseInt(dans[1]);
					
					// (구구단)\t(구구단) ... 총9개 : (구구단)\t(구구단)... 총 9개
					StringBuffer sbResult = new StringBuffer();
					for(int dan=startDan; dan<=endDan; dan++) {
						for(int col=1; col<=9; col++) {
							sbResult.append(dan + " X " + col + " = " + (dan*col) + "\t");
						}
						sbResult.append(":");
					}
					
					// 서버에서 디버깅해보고
					System.out.println(sbResult.toString());
					
					// 클라이언트에게 던진다.
					bw.write(sbResult.toString() + "\n");
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