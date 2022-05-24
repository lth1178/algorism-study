package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * ����
���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

���̰� ª�� �ͺ���
���̰� ������ ���� ������
�Է�
ù° �ٿ� �ܾ��� ���� N�� �־�����. (1 �� N �� 20,000) ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����. �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.

���
���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�. ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.

���� �Է� 1 
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
���� ��� 1 
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
*/
public class WordSort_1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCount=0;
		Set<String> wordSet = new HashSet<String>();
		totalCount = Integer.valueOf(br.readLine());
		for(int i=0; i<totalCount; i++) {
			wordSet.add(br.readLine());
		}
		List<String> wordList = new ArrayList<>(wordSet);
		wordList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else {
					return o1.length()-o2.length();
				}
			}
		});
		for(String out : wordList) {
			System.out.println(out);
		}
	}
}
