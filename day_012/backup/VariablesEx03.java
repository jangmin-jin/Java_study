class Variables {
    String data1 = "data11";
    String data2 = "data2";
    
    void printVariables(){
        String data1 = "data12";             // 덮어씌어진다.
        String data3 = "data3";
        System.out.println(data1);           // data12
        // 같은 클래스에 있는 뇨속은 가져다 쓸 수 있다.
        System.out.println(data2);           // data2
        System.out.println(data3);           // data3
        // 자기참조 : 클래스에 선언된 녀석을 가져다 쓸 수 있다.
        System.out.println(this.data1);      // data11
        System.out.println("this : "+ this); // 주소값

        this.doFunc();
    }
    
    void doFunc(){
        System.out.println("doFunc() 호출");
    }
}

public class VariablesEx03 {
    public static void main(String[] args){
        
        Variables v1 = new Variables();

        v1.printVariables();
        System.out.println( "v1 : " + v1);
    }
}