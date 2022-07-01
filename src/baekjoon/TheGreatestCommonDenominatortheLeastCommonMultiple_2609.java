package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGreatestCommonDenominatortheLeastCommonMultiple_2609 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] firstNumDivisor = new boolean[10001];
		boolean[] secondNumDivisor = new boolean[10001];
		int theGreatestCommonDenomicator = 0;
		int theLeastCommonMultiple = 0;
		
		int firstNum = 0;
		int secondNum = 0;
		int largeNum = 0;
		String [] request = br.readLine().split(" ");
		firstNum = Integer.valueOf(request[0]);
		secondNum = Integer.valueOf(request[1]);
		
		largeNum = firstNum>=secondNum?firstNum:secondNum;
		for(int i=1; i<=firstNum; i++) {
			if(firstNum%i==0) {
				firstNumDivisor[i] = true;
			}
		}
		for(int i=1; i<=secondNum; i++) {
			if(secondNum%i==0) {
				secondNumDivisor[i] = true;
			}
		}
		for(int i=largeNum; i>0; i--) {
			if(firstNumDivisor[i]==true && secondNumDivisor[i]==true) {
				theGreatestCommonDenomicator = i;
				sb.append(theGreatestCommonDenomicator+"\n");
				break;
			}
		}
		theLeastCommonMultiple = firstNum * secondNum / theGreatestCommonDenomicator;
		sb.append(theLeastCommonMultiple);
		System.out.print(sb);
	}

}
