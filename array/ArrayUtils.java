import java.util.Arrays;
/**
 * @author ponyo
 * 有关数组类型的数据操作
 * 
 */
public class ArrayUtils{
	public static void main(String[] args){
		int[] a = {1,2,3,1,2,1,1,6,1,1};
		int[] b = {1,2,2,3,4};
		// findMostAppears(a);
		findOnlyOneRepeat(b);
		findOnlyOneRepeatByXOR(b);
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
}