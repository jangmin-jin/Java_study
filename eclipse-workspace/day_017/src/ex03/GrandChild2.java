package ex03;

public class GrandChild2 extends Child2 {
	public GrandChild2( ) {
		// TODO Auto-generated constructor stub
		System.out.println( "GrandChild2( ) 호출" );
	}
	
	@Override
	public void viewParent2( ) {
		System.out.println( "viewParent2( ) 호출" );
	}
}