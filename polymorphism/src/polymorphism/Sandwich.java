package polymorphism;
/**
 * 构造器和多态
 * 深入理解初始化顺序
 * @author XZR
 *
 */
public class Sandwich extends PortableLunch{
	private Bread b = new Bread();
	private Meal m = new Meal();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	
	public Sandwich() {System.out.println("三明治便携式膳食午餐");}
	
	public static void main(String[] args) {
		new Sandwich();
	}
}

class Meal{
	Meal(){System.out.println("膳食");}
}
class Bread{
	Bread(){System.out.println("面包");}
}
class Cheese{
	Cheese(){System.out.println("奶酪");}
}
class Lettuce{
	Lettuce(){System.out.println("生菜");}
}
class Lunch extends Meal{
	Lunch(){System.out.println("膳食午餐");}
}
class PortableLunch extends Lunch{
	PortableLunch(){System.out.println("便携式膳食午餐");}
}