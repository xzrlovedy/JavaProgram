package test;

public class SubCar extends Car {
	int price;
	int speed;
	public void speedChange(int newSpeed){
		System.out.println(mark+"车的价格是"+price);
		System.out.println(mark+"车原来的速度是"+speed);
		speed = newSpeed;
		System.out.println("本车正在驾驶");
		System.out.println(mark+"车现在的速度是"+speed);
	}
}
