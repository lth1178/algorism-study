package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*����
N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� �� �־�����. �� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.

���
ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.*/
public class NumSort_2750 {
	public static void main(String[]args) throws IOException {
		NumSort_2750 ma = new NumSort_2750();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numbers = "";
		String tmp = null;

		while((tmp=br.readLine()) != null) {
			numbers += tmp + " ";
		}
		
		String[] numStringAry = numbers.split(" ");
		int[] numIntAry = new int[numStringAry.length-1];
		for(int i=1; i<numStringAry.length; i++) {
			numIntAry[i-1] = Integer.valueOf(numStringAry[i]);
		}

		for(int result:numIntAry) {
			System.out.println(result);
		}
		
		ma.quickSort(numIntAry);
		
		
	}
	
	public void swap (int[] ary, int left, int right) {
		int tamp;
		tamp = ary[left];
		ary[left] = ary[right];
		ary[right] = tamp;
	}
	//�� ������ ���� �񱳸� �� pivot ���� �������� �������� ���� ū���� ���������� �̵���Ų��.
	public int partition(int[] ary, int left, int right) {
		//left�� right�� �߰������� pivot ����
		int pivot = right - (right-left)/2;
		int low = left;
		int high = right;
		
		while(low<=high) {
			while(low<high) {
				if(ary[low]>=ary[pivot]) {
					break;
				}
				low++;
			}
			
			while(low<=high) {
				if(ary[pivot]>=ary[high]) {
					break;
				}
				high--;
			}
			swap(ary, low, high);
			low++;
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
		if(high +1 <left)
			quickSort(ary, high+1, left);
		
	}
}
