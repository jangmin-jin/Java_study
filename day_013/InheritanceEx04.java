class Parent {
    String p = "parent";

    Parent(){
        System.out.println("Parent() : " + this);
    }

    void doFunc_1(){
        System.out.println("doFunc_1()");
    }
}

class Child extends Parent{
    String c = "child";

    Child(){
        System.out.println("Child() : " + this);
    }

    // 오버라이딩 (재정의)
    // 이름, 파라메터, 리턴이 같아야 오버라이딩이 성립된다.
    void doFunc_1(){
        System.out.println("Child doFunc_1()");
        
        // super = parent
        // 내일 학교에 느그 부모님 모셔와라.
        super.doFunc_1();
        System.out.println(super.p);
    }

    void doFunc_2(){
        System.out.println("doFunc_2()");
    }
}

public class InheritanceEx04{
    public static void main(String[] args){ 
        Child c = new Child();
        c.doFunc_2();
        c.doFunc_1();
    }
}