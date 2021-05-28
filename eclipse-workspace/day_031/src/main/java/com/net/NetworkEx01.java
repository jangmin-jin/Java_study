package com.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx01 {

	public static void main(String[] args) {
		
		try {
			// 인터넷 어드레스
			InetAddress inetAddress = InetAddress.getByName("www.daum.net");
			
			// daum에서 사용하는 host이름과 주소값
			System.out.println( inetAddress.getHostName() );
			System.out.println( inetAddress.getHostAddress() );
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}