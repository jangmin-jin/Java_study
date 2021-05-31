package day_033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NewsEx03 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		// 다음 뉴스탭안으로 또 타고 들어가서 특정 부분만 긁어올 수 있다.
		try {
			URLConnection conn = new URL("https://news.daum.net/ranking/kkomkkom/").openConnection();
			br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
			String line = null;
			while( (line = br.readLine() ) != null) {
				// list_news2 클래스 부터
				if( line.contains("class=\"list_news2\"") ) {
					
					while(true) {
						
						line = br.readLine();
						
						// 특정 컨텐츠의 글자만 읽어오기
						// 뉴스 제목
						if(line.contains("<a") && line.contains("class=\"link_txt\"")) {

							int startText = line.indexOf(">");
							int endText = line.lastIndexOf("<");
							System.out.println(line.substring(startText + 1,endText));
						
						// 뉴스 사
						} else if(line.contains("span class=\"link_txt\"")) {
							
							line = br.readLine();
							System.out.println(line.trim());	
						
						// 뉴스 내용
						} else if(line.contains("class=\"info_news\"")) {
							
							int startText = line.indexOf(">");
							int endText = line.lastIndexOf("<");
							System.out.println(line.substring(startText +1,endText));
						}
						
						// box_info 클래스 전까지
						if(line.contains("class=\"box_info\"")) {
							break;
						}
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