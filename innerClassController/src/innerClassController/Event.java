package innerClassController;
/**
 * 抽象事件类
 * 描述基于时间的执行控制
 * @author Administrator
 *
 */
public abstract class Event {
	private long eventTime;//触发事件时间
	protected final long delayTime;//延迟时间
	//构造器
	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}
	//start获取当前时间加上延迟时间，生成触发事件时间
	public void start() {
		eventTime = System.nanoTime()+delayTime;
	}
	public boolean ready() {
		return System.nanoTime()>=eventTime;
	}
	//不同的Event有不同的action
	public abstract void action();
}
