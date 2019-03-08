package test2;

public class Test {
	public static void main(String[] args) {
		Man m=new Man();
		m.name = "Jack";
		m.age = 20;
		m.sex = "男";
		m.show();
		m.man();
		System.out.println("*********************");
		Human h=new Woman();//上转型对象
		h.name = "Lucy";
		h.age = 21;
		h.show();//只有Human类的属性和方法
	}
}
