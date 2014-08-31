import java.util.Arrays;
public class QuickSort {

	public static void main(String[] args){
		//int[] data = new int[]{1,1,1,1};
		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};


		System.out.println("before sort:\n"+Arrays.toString(data));
		quickSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void quickSort(int[] data){
		sort(data, 0, data.length-1);
	}

	private static void sort(int[] data, int start, int end){
		if (start >= end) {
			return;
		}
		int pivot = data[start];
		int i = start+1;
		int j = end;
		while(true){
			while(i<=end && data[i] <= pivot) i++;
			while(j>start && data[j] > pivot) j--;
			if (i<j) {
				swap(data, i, j);
			}else{
				break;
			}
		}

		swap(data, start, j);
		System.out.println(Arrays.toString(data));
		sort(data, start, j-1);
		sort(data, j+1, end);
	}
	private static void swap(int[] data, int i, int j){
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
} 