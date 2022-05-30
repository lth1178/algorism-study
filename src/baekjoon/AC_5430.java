package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int totalCaseCount = 0;
		String command = new String();
		String request = new String();
		int requestCount = 0;
		int responseSize = 0;
		char header = 'f';
		Boolean errorFlag = false;
		totalCaseCount = Integer.valueOf(br.readLine());
		for(int i=0; i<totalCaseCount; i++) {
			errorFlag = false;
			header = 'f';
			command = br.readLine();
			requestCount = Integer.valueOf(br.readLine());
			request = br.readLine();
			
			String [] requestData = request.substring(1, request.length()-1).split(",");
			
			Deque<String> deque = new ArrayDeque<String>();
			if(requestCount != 0) {
				for(String data : requestData) {
					deque.addLast(data);
				}
			}
			for(int index=0; index<command.length(); index++) {
				if(command.charAt(index) == 'R') {
					if(header=='f') {
						header = 'l';
					} else if (header == 'l') {
						header = 'f';
					}
				} else if(command.charAt(index) == 'D') {
					if(header=='f') {
						try {
							deque.removeFirst();
						} catch (Exception e) {
							// TODO: handle exception
							sb.append("error\n");
							errorFlag = true;
							break;
						}
					} else if (header == 'l') {
						try {
							deque.removeLast();
						} catch (Exception e) {
							// TODO: handle exception
							sb.append("error\n");
							errorFlag = true;
							break;
						}
					}
				}
			}
			responseSize = deque.size();
			if(responseSize == 0 && !errorFlag) {
				sb.append("[]\n");
			}
			for(int z=0; z<responseSize; z++) {
				if(responseSize==1) {
					sb.append("[" + deque.pollFirst() +"]"+ "\n");
				} else if(z==responseSize-1) {
					if(header=='f') {
						sb.append(deque.pollFirst() +"]"+ "\n");
						
					}
					else if(header=='l') {
						sb.append(deque.pollLast() + "]" + "\n");
					}
					
				}else if(z==0) {
					if(header=='f') {
						sb.append("["+deque.pollFirst() + ",");
					}
					else if(header=='l') {
						sb.append("["+deque.pollLast() + ",");
					}
				}else {
					if(header=='f') {
						sb.append(deque.pollFirst() + ",");
					}
					else if(header=='l') {
						sb.append(deque.pollLast() + ",");
					}
				}
			}
		}
		System.out.print(sb);
	}
}