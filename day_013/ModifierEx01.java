class Modifier{
    // 접근지정자
    // 아무나 접근 가능
    public String data1 = "public";
    // 같은 패키지 내부에서 접근 가능
    protected String data2 = "protected";
    // 아무나 접근 가능
    String data3 = "defailt";
    // 같은 클래스에서만 접근 가능
    private String data4 = "private";

    // 데이터 캡슐화하면 private도 접근가능
    void viewData(){
        System.out.println(this.data1);
        System.out.println(this.data2);
        System.out.println(this.data3);
        System.out.println(this.data4);
    }

    public void doFunc_1(){ System.out.println("doFunc_1() 호출"); }
    protected void doFunc_2(){ System.out.println("doFunc_2() 호출"); }
    void doFunc_3(){ System.out.println("doFunc_3() 호출"); }
    private void doFunc_4(){ System.out.println("doFunc_4() 호출"); }
}
public class ModifierEx01{
    public static void main(String[] args){
        Modifier m = new Modifier();
        System.out.println(m.data1);
        System.out.println(m.data2);
        System.out.println(m.data3);
        // System.out.println(m.data4);
        
        m.viewData();

        m.doFunc_1();
        m.doFunc_2();
        m.doFunc_3();
        // 접근 불가
        // m.doFunc_4();
    }
}