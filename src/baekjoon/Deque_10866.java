package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
0.5 �� (�߰� �ð� ����)	256 MB	43982	23990	20296	56.354%
����
������ �����ϴ� ��(Deque)�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push_front X: ���� X�� ���� �տ� �ִ´�.
push_back X: ���� X�� ���� �ڿ� �ִ´�.
pop_front: ���� ���� �տ� �ִ� ���� ����, �� ���� ����Ѵ�. ����, ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
pop_back: ���� ���� �ڿ� �ִ� ���� ����, �� ���� ����Ѵ�. ����, ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���� ����ִ� ������ ������ ����Ѵ�.
empty: ���� ��������� 1��, �ƴϸ� 0�� ����Ѵ�.
front: ���� ���� �տ� �ִ� ������ ����Ѵ�. ���� ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ���� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.

���� �Է� 1 
15
push_back 1
push_front 2
front
back
size
empty
pop_front
pop_back
pop_front
size
empty
pop_back
push_front 3
empty
front
���� ��� 1 
2
1
2
0
2
1
-1
0
1
-1
0
3
*/
public class Deque_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dequeSize = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		String [] data = new String[2];
		dequeSize = Integer.valueOf(br.readLine());
		for(int i=0; i<dequeSize; i++) {
			data = br.readLine().split(" ");
			if(data[0].equals("push_front")) {
				deque.addFirst(Integer.valueOf(data[1]));
			} else if(data[0].equals("push_back")) {
				deque.addLast(Integer.valueOf(data[1]));
			} else if(data[0].equals("pop_front")) {
				if(!deque.isEmpty()) {
					System.out.println(deque.pollFirst());
				} else {
					System.out.println(-1);
				}
			} else if(data[0].equals("pop_back")) {
				if(!deque.isEmpty()) {
					System.out.println(deque.pollLast());
				} else {
					System.out.println(-1);
				}
			} else if(data[0].equals("size")) {
				System.out.println(deque.size());
			} else if(data[0].equals("empty")) {
				if(deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(data[0].equals("front")) {
				if(!deque.isEmpty()) {
					System.out.println(deque.peekFirst());
				} else {
					System.out.println(-1);
				}
			} else if(data[0].equals("back")) {
				if(!deque.isEmpty()) {
					System.out.println(deque.peekLast());
				} else {
					System.out.println(-1);
				}
			}
		}
	}
}
