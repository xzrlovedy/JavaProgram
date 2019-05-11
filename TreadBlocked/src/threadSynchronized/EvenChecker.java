package threadSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 消费者任务，在随后的示例中被复用
 * 其中一个任务产生偶数，其他任务消费这些数字
 * @author Administrator
 *
 */
public class EvenChecker implements Runnable {
	private IntGenerator generator;  //抽象类对象
	@SuppressWarnings("unused")
	private final int id;
	/**
	 * 消费者任务构造
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
				generator.cancel();//退出while循环
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
