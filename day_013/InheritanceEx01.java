class Parent {

    String p = "parent";

    void viewParent(){
        System.out.println("viewParent() 호출");
    }
}

class Child extends Parent{

    String c = "child";
}

class Child2 extends Parent{

    String c2 = "child 2";
}

public class InheritanceEx01{
    public static void main(String[] args){
        
        Parent p = new Parent();
        System.out.println(p.p);

        Child c = new Child();
        System.out.println(c.c);
        // 상속되어서 부모에 있는 것도 선언이 가능하다
        System.out.println(c.p);
        
        Child2 c2 = new Child2();
        System.out.println(c2.c2);
        System.out.println(c2.p);

        p.viewParent();
        c.viewParent();
        c2.viewParent();
    }
}