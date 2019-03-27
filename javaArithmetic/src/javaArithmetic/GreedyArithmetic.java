package javaArithmetic;
/**
 * 贪心算法，又称贪婪算法(Greedy Algorithm)，是指在对问题求解时，总是做出在当前看来是最好的选择。
 * 也就是说，不从整体最优解出发来考虑，它所做出的仅是在某种意义上的局部最优解。
 * 贪婪算法是一种分阶段的工作，在每一个阶段，可以认为所做决定是最好的，而不考虑将来的后果。
 * 这种“眼下能够拿到的就拿”的策略是这类算法名称的来源。
 * 
 * 策略：
 * 1. 建立数学模型来描述问题。
 * 2. 把求解的问题分成若干个子问题。
 * 3. 对每一子问题求解，得到子问题的局部最优解。
 * 4. 把子问题的解局部最优解合成原来解问题的一个解。
 * @author Administrator
 *
 */
public class GreedyArithmetic {
	/**
	 * 纸币找零问题
	 * @param money
	 */
	public static void greedyGiveMoney(int money) {
        System.out.println("需要找零: " + money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money/ moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
    }
	/**
	 *现有一个背包容量150kg
	 *有一个宝藏里面有很多物品，物品的重量和价值分别为：
	 *	25kg--20
	 *	30kg--40
	 *	60kg--45
	 *	35kg--50
	 *	20kg--10
	 *	50kg--45
	 *	40kg--50
	 */
	public static void Backpack(int capacity){
		int[] weights = new int[] { 25, 30, 60, 35, 20, 50, 40 };// 物品重量
		int[] values = new int[] { 20, 40, 45, 50, 10, 45, 50 };// 物品价值
		//int capacity = 150;//背包容量
		
		//根据物品重量和物品价值，求出每个物品的性价比－》将性价比进行排序
		//选取性价比最高的物品添加到背包中－》直到背包不能再添加
		int size = weights.length;//物品数量
		double[] prices = new double[size];// 每个物品的性价比(每kg的价值)
		
		//用一个数组保存排序后的性价比和最开始的物品重量的下标
		int[] tags = new int[size];
		for (int i = 0; i < size; i++) {
		prices[i] = (double) values[i] /weights[i] ;
		tags[i] = i;//默认排序
		}
		// 选择排序 --按性价比
		for (int i = 0; i < size; i++) { 
			for (int j = i+1; j < size; j++) { 
				if (prices[i] < prices[j]) { // 交换
					double temp = prices[i]; 
					prices[i] = prices[j]; 
					prices[j] = temp; 
					
					int tag = tags[i]; 
					tags[i] = tags[j]; 
					tags[j] = tag; 
				} 
			} 
		}
		// 根据已经从大到小排好序的性价比，和相对应的重量和价值，添加到背包中
		for (int i = 0; i < size; i++) {
			// 根据tags数组中重量的下标，拿到重量
			if (weights[tags[i]] < capacity) {
				System.out.println("添加物品" + weights[tags[i]]);
				capacity = capacity - weights[tags[i]];
			}
		}
	}
	public static void main(String[] args) {
		//纸币-传入找零金额
		greedyGiveMoney(367);
		System.out.println("#################################");
		//背包-传入背包大小
		Backpack(220);
	}
}
