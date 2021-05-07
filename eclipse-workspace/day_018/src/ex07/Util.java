package ex07;

// Library
public class Util {
	
	// 사실 라이브러리에서 익셉션 처리하는것도 웃김
	public void methodA(int num) {
		System.out.println( "시작" );
		try {
			if( num == 1) {
				System.out.println( num );
			}else {
				throw new Exception( "잘못된 입력입니다" );
			}
		}catch (Exception e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		}
		System.out.println( "종료" );
	}
	
	// 그래서 익셉션 처리를 위임시킴 ( 호출한 녀석이 처리해라 )
	public void methodB(int num) throws MyException {
		System.out.println( "시작" );

		if( num == 1) {
			System.out.println( num );
		}else {
			throw new MyException( "My잘못된 입력입니다" );
		}

		System.out.println( "종료" );
	}
}