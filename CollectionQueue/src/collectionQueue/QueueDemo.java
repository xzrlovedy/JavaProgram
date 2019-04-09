package collectionQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * �����ǵ��͵��Ƚ��ȳ���FIFO��������
 * ���г�����һ�ֿɿ��Ľ�����ӳ����ĳ�������䵽��һ�������;��
 * LinkedList�ṩ�˷�����֧�ֶ��е���Ϊ��������Ϊ���е�һ��ʵ��
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void printQ(Queue<?> queue) {
		//peek()�������ض�ͷ���ڶ�ͷΪ��ʱ����null
		while(queue.peek()!=null) {
			//remove()�Ƴ������ض�ͷ
			System.out.print(queue.remove()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for(int i= 0;i<10;i++) {
			//offer()���������������£���һ��Ԫ�ز����β���򷵻�false
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
