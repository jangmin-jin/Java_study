package ex04;

public class Child2 extends Parent {
	// 정직원
	
	// 급여 계산용 메서드
	public void salary( ) {
		System.out.println( "salary( ) 호출" );
	}
	
	@Override
	public void sal( ) {
		System.out.println( "Child2 sal( ) 호출" );
	}
}