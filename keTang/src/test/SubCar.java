package test;

public class SubCar extends Car {
	int price;
	int speed;
	public void speedChange(int newSpeed){
		System.out.println(mark+"���ļ۸���"+price);
		System.out.println(mark+"��ԭ�����ٶ���"+speed);
		speed = newSpeed;
		System.out.println("�������ڼ�ʻ");
		System.out.println(mark+"�����ڵ��ٶ���"+speed);
	}
}
