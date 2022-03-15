package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9633 {
	//���� ������ �ʰ� �������� ����Ǽ�
	static int result=0;
	
	private static void setQueen(int N, int num, int[]queen) {
		
		//num��° ���� ��ġ�� �ϳ��� �̵�
		for(int i = 0; i < N; i++) {

			//��� ȣ�� or result++�� ���� flag
			boolean nextFlag = true;
			queen[num] = i;
 
			//�տ� ���� ����� ���� ������ �ʴ��� Ȯ��
			for(int j = 0; j < num; j++) {

				//���� ������ break(���� �÷��� ������ or �밢���� ������)
				if(queen[j]==queen[num] || Math.abs(queen[num] - queen[j])==Math.abs(num - j)) {
					nextFlag = false;
					break;
				}
			}
			
			//�տ� ���� ����� ��ġ�� �ʾ�����
			if(nextFlag) {
				nextFlag = true;
				//������ ������ ���� ������� ���ȣ��
				if(num<N-1) { 
					setQueen(N, num+1, queen);
				}
				//������ ������ ���� �������� ��� ++
				else {
					result++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		//���� ���� �� �ּ� ����(���� �Է�)
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		//final int N = Integer.parseInt(br.readLine());
		
		final int N = 8; 
		//���� �����ִ� ���� ����(num��° ��)
		int num = 0;
		  
		//���� �����ִ� ��ġ
		int [] queen = new int[N];
		
		setQueen(N, num, queen);
		System.out.println(result);
	}
}
