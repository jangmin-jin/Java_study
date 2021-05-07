package ex06;

import ex06.Outer1.Inner;

public class MainEx01 {

	public static void main(String[] args) {
		Outer1 out = new Outer1( );
		// System.out.println( out.x1 ); // private라서 안불림
		System.out.println( out.x2 );    // 100
		
		// Inner 선언 방법
		Outer1.Inner oi = out.new Inner();
		// System.out.println( oi.y1 ); // private라서 안불림
		System.out.println( oi.y2 );    // 200
		oi.viewInner(); 					 // method 도 호출가능
	}
}