import java.util.Arrays;
public class BubbleSort {
	public static void main(String[] args){
		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		bubbleSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void bubbleSort(int[] a){
		for (int i=0; i<a.length-1; i++) {
			boolean isExchanged = false;
			for (int j=0; j<a.length-1-i; j++) {
				if (a[j] > a[j+1]) {
					swap(a,j, j+1);
					isExchanged = true;

				}
			}

			System.out.println(Arrays.toString(a));
			if (!isExchanged) {
				break;
			}
		}
	}

	private static void swap(int[] data, int i, int j){
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
}