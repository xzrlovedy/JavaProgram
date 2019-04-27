package collectionDeep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Collection的功能方法
 * @author Administrator
 *
 */
public class CollectionMethods {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		String[] s = "a b c d e".split(" ");
		for(int i=0;i<s.length;i++) {
			c.add(s[i]);
		}
		c.add("ten");
		c.add("eleven");
		System.out.println(c);
		//object数组存放c
		Object[] array = c.toArray();
		//转换成String
		String[] str = c.toArray(new String[0]);
		System.out.println("Collections.max(c) = "+Collections.max(c));
		System.out.println("Collections.min(c) = "+Collections.min(c));
		
		Collection<String> c2 = new ArrayList<String>();
		for(int i=0;i<s.length;i++) {
			c2.add(s[i]);
		}
		c.addAll(c2);
		System.out.println(c);
		c.remove("a");
		System.out.println(c);
		c.remove("b");
		System.out.println(c);
		c.removeAll(c2);
		System.out.println(c);
	}
}
