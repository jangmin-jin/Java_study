class Variables {
    // 멤버 변수의 종류
    // 인스턴스 멤버 변수
    // 클래스(스태틱) 멤버 변수

    // 저강 공간의 생성 시점 / 유효시간
    String instanceVariable;
    static String classVariable;
}

public class VariablesEx01 {
    public static void main(String[] args){
        
        Variables v1 = new Variables();
        v1.instanceVariable = "10";
        v1.classVariable = "10";

        System.out.println(v1.instanceVariable);     // 10
        System.out.println(v1.classVariable);        // 10

        // 값 변경시 클래스 명으로 접근할 것
        System.out.println(Variables.classVariable); // 10
        Variables.classVariable = "40";
        System.out.println(Variables.classVariable); // 40

        // static 변수의 부적절한 변경 방법
        System.out.println(v1.classVariable);
        v1.classVariable = "50";
        System.out.println(v1.classVariable);

    }
}