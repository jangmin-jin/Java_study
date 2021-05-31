package day_033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NewsEx02 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		// 다음 뉴스탭으로 들어가서 특정 부분만 긁어올 수 있다.
		try {
			URLConnection conn = new URL("https://news.daum.net").openConnection();
			br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
			// MAIN_NEWS탭 부터
			String line = null;
			while( (line = br.readLine() ) != null) {
				if( line.contains("data-tiara-layer=\"MAIN_NEWS\"") ) {
					
					System.out.println(line);
					while(true) {
						line = br.readLine();
						// PHOTO까지만
						if(line.contains("data-tiara-layer=\"PHOTO\"")) {
							break;
						}
						System.out.println(line);
					}
				};
			}
		} catch (MalformedURLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
}