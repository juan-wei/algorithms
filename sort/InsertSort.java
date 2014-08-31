import java.util.Arrays;
public class InsertSort{

	public static void main(String[] args){
		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		insertSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void insertSort(int[] data){
		System.out.println("sort:");


		for (int i=1; i<data.length; i++) {
			int temp = data[i];
			
			if (data[i] < data[i-1]) {
				int j = i-1;
				for (; j>=0; j--) {
					if (data[j] > temp) {
						data[j+1] = data[j];
					}else break;
				}
				data[j+1] = temp;
			}
			System.out.println(Arrays.toString(data));
		}
	}
}