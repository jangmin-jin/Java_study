class Constructor{

    String data1;
    String data2;

    // Constructor 선언
    // Constructor Overloading
    Constructor(){

        this.data1 = "값1";
        this.data2 = "값2";
    }

    Constructor(String data1, String data2){

        this.data1 = data1;
        this.data2 = data2;
    }
}

public class ConstructorEx02{
    public static void main(String[] args){

        Constructor c;
        c = new Constructor("박문수", "홍길동");
        System.out.println(c.data1);
        System.out.println(c.data2);

        // 디폴트로 선언할 수 없음(값을 넣어줘야함)
        // 디폴트로만 가능한 Constructor가 실행됨
        Constructor c1 = new Constructor();
        System.out.println(c1.data1);
        System.out.println(c1.data2);

        Constructor c2 = new Constructor("장선우", "장자인");
        System.out.println(c2.data1);
        System.out.println(c2.data2);
    }
}