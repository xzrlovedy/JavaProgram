package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 添加一组元素
 * Arrays.asList();
 * Collections.addAll();
 * @author Administrator
 *
 */
public class AddGroups {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] moreInts = {6,7,8,9,10};
		boolean b = collection.addAll(Arrays.asList(moreInts));
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99);
		//list.add(21);	运行时异常java.lang.UnsupportedOperationException
		System.out.println(collection);
		System.out.println(b);
		System.out.println(list);
	}
}
