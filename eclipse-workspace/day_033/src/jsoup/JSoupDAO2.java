package jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupDAO2 {
	
	BufferedReader br = null;
	StringBuffer sbHtml = null;
	ArrayList<JSoupTO> newsLists = new ArrayList<JSoupTO>();
	Document doc = null;
	
	// 생성자 - DAO호출시 바로 doc(파싱) 까지 완료
	public JSoupDAO2(String address) {

		// 누적해서 저장하기 위한 StringBuffer
		sbHtml = new StringBuffer();
		
		try {
			URLConnection conn = new URL(address).openConnection();
			br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
			String html = null;
			while( (html = br.readLine()) != null ) {
				sbHtml.append(html);
			}
			
			// 파싱
			doc = Jsoup.parse(sbHtml.toString());
			
		} catch (MalformedURLException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
	
	/*
	 	*  열독률 높은, 댓글 많은
	 */
	public ArrayList<JSoupTO> newsLists(String address) {
		
		// 뉴스글이 적힌 부분 선택
		Elements litagLists = doc.select( "li[data-tiara-layer=news_list]" );
		
		// 뉴스글에서 select하여 필요한 부분의 데이터를 정제
		for( Element litag : litagLists) {
			JSoupTO to = new JSoupTO();
			
			// 제목
			Elements subjectLists = litag.select("a.link_txt");
			to.setSubject(subjectLists.text());
			
			// 출처
			Elements sourceLists = litag.select("span.info_news");
			to.setSource(sourceLists.text());
			
			// 내용
			Elements contentLists = litag.select("span.link_txt");
			to.setContent(contentLists.text());
			
			newsLists.add(to);
		}
		return newsLists;
	}
	
	/*
	 	*  연령대
	 */
	public ArrayList<JSoupTO> newsListsAge(String address) {
		
		// 뉴스글 적힌 부분
		Elements litagLists = doc.select( "li.num_news" );
		
		// 연령대 배열
		String[] ageList = {
				"20_age male news_list",
				"20_age female news_list",
				"30_age male news_list",
				"30_age female news_list",
				"40_age male news_list",
				"40_age female news_list",
				"50_age male news_list",
				"50_age female news_list",
				};
		
		// 연령대별로 데이터 정제
		for(int i=0; i<ageList.length; i++) {
			// 연령대 선택
			Elements ageLists = doc.select("li[data-tiara-layer='" + ageList[i] + "']");
			 // System.out.println( ageLists.toString() );
			 
			 for(Element litag : ageLists) {
				 JSoupTO to = new JSoupTO();
				 
				 //연령대
				 String age = ageList[i].substring(0,2) + "대";
				 to.setAge(age);
				 
				 // 제목
				 Elements subjectLists = litag.select("a.link_txt");
				 to.setSubject(subjectLists.text());
				 
				 // 출처
				 Elements sourceLists = litag.select("span.info_news");
				 to.setSource(sourceLists.text());
				 
				 newsLists.add(to);
			 }
		}
		return newsLists;
	}
}