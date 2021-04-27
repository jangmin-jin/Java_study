public class ArrayEx01 {
    public static void main(String[] args){
        System.out.println( "시작" );

        /*
            배열의 선언
            
            데이터형[] 배열변수명;
            데이터형 배열변수명[];
        */

        int[] arr1;
        int arr2[];
        
        /*
            배열의 생성
            배열 변수명 = new 데이터형[갯수]
        */

        // 배열이 시작되는 주소 값을 할당한다
        arr1 = new int[3];

        // 선언과 동시에 초기화
        int[] arr3 = new int[4];
        int arr4[] = new int[5];

        System.out.println(arr1.length);
        System.out.println(arr3.length);
        System.out.println(arr4.length);

        // 요소별 값 추가
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
        
        // System.out.println(arr1[3]); 
        // runtime error : Index 3 out of bounds for length 3

        for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }

        System.out.println( "끝" );
    }
}