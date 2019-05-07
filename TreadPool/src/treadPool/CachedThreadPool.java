package treadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 单个Executor被用来创建和管理系统中的所有的任务
 * @author Administrator
 *
 */
public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
