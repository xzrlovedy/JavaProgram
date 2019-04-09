package collectionQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
/**
 * 1�����ȼ�����������һ������Ԫ��������Ҫ��Ԫ��
 * 2��PriorityQueue����ȷ���������peek(),poll()��remove()����ʱ��ȡԪ���Ƕ��������ȼ���ߵ�
 * 3��PriorityQueue���Ժ�Integer,String,Character�����������๤��
 * 4�������ظ�Ԫ�أ���С��ֵ��������ȼ���String�Ŀո����ȼ����
 * @author Administrator
 *
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		//****************Integer*******************
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextInt(i + 10));
		}
		QueueDemo.printQ(priorityQueue);
		
		List<Integer> ints = Arrays.asList(25, 
				22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
		
		priorityQueue = new PriorityQueue<Integer>(
				ints.size(),Collections.reverseOrder());//���������Comparator
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		//****************String*******************
		String fact = "EDUCATTON SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		QueueDemo.printQ(stringPQ);
		
		stringPQ = new PriorityQueue<String>(
				strings.size(),Collections.reverseOrder());//���������Comparator
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);
		//*****************Character******************
		Set<Character> charSet = new HashSet<Character>();
		for(char c : fact.toCharArray()) {
			charSet.add(c);
		}
		PriorityQueue<Character> characterPQ = 
				new PriorityQueue<Character>(charSet);
		QueueDemo.printQ(characterPQ);
	}
}
