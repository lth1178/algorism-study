package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * �ð� ����	�޸� ����	����	����	���� ���	���� ����
0.5 �� (�߰� �ð� ����)	256 MB	152691	58343	41995	38.019%
����
������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� �ټ� �����̴�.

push X: ���� X�� ���ÿ� �ִ� �����̴�.
pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.

���� �Է� 1 
14
push 1
push 2
top
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
top
���� ��� 1 
2
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
���� �Է� 2 
7
pop
top
push 123
top
pop
top
pop
���� ��� 2 
-1
-1
123
123
-1
-1
*/
public class Stack_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		int stackSize = 0;
		String[] value = new String[2];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stackSize = Integer.valueOf(br.readLine());
		/*push X: ���� X�� ���ÿ� �ִ� �����̴�.
		pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
		size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
		empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
		top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.*/
		for(int i=0; i<stackSize; i++) {
			value = br.readLine().split(" ");
			if(value[0].equals("push")) {
				stack.push(Integer.valueOf(value[1]));
			} else if(value[0].equals("pop")) {
				if(!stack.empty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
			} else if(value[0].equals("size")) {
				System.out.println(stack.size());
			} else if(value[0].equals("empty")) {
				if(!stack.empty()) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			} else if(value[0].equals("top")) {
				if(!stack.empty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
			}
		}
		
		
	}

}
