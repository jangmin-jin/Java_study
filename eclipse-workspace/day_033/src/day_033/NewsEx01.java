package day_033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NewsEx01 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		// 다음 뉴스탭으로 들어가서 html을 다 읽어온다.
		try {
			URLConnection conn = new URL("https://news.daum.net").openConnection();
			br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
			String line = null;
			String lines = null;
			while( (line = br.readLine() ) != null) {
				lines += line;
			}
			System.out.println( lines );
		} catch (MalformedURLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
}