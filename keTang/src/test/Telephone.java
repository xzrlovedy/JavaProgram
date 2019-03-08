package test;

public class Telephone {
	String tel;
	double money;
	public Telephone(){
		
	}
	public Telephone(double m){
	
	}
	public double telephoneCharge(int time){
		double m;//m为话费使用，time本次通话时间
		m=3+(time-3);
		money-=m;
		System.out.println("第一种方式计费："+money);
		return 0;
	}
	public double telephoneCharge(int time,double p){
		double m;//p为每分钟的话费
		m=p*time;
		money-=m;
		System.out.println("第二种方式计费："+money);
		return 0;
	}
}
