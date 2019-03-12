package searchforVampireFromInternet;
/**
 * 代码来自网络，略作修改并添加了注释
 * 该算法只需要执行3721次
 * @author Administrator
 *
 */
public class SearchforVampireFromInternet {
	public static void main(String[] args) {
		String[] targetNum = null;
	    String[] gunNum=null;   //目标数字和枪数字（即对比数字）
	    int sum = 0;   //吸血鬼数字的总个数
	    int count = 0;	//有效判断次数，那些乘积不是4位数的就排除了
	    for (int i = 10; i < 100; i++) {   
	        for (int j = i+1; j < 100; j++) {   //没有哪个两位数满足ab*ab=abab（不信可以编程验证），所以这里j从i+1开始就可以了
	            int i_target = i * j;   
	            if (i_target < 1000 || i_target > 9999) {   
	                continue; // 积不是4位数则跳过 
	                }
	            count++;
	            targetNum = String.valueOf(i_target).split("");  //将其转换为一个字符串数组
	            gunNum = (String.valueOf(i) + String.valueOf(j)).split("");   
	            java.util.Arrays.sort(targetNum);   //升序排列，因为只有排列了再比较才能保证不遗漏abcd=ba*dc这样的情况
	            java.util.Arrays.sort(gunNum);   
	            if (java.util.Arrays.equals(targetNum, gunNum)) {   
	                // 排序后比较,为真则找到一组   
	                sum++;   
	                System.out.println("第" + sum + "个: " +  i_target+"="+i + "*" + j);   
	            }   
	        }     
	        System.out.println("共进行了"+count+"次判断，找到" + sum + "个吸血鬼数字。");
	    }
	}
}
