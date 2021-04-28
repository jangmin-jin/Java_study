public class ArrayEx01 {
    public static void main(String[] args){
        System.out.println( "시작" );

        int[][] arr1 = new int[][]{{10, 20}, {30, 40}, {50, 60}};

        for(int cols[] : arr1){
            for(int data : cols){
                System.out.println( data );
            }
        }

        System.out.println( "끝" );
    }
}