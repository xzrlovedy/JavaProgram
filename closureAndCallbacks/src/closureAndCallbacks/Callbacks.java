package closureAndCallbacks;
/**
 * 内部类中的闭包和回调
 * @author Administrator
 *
 */
interface Incrementable{
	//增量
	void increment();
}
class MyIncrement{
	public void increment() {
		System.out.println("其他操作");
	}
	static void f(MyIncrement mi) {
		mi.increment();
	}
}
//==================================//
class Callee_1 implements Incrementable{
	private int i = 0;
	@Override
	public void increment() {
		i++;
		System.out.println(i);
	}
}
class Callee_2 extends MyIncrement{
	private int i = 0;
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	private class Closure implements Incrementable{
		public void increment() {
			Callee_2.this.increment();
		}
	}
	Incrementable getCallbackReference() {
		return new Closure();
	}
}
//==================================//
class Caller{
	private Incrementable callbackRenference;
	Caller(Incrementable cbh){
		callbackRenference = cbh;
	}
	void go() {
		callbackRenference.increment();
	}
}
//==================================//
public class Callbacks {
	public static void main(String[] args) {
		Callee_1 c1 = new Callee_1();
		Callee_2 c2 = new Callee_2();
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}
