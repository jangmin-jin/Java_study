public class ArrayEx02 {
    public static void main(String[] args){
        System.out.println( "시작" );

        // 선언, 생성, 초기화를 한번에
        int arr1[] = new int[]{10, 20, 30, 40};
        int arr2[] = {100, 200, 300, 400};

        for(int i = 0; i<arr1.length; i++){
            System.out.println( arr1[i] );
        }

        // 향상된 for문
        for(int data2 : arr2){
            System.out.println(data2);
        }

        String arr3[] = {"1000", "2000", "3000", "4000"};

        for(String data3 : arr3){
            System.out.println(data3);
        }

        System.out.println( "끝" );
    }
}