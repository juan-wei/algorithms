import java.util.Arrays;
/**
 * @author ponyo
 * �й��������͵����ݲ���
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
	 * ��һ��byte�����ж�ȡһ��int��
	 * @param bts byte����
	 * @param start int������ʼ�洢λ��
	 * @param len byte�ĳ���
	 * @param isBE TRUE-���ģʽ��FALSE-С��ģʽ
	 * @return int��
	 */
	public static int byte2Int(byte[] bts, int start, int len, boolean isBE){
		int n = 0;
		for (int i = start, k=start+len%(Integer.SIZE/Byte.SIZE+1); i < k; i++) { // k:int���Ľ�βλ��
			n |= (bts[i]& 0xff) << ((isBE?(k-i-1):i)*Byte.SIZE); //"|="���ڽ������ֽ�����������
		}
		return n;
	}
	
	/**
	 * ���ڲ��������г��ִ�������һ�������ʱ�临�Ӷ�ΪO(n)
	 * @param a
	 */
	public static void findMostAppears(int[] a){
		int candidate = 0;	//���ڴ洢��ǰ��	
		int count = 0;		//���ڼ�����ֵ��ʾ��ǰcandidate�ظ��Ĵ���
		for (int i=0; i<a.length; i++) {
			if (count == 0) {
				candidate = a[i];
				count = 1;
			}else{
				if (candidate == a[i]) {		//���Ƚ�a[i-1]��a[i]�Ƿ����
					count++;
				}else{
					count--;
				}
			}
		}
		System.out.println(candidate);
	}

	/**
	 * �ҳ�������Ψһ���ظ�Ԫ�أ�ֻ�ظ�һ��
	 * Ҫ��ÿ������Ԫ��ֻ�ܷ���һ�Σ����ø����ռ�
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
	 * �ҳ�������Ψһ���ظ�Ԫ�أ�ֻ�ظ�һ��
	 * Ҫ����
	 * �㷨��ʹ�����a[]�е�n�����������1~N-1���Ľ������򣬽��Ϊ����
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
	 * ��Ŀ��һ����ά���飬ÿ�ж����մ����ҵ�����˳�����У�ÿ�ж����մ��ϵ��µ�����˳�����С������������Ƿ���ڸ���������
	 * �㷨��1. ѡȡ���Ͻǵ���������ǣ��������2.���>���޳������У�3. ���С�ڣ��޳������У�
	 * @param  a ��ά����
	 * @param num Ҫ���ҵ���
	 * @return boolean �Ƿ��ҵ�
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
	 * ��Ŀ�����ַ������ַ���ȫ����
	 * @param str
	 *
	 */
	public static void permutation(String str){
		char[] chars = str.toCharArray();
		permutationByRecursion(chars, 0);
	} 
	
	/**
	 * ����취���ݹ�����ַ������ַ���ȫ����
	 * @param chars �ַ�����
	 * @param begin �����ַ��������ַ�λ��
	 *
	 */
	private static void permutationByRecursion(char[] chars, int begin){
		if(begin == chars.length){ //
			System.out.println(Arrays.toString(chars));
		}
		for(int i=begin; i<chars.length; i++){ // һ��ѭ�������ν�����֤����֤begin���ַ���ÿ���ַ�����
			swap(chars, begin, i);
			permutation(chars, begin+1);
			swap(chars, begin, i);
		}
	}

	private  static void permutaionByLoop(char[] chars){
		//================����====================
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
	 * ��ӡ��ά����
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
	 * ������˳ʱ����ת90��
	 * �㷨��������ֲ�layers=a.length/2;һ��һ�����λ��
	 * @param a 
	 */
	public static void rotate90(int[][] a){
		
		int n = a.length;
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer; //ÿ�����һ��λ��
			System.out.println("first="+first+",layer="+layer+",n="+n+",last="+last);
			
			for (int i = first; i < last; i++) { //��first��
				
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
	 * ��Ŀ�����������е�������
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