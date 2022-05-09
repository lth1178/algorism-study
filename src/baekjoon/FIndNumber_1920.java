package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

/*
 * ����
N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N(1 �� N �� 100,000)�� �־�����. ���� �ٿ��� N���� ���� A[1], A[2], ��, A[N]�� �־�����. ���� �ٿ��� M(1 �� M �� 100,000)�� �־�����. ���� �ٿ��� M���� ������ �־����µ�, �� ������ A�ȿ� �����ϴ��� �˾Ƴ��� �ȴ�. ��� ������ ������ -231 ���� ũ�ų� ���� 231���� �۴�.

���
M���� �ٿ� ���� ����Ѵ�. �����ϸ� 1��, �������� ������ 0�� ����Ѵ�.
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
