package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.*/
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
	//양 끝에서 부터 비교를 해 pivot 값을 기준으로 작은값은 왼쪽 큰값은 오른쪽으로 이동시킨다.
	public int partition(int[] ary, int left, int right) {
		//left와 right의 중간값으로 pivot 설정
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
