package treadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�����һ������߲��е��̵߳�����
 * @author Administrator
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		//����Ϊ5��
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<6;i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
