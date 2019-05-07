package treadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池限制一次性最高并行的线程的数量
 * @author Administrator
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		//限制为5个
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<6;i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
