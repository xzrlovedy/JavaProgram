package threadPool;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable是执行工作的独立任务，不返回任何值
 * 如果希望任务完成时返回一个值，可以实现Callable接口，重写call()方法
 * @author Administrator
 *
 */
class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult "+id;
	}
}
public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i=0;i<10;i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs:results) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally {
				exec.shutdown();
			}
		}
	}
}
