package test2;

public class MyTime {

    private int hour; //ʱ
    private int minute; //��
    private int second; //��
    
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
        //���ӳ���60�����Ӽ�1��
        if(this.second>=60){
        	this.second-=60;
        	this.minute+=1;
        }
    }
    public void addMinute(int min){
        this.minute = minute + min;
      //���ӳ���60��ʱ�Ӽ�1��
        if(this.minute>=60){
        	this.minute-=60;
        	this.hour+=1;
        }
    }
    public void addHour(int hou){
        this.hour = hour + hou;
        //ʱ�ӳ���24�����㡣
        if(this.hour>=24){
        	this.hour=0;
        }
    }

    public void subSecond(int sec){
        this.second = second - sec;
        //����С��0�����Ӽ�60�����Ӽ�1��
        if(this.second<0){
        	this.second+=60;
        	this.minute-=1;
        }
    }
    public void subMinute(int min){
        this.minute = minute - min;
      //����С��0�����Ӽ�60��ʱ�Ӽ�1��
        if(this.second<0){
        	this.second+=60;
        	this.minute-=1;
        }
    }
    public void subHour(int hou){
        this.hour = hour - hou;
        //ʱ��С��0��ʱ�Ӽ�24��
        if(this.hour<0){
        	this.hour+=24;
        }
    }

    public static void main(String[] args) {

        MyTime time = new MyTime(12,14,59);
        System.out.print("ԭʱ�䣺");
        time.diaplay(time);
        System.out.println("����3:01:20");
        time.addHour(3);
        time.addMinute(1);
        time.addSecond(20);
        time.diaplay(time);
        System.out.println("����2:02:02");
        time.subHour(2);
        time.subMinute(2);
        time.subSecond(2);
        time.diaplay(time);
    }

}
