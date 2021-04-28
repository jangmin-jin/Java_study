class Method {
    // 메서드 (ECMAScript에선 function) 선언 방식이 조금 다름
    void doFunc_1(){
        System.out.println("doFunc_1() 호출");
    }
    
    void doFunc_2(int data1){
        // int data1 - 지역변수
        System.out.println("doFunc_2() 호출 : " + data1);
    }

    void doFunc_3(int data1, int data2){
        System.out.println("doFunc_3() 호출 : " + data1);
        System.out.println("doFunc_3() 호출 : " + data2);
    }

    // void : 리턴이 없음을 나타내는 예약어
    // 리턴이 있을시 리턴하는 자료의 자료형 명시
    int doFunc_4(int data1, int data2){
        int sum = data1 + data2;
        return sum;
    }
}

public class MethodEx01 {
    public static void main(String[] args){

        // 선언부
        Method m = new Method();
        // 호출
        m.doFunc_1();
        m.doFunc_2(10);
        m.doFunc_3(20, 30);

    }
}