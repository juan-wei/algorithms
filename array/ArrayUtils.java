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
		// int[][] c = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
		// System.out.println(isExisted(c, 15));
		// findMostAppears(a);
		// findOnlyOneRepeat(b);
		// findOnlyOneRepeatByXOR(b); 

		String str = "abc";
		// permutation(str);

	}

	/**
	 * 从一个byte数组中读取一个int数
	 * @param bts byte数组
	 * @param start int数的起始存储位置
	 * @param len byte的长度
	 * @param isBE TRUE-大端模式，FALSE-小端模式
	 * @return int数
	 */
	public static int byte2Int(byte[] bts, int start, int len, boolean isBE){
		int n = 0;
		for (int i = start, k=start+len%(Integer.SIZE/Byte.SIZE+1); i < k; i++) { // k:int数的结尾位置
			n |= (bts[i]& 0xff) << ((isBE?(k-i-1):i)*Byte.SIZE); //"|="用于将各个字节连接起来，
		}
		return n;
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

	/**
	 * 题目：求字符串中字符的全排列
	 * @param str
	 *
	 */
	public static void permutation(String str){
		char[] chars = str.toCharArray();
		permutationByRecursion(chars, 0);
	} 
	
	/**
	 * 解决办法：递归求解字符串中字符的全排列
	 * @param chars 字符数组
	 * @param begin 与别的字符交换的字符位置
	 *
	 */
	private static void permutationByRecursion(char[] chars, int begin){
		if(begin == chars.length){ //
			System.out.println(Arrays.toString(chars));
		}
		for(int i=begin; i<chars.length; i++){ // 一次循环中两次交换保证，保证begin个字符与每个字符交换
			swap(chars, begin, i);
			permutation(chars, begin+1);
			swap(chars, begin, i);
		}
	}

	private  static void permutaionByLoop(char[] chars){
		//================排序====================
		Arrays.sort();
	}

	
	private static void reverse(char[] chars, int begin, int end){
		while(begin < end){
			swap(chars, begin++, end--);
		}
	}
	private static boolean nextPermutaiton(char[] a){
		if(a == null || a.length == 0)
			return false;
		int pEnd = a.length-1;
		int p = pEnd, q, pFind, pEnd;
		while(last > 0){
			q = p;
			p--;
			if(a[last] < a[tmp]){
				pFind = pEnd;
				while(a[pFind] < a[last]){
					pFind--;
				}
				swap(a, pFind, last);
				reverse(a, q, pEnd); 
			}
		}
	}

	/**
	 * 打印二维数组
	 * @param a
	 */
	public static void print2DArray(int[][] a){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 将数组顺时针旋转90度
	 * 算法：将数组分层layers=a.length/2;一层一层调换位置
	 * @param a 
	 */
	public static void rotate90(int[][] a){
		
		int n = a.length;
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer; //每层最后一个位置
			System.out.println("first="+first+",layer="+layer+",n="+n+",last="+last);
			
			for (int i = first; i < last; i++) { //第first层
				
				int offset = i-first;
				
				//save top
				int top = a[first][i];
				//left -> top
				a[first][i] = a[last-offset][first];
				//bottom -> left
				a[last-offset][first] = a[last][last-offset];
				//right -> bottom
				a[last][last-offset] = a[i][last];
				//top-right
				a[i][last] = top;
			}
			System.out.println("after rotate :"+first+" layer:");
			print2DArray(a);
		}
		System.out.println("==========================\nfinished!");
	}

	/**
	 * 题目：交换数组中的两个数
	 * @param chars
	 * @param m
	 * @param n
	 *
	 */
	public static void swap(char[] chars, int m, int n){
		char tmp = chars[m];
		chars[m] = chars[n];
		chars[n] = tmp;
	}
}