package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto_6603 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int requestCount = 0;
		do {
			String [] request = br.readLine().split(" ");
			requestCount = Integer.valueOf(request[0]);
			if(requestCount == 0) {
				break;
			}
		}while(requestCount != 0);
	}

}
