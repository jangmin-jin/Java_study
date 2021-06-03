package gugudan;

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
			
			// args를 이용해 받아 올 수 있다.
			 int startDan = Integer.parseInt(args[0]);
			 int endDan = Integer.parseInt(args[1]);
			
			// int startDan = 2;
			// int endDan = 6;
			// 입력 받은 단수로 서버로 전송
			bw.write( startDan + ":" + endDan + "\n");
			bw.flush();
			System.out.println("전송 완료");
			
			String msg = br.readLine();
			String[] gugudans = msg.split(":");
			for(String gugudan : gugudans) {
				System.out.println(gugudan);
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