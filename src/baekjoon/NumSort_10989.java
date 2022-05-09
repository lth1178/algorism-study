package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���� �־�����. �� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
*/

//�뷮�� ���� ������ ���ķ� Ǫ�°��� �ƴϴ�.
public class NumSort_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		int [] ary = new int[10000];
		
		for (int i=0; i<size; i++) {
			ary[Integer.valueOf(br.readLine()) -1]++;
		}
		
		for(int i=0; i<10000; i++) {
			while(ary[i]>0) {
				ary[i]--;
				sb.append(i+1).append('\n');
			}
		}
		System.out.println(sb);
        br.close();
	}

}
