package day_034;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx02 {

	public static void main(String[] args) {
		
		// 기본 형태의 데이터
		// String strJson = "{ \"data1\" : \"value1\", \"data2\" : \"value2\" }";
		
		// 배열 형식의 객체 데이터
		// String strJson = "{ \"data1\" : [8, 9, 6, 2, 9] }";
		
		String strJson = "{ \"data1\" : {\"data11\" : \"value11\", \"data12\" : \"value12\"} }";
		
		JSONParser parser = new JSONParser();
		
		try {
			// object형태로 strJson을 parse한다.
			JSONObject object = (JSONObject)parser.parse(strJson);
			
			// key값으로 접근하여 데이터 값을 뽑아온다.
			/*
			String data1 = (String)object.get("data1");
			System.out.println(data1);
			String data2 = (String)object.get("data2");
			System.out.println(data2);
			*/
			
			// Array형태로 strJson을 parse한다.
			// 단, 객체의 크기로 접근해야해서 .size()를 사용한다.
			/*
			JSONArray array = (JSONArray)object.get("data1");
			for(int i=0; i<array.size(); i++) {
				System.out.println(array.get(i));
			}
			*/
			
			// 한번더 파고 들어가야 한다.
			JSONObject childObject = (JSONObject)object.get("data1");
			System.out.println((String)childObject.get("data11"));
			System.out.println((String)childObject.get("data12"));
			
		} catch (ParseException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}
	}
}