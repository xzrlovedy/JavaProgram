package typeInformation;
/**
 * forName()是取得class对象的引用的一种方法
 * 在main中调用class.getInterfaces()方法返回的是class对象
 * @author Administrator
 *
 */
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
	Toy(){}
	Toy(int i){}
}
class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	FancyToy(){
		super(1);
	}
}
@SuppressWarnings("all")
public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name:"+cc.getName()+
				" is interface? ["+cc.isInterface()+"]");
		System.out.println("Simple name:"+cc.getSimpleName());
		System.out.println("Canonical name:"+cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			//传递给forName()的字符串必须使用全限定名(包含包名和类名)
			c = Class.forName("typeInformation.FancyToy");
		} catch (ClassNotFoundException e) {
			System.err.println("can't find FancyToy!");
			System.exit(1);
		}
		printInfo(c);
		//返回class对象
		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}
		//获取c的父类
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.err.println("can't instantiate!");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.err.println("can't access!");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}
