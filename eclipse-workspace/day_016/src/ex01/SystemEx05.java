package ex01;

public class SystemEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( System.getProperty( "os.name" ) );
		System.out.println( System.getProperty( "user.name" ) );
		System.out.println( System.getProperty( "user.home" ) );
		
		// SE-15라서 15. ~~ 로 나옴
		// 내가 설치한 jdk가 11버전이라 여기에 맞추려면 eclipse 에서 프로젝트 만들때 버전 설정 가능
		System.out.println( System.getProperty( "java.version" ) );
		
		String javaHome = System.getenv( "JAVA_HOME" );
		System.out.println( javaHome );
	}
}