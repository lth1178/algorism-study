package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Addition123_9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int totalCaseCount =Integer.valueOf(br.readLine());
		int [] dp = new int [10];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int i=3; i<10; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for(int i=0; i<totalCaseCount; i++) {
			sb.append(dp[Integer.valueOf(br.readLine())-1] + "\n");
		}
		System.out.print(sb);
	}

}
