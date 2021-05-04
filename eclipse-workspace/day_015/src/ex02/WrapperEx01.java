package ex02;

public class WrapperEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Wrap/per 감싸준다 - 기본자료형 객체형 자료로 변경하는 것
		// 각 자료형의 최대 최소값
		// 형변환 ( 문자열 <-> 기본자료형 )
		/*
		 boolean    - Boolean
		 char 		   - Character
		 byte		   - Byte
		 short		   - Short
		 int		   - Integer
		 lon 		   - Long
		 float		   - float
		 double	   - Double
		 */
		
		System.out.println( Integer.MAX_VALUE );		//  2147483647
		System.out.println( Integer.MIN_VALUE );		// -2147483648
		System.out.println( Integer.SIZE );				// 자료형의 크기
		
		System.out.println( Double.MAX_VALUE );		// 암튼 높은수
		System.out.println( Double.MIN_VALUE );		// -암튼 높은수
		System.out.println( Double.SIZE );				// 64
	}
}
