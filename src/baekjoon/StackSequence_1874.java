package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int stackSize = 0;
		int num = 0;
		int seq = 1;
		boolean pushFlag = true;
		Stack<Integer> stack = new Stack<>();
		stackSize = Integer.valueOf(br.readLine());
		for(int i=0;i<stackSize;i++) {
			num = Integer.valueOf(br.readLine());
			while(pushFlag) {
				if(stack.empty()) {
					stack.push(seq++);
					sb.append("+\n");
				} else if(num >= seq) {
					stack.push(seq++);
					sb.append("+\n");
				} else if(num == stack.peek()) {
					stack.pop();
					sb.append("-\n");
					break;
				} else {
					pushFlag = false;
					break;
				}
			}
			if(!pushFlag) {
				break;
			}
		}
		if(pushFlag) {
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}
	}
}
