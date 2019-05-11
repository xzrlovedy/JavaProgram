package threadSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显式的locked对象
 * Locked对象必须被显式地创建、锁定和释放。因此，它与内建的锁形势相比，代码缺乏优雅性
 * @author Administrator
 *
 */
public class MutexEvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();
	
	@Override	
	/*
	 * 使用lock()和unlock()方法在next()内部创建了临界资源。
	 * return语句必须在try子句中出现，以确保unlock()不会过早发生，从而将数据暴露给第二个任务
	 * @see threadSynchronized.IntGenerator#next()
	 */
	public int next() {
		lock.lock();//锁定
		try {
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		}finally {
			lock.unlock();//释放锁
		}
	}
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
}
