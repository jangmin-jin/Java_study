package ex04;

public class ThreadEx01 {

	public static void main(String[] args) {
		
		// 스레드 우선순위 결정하기
		
		// 1 <= priority <= 10
		System.out.println( Thread.currentThread().getPriority() );
	
		// 숫자
		// 상수 Thread.MAX_PRIORITY
		// 상수 Thread.NORM_PRIORITY
		// 상수 Thread.MIn_PRIORITY
		
		// 우선순위를 최상으로 변경
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		System.out.println( Thread.currentThread().getPriority() );
	}
}