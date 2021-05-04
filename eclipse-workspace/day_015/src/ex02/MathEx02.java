package ex02;

public class MathEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Math - 수학관련( static ) / 인스턴스화를 안함
		// 0 <= Math.random( ) < 1 랜덤 변수 출력
		System.out.println( Math.random( ) );
		System.out.println( Math.random( ) );
		
		// 0 <= Math.random( ) < 10 정수만을 추출
		System.out.println( (int)(Math.random( ) * 10) );
		System.out.println( (int)(Math.random( ) * 10) );
		
		// 1 <= Math.random( ) < 45 정수만을 추출
		System.out.println( (int)(Math.random( ) * 45 + 1) );
		System.out.println( (int)(Math.random( ) * 45 + 1) );
	}
}
