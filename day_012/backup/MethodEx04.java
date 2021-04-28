class Method {
    // 인스턴스 메서드 / 클래스 메서드
    void doFunc_1(){
        System.out.println("doFunc_1() 호출");
    }

    static void doFunc_2(){
        System.out.println("doFunc_2() 호출");
    }    
}

public class MethodEx04 {
    public static void main(String[] args){

        Method m = new Method();
        m.doFunc_1();
        m.doFunc_2();

        Method.doFunc_2();   // 인스턴스 화를 거치지 않고 호출 가능
    
    }
}