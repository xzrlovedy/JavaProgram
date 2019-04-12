package typeInformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied; // �������

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("������: " + proxy.getClass() 
			+ "\n" + "������: " + method + "\n" + "����: " + args);
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
 * �����ǻ��������ģʽ֮һ�����ô�����Ϊ���������ṩ����Ļ�ͬ�Ĳ�����
 * ����̬��������Ҫһ���������������Javaʵ��RTTIʱ��Ҫ����������������Ϣ��
 * �����Ϳ���֪����������Ϣ��
 * @author Administrator
 *
 */
public class DynamicProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
	}

	public static void main(String[] args) {
		RealObject realObject = new RealObject();
		// ʹ�ö�̬����
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(realObject));
		consumer(proxy);
	} 	
}
/*
 * ����� ������: class typeInformation.$Proxy0 
 * ������: public abstract void
 * typeInformation.Interface.doSomething() 
 * ����: null 
 * doSomething
 */
