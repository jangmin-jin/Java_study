package day_017_practice1;

public class TestContinue {

	public static void main(String[] args) {
		System.out.println("출력테스트");
		
		System.out.println("1 ~1000 까지 정수 중 3의 배수의 합은? ");
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if( i % 3 > 0 ) {
				continue;
			}
			sum += i;
		}
		System.out.println( sum );
	}
}