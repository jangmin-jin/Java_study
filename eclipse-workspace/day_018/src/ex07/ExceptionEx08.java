package ex07;

public class ExceptionEx08 {

	public static void main(String[] args){
		
		Util u = new Util( );
		u.methodA(1);
		u.methodA(0);
		
		// throws Exception 을 이런식으로 받아서 처리
		try {
			u.methodB(0);
		} catch (MyException e) {
			System.out.println( "에러 : " +e.getMessage( ) );
		}
	}
}