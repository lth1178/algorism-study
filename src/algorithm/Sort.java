package algorithm;

public class Sort { 
	
	public void swap (int[] ary, int left, int right) {
		int tamp;
		tamp = ary[left];
		ary[left] = ary[right];
		ary[right] = tamp;
	}
	//����� pivot���� ���� �� pivot�� left/right�� ���� �� ���� ������/Ŭ������ �����Ѵ�.
	//�׷��� �������
	public int partition(int[] ary, int left, int right) {
		//left�� right�� �߰������� pivot ����
		int pivot = ary[right - (right-left)/2];
		int low = left;
		int high = right;
		
		while(low<=high) {
			while(low<high) {
				if(ary[low]>=pivot) {
					break;
				}
				low++;
			}
			
			while(low<=high) {
				if(pivot>=ary[high]) {
					break;
				}
				high--;
			}
			if(low<=high) {
				swap(ary, low++, high--);
			}
		}
		return high;
	}
	public void quickSort(int[] ary) {
		quickSort(ary, 0, ary.length-1);
	}
	public void quickSort(int[] ary, int left, int right) { 
		int high = partition(ary, left, right);
		if(left<high)
			quickSort(ary, left, high);
		if(high +1 <right)
			quickSort(ary, high+1, right); 
		
	}
}
