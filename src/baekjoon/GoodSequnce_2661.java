package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodSequnce_2661 {
	static int N = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String result = "";
		N = Integer.valueOf(br.readLine()); 
		
		dfs(result);
	}
	static void dfs(String result) {
		if(N == result.length()) {
			System.out.println(result);
			System.exit(0);
		}
		for(int i=1; i<4; i++) {
			if(checkGoodSequnce(result + i)) {
				dfs(result + i);
			}
		}
	}
	
	//���� ������ �����ϱ� ���ؼ��� ��� ������ ���ӵǼ��� �ȵȴ�. ���� 1���� n/2������ �������� ���ӵ� ���� �ִ��� ã�Ƴ���.
	static boolean checkGoodSequnce(String result) {
		int len = result.length();
		for(int i=1; i<=len/2; i++) {
			if(result.substring(len-i).equals(result.substring(len-2*i, len-i)) ){
				return false;
			}
		}
		return true;
	}
	
}
