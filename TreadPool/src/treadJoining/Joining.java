package treadJoining;
/**
 * 一个线程可以在其他线程之上调用join()方法，其效果是等待一段时间直到第二个线程结束才能继续执行
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
			//在Joiner线程的run()方法加入sleeper.join()
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
