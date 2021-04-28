class Util {
    void doGugudan(int startDan, int endDan){
        for(int i = startDan; i <= endDan; i++){
            for(int j = 1; j < 10; j++){
                System.out.print(i + "X" + j + "=" + (i*j) + "\t");
            }
            System.out.println();
        }
    }
}

public class UtilEx01 {
    public static void main(String[] args){

        Util util = new Util();
        util.doGugudan(1, 3);
    
    }
}