package ex02;

public class WrapperEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer i1 = Integer.valueOf( 10 );
		
		// auto boxing 객체 상자에 담음
		Integer i2 = 20;
		
		// auto unboxing 바로 객체 풀음
		int i11 = i1;
		int i12 = i2;
		
		int sum = i1 + i2;
		System.out.println( sum );
	}
}
