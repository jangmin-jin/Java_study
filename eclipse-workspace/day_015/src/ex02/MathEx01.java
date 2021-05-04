package ex02;

public class MathEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Math - 수학관련( static ) / 인스턴스화를 안함
		// 올림
		System.out.println( Math.ceil( 10.3 ) );
		System.out.println( Math.ceil( 10.5 ) );
		System.out.println( Math.ceil( 10.7 ) );
		// 내림
		System.out.println( Math.floor( 10.3 ) );
		System.out.println( Math.floor( 10.5 ) );
		System.out.println( Math.floor( 10.7 ) );
		// 반올림
		System.out.println( Math.round( 10.3 ) );
		System.out.println( Math.round( 10.5 ) );
		System.out.println( Math.round( 10.7 ) );
		
		// 지수
		System.out.println( Math.pow( 10.0, 2.0 ) );  // 10.0 ^2
		System.out.println( Math.pow( 10., 2. ) );  // 10 ^2
	}
}