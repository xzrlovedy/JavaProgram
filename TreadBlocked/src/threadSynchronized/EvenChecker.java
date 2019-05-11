package threadSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ����������������ʾ���б�����
 * ����һ���������ż������������������Щ����
 * @author Administrator
 *
 */
public class EvenChecker implements Runnable {
	private IntGenerator generator;  //���������
	@SuppressWarnings("unused")
	private final int id;
	/**
	 * ������������
	 * @param g 
	 * @param ident 
	 */
	public EvenChecker(IntGenerator g, int ident) {
		generator = g;
		id = ident;
		System.out.println("1");
	}
	
	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel();//�˳�whileѭ��
			}
		}
	}

	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(gp, i));
		}
		exec.shutdown();
	}

	public static void test(IntGenerator gp) {
		test(gp, 10);
		System.out.println("3");
	}
}
