class Method{
    
    String instanceVariable = "instance";
    static String staticVariable = "static";

    void dofunc_1(){
        System.out.println("doFunc_1()");
        
        System.out.println(this.instanceVariable);
        System.out.println(Method.staticVariable);
    }
    
    static void dofunc_2(){
        System.out.println("doFunc_2()");

        // non-static variable this cannot be referenced from a static context
        // System.out.println(this.instanceVariable); 
        System.out.println(Method.staticVariable);
    }
}
public class MethodEx06{
    public static void main(String[] args){
        
        Method.dofunc_2();
        
        Method m = new Method();
        m.dofunc_1();
    }
}