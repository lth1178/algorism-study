package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ���� ī��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	256 MB	39762	19783	13815	48.932%
����
���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�. ����̴� ���� ī�� N���� ������ �ִ�. ���� M���� �־����� ��, �� ���� �����ִ� ���� ī�带 ����̰� ������ �ִ��� �ƴ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����̰� ������ �ִ� ���� ī���� ���� N(1 �� N �� 500,000)�� �־�����. ��° �ٿ��� ���� ī�忡 �����ִ� ������ �־�����. ���� ī�忡 �����ִ� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����. �� ���� ī�忡 ���� ���� �����ִ� ���� ����.

��° �ٿ��� M(1 �� M �� 500,000)�� �־�����. ��° �ٿ��� ����̰� ������ �ִ� ���� ī������ �ƴ����� ���ؾ� �� M���� ������ �־�����, �� ���� �������� ���еǾ��� �ִ�. �� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����

���
ù° �ٿ� �Է����� �־��� M���� ���� ���ؼ�, �� ���� ���� ���� ī�带 ����̰� ������ ������ 1��, �ƴϸ� 0�� �������� ������ ����Ѵ�.

���� �Է� 1 
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
���� ��� 1 
1 0 0 1 1 0 0 1
*/
public class NumberCard_10815 {
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sangenCount = 0; 
		Map<String, String> sagenCard = new HashMap<>();
		int standardCount = 0;
		 
		sangenCount = Integer.valueOf(br.readLine());
		
		for(String card: br.readLine().split(" ")) {
			sagenCard.put(card, card);
		}
		
		standardCount = Integer.valueOf(br.readLine());
		String[] standardCard = br.readLine().split(" ");

		
		for(int i=0; i<standardCount; i++) {
			if(sagenCard.get(standardCard[i])!=null) {
				System.out.print("1 ");
			}
			else
				System.out.print("0 ");
		}		
		
	}
}
