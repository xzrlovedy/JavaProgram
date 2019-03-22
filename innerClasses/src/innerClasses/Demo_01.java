package innerClasses;
/**
 * 普通内部类
 * @author Administrator
 *
 */
public class Demo_01 {
	//内部类01
	class Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}
	//内部类02
	class Destination{
		private String label;
		//构造器
		public Destination(String whereTo){
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
	}
	//外部类方法，使用两个内部类对象
	public void ship(String dest){
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}
	public static void main(String[] args) {
		Demo_01 demo = new Demo_01();
		demo.ship("我的世界");
		//在main方法通过.new使用内部类
		//Demo_01.Contents c = new Contents();错误
		//Contents c = new Contents();错误
		Contents c = demo.new Contents();
		System.out.println(c.value());
	}
}