package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class startAndLink_14889 {
	static int result = 100000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalPeopleCount = 0;
		
		totalPeopleCount = Integer.valueOf(br.readLine());
		int [][] abilitySynergy = new int [totalPeopleCount][totalPeopleCount];
		for(int i=0; i<totalPeopleCount; i++) {
			String [] request = br.readLine().split(" ");
			for(int j=0; j<totalPeopleCount; j++) {
				abilitySynergy[i][j] = Integer.valueOf(request[j]);
			}
		}
		boolean[] team = new boolean[totalPeopleCount];
		dfs(abilitySynergy, team, 0, 0, totalPeopleCount);
		System.out.println(result);
		
		
	}
	public static void dfs(int [][] abilitySynergy, boolean[] team, int depth, int start, int totalPeopleCount) {
		
		if(depth == totalPeopleCount/2) {
			Map<Integer, Integer> teamStart = new HashMap<>();
			Map<Integer, Integer> teamLink = new HashMap<>();
			int teamStartAbility = 0;
			int teamLinkAbility = 0;
			
			for(int j=0; j<totalPeopleCount; j++) {
				if(team[j]) {
					teamStart.put(j, j);
				} else {
					teamLink.put(j, j);
				}
			}
			
			for(int z=0; z<totalPeopleCount; z++) {
				for(int y=0; y<totalPeopleCount; y++) {
					if(teamStart.get(z) != null && teamStart.get(y) != null) {
						teamStartAbility += abilitySynergy[z][y];
					} else if(teamLink.get(z) != null && teamLink.get(y) != null) {
						teamLinkAbility += abilitySynergy[z][y];
					}
				}
			}
			
			if (result >Math.abs(teamStartAbility - teamLinkAbility)) {
				result = Math.abs(teamStartAbility - teamLinkAbility);
			}
		}
		
		for(int i=start; i<totalPeopleCount; i++) {
			team[i] = true;
			dfs(abilitySynergy, team, depth+1, i+1, totalPeopleCount);
			team[i] = false;
		}
	}
}
