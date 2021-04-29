class Modifier{
    // 멤버필드의 데이터는 private
    private String data1 = "private";

    // 메서드는 public으로 선언 하는것이 적절
    // 메서드 - 제어문
    // 멤버필드 접근 메서드 : getter / setter
    // getter : get멤버변수명 (대문자로 시작)
    // setter : set멤버변수명 (대문자로 시작)
    public void setData1(String data1){ 
        this.data1 = data1; 
    }

    public String getData1(){
        return data1;
    }
}
public class ModifierEx02{
    public static void main(String[] args){
        
        Modifier m = new Modifier();
        // data1 set
        m.setData1("데이터1");
        // data1 get
        System.out.println(m.getData1());
    }
}