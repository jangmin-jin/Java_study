package day_034;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupEx01 {

	public static void main(String[] args) {
		Document doc = null;
		
		try {
			// Jsoup을 이용한  document 연결
			doc = Jsoup.connect("https://m.daum.net").get();
//			System.out.println(doc.toString());
			
			// title가져오는 방법 1
			Elements titleTagList = doc.getElementsByTag("title");
			System.out.println(titleTagList.text());
			
			// title가져오는 방법 2
			String title = doc.title();
			System.out.println(title);
			
		} catch (IOException e) {
			System.out.println("에러 : " + e.getMessage());
		}
	}
}