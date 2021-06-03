package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// CRUD
public class ZipcodeDAO {
	public ZipcodeDAO() {
		System.out.println("생성자 호출");
	}
	
	public ArrayList<ZipcodeTO> searchZipcode(String strDong){
		
		Socket socket = null;
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		// datas 초기화
		ArrayList<ZipcodeTO> datas = new ArrayList<ZipcodeTO>();
		
		try {
			System.out.println("서버 연결중");
			socket = new Socket("localhost", 7777);
			System.out.println("서버 연결완료");
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			String msg =  strDong ;
			bw.write(msg +"\n");
			bw.flush();
			System.out.println("전송 완료");
			
			String result = br.readLine();
			System.out.println( "디버그 : " + result);
			
			
			int endtext = result.lastIndexOf(",");
			result = result.substring(0, endtext);
			
			System.out.println( "디버그2 : " + result);
			
			 // [ %s:%s:%s:%s:%s:%s , ... , %s:%s:%s:%s:%s:%s ]
			String[] results = result.split(",");
			for(int i=0; i<(results.length); i++) {
				System.out.println("results : " +results[i]);
				
				String[] address = results[i].split(":");
				
				ZipcodeTO to = new ZipcodeTO();
				
				to.setZipcode(address[0]);
				to.setSido(address[1]);
				to.setGugun(address[2]);
				to.setDong(address[3]);
				to.setRi(address[4]);
				to.setBunji(address[5]);
//				for(int j=0; j<address.length; j++) {
//					to.setZipcode(address[j]);
//				}
				
				datas.add(to);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( br != null) try { br.close(); } catch (IOException e) {}
			if( bw != null) try { bw.close(); } catch (IOException e) {}
			
			if( socket != null ) try { socket.close(); } catch (IOException e) {}

		}
		
		return datas;
	}
}