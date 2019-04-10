package userDefinedExceptions;

/**
 * 无论异常是否发生 finally语句都会执行
 * 
 * @author Administrator
 *
 */
class MyException2 extends Exception {
	public MyException2() {
	}

	public MyException2(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;
}

public class FinallyWorks {
	static int count = 0;

	public static void main(String[] args) {
		while (true) {
			try {
				if (count++ == 0) {
					throw new MyException2("count is 0！");
				}
				System.out.println("No Exception");
			} catch (MyException2 m) {
				System.out.println("MyException2");
				m.printStackTrace(System.out);
			} finally {
				System.out.println("In finally clause");
				if (count == 2) {
					break;
				}
			}
		}
	}
}
