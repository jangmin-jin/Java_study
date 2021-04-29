class Time{
    private int hour;       // 0 <= x <= 24;
    private int minute;     // 0 <= x <= 60;
    private int second;     // 0 <= x <= 60;

    // setter / getter
    public void setHour(int hour){
        if(hour < 0 || hour > 24) return;
        this.hour = hour;
    }
    public int getHour(){
        return hour;
    }

    public void setMinute(int minute){
        if(minute < 0 || minute > 60) return;
        this.minute = minute;
    }
    public int getMinute(){
        return minute;
    }

    public void setSecond(int second){
        if(second < 0 || second > 60) return;
        this.second = second;    
    }
    public int getSecond(){
        return second;
    }
}

public class TimeEx01{
    public static void main(String[] args){
        Time t = new Time();
        // if문에 걸려버리면 데이터 0으로 반환됨
        t.setHour(16);
        t.setMinute(29);
        t.setSecond(40);

        System.out.println(t.getHour() + "시" + t.getMinute() + "분" + t.getSecond() + "초");
    }
}