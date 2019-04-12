package typeInformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied; // 代理对象

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理类: " + proxy.getClass() 
			+ "\n" + "代理方法: " + method + "\n" + "参数: " + args);
		if (args != null)
			for (Object arg : args)
				System.out.println(" " + arg);
		return method.invoke(proxied, args);
	}
}

interface Interface {
	void doSomething();
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

}
/**
 * 代理是基本的设计模式之一，即用代理类为被代理类提供额外的或不同的操作。
 * 而动态代理则需要一个类加载器，就像Java实现RTTI时需要类加载器加载类的信息，
 * 这样就可以知道类的相关信息。
 * @author Administrator
 *
 */
public class DynamicProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
	}

	public static void main(String[] args) {
		RealObject realObject = new RealObject();
		// 使用动态代理
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(realObject));
		consumer(proxy);
	} 	
}
/*
 * 输出： 代理类: class typeInformation.$Proxy0 
 * 代理方法: public abstract void
 * typeInformation.Interface.doSomething() 
 * 参数: null 
 * doSomething
 */
