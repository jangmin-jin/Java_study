package ex07;

public class ExceptionEx04 {

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
		// Exception 처리 구역
		}catch (ArithmeticException e) {
			// Exception이 발생하면 JVM이 자동으로
			// e = new ArithmeticException(); 으로 인스턴스화 시켜줌
			System.out.println( "3" + e.getMessage( ) );
		}

		System.out.println( "종료" );
	}
}