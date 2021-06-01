package day_034;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupEx02 {

	public static void main(String[] args) {
		Document doc = null;
		
		try {
			// Jsoup을 이용한  document 연결
			// doc = Jsoup.connect("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109").get();
			
			doc = Jsoup.connect("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp")
					// 분리해서 관리하게 편하게끔
					.data("stnId","109")
					.get();
			
			// System.out.println(doc.toString());
			
			// city tag만 가져와서 출력
			Elements citytagLists = doc.getElementsByTag("city");
			System.out.println(citytagLists.toString());
			
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		}
	}
}