package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Editer_1406 {
	public static void main (String [] args) throws IOException {
		int count = 0;
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer buf_1 = new StringBuffer();
		StringBuffer buf_2 = new StringBuffer();
		String a = new String();
		String b = new String();
		
		char[] input = new char[2];
		for(String s: br.readLine().split("")) {
			leftStack.push(s.charAt(0));
		}
		count = Integer.valueOf(br.readLine());
		for(int i=0; i<count; i++) {
			input = br.readLine().toCharArray();
			switch (input[0]) {
			case 'L': 
				if(!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
				break;
			case 'D':
				if(!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
				break;
			case 'B':
				if(!leftStack.isEmpty()) {
					leftStack.pop();
				}
				break;
			case 'P':
				leftStack.push(input[2]);
				break;
			}
		}
//		for(Character s: leftStack) {
//			a+=s; 
//		}
//		while(rightStack.size()>0) {
//			b+=rightStack.pop();
//		}
//		System.out.print(a+b);
		for(Character s: leftStack) {
			buf_1.append(s.toString()); 
		}
		while(rightStack.size()>0) {
			if(!rightStack.peek().toString().equals("null"))
				buf_2.append(rightStack.pop().toString()); 
		}
		bw.write(buf_1.toString() + buf_2.toString() + "\n");
		bw.flush();
		
	}
}
