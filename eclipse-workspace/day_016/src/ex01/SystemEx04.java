package ex01;

public class SystemEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print( "Hello" );
		System.out.println( " World" );
		
		// lineSeparator ( 엔터키 ); / 운영체제마다 \n이 달라서 저렇게 확실히 분리해줌
		System.out.print( "Hello" + System.lineSeparator( ) );
		System.out.println( " World" );

		System.out.print( "Hello" + "\n" );
		System.out.println( " World" );
	}
}