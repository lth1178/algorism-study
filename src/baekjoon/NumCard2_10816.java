package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumCard2_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> sangGunCardMap = new HashMap<>();
		int sangGunCardCount = 0;
		int cardCount = 0;
		sangGunCardCount =Integer.valueOf(br.readLine());
		String[] sangGunCardList = new String[sangGunCardCount];
		sangGunCardList = br.readLine().split(" ");
		for(String sangGunCard : sangGunCardList) {
			if(sangGunCardMap.get(sangGunCard)==null) {
				sangGunCardMap.put(sangGunCard, 1);
			}
			else {
				sangGunCardMap.put(sangGunCard, sangGunCardMap.get(sangGunCard)+1);
			}
		}
		cardCount = Integer.valueOf(br.readLine());
		String[] cards = new String[cardCount];
		cards = br.readLine().split(" ");
		for(String card : cards) {
			if(sangGunCardMap.get(card)==null) {
				sb.append("0 ");
			}
			else {
				sb.append(sangGunCardMap.get(card) + " ");
			}
		}
		System.out.print(sb);
	}
}
