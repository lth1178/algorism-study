package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Chicken_15686{
	static int result = 10000;
	static int newChickenStoreCount = 0;
	static List<Coordinate> chickenStore = new ArrayList<>();
	static List<Coordinate> home = new ArrayList<>();
	static Stack<Coordinate> newChickenStore = new Stack<Coordinate>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int villagySize = 0;
		StringTokenizer request = new StringTokenizer(br.readLine());
		villagySize = Integer.valueOf(request.nextToken());
		newChickenStoreCount = Integer.valueOf(request.nextToken());

		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
		for(int i=0; i<villagySize; i++) {
			request = new StringTokenizer(br.readLine());
			for(int j=0; j<villagySize; j++) { 
				String data = request.nextToken();
				if(data.equals("1")) {
					Coordinate homeData = new Coordinate(j, i);
					home.add(homeData);
				} else if(data.equals("2")) {
					Coordinate chickenStoreData = new Coordinate(j, i);
					chickenStore.add(chickenStoreData);
				}
			}
		}
		dfs(0, 0); 
		System.out.println(result);
	}
	
	/* dfs�˰����� �̿��� ������ ġŲ �Ÿ� ���ϱ� �Լ� */
	public static void dfs(int depth, int start) {
		/* �־��� ġŲ���� �� �϶� ġŲ�Ÿ� */
		if(depth == newChickenStoreCount) {
			int cityDist = calculate();
			result = Math.min(result, cityDist);
		}
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		for(int i=start; i<chickenStore.size(); i++) {
			newChickenStore.push(chickenStore.get(i));
			dfs(depth +1, i +1);
			newChickenStore.pop();
		}
	}
	public static int calculate() {
		int sumOfShortestPath = 0;
		/* ��� ���� ���� ġŲ�Ÿ�(shortestPath)�� ���� �� ���� ������ ġŲ �Ÿ�(sumOfShortestPath)�� ���Ѵ� */
		for(int j=0; j<home.size(); j++) {
			Coordinate nowHouse = home.get(j);
			int shortestPath = 100;
			for(int i = 0; i < newChickenStore.size(); i++) {
				Coordinate nowChicken = newChickenStore.get(i);
				shortestPath = Math.min(shortestPath, Math.abs(nowChicken.getX() - nowHouse.getX()) 
													+ Math.abs(nowChicken.getY() - nowHouse.getY()));
			}
			sumOfShortestPath += shortestPath;
		}
		return sumOfShortestPath;
	}
}
/* ��ǥ Ŭ���� */
//�ٸ� ���Ͽ� ����� ä�� �� �ּ� ���� ���
class Coordinate {
	private int x;
	private int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
