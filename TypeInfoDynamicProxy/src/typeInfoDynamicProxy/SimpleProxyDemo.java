package typeInfoDynamicProxy;
/**
 * ��̬����Ϊ���ṩ����Ĳ�����ͬ�Ĳ�������������������桰ʵ�ʡ�����Ķ���
 * @author Administrator
 *
 */
interface Interface{
	void doSomething();
	void doSomethingElse(String arg);
}
/**
 * ʵ�ʶ���
 * @author Administrator
 *
 */
class RealObject implements Interface{
	@Override
	public void doSomething() {
		System.out.println("doSomething!");
	}
	@Override
	public void doSomethingElse(String arg) {
		System.out.println("doSomethingElse "+arg);
	}
}
/**
 * �������
 * @author Administrator
 *
 */
class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething!");
		proxied.doSomething();
	}
	@Override
	public void doSomethingElse(String arg) {
		System.out.println("SimpleProxy doSomethingElse "+arg);
		proxied.doSomethingElse(arg);
	}
}
public class SimpleProxyDemo {
	public static void consumer(Interface iface) { 
		iface.doSomething();
		iface.doSomethingElse("�������£�");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
