package genericsAsteriskWildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * �޽�ͨ���
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
		//list3 = list;//���� unchecked conversion
	}
	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;//û�о���
	}
	static void assign3(List<?extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;//û�о���
	}
	public static void main(String[] args) {
		assign1(new ArrayList());
		assign2(new ArrayList());
		//assign3(new ArrayList());//����
		
		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
	}
}
