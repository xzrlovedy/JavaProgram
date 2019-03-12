package bubbleSort;
/**
 * 自定义冒泡排序工具类
 * @author XZR
 *
 */
public class Utils {
	
	/**
	 * int类型数组的排序 （升序）
	 * @param arr
	 */
	public static void sort(int[] arr){
		//从大到小排序 降序
		boolean sorted= true;
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //趟数
			sorted =true; //假定有序
			for(int i=0;i<len-1-j;i++){ //次数
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
					sorted =false; //假定失败
				}
			}
			if(sorted){ //减少趟数
				break;
			}
		}
	}
	
	/**
	 * 字符串类型数组的排序 （按长度升序）
	 * @param arr
	 */
	public static void sort(String[] arr){
		//从大到小排序 降序
		boolean sorted= true;
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //趟数
			sorted =true; //假定有序
			for(int i=0;i<len-1-j;i++){ //次数
				if((arr[i]).length()>(arr[i+1]).length()){
					String temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
					sorted =false; //假定失败
				}
			}
			if(sorted){ //减少趟数
				break;
			}
		}
	}
	
	/**
	 * char类型数组的排序 （升序）
	 * @param arr
	 */
	public static void sort(char[] arr){
		//从大到小排序 降序
		boolean sorted= true;
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //趟数
			sorted =true; //假定有序
			for(int i=0;i<len-1-j;i++){ //次数
				if(arr[i]>arr[i+1]){
					char temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
					sorted =false; //假定失败
				}
			}
			if(sorted){ //减少趟数
				break;
			}
		}
	}
}
