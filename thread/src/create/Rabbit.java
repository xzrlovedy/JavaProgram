package create;
/**
 * 模拟龟兔赛跑
 * 1、创建多线程  继承  Thread  +重写run(线程体)
 * 2、使用线程: 创建子类对象 + 对象.start()  线程启动
 * 
 * @author Administrator
 *
 */
public class Rabbit extends Thread {

	@Override
	public void run() {
		//线程体
		for(int i=0;i<50;i++){
			System.out.println("兔子跑了"+i+"步");
		}
	}
}
class Tortoise extends Thread {

	@Override
	public void run() {
		//线程体
		for(int i=0;i<50;i++){
			System.out.println("乌龟跑了"+i+"步");
		}
	}
}
