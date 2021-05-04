package ex02;

public class JuminCheckEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 주민번호를 담을 자료형 선언
		String juminString = "940227-1150324";
		String juminSplit[] = juminString.split("-");
		String juminStringNum = juminSplit[0] + juminSplit[1];
		String juminStringNumArr[] = juminStringNum.split("");
		int juminNumArr[] = new int[13];
		
		// 주민번호를 숫자형식으로 변환하여 자료형에 담기
		for( int i = 0; i < 13; i++) {
			juminNumArr[ i ] = Integer.parseInt(juminStringNumArr[ i ]);
		}
		
		// 주민번호 검사 로직 변수 선언
		int juminMulNum[] = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int checkValue = 0;
		int checkLogicNum = 11;
		
		// 주민번호 로직에 의해 검사
		for ( int i =0; i < 12; i++ ) {
			checkValue += juminNumArr[i] * juminMulNum[i] ;
		}
		int checkLogic = (checkLogicNum - (checkValue%checkLogicNum)) % 10;

		// 결과 출력
		if (checkLogic == juminNumArr[ 12 ]) {
			System.out.println( "맞습니다" );
		}else {
			System.out.println( "틀립니다" );
		}
	}
}
