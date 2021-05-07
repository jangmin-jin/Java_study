package ex07;

public class ExceptionEx03 {
	public static void main(String[] args) {
		System.out.println( "시작" );
		String[] datas = { "1", "2", "3" };
		
		try {
			System.out.println( datas[0] );
			System.out.println( datas[3] );
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println( " 에러 : " + e.getMessage( ) );
		}
		
		System.out.println( "종료" );
	}
}