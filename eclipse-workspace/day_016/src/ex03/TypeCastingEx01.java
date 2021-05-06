package ex03;

public class TypeCastingEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child1 c1 = new Child1( )	;
		
		// 자동 형변환 (자식 - > 부모)
		// Parent p1 = c1;
		// Parent p2 = new Child1( );
		
		// (최상위 부모 -> 부모 / 자식)
		// Object o1 = new Parent( );
		// Object o2 = new Child1( );
		
		c1.doFunc1( );		// 부모
		c1.doFunc2( );		// 자식
		
		// 자식 -> 부모의 경우 부모껀 출력 가능한데 자식 전용꺼는 출력 불가
		Parent p1 = c1;
		p1.doFunc1( );		//
		p1.doFunc2( );		// 자식
		// p1.doFunc3( );		// 호출 못함
		
		// 강제 형변환
		// 큰거에서 작은거로 변환 하니까 (변환 자료형)(변환변수)
		Child1 c2 = ( Child1 )( p1 );
		c2.doFunc1( );
		c2.doFunc2( );
		c2.doFunc3( );
		
		// 이렇게 선언하면 안됨 - **런타임 에러 발생
		// 자식 -> 부모 -> 자식은 가능
		// 부모 -> 자식은 불가능
		Child1 c3 = ( Child1 )( new Parent( ) );
		c2.doFunc1( );
		c2.doFunc2( );
		c2.doFunc3( );
	}
}