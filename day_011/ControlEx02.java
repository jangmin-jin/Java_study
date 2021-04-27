public class ControlEx02 {
    public static void main(String[] args){
        System.out.println( "시작" );

        int hakjum = 99;

        // 90점 이상이면 A
        // 80점 이상이면 B
        // 70점 이상이면 C
        // 60점 이상이면 D
        // 60점 미만이면 F
        if( hakjum >= 90 ){
            System.out.println( "A" );
        }else if( hakjum >= 80 ){
            System.out.println( "B" );
        }else if( hakjum >= 70 ){
            System.out.println( "C" );
        }else if( hakjum >= 60 ){
            System.out.println( "D" );
        }else{
            System.out.println( "F" );
        }

        System.out.println( "끝" );
    }
}