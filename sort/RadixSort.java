import java.util.Arrays;
public class RadixSort{
	public static void main(String[] args){
		int[] data = new int[]{1100, 192, 221, 12, 23};
		System.out.println("before sort:\n"+Arrays.toString(data));
		radixSort(data, 10, 4);
		System.out.println("after sort:\n"+Arrays.toString(data));

	}

	private static void radixSort(int[] data, int radix, int d){
		int[] tmp = new int[data.length];
		int[] buckets = new int[radix];
		for (int i=0, rate=1; i<d; i++ ) {
			Arrays.fill(buckets, 0);
			System.arraycopy(data, 0, tmp, 0, data.length);
			for (int j=0; j<data.length; j++) {
				int subKey = (tmp[j]/rate)%radix;
				buckets[subKey]++;
			}
			for (int j=1; j<radix; j++) {
				buckets[j] = buckets[j]+buckets[j-1];
			}
			for (int m=data.length-1; m>=0; m--) {
				int subKey = (tmp[m]/rate)%radix;
				data[--buckets[subKey]] = tmp[m];
			}
			rate *= radix;
		}
	}
}