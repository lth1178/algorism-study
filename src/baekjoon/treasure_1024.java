package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
public class treasure_1024 {
	/*����
���� ������ ������ �׻� ū ��ĩ�Ÿ����� ���� �־���. �� ������ ���� �������� ������ ���� ������ ���� ū ����� �ɾ���.

���̰� N�� ���� �迭 A�� B�� �ִ�. ������ ���� �Լ� S�� ��������.

S = A[0] �� B[0] + ... + A[N-1] �� B[N-1]

S�� ���� ���� �۰� ����� ���� A�� ���� ��迭����. ��, B�� �ִ� ���� ��迭�ϸ� �� �ȴ�.

S�� �ּڰ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. ��° �ٿ��� A�� �ִ� N���� ���� ������� �־�����, ��° �ٿ��� B�� �ִ� ���� ������� �־�����. N�� 50���� �۰ų� ���� �ڿ����̰�, A�� B�� �� ���Ҵ� 100���� �۰ų� ���� ���� �ƴ� �����̴�.

���
ù° �ٿ� S�� �ּڰ��� ����Ѵ�.

���� �Է� 1 
5
1 1 1 6 0
2 7 8 3 1
���� ��� 1 
18
���� �Է� 2 
3
1 1 3
10 30 20
���� ��� 2 
80
���� �Է� 3 
9
5 15 100 31 39 0 0 3 26
11 12 13 2 3 4 5 9 1
���� ��� 3 
528
��Ʈ
���� 1�� ��� A�� {1, 1, 0, 1, 6}�� ���� ��迭�ϸ� �ȴ�.
		*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int count = 0;
		int result = 0;
		
		count = Integer.valueOf(br.readLine());
		Integer[] ary_1 = new Integer[count];
		Integer[] ary_2 = new Integer[count];
		String [] store = new String[count];
		store = br.readLine().split(" ");
		for(int i=0; i<count; i++) {
			ary_1[i] = Integer.valueOf(store[i]);
		}
		store = br.readLine().split(" ");
		for(int i=0; i<count; i++) {
			ary_2[i] = Integer.valueOf(store[i]);
		}
		Arrays.sort(ary_1);
		Arrays.sort(ary_2, Collections.reverseOrder());
		
		for(int i=0; i<count; i++) {
			result += ary_1[i]*ary_2[i];
		}
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
	}

}
