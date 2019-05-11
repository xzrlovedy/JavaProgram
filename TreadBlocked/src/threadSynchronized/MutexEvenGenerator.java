package threadSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ʹ����ʽ��locked����
 * Locked������뱻��ʽ�ش������������ͷš���ˣ������ڽ�����������ȣ�����ȱ��������
 * @author Administrator
 *
 */
public class MutexEvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();
	
	@Override	
	/*
	 * ʹ��lock()��unlock()������next()�ڲ��������ٽ���Դ��
	 * return��������try�Ӿ��г��֣���ȷ��unlock()������緢�����Ӷ������ݱ�¶���ڶ�������
	 * @see threadSynchronized.IntGenerator#next()
	 */
	public int next() {
		lock.lock();//����
		try {
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		}finally {
			lock.unlock();//�ͷ���
		}
	}
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
}
