package javaArithmetic;
/**
 * ú����Ŀ
 * ��һ��ú�򣬶ѳ�������׶�Ρ����壺
 * ��һ���1����
 * �ڶ���3�������г������Σ���
 * ������6�������г������Σ���
 * ���Ĳ�10�������г������Σ���
 * ....
 * ���һ����100�㣬���ж��ٸ�ú��
 * @author XZR
 *
 */
public class NumberOfCoal {
	public static void main(String[] args) {
		NumberOfCoal nc = new NumberOfCoal();
		System.out.println("��100���ܸ�����"+nc.calculate(100));
	}
	//����������������
	public int calculate(int tier){
		int sum = 0;//�ܸ���
		int j = 0;//i�ǲ�����j��ÿ��ĸ���
		for(int i = 1;i<=tier;i++){
			j += i;
			sum += j;
		}
		return sum;
	}
}
