package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import algorithm.Sort;

public class InputType {
//���ڿ� �Է�
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	String str = ""; str = br.readLine();
	 
    
    //��ü�Է� ����
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	String str = ""; String tmp = ""; 
//	while((tmp = bf.readLine())!= null){ 
//		str += tmp + "\n"; 
//	}
	 
    
    //���� �Է�
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//	int a; 
//	a = Integer.parseInt(br.readLine());
	 
    
    //�������� �ѱ��ھ� �ԷµǴ� ���
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//	int [] targetArray = new int[100]; 
//	st = new StringTokenizer(sc.readLine()," ");
//	for(int i = 0 ; i < M ; i++){ 
//		targetArray[i] =Integer.parseInt(st.nextToken()); 
//	}
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] numbers = new int[N];
		for(int i = 0; i<N;i++) {
			numbers[i] = Integer.valueOf(br.readLine());
		}
		Sort sort = new Sort(); 
		sort.quickSort(numbers);
		for(int number:numbers) {
			System.out.println(number);
		}
	}

}
