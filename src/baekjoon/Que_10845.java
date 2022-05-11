package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ����
������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.

���� �Է� 1 
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front
���� ��� 1 
1
2
2
0
1
2
-1
0
1
-1
0
3
*/
public class Que_10845 {
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int queCount = 0;
		int lastInput = 0;
		String[] respons = new String[2];
		Queue<Integer> queue = new LinkedList<>();
		queCount = Integer.valueOf(br.readLine());
		for(int i=0; i<queCount; i++) {
			respons = (br.readLine()).split(" ");
			if(respons[0].equals("push")) {
				queue.add(Integer.valueOf(respons[1]));
				lastInput = Integer.valueOf(respons[1]);
			} else if(respons[0].equals("pop")) {
				if(!queue.isEmpty()) {
					System.out.println(queue.poll());
				} else {
					System.out.println(-1);
				}
			} else if(respons[0].equals("size")) {
				System.out.println(queue.size());
			} else if(respons[0].equals("empty")) {
				if(!queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			} else if(respons[0].equals("front")) {
				if(!queue.isEmpty()) {
					System.out.println(queue.peek());
				} else {
					System.out.println(-1);
				}
			} else if(respons[0].equals("back")) {
				if(!queue.isEmpty()) {
					System.out.println(lastInput);
				} else {
					System.out.println(-1);
				}
			}
		}
	}
}
