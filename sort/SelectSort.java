import java.util.Arrays;
public class SelectSort {

	public static void main(String[] args){
		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		selectSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void selectSort(int[] a){
		for (int i=0; i<a.length; i++) {
			int min = i;
			for (int j = i+1; j<a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(a, i, min);
			}

			System.out.println(Arrays.toString(a));
		}
	}
	private static void swap(int[] data, int i, int j){
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
}