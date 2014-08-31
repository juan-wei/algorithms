import java.util.Arrays;
/**
 * @author ponyo
 * �й��������͵����ݲ���
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
}