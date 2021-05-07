package ex06;

public class MainEx02 {

	public static void main(String[] args) {
		Outer2 out = new Outer2( );
		System.out.println( out.x2 );
		
		Outer2.Inner oi = new Outer2.Inner( );
		System.out.println( oi.y2 );
		
		oi.viewInner( );
	}
}