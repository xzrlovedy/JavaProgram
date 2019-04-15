package typeInfoDynamicProxy;
/**
 * 静态代理，为了提供额外的操作或不同的操作，而插入的用来代替“实际”对象的对象
 * @author Administrator
 *
 */
interface Interface{
	void doSomething();
	void doSomethingElse(String arg);
}
/**
 * 实际对象
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
 * 代理对象
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
		iface.doSomethingElse("做其他事！");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
