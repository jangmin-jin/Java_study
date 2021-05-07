package ex07;

public class ExceptionEx01 {

	public static void main(String[] args) {
		System.out.println( "시작" );
		
		int num1 = 0;
		int num2 = 10;
		
		int result = num2 / num1;  // Exception
		System.out.println( "결과 : " +result );
		
		System.out.println( "종료" );
	}
}