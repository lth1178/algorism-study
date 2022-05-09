package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

/*
 * 문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
*/
public class FIndNumber_1920 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String aString = "";      
        int N = 0; 
		int M = 0;
        String bString = "";
        N = Integer.valueOf(br.readLine());
        aString = br.readLine() ;
        M = Integer.valueOf(br.readLine());
        bString = br.readLine();
       
        int [] A = new int [N];
        String [] aStringAry = aString.split(" ");
        int [] B = new int [M];
        String [] bStringAry = bString.split(" ");
		int [] results = new int [M];
		
        for(int i=0; i<N; i++){
            A[i] = Integer.valueOf(aStringAry[i]);
        }
        for(int i=0; i<M; i++){
            B[i] = Integer.valueOf(bStringAry[i]);
        }
        Arrays.sort(A);
        
		for(int i=0; i<M; i++) {
			results[i] = solution(B[i], A);
		}
		for(int result : results) {
			System.out.println(result);
		}
		
	}
	
	public static int solution(int key, int[] ary) {
		int lowNum = 0;
		int highNum = ary.length -1;
		
		while(lowNum<=highNum) {
			int middleNum = (lowNum + highNum)/2;
			
			if(key<ary[middleNum]) {
				highNum = middleNum -1;
			}
			else if(key>ary[middleNum]) {
				lowNum = middleNum +1;
			}
			else if(key == ary[middleNum]) {
				return 1;
			}
			else {
				return 0;
			}
		}
		return 0;
	}
}
