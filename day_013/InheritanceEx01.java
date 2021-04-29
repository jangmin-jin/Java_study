class Parent {

    String p = "parent";
}

class Child extends Parent{

    String c = "child";
}

public class InheritanceEx01{
    public static void main(String[] args){
        
        Parent p = new Parent();
        System.out.println(p.p);

        Child c = new Child();
        System.out.println(c.c);
        // 상속되어서 부모에 있는 것도 선언이 가능하다
        System.out.println(c.p);
    }
}