import java.util.Arrays;
public class MergeSort {
	public static void main(String[] args){

		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		mergeSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
		

	}

	private static void mergeSort(int[] data){
		System.out.println("sort:\n");
		sortByRecurison(data, 0, data.length-1);
		

	}
	private static void sortByRecurison(int[] data, int left, int right){
		if (left>=right) {
			return ;
		}
		int mid = (left+right)/2;
		sortByRecurison(data, left, mid);
		sortByRecurison(data, mid+1, right);
		merge(data, left, mid, right);
		System.out.println(Arrays.toString(data));
		
	}

	private static void merge(int[] data, int left, int mid, int right){
		int[] tempArray = new int[data.length];
		int tempIndex = left;
		
		int firstRight = mid+1;
		int lastLeft = mid;

		int tempLeft  = left;

		while(left <= lastLeft && firstRight <= right){
			if (data[left] <= data[firstRight]) {
				tempArray[tempIndex++] = data[left++];
			}else{
				tempArray[tempIndex++] = data[firstRight++];
			}
		}

		while(firstRight<=right){
			
			tempArray[tempIndex++] = data[firstRight++];

		}
		while(left<=lastLeft){
			tempArray[tempIndex++] = data[left++];
		}

		while(tempLeft <= right){
			data[tempLeft] = tempArray[tempLeft++];
		}
		
	}

}