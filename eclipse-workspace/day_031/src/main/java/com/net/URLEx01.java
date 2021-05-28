package com.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEx01 {

	public static void main(String[] args) {
		
		try {
			// URL를 임포트하면 입력한 데이터가 구분되어 영역별로 저장된다.
			URL url = new URL("https://search.naver.com:8080/dir1/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=covid");
		
			// 데이터의 형태가 이상하면 exception이 발생한다.
			System.out.println(url.getProtocol()); // https
			System.out.println(url.getHost()); // search.naver.com
			System.out.println(url.getPort()); // 8080
		
			System.out.println(url.getPath()); // dir1/search.naver.com
			System.out.println(url.getQuery());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}