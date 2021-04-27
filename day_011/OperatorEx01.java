public class OperatorEx01 {
    public static void main(String[] args){
        /*
            피연산자 연산자 피연산자 => 결과

            갯수
            단항연산자 : 부호, ++/--
            이항연산자
                산술연산자 : +, -, *, % 등
                대입연산자 : = 등
                비교연산자 : >, <, <=, >= 등
                논리연산자 : &&, ||, &, | 등
            삼항연산자 : ? :

            산술연산자 = 피연산자(최소 기준이 int)
        */
        int i1 = 10;
        int i2 = 20;
        int sum1 = i1 + i2;
        System.out.println( sum1 );

        short s1 = 10;
        short s2 = 20;
        // 산술연산자가 들어가면 int로 자동형변환이 일어난다.
        // short sum2 = s1 + s2; 자료형이 맞지 않아 오류 발생
        // 자료형을 int로 변환
        int sum2 = s1 + s2;
        // 혹은 short로 형변환 시킨다
        short sum3 = (short)(s1 + s2);
        System.out.println( sum2 );
        System.out.println( sum3 );

        int i3 = 10;
        int i4 = 3;
        // 소수점 생략
        System.out.println( i3/i4 );            // 몫 3
        System.out.println( i3%i4 );            // 나머지 1
        System.out.println( i3 / (double)i4 );  // 3.3333333333333335
    }
}