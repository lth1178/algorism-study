package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parenthesis_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vpsFlag = 0;
		int totalPsCount = 0;
		String psList = new String();
		totalPsCount = Integer.valueOf(br.readLine());
		
		for(int i=0;i<totalPsCount;i++) {
			psList = br.readLine();
			for(int j=0;j<psList.length();j++) {
				if( psList.charAt(j)=='(') {
					vpsFlag++;
				}
				else if(psList.charAt(j)==')'){
					vpsFlag--;
				}
				if(vpsFlag<0) {
					break;
				}
			}
			if(vpsFlag==0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			vpsFlag = 0;
		}
	}
}
