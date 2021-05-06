package ex03;

import java.util.Date;

public class TypeCastingEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Parent -> 여러개를 만들어서 배열에 담고 싶음
		Parent[ ] arr1 = new Parent[ 3 ];
		Parent p1 = new Parent( );
		Parent p2 = new Parent( );
		Parent p3 = new Parent( );
		String str = new String( "test" );
		arr1[ 0 ] = p1;
		arr1[ 1 ] = p2;
		// arr1[ 2 ] = str;  // 타입이 안맞음
		
		// 최상위 객체를 이용해서 여러 자료형으로 형변환을 자유롭게
		Object[ ] arr2 = new Object[3];
		arr2[ 0 ] = p1;
		arr2[ 1 ] = str;
		arr2[ 2 ] = new Date( );
	}
}