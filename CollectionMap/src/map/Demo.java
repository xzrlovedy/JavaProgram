package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Map容器的分拣思路
 * 获取字段单词出现个数和次数
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		String str = "this is s cat";
		//创建map对象
		Map<String,Letter> letters = new HashMap<String,Letter>();
		String[] strArray = str.split(" ");
		for(String temp:strArray) {
			//为所有的key创建容器
			if(!letters.containsKey(temp)) {
				letters.put(temp, new Letter());
			}
		}
		//容器中存放对应的value
		for(String temp:strArray) {
			Letter col = letters.get(temp);
			col.setCount(col.getCount()+1);
		}
		//输出map的值
		Set<String> keys= letters.keySet();
		for(String key:keys) {
			Letter col = letters.get(key);
			System.out.println(""+key+" 出现次数:"+col.getCount());
		}
	}
}
