package ex02;

public class StringEx03 {

	// Run As - Run Configration - Arguments 들어가서 설정하면 args를 뽑아낼수 있다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( args.length );
		for( String arg : args) {
			System.out.println( arg );
		}
	}
}