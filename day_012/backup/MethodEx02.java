class Method {
    // **오버로딩 (Overloading : 중복정의)
    // 같은 이름의 메서드를 선언할 수 있다.
    // 파라메터의 종류 / 갯수 / 순서가 다른경우 다른 메서드 취급한다.
    void doFunc(){
        System.out.println("doFunc()");
    }

    void doFunc(int data){
        System.out.println("doFunc(int data)");
    }

    void doFunc(String data){
        System.out.println("doFunc(String data)");
    }
    
    void doFunc(String data1, int data2){
        System.out.println("doFunc(String data1, int data2)");
    }

    void doFunc(int data1, int data2){
        System.out.println("doFunc(int data1, int data2)");
    }
}

public class MethodEx02 {
    public static void main(String[] args){
        Method m = new Method();
        m.doFunc();
        m.doFunc(10);
        m.doFunc("10");
        m.doFunc("10", 10);
        m.doFunc(10, 20);
    }
}