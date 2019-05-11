package threadSynchronized;

public class SynchronizedEvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;
	@Override
	public synchronized int next() {
		++currentEvenValue;
		//被插入两个递增操作之间提高在currentEvenValue是奇数时的上下文切换的可能性
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args) {
		EvenChecker.test(new SynchronizedEvenGenerator());
	}
}
