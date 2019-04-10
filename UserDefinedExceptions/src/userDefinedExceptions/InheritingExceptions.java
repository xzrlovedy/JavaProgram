package userDefinedExceptions;

/**
 * 自定义异常必须从已有的异常类继承
 * @author Administrator
 *
 */
class SimpleException extends Exception{
	private static final long serialVersionUID = 1L;
}
/**
 * 抛出自定义异常方式
 * @author Administrator
 *
 */
public class InheritingExceptions{
	public void f() throws SimpleException{
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	public static void main(String[] args) {
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.f();
		}catch(SimpleException s){
			System.out.println("Caught it!");
		}
	}
}
