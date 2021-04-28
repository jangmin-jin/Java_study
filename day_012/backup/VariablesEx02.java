class Variables {
    // 초기화
    // 멤버 필드 / 클래스 멤버 필드 - 자동초기화
    // 객체 - null;
    // 기본 자료형 - 기본값;
    String instanceVariable;        // 기본값 : null
    int intVariable;                // 기본값 : 0
    static String classVariable;    // 기본값 : null
    
    // 지역변수는 자동 초기화가 안되서 에러뜸
    // VariablesEx02.java:11: error: variable localVariable might not have been initialized
    void printVariables(){
        String localVariable ="초기화 직접 해야함";
        System.out.println(localVariable);
    }
}

public class VariablesEx02 {
    public static void main(String[] args){
        
        Variables v1 = new Variables();

        System.out.println(v1.instanceVariable);
        System.out.println(v1.intVariable);
        v1.printVariables();
        System.out.println(Variables.classVariable);
    }
}