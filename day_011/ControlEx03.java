public class ControlEx03 {
    public static void main(String[] args){
        System.out.println( "시작" );
            
            // switch - byte, short, int, char / String(추가됨)
            int data = 10;
            switch( data ){
                case 10:
                    System.out.println( "10" );
                    break;
                case 20:
                    System.out.println( "20" );
                    break;
                case 30:
                    System.out.println( "30" );
                    break;
                default:
                    System.out.println( "기타" );
            }

            String data2 = "30";
            switch( data2 ){
                case "10":
                    System.out.println( "10" );
                    break;
                case "20":
                    System.out.println( "20" );
                    break;
                case "30":
                    System.out.println( "30" );
                    break;
                default:
                    System.out.println( "기타" );
            }

        System.out.println( "끝" );
    }
}