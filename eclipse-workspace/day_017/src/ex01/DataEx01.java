package ex01;

import java.util.ArrayList;

public class DataEx01 {

	public static void main(String[] args) {
		ArrayList<String> data1 = new ArrayList<String>( );
		data1.add("1");
		data1.add("홍길동");
		data1.add("010-1111-1111");
		data1.add("20");
		data1.add("서울시");
		
		ArrayList<String> data2 = new ArrayList<String>( );
		data2.add("2");
		data2.add("박문수");
		data2.add("010-1111-2222");
		data2.add("30");
		data2.add("경기도");
		
		ArrayList<String> data3 = new ArrayList<String>( );
		data3.add("3");
		data3.add("이몽룡");
		data3.add("010-1111-3333");
		data3.add("30");
		data3.add("인천");
		
		// 이차원 배열
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>( );
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);
		
		// 이중 for문을 이용한 출력
		for( int i = 0; i<datas.size( ); i++) {
			ArrayList<String> data = datas.get( i );
			for( int j = 0; j<data.size( ); j++) {
				System.out.print( data.get( j ) + "\t" );
			}
			System.out.println( );
		}
		
		// 향상된 이중 for문을 이용한 출력
		for( ArrayList<String> str : datas ) {
			for ( String str2 : str) {
				System.out.print( str2 + "\t" );
			}
			System.out.println( );
		}
	}
}