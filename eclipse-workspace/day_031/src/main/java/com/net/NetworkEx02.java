package com.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx02 {

	public static void main(String[] args) {
		
		try {
			// 배열형태로 모든 인터넷 어드레스에 대한 정보를 볼 수있다.
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");
			InetAddress[] inetAddresses2 = InetAddress.getAllByName("www.daum.net");
			
			// 한개가 아닌 여러 주소를 사용하는 것을 알 수 있다.
			for(InetAddress inetAddress : inetAddresses) {
				System.out.println( inetAddress.getHostName() );
				System.out.println( inetAddress.getHostAddress() );
			}
			
			for(InetAddress inetAddress : inetAddresses2) {
				System.out.println( inetAddress.getHostName() );
				System.out.println( inetAddress.getHostAddress() );
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}