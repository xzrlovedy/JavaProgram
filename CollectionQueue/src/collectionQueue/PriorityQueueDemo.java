package collectionQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
/**
 * 1、优先级队列声明下一个弹出元素是最需要的元素
 * 2、PriorityQueue可以确保当你调用peek(),poll()和remove()方法时获取元素是队列中优先级最高的
 * 3、PriorityQueue可以和Integer,String,Character这样的内置类工作
 * 4、允许重复元素，最小的值有最高优先级，String的空格优先级最高
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
				ints.size(),Collections.reverseOrder());//产生反序的Comparator
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		//****************String*******************
		String fact = "EDUCATTON SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		QueueDemo.printQ(stringPQ);
		
		stringPQ = new PriorityQueue<String>(
				strings.size(),Collections.reverseOrder());//产生反序的Comparator
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
