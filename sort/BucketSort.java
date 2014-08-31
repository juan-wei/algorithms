import java.util.Arrays;
public class BucketSort {
	public static void main(String[] args){
		int[] data = new int[]{5,3,6,8,1,9,3};

		System.out.println("before sort:\n"+Arrays.toString(data));
		bucketSort(data, 0, 10);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void bucketSort(int[] data, int min, int max){
		int[] tempArray = new int[data.length];
		int[] buckets = new int[max-min];
		for (int i=0; i<data.length; i++) {
			buckets[data[i]-min]++;
		}
		for (int i =1; i<max-min; i++) {
			buckets[i] = buckets[i] + buckets[i-1];
		}
		System.arraycopy(data, 0, tempArray, 0, data.length);
		for (int i=data.length-1; i>=0; i--) {
			data[--buckets[tempArray[i]-min]] = tempArray[i];
		}
	}
	private static void swap(int[] data, int i, int j){
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
}