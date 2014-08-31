import java.util.Arrays;
/**
* 折半插入排序
*/
public class BinaryInsertSort {

	public static void main(String[] args){
		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		binaryInsertSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void binaryInsertSort(int[] data){
		System.out.println("sort:\n");
		for (int i=1; i<data.length; i++) {
			if (data[i]<data[i-1]) {
				int temp =data[i];
				int low =0;
				int high = i-1;
				
				while(low<=high){
					int mid = (low+high)/2;
					if (data[mid] < temp) {
						low = mid+1;
					}else{
						high = mid-1;
					}
				}

				for (int j=i; j>low; j--) {
					data[j] = data[j-1];
				}
				data[low] = temp;
				System.out.println(Arrays.toString(data));
			}
			
		}
	}

}