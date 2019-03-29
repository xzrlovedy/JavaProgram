package create;

public class RabbitDemo {
	public static void main(String[] args) {
		//创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor =new Tortoise();
		
		//调用start 方法
		rab.start(); //不要调用run方法,调用run方法就和普通调用没区别了
		//rab.run();
		tor.start();
		//tor.run();
		
		for(int i=0;i<50;i++){
			System.out.println("main==>"+i);
		}
	}
}
