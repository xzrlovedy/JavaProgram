package foreachAndIterator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ��Foreach��ʽ��������
 * @author Administrator
 *
 */
public class ForeachCollection {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		Collections.addAll(list, "Take the long way home".split(" "));
		for(String s : list) {
			System.out.print("'"+s+"' ");
		}
	}
}
