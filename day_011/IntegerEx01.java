public class IntegerEx01 {
    public static void main(String[] args){
        // 정수형 byte, short, int, long
        byte b = 1;
        short s = 1;
        int i = 1;
        // long l = 1;
        long l = 1L; // 소문자도 가능

        System.out.println( b );
        System.out.println( s );
        System.out.println( i );
        System.out.println( l );

        // 진수
        int i_2 = 0b1010;
        int i_8 = 030;
        int i_16 = 0xA4;

        System.out.println( i_2 );
        System.out.println( i_8 );
        System.out.println( i_16 );
    }
}