package test;

public class Test2 {
	public static void main(String[] args) {
		Telephone t1 = new Telephone();
		Telephone t2 = new Telephone();
		t1.money = 100;
		t2.money = 100;
		t1.telephoneCharge(20);
		t2.telephoneCharge(20, 1);
	}
}
