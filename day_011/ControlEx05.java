public class ControlEx05 {
    public static void main(String[] args){
        System.out.println( "시작" );
        
        // 1 ~ 100까지 3의 배수의 합
        int sum1 = 0;
        for(int i=1; i<=100; i++){
            if(i % 3 == 0){
                sum1 += i;
            }
        }
        System.out.println( sum1 );

        System.out.println( "끝" );
    }
}