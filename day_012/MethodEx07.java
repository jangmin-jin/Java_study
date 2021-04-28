public class MethodEx07{
    
    // 멤버 필드(변수)
    String instanceVariable = "instance";
    static String staticVariable = "static";

    void doFunc_1(){
        System.out.println("doFunc_1()");
    }
    
    static void doFunc_2(){
        System.out.println("doFunc_1()");
    }

    public static void main(String[] args){

        MethodEx07 m = new MethodEx07();

        // 인스턴스화를 시켜줘도 this로는 쓸수 없음
        // System.out.println(this.instanceVariable);
        System.out.println(m.instanceVariable);
        System.out.println(MethodEx07.staticVariable);

        // m을 통해서 호출해야함
        m.doFunc_1();
        // static이라서 class를 통해서 호출해야함
        MethodEx07.doFunc_2();
    }
}