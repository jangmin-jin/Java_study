package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// Jsoup.jar를 이용한 html 정렬 및 추출
public class JSoupEx02 {

	public static void main(String[] args) {
		
		String html = "<html>"
				+ "<head><title>바로가기 묶음 만들기</title></head>"
				  + "<body>"
				  + "<a href='https://www.daum.net'>"
				  + "<image src='./image/daum.png'  />"
				  + "<div class='d1'>다음 바로가기</div>"
				  + "</a>"
				  + "<a href='https://www.naver.com'>"
				  + "<image src='./image/naver.png'  />"
				  + "<div class='d1'>네이버 바로가기</div>"
				  + "</a>"
				  + "<a href='https://www.google.com'>"
				  + "<image src='./image/google.png'  />"
				  + "<div class='d1'>구글 바로가기</div>"
				  + "</a>"
				  + "</body></html>";
		
		Document doc = Jsoup.parse(html);
		// System.out.println(doc.toString());
		
		// a href 전부 가져오기
		Elements alists = doc.select("a[href]");
		// System.out.println(alists.toString());
		
		// daum.net만 선택해서 가져오기
		Elements alists2 = doc.select("a[href=https://www.daum.net  ]");
		// System.out.println(alists2.toString());
		
		// com으로 끝나는 a href만 가져오기
		Elements alists3 = doc.select("a[href$=com  ]");
		// System.out.println(alists3.toString());

		// png로 끝나는 img 요소만 가져오기
		Elements imglists = doc.select("img[src$=png]");
		// System.out.println(imglists.toString());
		
		// a tag 안에있는 d1클래스 가져오기
		Elements divtagList = doc.select("a .d1");
		System.out.println(divtagList);
	}
}