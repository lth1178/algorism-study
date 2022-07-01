package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//�����佺�׳׽��� ü�� �̿��� �Ҽ� ���ϱ�
public class FIndDecimal_1978 {
	static int maxNum = 1000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalRequestCount = 0;
		boolean[] isDecimal = new boolean[maxNum +1];
		int result = 0;
		
		Arrays.fill(isDecimal, true);
		// 0�� 1�� �Ҽ��� �ƴ����� false
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
	//���� ���� �Ҽ��� 2���� ����� Ȯ�������ν� �Ҽ��� �ƴ� ���� �ɷ�����.
	//i�� �Ҽ��� ��� �Ҽ��� ���ϴ� ����(maxNum)�� i*i���� �۰ų� ���� ����� i�� ����� �豳�� ���� �ȴ�. ex) 130�� ��� 11*11=121 �̹Ƿ�  1 ~ 130������ 11���� ū �Ҽ��θ� �̷���� ���� ����. �� 2, 3, 5, 7, 11�� ������ �������� �ʴ� ���� ��� �Ҽ��̴�.  
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
