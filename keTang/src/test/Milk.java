package test;

public class Milk extends Goods {
	double vip;
	public void zheKou() {
		double p = 3;
		vip = 2.6f;
		p = p * 0.8;
		vip = vip * 0.8;
		System.out.println("�ǻ�Ա�ۿۣ�" + p);
		System.out.println("��Ա�ۿۣ�" + vip);
	}
}
