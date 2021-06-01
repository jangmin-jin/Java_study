package day_034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JSONEx01 {

	public static void main(String[] args) {
		
		BufferedReader br =null;
			
	try {
		// JSON 데이터를 불러와서 읽기
		URLConnection conn = new URL("https://www.kma.go.kr/DFSROOT/POINT/DATA/top.json.txt").openConnection();
		br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			
		String json = null;
		while( (json = br.readLine()) != null ) {
			// System.out.println(json + "\n");
			
			String jsonArr[] = json.split(",");
			
			for(int i=0; i<jsonArr.length; i++) {
				// value 값만 찾아서 출력
				if(jsonArr[i].contains("value")) {
					int startValue = jsonArr[i].indexOf(":") + 2;
					int endValue = jsonArr[i].lastIndexOf("}") - 1;
					System.out.println(jsonArr[i].substring(startValue, endValue));
				}
			}
		}
			
		} catch (MalformedURLException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " +e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch (IOException e) {}
		};
	}
}