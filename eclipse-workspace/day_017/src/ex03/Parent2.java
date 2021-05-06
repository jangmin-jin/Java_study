package ex03;

public abstract class Parent2 {
	public Parent2( ) {
		// TODO Auto-generated constructor stub
		System.out.println( "Parent2( ) 호출" );
	}
	
	public void viewParent1( ) {
		System.out.println( "viewParent1( ) 호출");
	}
	
	// 반드시 오버라이딩이 되어야 사용 가능
	// abstract 클래스에서는 추상 메서드 선언 가능
	public abstract void viewParent2( );
}