package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Measure_1037 {
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int measureCount = Integer.valueOf(br.readLine());
		String [] request = br.readLine().split(" ");
		List<Integer> measure = new ArrayList<>(measureCount);
		for(int i=0; i<measureCount; i++) {
			measure.add(Integer.valueOf(request[i]));
		}
		measure.sort(null);
		System.out.print(measure.get(0) * measure.get(measureCount-1));
	}
}
