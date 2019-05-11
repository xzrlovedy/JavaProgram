package threadSynchronized;
/**
 * 定义一个抽象类
 * @author Administrator
 *
 */
public abstract class IntGenerator {
	private volatile boolean canceled = false;
	public abstract int next();
	public void cancel() {
		canceled = true;
	}
	public boolean isCanceled() {
		return canceled;
	}
}
