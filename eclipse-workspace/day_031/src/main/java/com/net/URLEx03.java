package com.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx03 {

	public static void main(String[] args) {
		
		// 기존의 InputStream 대신 BufferedReader를 사용한다.
		BufferedReader br = null;
		
		try {
			
			// 다국어도 읽을 수 있다.
			// 해당 URL을 요청하면
			URL url = new URL("https://m.naver.com");
			br = new BufferedReader( new InputStreamReader( url.openStream() ) );
			
			String line = "";
			// html 정보를 다 긁어온다.
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( br!=null ) try { br.close(); } catch ( IOException e ) {}
		}
	}
}