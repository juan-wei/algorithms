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
		
		//ѭ������
		for(int i=0; i<a.length-1; i++){
			// ����
			adjustMinHeap(a, a.length-1-i); 

			// �����Ѷ�Ԫ�غ����һ��Ԫ��
			swap(a, 0, a.length-1-i);

			//�������������Ԫ��
			System.out.println(Arrays.toString(a));		
		}

	}

	//������a��0��lastIndex��С�ѣ�����������ǽ�������
	private static void adjustMinHeap(int[] a, int lastIndex){

		//��lastIndex(δ��������һ��Ԫ��)�ڵ�ĸ��ڵ㿪ʼ
		for(int i=(lastIndex-1)/2; i>=0; i--){

			// pos���������жϵĽڵ�λ��
			int pos = i;

			while(pos*2+1 <= lastIndex){ // �����ǰpos�ڵ���ӽڵ����
				int min = pos*2+1; //pos�ڵ�����ӽڵ�
				if(min < lastIndex){ //��ʾpos�����ӽڵ����
					if(a[min]> a[min+1]){ //���ӽڵ�ֵ��С
						min++; //����ֵС�Ľڵ������
					}
				}

				if(a[pos]> a[min]){ // ��pos�ڵ��ֵ�������ӽڵ��ֵ
					swap(a, pos, min); //����
					pos = min; //posֵ���潻�������λ�ã���֤pos�ڵ��ֵС�������ҽڵ��ֵ
				}else {
					break;
				}
			}
		}
		
	}

    //���swap(a[i],a[j]), a��Ԫ��û�н����� ���ǵ�ַ���ݣ�ֵ���ݴﲻ���ı�a��˳���Ч��
	private static void swap(int[]a, int i, int j){
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
}
