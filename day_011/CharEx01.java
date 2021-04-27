public class CharEx01{
    public static void main(String[] args){
        // 문자형 : 두글자를 넣을 수 없다.
        // char c1 = 'ab'; -> 에러 발생
        char c1 = 'a';
        System.out.println( c1 );

        char c2 = '한';
        System.out.println( c2 );

        // 문자(열문자, 특수문자) 코드 - ASCII
        // 97=a, 98=b
        char c3 = 97 + 1;
        System.out.println( c3 );

        // 다국어 - 유니코드
        char c4 = '\uC790';
        System.out.println( c4 );

        // escape 코드
        // \t - tap,  \n - enter, \' - 단일따음표, \" - 쌍따음표
        System.out.print( "abc" );
        System.out.print( '\n' );
        System.out.print( "\tdef" );
    }
}