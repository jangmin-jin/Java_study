package ex02;

import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r1 = new Random( );
		// 현재 시간은 계속 변하기 때문에 이렇게하면 중복값이 줄어듬
		Random r2 = new Random( System.currentTimeMillis( ) );
		
		// 자료형별로 추출 가능
		System.out.println( r2.nextInt( ) );
		System.out.println( r2.nextDouble( ) );  // double를 기준으로 한다.
		System.out.println( r2.nextLong( ) );
		
		// 0 <= x <10
		System.out.println( r2.nextInt( 10 ) );
		
		// 로또 번호 1 <= x <46
		System.out.println( r2.nextInt(45) + 1 );
	}
}