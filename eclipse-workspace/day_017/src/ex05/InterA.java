package ex05;

// 상속(X), implement(O)
public interface InterA {
	// 상수
	public static final String STR1 = "홍길동";
	// 추상 메서드
	public abstract void methodA( );
	
	// public static final이 자동생략됨
	String str2 = "박문수";
	// public void methodB( ) {};  // 에러남
	// public abstract이 자동생략됨
	void methodB( );
}