package javaArithmetic;
/**
 * ̰���㷨���ֳ�̰���㷨(Greedy Algorithm)����ָ�ڶ��������ʱ�����������ڵ�ǰ��������õ�ѡ��
 * Ҳ����˵�������������Ž���������ǣ����������Ľ�����ĳ�������ϵľֲ����Ž⡣
 * ̰���㷨��һ�ַֽ׶εĹ�������ÿһ���׶Σ�������Ϊ������������õģ��������ǽ����ĺ����
 * ���֡������ܹ��õ��ľ��á��Ĳ����������㷨���Ƶ���Դ��
 * 
 * ���ԣ�
 * 1. ������ѧģ�����������⡣
 * 2. ����������ֳ����ɸ������⡣
 * 3. ��ÿһ��������⣬�õ�������ľֲ����Ž⡣
 * 4. ��������Ľ�ֲ����Ž�ϳ�ԭ���������һ���⡣
 * @author Administrator
 *
 */
public class GreedyArithmetic {
	/**
	 * ֽ����������
	 * @param money
	 */
	public static void greedyGiveMoney(int money) {
        System.out.println("��Ҫ����: " + money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money/ moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if (num > 0) {
                System.out.println("��Ҫ" + num + "��" + moneyLevel[i] + "���");
            }
        }
    }
	/**
	 *����һ����������150kg
	 *��һ�����������кܶ���Ʒ����Ʒ�������ͼ�ֵ�ֱ�Ϊ��
	 *	25kg--20
	 *	30kg--40
	 *	60kg--45
	 *	35kg--50
	 *	20kg--10
	 *	50kg--45
	 *	40kg--50
	 */
	public static void Backpack(int capacity){
		int[] weights = new int[] { 25, 30, 60, 35, 20, 50, 40 };// ��Ʒ����
		int[] values = new int[] { 20, 40, 45, 50, 10, 45, 50 };// ��Ʒ��ֵ
		//int capacity = 150;//��������
		
		//������Ʒ��������Ʒ��ֵ�����ÿ����Ʒ���Լ۱ȣ������Լ۱Ƚ�������
		//ѡȡ�Լ۱���ߵ���Ʒ��ӵ������У���ֱ���������������
		int size = weights.length;//��Ʒ����
		double[] prices = new double[size];// ÿ����Ʒ���Լ۱�(ÿkg�ļ�ֵ)
		
		//��һ�����鱣���������Լ۱Ⱥ��ʼ����Ʒ�������±�
		int[] tags = new int[size];
		for (int i = 0; i < size; i++) {
		prices[i] = (double) values[i] /weights[i] ;
		tags[i] = i;//Ĭ������
		}
		// ѡ������ --���Լ۱�
		for (int i = 0; i < size; i++) { 
			for (int j = i+1; j < size; j++) { 
				if (prices[i] < prices[j]) { // ����
					double temp = prices[i]; 
					prices[i] = prices[j]; 
					prices[j] = temp; 
					
					int tag = tags[i]; 
					tags[i] = tags[j]; 
					tags[j] = tag; 
				} 
			} 
		}
		// �����Ѿ��Ӵ�С�ź�����Լ۱ȣ������Ӧ�������ͼ�ֵ����ӵ�������
		for (int i = 0; i < size; i++) {
			// ����tags�������������±꣬�õ�����
			if (weights[tags[i]] < capacity) {
				System.out.println("�����Ʒ" + weights[tags[i]]);
				capacity = capacity - weights[tags[i]];
			}
		}
	}
	public static void main(String[] args) {
		//ֽ��-����������
		greedyGiveMoney(367);
		System.out.println("#################################");
		//����-���뱳����С
		Backpack(220);
	}
}
