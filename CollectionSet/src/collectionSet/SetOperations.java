package collectionSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		Collections.addAll(set1,"A B C D E F G H I J K L".split(" "));
		set1.add("M");
		System.out.println("set1:"+set1);
		System.out.println("set1是否包含H:"+set1.contains("M"));
		System.out.println("set1是否包含N:"+set1.contains("N"));
		
		Set<String> set2 = new HashSet<String>();
		Collections.addAll(set2, "H I J K".split(" "));
		System.out.println("set2:"+set2);
		System.out.println("set1是否包含set2:"+set1.containsAll(set2));
		set1.remove("H");
		System.out.println("set1删除H后的元素："+set1);
		System.out.println("set1是否包含set2:"+set1.containsAll(set2));
		set1.removeAll(set2);
		System.out.println("set1删除包含set2的所有元素:"+set1);
		Collections.addAll(set1, "X Y Z".split(" "));
		System.out.println("set1假如XYZ:"+set1);
	}
}
