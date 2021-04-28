class Util{
    
    int doCalculator(int Number_1, char cal, int Number_2){
        int calResult = 0;
        if(cal == '+'){
            calResult = Number_1 + Number_2;
        }else if(cal == '-'){
            calResult = Number_1 - Number_2;
        }else if(cal == '*'){
            calResult = Number_1 * Number_2;
        }else if(cal == '/'){
            calResult = Number_1 / Number_2;
        }else if(cal == '%'){
            calResult = Number_1 % Number_2;
        }else{
            System.out.println("지원하지 않는 연산자 입니다.");
        }
        return calResult;
    }
}

public class MethodEx08{
    public static void main(String[] args){

        Util calUtil = new Util();
        int number_1 = 10;
        int number_2 = 3;
        char calFuncArr[] = {'+', '-', '*', '/', '%'};
        int calResult = 0;
        
        // calfuncArr[]를 이용하여 원하는 연산자 선택
        calResult = calUtil.doCalculator(number_1, calFuncArr[0], number_2);
        System.out.println(calResult);

        // for(char cal : calFuncArr){
        //     calResult = calUtil.doCalculator(number_1, cal, number_2);
        //     System.out.println(calResult);
        // };
    }
}