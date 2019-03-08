package test2;

public class TestRole {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.SetName("ĞìÔóÈÙ");
		e.SetAge(22);
		e.SetSex("ÄĞ");
		e.setID("20162557");
		e.play();
		e.sing();
		System.out.println("***********");
		Manager m = new Manager();
		m.SetName("xzr");
		m.SetAge(20);
		m.SetSex("ÄĞ");
		m.setID("123456");
		m.setVehicle("»ú¶¯³µ");
		m.play();
		m.sing();
	}
}
