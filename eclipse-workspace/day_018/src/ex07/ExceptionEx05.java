package ex07;

public class ExceptionEx05 {

	public static void main(String[] args) {
		System.out.println( "시작" );
		
		String name = "";
		int num1 = 0;
		int num2 = 10;
		
		// 여러개 걸 수 있다.
		// 대신 하나라도 걸리면 바로 빠져나간다
		try {
			System.out.println( name.length( ) );
			System.out.println( num2 / num1 );
		/*
		}catch (NullPointerException e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		}catch (ArithmeticException e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		}
		*/
			
		// 한번에 다 잡아머금
		}catch (Exception e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		}
		
		System.out.println( "종료" );
	}
}