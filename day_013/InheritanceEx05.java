class Parent {
    // Parent(){
    //     System.out.println("Parent() : " + this);
    // }

    Parent(int data){
        System.out.println("parent() : " + this);
    }
}

class Child extends Parent{
    Child(){
        // 같은 디폴트가 아니여서 부모를 부를때 super를 쓴다
        super(10);
        System.out.println("Child() : " + this);
    }
}

public class InheritanceEx05{
    public static void main(String[] args){ 
        Child c = new Child();
    }
}