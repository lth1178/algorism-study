package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//에라토스테네스의 체를 이용한 소수 구하기
public class FIndDecimal_1978 {
	static int maxNum = 1000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalRequestCount = 0;
		boolean[] isDecimal = new boolean[maxNum +1];
		int result = 0;
		
		Arrays.fill(isDecimal, true);
		// 0과 1은 소수가 아님으로 false
		isDecimal[0] = false;
		isDecimal[1] = false;
		sieveOfEratosthenes(isDecimal);
		totalRequestCount = Integer.valueOf(br.readLine());
		String[] request = br.readLine().split(" ");
		for(int i=0; i<totalRequestCount; i++) {
			if(isDecimal[Integer.valueOf(request[i])]) {
				result++;
			}
		}
		System.out.print(result);
		
	}
	//가장 작은 소수인 2부터 배수를 확인함으로써 소수가 아닌 수를 걸러낸다.
	//i가 소수일 경우 소수를 구하는 범위(maxNum)가 i*i보다 작거나 같은 경우의 i의 배수를 배교해 보면 된다. ex) 130일 경우 11*11=121 이므로  1 ~ 130까지는 11보다 큰 소수로만 이루어진 수가 없다. 즉 2, 3, 5, 7, 11로 나누어 떨어지지 않는 수는 모두 소수이다.  
	static void sieveOfEratosthenes(boolean[] isDecimal) {
		for(int i=2; i*i<=maxNum; i++) {
			if(isDecimal[i]) {
				for(int j=i+1; j<=maxNum;j++) {
					if(j%i == 0) {
						isDecimal[j] = false;
					}
				}
			}
		}
	}
}
