public class ControlEx04 {
    public static void main(String[] args){
        System.out.println( "시작" );
        
        // 행
        for(int i=1; i<=5; i++){
            //System.out.println( i ); 세로출력
            //System.out.print( i );   가로출력
            
            //열
            for(int j=1; j<=5; j+=2){
                System.out.println( i + " : " + j);
            }
        }

        System.out.println( "끝" );
    }
}