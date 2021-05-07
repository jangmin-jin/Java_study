package ex07;

public class ExceptionEx06 {

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
		
		}catch (NullPointerException e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		// else 같은 느낌으로 다가 쓸수 있다.
		// 단, Exception은 마지막에 써야한다.
		}catch (Exception e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		}
		
		System.out.println( "종료" );
	}
}