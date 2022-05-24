package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CoordinateSore_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCount = 0;
		String[] coordinate = new String[2];
		totalCount = Integer.valueOf(br.readLine());
		List<Coordinate> coordinates = new ArrayList<>();
		for(int i=0; i<totalCount; i++) {
			coordinate = br.readLine().split(" ");
			coordinates.add(new Coordinate(Integer.valueOf(coordinate[0]), Integer.valueOf(coordinate[1])));
		}
		coordinates.sort(new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				// TODO Auto-generated method stub
				if(o1.getY()==o2.getY()) {
					return o1.getX() - o2.getX();
				}
				else {
					return o1.getY() - o2.getY();
				}
			}
		});
		for(Coordinate result : coordinates) {
			System.out.println(result.getX() + " " + result.getY());
		}
	}
}
class Coordinate {
	private int x;
	private int y;
	Coordinate(int x, int y) {
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

