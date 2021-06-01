package pack6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// 클라이언트
public class TCPClientEx01 {

	public static void main(String[] args) {
		Socket socket = null;
		
		// 쓰고, 읽고
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			System.out.println("서버와 연결중...");
			// Socket( "ID", 연결번호 ) 연결 설정
			socket = new Socket("localhost", 7777);
			System.out.println("서버연결 완료");
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 스캐너로 구구단 입력 받기
			Scanner sc = new Scanner(System.in);
			System.out.print("단수 입력 > ");
			String dan = (String)sc.next();
			// 스캐너 종료
			sc.close();
			
			// 입력 받은 단수로 서버로 전송
			bw.write(dan + "\n");
			bw.flush();
			System.out.println("전송 완료");
			
			// 서버를 통해 계산된 구구단 출력
			String guguDan = "";
			while( ( guguDan = br.readLine() ) != null ) {
				System.out.println(guguDan);
			}

		} catch (UnknownHostException e) {
			System.out.println("에러 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		} finally {
			if( br != null) try { br.close(); } catch (IOException e) {}
			if( bw != null) try { bw.close(); } catch (IOException e) {}
			
			if( socket != null ) try { socket.close(); } catch (IOException e) {}
		}
	}
}