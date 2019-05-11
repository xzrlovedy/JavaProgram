package threadPool;
/**
 * 将Runnable对象转变为工作任务的传统方式是把它提交给一个Thread构造器
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
