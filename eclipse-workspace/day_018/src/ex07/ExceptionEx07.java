package ex07;

public class ExceptionEx07 {

	public static void main(String[] args) {
		System.out.println( "시작" );
		
		// Exception 처리가 감지되면 없는 녀석으로
		try {
			int num1 = 0;
			int num2 = 10;
			
			System.out.println( "1" );
			
			int result = num2 / num1;  // Exception

			System.out.println( "2" );
			
			System.out.println( "결과 : " +result );

		}catch (ArithmeticException e) {
			System.out.println( "3" + e.getMessage( ) );
		
		// 무조건 실행해라 : finally / 정리작업을 할때 주로 사용
		}finally {
			System.out.println( "4" );
		}

		System.out.println( "종료" );
	}
}