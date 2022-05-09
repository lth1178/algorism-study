package algorithm;

public class Sort { 
	
	public void swap (int[] ary, int left, int right) {
		int tamp;
		tamp = ary[left];
		ary[left] = ary[right];
		ary[right] = tamp;
	}
	//가운데를 pivot으로 정한 뒤 pivot과 left/right를 비교한 후 각각 작을때/클때까지 진행한다.
	//그렇지 않을경우
	public int partition(int[] ary, int left, int right) {
		//left와 right의 중간값으로 pivot 설정
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
