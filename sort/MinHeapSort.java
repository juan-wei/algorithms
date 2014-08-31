import java.util.Arrays;
public class MinHeapSort 
{
	public static void main(String[] args) 
	{
		int[] a = {1,3,5,2,8,4,0};
		System.out.println("before sort: \n"+ Arrays.toString(a));
		sort(a);
		System.out.println("after sort: \n"+ Arrays.toString(a));
		
	}

	private static void sort(int[] a){
		
		System.out.println("begin sort: \n");
		
		//循环建堆
		for(int i=0; i<a.length-1; i++){
			// 建堆
			adjustMinHeap(a, a.length-1-i); 

			// 交换堆顶元素和最后一个元素
			swap(a, 0, a.length-1-i);

			//输出本次排序后的元素
			System.out.println(Arrays.toString(a));		
		}

	}

	//对数组a从0到lastIndex建小堆，最后输出结果是降序排列
	private static void adjustMinHeap(int[] a, int lastIndex){

		//从lastIndex(未排序的最后一个元素)节点的父节点开始
		for(int i=(lastIndex-1)/2; i>=0; i--){

			// pos保存正在判断的节点位置
			int pos = i;

			while(pos*2+1 <= lastIndex){ // 如果当前pos节点的子节点存在
				int min = pos*2+1; //pos节点的左子节点
				if(min < lastIndex){ //表示pos的右子节点存在
					if(a[min]> a[min+1]){ //右子节点值较小
						min++; //保存值小的节点的索引
					}
				}

				if(a[pos]> a[min]){ // 若pos节点的值大于其子节点的值
					swap(a, pos, min); //交换
					pos = min; //pos值保存交换后的新位置，保证pos节点的值小于其左右节点的值
				}else {
					break;
				}
			}
		}
		
	}

    //如果swap(a[i],a[j]), a的元素没有交换； 这是地址传递，值传递达不到改变a的顺序的效果
	private static void swap(int[]a, int i, int j){
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
}
