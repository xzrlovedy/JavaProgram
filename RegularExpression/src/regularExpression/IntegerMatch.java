package regularExpression;
/**
 * ���String�ַ����Ƿ���������ʽƥ��
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
