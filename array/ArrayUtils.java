import java.util.Arrays;
/**
 * @author ponyo
 * 有关数组类型的数据操作
 * 
 */
public class ArrayUtils{
	public static void main(String[] args){
		// int[] a = {1,2,3,1,2,1,1,6,1,1};
		// int[] b = {1,2,2,3,4};
		int[][] c = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(isExisted(c, 15));
		// findMostAppears(a);
		// findOnlyOneRepeat(b);
		// findOnlyOneRepeatByXOR(b); 
	}

	/**
	 * 用于查找数组中出现次数超过一半的数，时间复杂度为O(n)
	 * @param a
	 */
	public static void findMostAppears(int[] a){
		int candidate = 0;	//用于存储当前数	
		int count = 0;		//用于记数，值表示当前candidate重复的次数
		for (int i=0; i<a.length; i++) {
			if (count == 0) {
				candidate = a[i];
				count = 1;
			}else{
				if (candidate == a[i]) {		//即比较a[i-1]与a[i]是否相等
					count++;
				}else{
					count--;
				}
			}
		}
		System.out.println(candidate);
	}

	/**
	 * 找出数组中唯一的重复元素，只重复一次
	 * 要求：每个数组元素只能访问一次；不用辅助空间
	 * @param a 
	 */
	public static void findOnlyOneRepeat(int[] a){
		int sum1 = 0;
		int sum2 = 0;
		for (int i=0; i<a.length-1; i++) {
			sum1 += (i+1);
			sum2 += a[i];
		}
		sum2 += a[a.length-1];
		System.out.println((sum2 - sum1));
	}

	/**
	 * 找出数组中唯一的重复元素，只重复一次
	 * 要求：无
	 * 算法：使用异或。a[]中的n个数异或结果与1~N-1异或的结果再异或，结果为所求；
	 * @param a 
	 */
	public static void findOnlyOneRepeatByXOR(int[] a){
		int result = 0;
		for (int i=0; i<a.length; i++) {
			result ^= a[i];
		}
		for (int i=1; i<a.length; i++) {
			result ^= i;
		}
		System.out.println(result);
	}

	/**
	 * 题目：一个二维数组，每行都按照从左到右递增的顺序排列，每列都按照从上到下递增的顺序排列。查找数组中是否存在给定的数；
	 * 算法：1. 选取右上角的数，如果是，则结束；2.如果>，剔除所在列；3. 如果小于，剔除所在行；
	 * @param  a 二维数组
	 * @param num 要查找的数
	 * @return boolean 是否找到
	 */
	public static boolean isExisted(int[][] a, int num){
		boolean isFind = false;
		int rows = a.length;
		int columns = a[0].length;
		if (a != null && rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0){
				if (a[row][column] == num) {
					isFind = true;
					break;
				}else if (a[row][column] > num) {
					column--;
				}else{
					row++;
				}
			} 
		}
		return isFind;
	}
}