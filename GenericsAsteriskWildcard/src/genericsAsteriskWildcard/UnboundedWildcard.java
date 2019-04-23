package genericsAsteriskWildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * 无界通配符
 * @author Administrator
 *
 */
public class UnboundedWildcard {
	static List list1;
	static List<?> list2;
	static List<?extends Object> list3;
	static void assign1(List list) {
		list1 = list;
		list2 = list;
		//list3 = list;//警告 unchecked conversion
	}
	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;//没有警告
	}
	static void assign3(List<?extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;//没有警告
	}
	public static void main(String[] args) {
		assign1(new ArrayList());
		assign2(new ArrayList());
		//assign3(new ArrayList());//警告
		
		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
	}
}
