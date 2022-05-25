package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Josephus_1158 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] request = new String[2];
		int totalPeopleCount = 0;
		int currentPeopleNum = -1;
		int interval = 0;
		request = br.readLine().split(" ");
		totalPeopleCount = Integer.valueOf(request[0]);
		interval = Integer.valueOf(request[1]);
		List<Integer> josephus = new ArrayList<>();
		for(int i=0; i<totalPeopleCount; i++) {
			josephus.add(i+1);
		}
		
		while(josephus.size()>0) {
			for(int i=0; i<interval; i++) {
				currentPeopleNum++;
				if(currentPeopleNum >= josephus.size()) {
					currentPeopleNum = 0;
				}
			}
			sb.append(josephus.get(currentPeopleNum) + ", ");
			josephus.remove(currentPeopleNum);
			currentPeopleNum--;
		}
		sb.delete(sb.length()-2, sb.length());
		System.out.print("<"+sb+">");
	}
}