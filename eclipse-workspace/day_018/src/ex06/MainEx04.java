package ex06;

public class MainEx04 {

	public static void main(String[] args) {
		// 익명 Inner class
		InnerA ia = new InnerA() {
			
			@Override
			public void viewInner() {
				System.out.println( "viewInner( ) 호출" );
			}
		};
		
		ia.viewInner();
		
		//지역변수
		int y = 100;
		
		// 익명 Inner class (interface이용) ** 그래픽 배울때 씀
		InnerB ib = new InnerB() {
			
			@Override
			public void viewInner() {
				System.out.println( "viewInner( ) 호출" );
				System.out.println( y );
			}
		};
		
		ib.viewInner( );
	}
}