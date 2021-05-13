package ex01;

public class JuminCheck {
	public String jumincheck (String jumin) {
		String result ="";
		// -가 있는지 없는지 검사해야함
		jumin = jumin.replaceAll("-", "");
		String juminStrArr[] = jumin.split("");
		int juminIntArr[] = new int[13];
		int lastJuminNum = Integer.parseInt(jumin.substring(12,13));
		
		int checkMulNum[] = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int checkValue = 0;
		
		if(juminStrArr.length != 13) {
			result = "주민번호 길이가 맞지 않습니다.";
			return result;
		}
		
		for(int i = 0; i < juminStrArr.length-1; i++) {
			juminIntArr[i] = Integer.parseInt(juminStrArr[i]) * checkMulNum[i] ;
			checkValue += juminIntArr[i];
		}
		
		int checkLogic = ( 11 -( checkValue%11 ) ) % 10;
		
		if(checkLogic == lastJuminNum) {
			result = "맞습니다.";
			return result;
		}else {
			result = "틀렸습니다.";
			return result;
		}
	}
}