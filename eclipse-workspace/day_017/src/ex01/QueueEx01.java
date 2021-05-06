package ex01;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx01 {

	public static void main(String[] args) {
		// queue는 LinkedList로 선언 한다 **
		Queue<String> queue = new LinkedList<String>( );
		
		// 데이터 삽입
		queue.offer( "홍길동" );
		queue.offer( "박문수" );
		queue.offer( "이몽룡" );
		
		System.out.println( queue.toString( ) );
		
		// 데이터 삭제 poll
		// System.out.println( queue.poll( ) );
		System.out.println( queue.toString( ) );
		
		// 전체 데이터 뽑기
		while( !queue.isEmpty( ) ) {
			System.out.println( queue.poll( ) );
		}
	}
}