package treadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池限制一次性最高并行的线程的数量
 * @author Administrator
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		//限制为5个
		ExecutorService exec = Executors.newFixedThreadPool(5);
		//若有六个线程，则：等待至少一个线程执行完后，再运行
		for(int i=0;i<6;i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
/*
 * #1(9) #2(9) #0(9) #3(9) #1(8) #2(8) #0(8) #3(8) #4(9) #1(7) 
 * #2(7) #0(7) #3(7) #4(8) #1(6) #2(6) #0(6) #1(5) #4(7) #3(6) 
 * #2(5) #1(4) #4(6) #0(5) #3(5) #2(4) #1(3) #4(5) #0(4) #3(4) 
 * #2(3) #1(2) #4(4) #0(3) #3(3) #2(2) #1(1) #4(3) #0(2) #3(2) 
 * #2(1) #1(LiftOff!) #0(1) #4(2) #3(1) #2(LiftOff!) #0(LiftOff!) 
 * #4(1) #5(9) #3(LiftOff!) #4(LiftOff!) 
 * #5(8) #5(7) #5(6) #5(5) #5(4) #5(3) #5(2) #5(1) #5(LiftOff!)
 */
