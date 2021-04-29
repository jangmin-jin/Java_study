class Parent {

    String p = "parent";
}

class Child extends Parent{

    String c = "child";
}

class GrandChild extends Child{

    String gc = "Grand child";
}

public class InheritanceEx02{
    public static void main(String[] args){
        
        GrandChild gc = new GrandChild();
        System.out.println(gc.gc);
        System.out.println(gc.c);
        // Child 가 Parent와 연결되어 있어서 GrandChild 도 Parent랑 이어져있다
        System.out.println(gc.p);
    }
}