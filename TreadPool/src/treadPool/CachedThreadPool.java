package treadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�
 * ����Executor�����������͹���ϵͳ�е����е�����
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
