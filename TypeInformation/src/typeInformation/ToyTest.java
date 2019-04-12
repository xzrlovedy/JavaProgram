package typeInformation;
/**
 * forName()��ȡ��class��������õ�һ�ַ���
 * ��main�е���class.getInterfaces()�������ص���class����
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
			//���ݸ�forName()���ַ�������ʹ��ȫ�޶���(��������������)
			c = Class.forName("typeInformation.FancyToy");
		} catch (ClassNotFoundException e) {
			System.err.println("can't find FancyToy!");
			System.exit(1);
		}
		printInfo(c);
		//����class����
		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}
		//��ȡc�ĸ���
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
