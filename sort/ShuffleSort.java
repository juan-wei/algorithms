import java.util.Arrays;
import java.lang.Math;
public class ShuffleSort{
	public static void main(String[] args){
		int[] data = new int[]{5,3,6,2,1,9,3,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		shuffleSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));
	}

	private static void shuffleSort(int[] data){
		for (int i=0; i<data.length-1; i++) {
			int j = (int) (data.length*Math.random());
			swap(data, i, j);
		}
	}

	private static void swap(int[] data, int i, int j){
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
}