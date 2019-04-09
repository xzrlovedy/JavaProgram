package collectionQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 队列是典型的先进先出（FIFO）的容器
 * 队列常用作一种可靠的将对象从程序的某个区域传输到另一个区域的途径
 * LinkedList提供了方法以支持队列的行为，可以作为队列的一种实现
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void printQ(Queue<?> queue) {
		//peek()方法返回队头，在队头为空时返回null
		while(queue.peek()!=null) {
			//remove()移除并返回队头
			System.out.print(queue.remove()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for(int i= 0;i<10;i++) {
			//offer()方法在允许的情况下，将一个元素插入队尾，或返回false
			queue.offer(rand.nextInt(i+10));
		}
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "Brontosaurus".toCharArray()) {
			qc.offer(c);
		}
		printQ(qc);
	}
}
