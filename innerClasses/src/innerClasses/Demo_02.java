package innerClasses;
/**
 * 匿名内部类
 * 一个接口和一个抽象类
 * 主类用匿名内部类实现接口和抽象类
 * @author XZR
 *
 */
interface Contents{
	public default int value() {
		return 0;
	}
}
abstract class InnerClass{
	public String getName() {
		return null;
	}
	public int getAge() {
		return 0;
	}
}

public class Demo_02 {
	public Contents contents(final int i) {
		return new Contents() {
			public int value() {
				return i;
			}
		};
	}
	public InnerClass getInnerClass(final int age,final String name) {
		return new InnerClass() {
			int age_;
			String name_;
			{
				if(0<age&&age<200) {
					age_=age;
					name_=name;
				}
			}
			public String getName() {
				return name_;
			}
			public int getAge() {
				return age_;
			}
		};
	}
	public static void main(String[] args) {
		Demo_02 demo = new Demo_02();
		Contents c = demo.contents(1);
		System.out.println(c.value());
		InnerClass i = demo.getInnerClass(23, "XZR");
		System.out.println(i.getAge());
		System.out.println(i.getName());
	}
}
