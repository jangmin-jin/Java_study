package ex02;

public class StringBufferEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer( );
		StringBuffer sb2 = new StringBuffer( 100 );  // 저장 공간의 크기
		
		// StringBuffer sb3 = new StringBuffer( "Hello StringBuffer" );
		// 빌더가 Buffer 랑 기능적으로 완전 동일하고, 속도도 빨라서 많이 쓴다.
		 StringBuilder sb3 = new StringBuilder( "Hello StringBuffer" );
		
		System.out.println( sb1.capacity( ) );  // 16 : default 값
		System.out.println( sb2.capacity( ) );  // 100 : 지정값
		System.out.println( sb3.capacity( ) );  // 34 : 입력한 문자열 길이 + 16(default)
		
		System.out.println( sb1.length( ) );
		System.out.println( sb2.length( ) );
		System.out.println( sb3.length( ) );
		
		// String에도 다 포함된 기능들
		// charAt / substring
		// indexOf / lastIndexOf
		// resplaceAll -> replace
		
		// 내부 문자열 조작
		// append / insert / delete
		
		// 기존 상태
		System.out.println( sb3 );
		
		// 끝에 데이터 삽입
		sb3.append( " 안녕" );
		System.out.println( sb3 );
		
		// 3번째에 데이터 삽입
		sb3.insert( 3, " 추가" );
		System.out.println( sb3 );
		
		// 0부터 4번 전까지 지움
		sb3.delete( 0, 4 );
		System.out.println( sb3 );
	}
}