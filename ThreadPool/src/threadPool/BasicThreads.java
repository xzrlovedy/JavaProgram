package threadPool;
/**
 * ��Runnable����ת��Ϊ��������Ĵ�ͳ��ʽ�ǰ����ύ��һ��Thread������
 * @author Administrator
 *
 */
public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		for(int i=0;i<5;i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff...");
	}
}
