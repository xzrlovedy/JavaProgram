package treadPool;
/*
 * 测试LiftOffd的run方法，此处不是多线程，只是普通的调用
 */
public class MainThread {
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
	}
}
