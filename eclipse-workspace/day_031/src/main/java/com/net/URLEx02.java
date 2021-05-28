package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx02 {

	public static void main(String[] args) {
		
		InputStream is = null;
		
		try {
			
			// 단, 다국어문서는 이렇게 읽으면 문자가 깨진다.
			// 해당 URL을 요청하면
			URL url = new URL("https://m.naver.com");
			is = url.openStream();
			
			int data = 0;
			// html 정보를 다 긁어온다.
			while((data = is.read()) != -1) {
				System.out.print((char)data);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( is!=null ) try { is.close(); } catch ( IOException e ) {}
		}
	}
}