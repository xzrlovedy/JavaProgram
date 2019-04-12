package regularExpression;
/**
 * 检查String字符串是否与正则表达式匹配
 * @author Administrator
 *
 */
public class IntegerMatch {
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("1234".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+019".matches("(-|\\+)?\\d+"));
	}
}
