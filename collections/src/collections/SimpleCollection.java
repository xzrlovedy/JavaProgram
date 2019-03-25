package collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 简单的容器
 * @author Administrator
 *
 */
public class SimpleCollection {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			c.add(i);
		}
		for(Integer i:c) {
			System.out.print(i+" ");
		}
	}
}
