package ex06;

public class Outer2 {
	private int x1 = 1000;
	public int x2 = 1000;
	
	// 클래스(스태틱) 중첩 클래스
	static class Inner{
		private int y1 = 2000;
		public int y2 = 2000;
		
		public Inner( ) {
			System.out.println( "Inner : " + this );
		}
		
		public void viewInner() {
			// System.out.println( x1 );
			// System.out.println( x2 );
			System.out.println( y1 );
			System.out.println( y2 );
		}
	}
}