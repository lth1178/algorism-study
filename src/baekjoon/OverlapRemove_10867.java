package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OverlapRemove_10867 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> overlapRemoveSort = new HashSet<>();
		int totalCount = 0;
		totalCount = Integer.valueOf(br.readLine());
		String [] store = new String[totalCount];
		store = br.readLine().split(" ");
		for(String num:store) {
			overlapRemoveSort.add(Integer.valueOf(num));
		}
		List<Integer> results = new ArrayList<>(overlapRemoveSort);
		results.sort(new Comparator<Integer>() {@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		for(int result:results) {
			System.out.print(result + " ");
		}
	}
}