package collectionSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Set不保存重复元素
 * 重复元素被移除
 * @author Administrator
 *
 */
public class SetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);
		
		Set<Integer> intSet = new HashSet<Integer>();
		Set<Integer> intSet2 = new LinkedHashSet<Integer>();
		SortedSet<Integer> intSet3 = new TreeSet<Integer>();
		
		for(int i = 0;i<10;i++) {
			//取10次随机数，每次随机数范围0-39
			intSet.add(rand.nextInt(40));
			intSet2.add(rand.nextInt(40));
			intSet3.add(rand.nextInt(40));
		}
		//查看随机数容器Set有多少个随机数
		System.out.println("HashSet:"+intSet);
		System.out.println("LinkedHashSet:"+intSet2);
		System.out.println("TreeSet:"+intSet3);
		System.out.println("**************************************************");
		for(int i = 0;i<10000;i++) {
			//再取10000次随机数，每次随机数范围0-39
			intSet.add(rand.nextInt(40));
			intSet2.add(rand.nextInt(40));
			intSet3.add(rand.nextInt(40));
		}
		//查看随机数容器Set有多少个随机数
		System.out.println("HashSet:"+intSet);
		System.out.println("LinkedHashSet:"+intSet2);
		System.out.println("TreeSet:"+intSet3);
	}
}
