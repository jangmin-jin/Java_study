package day_034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx03 {

	public static void main(String[] args) {
		
		BufferedReader br =null;


		
	try {
		// JSON 데이터를 불러와서 읽기
		URLConnection conn = new URL("https://www.kma.go.kr/DFSROOT/POINT/DATA/top.json.txt").openConnection();
		br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
		// StringBuffer sbJson = new StringBuffer();
		// String json = null;
		
		// while( (json = br.readLine()) != null ) {
		// 	sbJson.append(json);
		// }
		
		JSONParser parser = new JSONParser();
		
		// br을 바로 받을 수 있다.
		// JSONArray arrays  = (JSONArray)parser.parse(sbJson.toString());
		JSONArray arrays  = (JSONArray)parser.parse(br);
		
		// 배열안에 들어있는 JSON 데이터를 읽어오는 방법
		for(int i=0; i<arrays.size(); i++) {
			JSONObject object = (JSONObject)arrays.get(i);
			System.out.printf("%s : %s\n", 
					(String)object.get("code"), (String)object.get("value") );
		}
		
		} catch (MalformedURLException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
}