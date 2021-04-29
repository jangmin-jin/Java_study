class Parent {

    String p = "parent";
    Parent(){
        System.out.println("Parent() : " + this);
    }
}

class Child extends Parent{

    String c = "child";
    Child(){
        System.out.println("Child() : " + this);
    }
}

class GrandChild extends Child{

    String gc = "Grand child";
    GrandChild(){
        System.out.println("GrandChild() : " + this);
    }
    
    void doFunc_1(){
        System.out.println("doFunc_1() : " + this);
    }
}

public class InheritanceEx03{
    public static void main(String[] args){
        
        GrandChild gc = new GrandChild();
        gc.doFunc_1();
    }
}