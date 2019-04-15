package typeInfoDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理
 * @author Administrator
 *
 */
class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	//代理传进来的对象
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("### proxy: "+proxy.getClass() +", method: "+method+", args: "+args);
		if(args!=null) {
			for(Object arg:args) {
				System.out.println(" "+arg);
			}
		}
		return method.invoke(proxied, args);
	}
}
public class SimpleDynamicProxy {
	public static void consumer(Interface iface) { 
		iface.doSomething();
		iface.doSomethingElse("做其他事！");
	}
	public static void main(String[] args) {
		RealObject real= new RealObject();
		consumer(real);
		System.out.println("*************************");
		Interface proxy = (Interface)Proxy.newProxyInstance(
				Interface.class.getClassLoader(), 
				new Class[] {Interface.class}, 
				new DynamicProxyHandler(real));
		consumer(proxy);
	}
}
