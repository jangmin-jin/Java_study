package day_034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class XMLEx02 {

	public static void main(String[] args) {
		// https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109 (서울, 경기)
		// https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108 (전국)
		
		StringBuffer sbXml = new StringBuffer();
		BufferedReader br =null;
			
	try {
		URLConnection conn = new URL("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109").openConnection();
		br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
		// xml에 문서 저장
		String xml = null;
		while( (xml = br.readLine()) != null ) {
			sbXml.append(xml);
		}
		
		Document doc = Jsoup.parse(sbXml.toString());
		
		// 도시명만 가져오기
		Elements city = doc.select("city");
		System.out.println(city.text());
			
		} catch (MalformedURLException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
}