public class AlphabetEx01 {
    public static void main(String[] args){
        System.out.println( "시작" );
        /*
        알파벳 트리만들기
        A
        AB
        ABC
        ....
        ABCDEFGHIJ
        */ 
        for(int i=0; i<10; i++){
            for(int j=0; j<=i; j++){
                System.out.print((char)('A' + j));
            }
            System.out.print("\n");
        }

        System.out.println( "끝" );
    }
}