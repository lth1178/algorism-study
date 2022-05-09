package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/

//용량이 적은 문제로 정렬로 푸는것이 아니다.
public class NumSort_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		int [] ary = new int[10000];
		
		for (int i=0; i<size; i++) {
			ary[Integer.valueOf(br.readLine()) -1]++;
		}
		
		for(int i=0; i<10000; i++) {
			while(ary[i]>0) {
				ary[i]--;
				sb.append(i+1).append('\n');
			}
		}
		System.out.println(sb);
        br.close();
	}

}
