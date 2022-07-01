package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsequence_1182 {
	static int result = 0;
	static int subsequenceSize;
	static int subsequenceSum;
	static int index = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] request = br.readLine().split(" ");
		
		subsequenceSize = Integer.valueOf(request[0]);
		subsequenceSum = Integer.valueOf(request[1]);
		
		String [] request_2 = br.readLine().split(" ");
		int [] subsequence = new int[subsequenceSize];
		boolean [] check = new boolean[subsequenceSize];
		
		for(int i=0; i<subsequenceSize; i++) {
			subsequence[i] = Integer.valueOf(request_2[i]);
		}
		sumOfSubsequece(0, 0, subsequence, check);
		System.out.print(result);
	}
	public static void sumOfSubsequece(int depth, int start, int [] subsequence, boolean [] check) {
		index++;
		int sum = 0;
		boolean sumFlag = false;
		for(int j=0; j<subsequenceSize; j++) {
			if(check[j]) {
				sum += subsequence[j];
				sumFlag= true;
			}
		}
		if(sum==subsequenceSum && sumFlag) {
			result++;
		}
		
		for(int i=start; i<subsequenceSize; i++) {
			check[i] = true;
			sumOfSubsequece(depth+1, i+1, subsequence, check);
			check[i] = false;
		}
	}
}
