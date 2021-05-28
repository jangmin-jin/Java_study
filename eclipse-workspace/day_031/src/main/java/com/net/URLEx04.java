package com.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLEx04 {

	public static void main(String[] args) {

		BufferedReader br = null;
		
		try {
			// URLConnection 
			// html문서를 깨짐 없이 읽어온다.
			URL url = new URL("https://m.daum.net");
			URLConnection conn = url.openConnection();
			
			br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
			
			String line = "";
			while( (line = br.readLine()) != null ) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ( br!=null ) try { br.close(); } catch ( IOException e ) {}
		}
		
	}
}