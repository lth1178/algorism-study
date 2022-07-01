package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//일단 넣고 체크하는 방향으로 바꿔야 한다.
public class Sudoku_2580 {
	static final int sudoku_SIZE = 9;
	static List<Coordinate> blanks = new LinkedList<Coordinate>();
	static String [][] sudoku = new String[sudoku_SIZE][sudoku_SIZE];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<sudoku_SIZE; i++) {
			sudoku[i] = br.readLine().split(" ");
			for(int j=0; j<sudoku_SIZE; j++) {
				if(sudoku[i][j].equals("0")) {
					blanks.add(new Coordinate(j, i));
				}
			}
		}
		dfs(0);
		
	}
	static void dfs(int blankIndex) {
		if(blankIndex == blanks.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<sudoku_SIZE; i++) {
				for(int j=0; j<sudoku_SIZE; j++) {
					
					if(j==sudoku_SIZE-1) {
						sb.append(sudoku[i][j] + "\n");
					} else {
						sb.append(sudoku[i][j] + " ");
					}
				}
				
			}
			System.out.print(sb);
			System.exit(0);
			return;
		}
		while(blankIndex != blanks.size()) {
			Coordinate storeBlank = blanks.get(blankIndex);
			int storeVlaue = Integer.valueOf(sudoku[storeBlank.getY()][storeBlank.getX()]); 
			
			for(int i = storeVlaue + 1; i<10; i++) {
				if(fillBlank(storeBlank, i)) {
					sudoku[storeBlank.getY()][storeBlank.getX()] = String.valueOf(i);
					dfs(blankIndex + 1);
				}
			}
			sudoku[storeBlank.getY()][storeBlank.getX()] = String.valueOf(0);
			dfs(blankIndex-1);
			
		}
		
	}
	
	static boolean fillBlank(Coordinate storeBlank, int blankValue) {
		
		//가로
		for(int x=0; x<sudoku_SIZE; x++) {
			if(sudoku[storeBlank.getY()][x].equals(String.valueOf(blankValue))) {
				return false;
			}
		}
		
		//세로
		for(int y=0; y<sudoku_SIZE; y++) {
			if(sudoku[y][storeBlank.getX()].equals(String.valueOf(blankValue))) {
				return false;
			}
		}
		//3 *3 박스
		int yStart = storeBlank.getY()/3 * 3;
		int xStart = storeBlank.getX()/3 * 3;
		for(int y=yStart; y<yStart + 3; y++) {
			for(int x=xStart; x<xStart + 3; x++) {
				if(sudoku[y][x].equals(String.valueOf(blankValue))) {
					return false;
				}
			}
		}	
		return true;
	}
	
}
