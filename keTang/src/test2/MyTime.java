package test2;

public class MyTime {

    private int hour; //时
    private int minute; //分
    private int second; //秒
    
    public MyTime(int hour,int minute,int second){  
       this.hour = hour;
       this.minute = minute;
       this.second = second;
    }

    public void diaplay(MyTime time){
        System.out.println(time.getHour()+":"+time.getMinute()+":"+time.getSecond());
    }    

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }

    public void addSecond(int sec){
        this.second = second + sec;
        //秒钟超出60，分钟加1。
        if(this.second>=60){
        	this.second-=60;
        	this.minute+=1;
        }
    }
    public void addMinute(int min){
        this.minute = minute + min;
      //分钟超出60，时钟加1。
        if(this.minute>=60){
        	this.minute-=60;
        	this.hour+=1;
        }
    }
    public void addHour(int hou){
        this.hour = hour + hou;
        //时钟超出24，归零。
        if(this.hour>=24){
        	this.hour=0;
        }
    }

    public void subSecond(int sec){
        this.second = second - sec;
        //秒钟小于0，秒钟加60，分钟减1。
        if(this.second<0){
        	this.second+=60;
        	this.minute-=1;
        }
    }
    public void subMinute(int min){
        this.minute = minute - min;
      //分钟小于0，分钟加60，时钟减1。
        if(this.second<0){
        	this.second+=60;
        	this.minute-=1;
        }
    }
    public void subHour(int hou){
        this.hour = hour - hou;
        //时钟小于0，时钟加24。
        if(this.hour<0){
        	this.hour+=24;
        }
    }

    public static void main(String[] args) {

        MyTime time = new MyTime(12,14,59);
        System.out.print("原时间：");
        time.diaplay(time);
        System.out.println("增加3:01:20");
        time.addHour(3);
        time.addMinute(1);
        time.addSecond(20);
        time.diaplay(time);
        System.out.println("减少2:02:02");
        time.subHour(2);
        time.subMinute(2);
        time.subSecond(2);
        time.diaplay(time);
    }

}
