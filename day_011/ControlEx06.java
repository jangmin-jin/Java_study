public class ControlEx06 {
    public static void main(String[] args){
        System.out.println( "시작" );
        
        /*
        트리 만들기
        *
        **
        ***
        .....
        **********
        */
        for(int i=0; i<10; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.println( "끝" );
    }
}