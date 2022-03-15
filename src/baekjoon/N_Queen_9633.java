package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9633 {
	//퀸의 잡하지 않고 놓여지는 경우의수
	static int result=0;
	
	private static void setQueen(int N, int num, int[]queen) {
		
		//num번째 퀸의 위치를 하나씩 이동
		for(int i = 0; i < N; i++) {

			//재귀 호출 or result++를 위한 flag
			boolean nextFlag = true;
			queen[num] = i;
 
			//앞에 놓은 퀸들과 서로 잡히지 않는지 확인
			for(int j = 0; j < num; j++) {

				//서로 잡히면 break(같은 컬럼에 있을때 or 대각선에 있을때)
				if(queen[j]==queen[num] || Math.abs(queen[num] - queen[j])==Math.abs(num - j)) {
					nextFlag = false;
					break;
				}
			}
			
			//앞에 놓은 퀸들과 겹치지 않았을때
			if(nextFlag) {
				nextFlag = true;
				//마지막 퀸까지 놓지 않은경우 재귀호출
				if(num<N-1) { 
					setQueen(N, num+1, queen);
				}
				//마지만 퀸까지 전부 놓았을때 결과 ++
				else {
					result++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		//백준 제출 시 주석 제거(정수 입력)
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		//final int N = Integer.parseInt(br.readLine());
		
		final int N = 8; 
		//현재 놓고있는 퀸의 순서(num번째 퀸)
		int num = 0;
		  
		//퀸이 놓여있는 위치
		int [] queen = new int[N];
		
		setQueen(N, num, queen);
		System.out.println(result);
	}
}
