public class ConstantEx01 {
    public static void main(String[] args){
        // 기본 식별자(이름 규칙) - 에러
        // 변수
        // intnumber => intNumber
        int i_1 = 10;
        // 상수 : 대문자
        // intnumber => Int_Number
        final int I_2 = 20;

        System.out.println( i_1 );
        System.out.println( 20 );

        i_1 = 20;
        // I_2 = 20; 에러남
    }
}