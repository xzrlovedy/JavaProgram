package test;

public class Telephone {
	String tel;
	double money;
	public Telephone(){
		
	}
	public Telephone(double m){
	
	}
	public double telephoneCharge(int time){
		double m;//mΪ����ʹ�ã�time����ͨ��ʱ��
		m=3+(time-3);
		money-=m;
		System.out.println("��һ�ַ�ʽ�Ʒѣ�"+money);
		return 0;
	}
	public double telephoneCharge(int time,double p){
		double m;//pΪÿ���ӵĻ���
		m=p*time;
		money-=m;
		System.out.println("�ڶ��ַ�ʽ�Ʒѣ�"+money);
		return 0;
	}
}
