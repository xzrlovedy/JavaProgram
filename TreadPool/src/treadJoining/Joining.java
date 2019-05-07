package treadJoining;
/**
 * һ���߳̿����������߳�֮�ϵ���join()��������Ч���ǵȴ�һ��ʱ��ֱ���ڶ����߳̽������ܼ���ִ��
 * @author Administrator
 *
 */
class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name,int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName()+" was interrupted. "+"isInterrupted(): "+isInterrupted());
			return;
		}
		System.out.println(getName()+" has awakened");
	}
}
class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name,Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run() {
		try {
			//��Joiner�̵߳�run()��������sleeper.join()
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println(getName()+" join completed");
	}
}
public class Joining {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper("Sleeper",1500),
				grumpy = new Sleeper("Grumper",1500);
		Joiner
				dopey = new Joiner("Dopey",sleeper),
				doc = new Joiner("Doc",grumpy);
		grumpy.interrupt();
	}
}
