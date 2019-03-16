package que;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行存款业务
 * 
 * @author XZR
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		//队列泛型存储
		Queue<Request> que = new ArrayDeque<Request>();
		// 模拟排队情况,匿名内部类
		for (int i = 0; i < 10; i++) {
			final int num = i;
			que.offer(new Request() {

				@Override
				public void deposit() {
					System.out.println("第" + num + "个人，办理存款业务，存款额度为:" + (Math.random() * 10000));
				}

			});
		}

		dealWith(que);
	}

	// 处理业务
	public static void dealWith(Queue<Request> que) {
		Request req = null;
		while (null != (req = que.poll())) {
			req.deposit();
		}
	}

}

interface Request {
	// 存款
	void deposit();
}