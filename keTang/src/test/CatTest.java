package test;

public class CatTest {
	public static void main(String[] args) {
		SubCar aodi = new SubCar();
		SubCar benchi = new SubCar();
		aodi.mark = "�µ�";
		aodi.price = 50;
		aodi.speed = 80;
		benchi.mark = "����";
		benchi.price = 100;
		benchi.speed = 90;
		aodi.drive();
		aodi.speedChange(120);
		System.out.println();
		benchi.drive();
		benchi.speedChange(120);
	}
}
