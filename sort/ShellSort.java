import java.util.Arrays;
public class ShellSort {

	public static void main(String[] args){

		int[] data = new int[]{5,3,6,2,1,9,3,0,4,8,7};

		System.out.println("before sort:\n"+Arrays.toString(data));
		shellSort(data);
		System.out.println("after sort:\n"+Arrays.toString(data));

	}

	private static void shellSort(int[] data){
		int h = 1;
		while(h<=data.length/3){
			h= h*3+1;

		}
		System.out.println("begin:\n");
		while(h>0){
			System.out.println("h="+h+"\t"+Arrays.toString(data));	
			for (int i=h; i<data.length; i+=h) {
				System.out.println(Arrays.toString(data));	
				if (data[i] < data[i-h]) {
					int temp = data[i];
					
					int j=i-h;
					while(j>=0&&data[j]>temp){
						data[j+h] = data[j];
						j-=h;
					}
					data[j+h] = temp;

				}
			}

			h = (h-1)/3;
		}
	}

		
}