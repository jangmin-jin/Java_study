package ex01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PostSearch {
	
	public String postSearch (String address) {
		
		// 변수 선언
		String result = "";
		BufferedReader br = null;

		// 주소 검사 실행
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			String data = null;
			int count =0;
			
			// 입력한 주소가 포함된 결과를 반환
			while( (data = br.readLine() ) != null ) {
				String arr[] = data.split(",");
				if(arr[3].contains(address)) {
					result += (data + "\n");
					count++;
				}
			}
			
			// 조건 : 일치하는 결과가 없으면 메세지 출력
			if (count == 0) {
				result = "일치하는 결과가 없습니다.";
				return result;
			}
			count = 0;
			
		// 예외 처리
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br!=null) try { br.close(); } catch(IOException e) {}
		}
		
		// 결과 최종 반환
		return result;
	}
}