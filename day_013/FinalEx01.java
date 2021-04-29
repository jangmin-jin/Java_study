class Parent1 {
    // doFunc_1() in Child1 cannot override doFunc_1() in Parent1
    // final 메서드 오버라이딩 불가
    final void doFunc_1(){
        System.out.println("doFunc_1() 호출");
    }
}

final class Parent2 {

}

class Child1 extends Parent1{
    void doFunc_1(){
        System.out.println("Child1 doFunc_1() 호출");
    }
}

// final 클래스 상속불가
class Child2 extends Parent2{

}

public class FinalEx01{
    
    public static void main(String[] args){ 

        // final + 변수명 = 상수
        // final + 클래스명 = 상속불가 클래스
        // final + 메서드명 = 오버라이딩 불가
        Child1 c1 = new Child1();
        Child2 c2 = new Child2();
    }
}