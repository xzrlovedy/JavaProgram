package threadProducersAndConsumers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 多线程解决生产者消费者问题 
 * 厨师代表生产者，服务员代表消费者
 * 
 * @author Administrator
 *
 */
class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable {
	private ThreadProducersAndConsumers tpc;

	public WaitPerson(ThreadProducersAndConsumers tpc) {
		this.tpc = tpc;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (tpc.meal == null) {
						wait();
					}
				}
				System.out.println("Waitperson got " + tpc.meal);
				synchronized (tpc.chef) {
					tpc.meal = null;
					tpc.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable {
	private ThreadProducersAndConsumers tpc;
	private int count = 0;

	public Chef(ThreadProducersAndConsumers tpc) {
		this.tpc = tpc;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (tpc.meal != null) {
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("out of food,closing!");
					tpc.exec.shutdownNow();
				}
				System.out.println("order up!");
				synchronized (tpc.waitPerson) {
					tpc.meal = new Meal(count);
					tpc.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}

public class ThreadProducersAndConsumers {
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public ThreadProducersAndConsumers() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new ThreadProducersAndConsumers();
	}
}
