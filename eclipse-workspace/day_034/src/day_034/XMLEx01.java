package day_034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class XMLEx01 {

	public static void main(String[] args) {
		// https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109 (서울, 경기)
		// https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108 (전국)
		
		StringBuffer sbXml = new StringBuffer();
		BufferedReader br =null;
			
	try {
		// 날씨 정보에서 원하는 정보만 빼오기
		URLConnection conn = new URL("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109").openConnection();
		br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
		String xml = null;
		while( (xml = br.readLine()) != null ) {
			// 지역정보 가져오기
			if(xml.contains("<province>")) {
				while(true) {
					xml = br.readLine();
					
					// 스킵
					if(xml.contains("<data>") || xml.contains("</data>")) {
						continue;
					}
					
					sbXml.append(xml + "\n");
					
					if(xml.contains("</body>")) {
						break;
					}
				}
			}
			
		}
		
		// 결과 출력
		System.out.println(sbXml.toString());
			
		} catch (MalformedURLException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
}