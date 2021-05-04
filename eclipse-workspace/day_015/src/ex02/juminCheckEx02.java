package ex02;

public class juminCheckEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jumin = args[0].replaceAll("-", "");
		int checkMulNum[] = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int juminArr[] = new int[12];
		int lastjuminNum = Integer.parseInt(jumin.substring(12, 13));
		int checkValue = 0;
		
		for( int i = 0; i < 12; i++) {
			juminArr[i] = Integer.parseInt(jumin.substring(i, i+1)) * checkMulNum[i];
			checkValue += juminArr[i];
		}
		
		int checkLogic = ( 11 -( checkValue%11 ) ) % 10;
		
		if(checkLogic == lastjuminNum) {
			System.out.println( "맞다" );
		}else {
			System.out.println( "틀리다" );
		}
	}
}
