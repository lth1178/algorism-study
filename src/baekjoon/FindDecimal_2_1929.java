package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindDecimal_2_1929{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int startNum = 0;
		int endNum = 0;
		String [] request = new String[2];
		request = br.readLine().split(" ");
		startNum = Integer.valueOf(request[0]);
		endNum = Integer.valueOf(request[1]);
		boolean[] decimas = new boolean[endNum + 1];
		Arrays.fill(decimas, true);
		decimas[0] = false;
		decimas[1] = false;
		if(endNum!=1) {
			for(int i=2; i*i<=endNum; i++) {
				if(decimas[i]) {
					for(int j=startNum; j<=endNum; j++) {
						if(i!=j && j%i == 0) {
							decimas[j] = false; 
						}
					}
				}
			}
		
			for(int z=startNum; z<=endNum; z++) {
				if(decimas[z])
					sb.append(z+"\n");
			}
			System.out.print(sb);
		} 
	}

}
