package collectionDeep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ìî³äÈÝÆ÷
 * @author Administrator
 *
 */
class StringAddress{
	private String s;
	public StringAddress(String s) {
		this.s = s;
	}
	public String toString() {
		return super.toString()+" "+s;
	}
}
public class FillingLists {
	public static void main(String[] args) {
		List<StringAddress> list = new ArrayList<StringAddress>(
			Collections.nCopies(4, new StringAddress("hello")));
		System.out.println(list);
		Collections.fill(list, new StringAddress("world"));
		System.out.println(list);
	}
}
