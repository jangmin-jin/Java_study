public class TypeCastingEx02 {
    public static void main(String[] args){
        // 수동형변환
        int i1 = 10;
        // short s1 = i1; 그냥 쓰면 에러
        short s1 = (short)i1;
        System.out.println( i1 );       // 10

        double d1 = 10.0f;
        float f1 = (float)d1;
        float f2 = (float)10.0;
        System.out.println( f1 );       // 10.0
        System.out.println( f2 );       // 10.0

        // ASKII에서 문자로 가져온다.
        int i2 = 'A';
        char c1 = (char)i2;
        System.out.println( i2 );       // 65
        System.out.println( c1 );       // A
        System.out.println( (char)65 ); // A
    }
}