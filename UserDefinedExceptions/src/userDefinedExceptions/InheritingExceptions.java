package userDefinedExceptions;

/**
 * �Զ����쳣��������е��쳣��̳�
 * @author Administrator
 *
 */
class SimpleException extends Exception{
	private static final long serialVersionUID = 1L;
}
/**
 * �׳��Զ����쳣��ʽ
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
