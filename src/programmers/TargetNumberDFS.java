package programmers;


/*n���� ���� �ƴ� �������� �ֽ��ϴ�. �� �������� ������ �ٲ��� �ʰ� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�. ���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־��� �� ���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�־����� ������ ������ 2�� �̻� 20�� �����Դϴ�.
�� ���ڴ� 1 �̻� 50 ������ �ڿ����Դϴ�.
Ÿ�� �ѹ��� 1 �̻� 1000 ������ �ڿ����Դϴ�.
����� ��
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
����� �� ����
����� �� #1

���� ���ÿ� �����ϴ�.

����� �� #2

+4+1-2+1 = 4
+4-1+2-1 = 4
�� 2���� ����� �����Ƿ�, 2�� return �մϴ�.*/

public class TargetNumberDFS {
	static int result = 0;

	private static void setNumbers(int depth, int []numbers, int target) {	
		int sum = 0;
		//������ ����� ��ȯ
		for(int j=0; j<2; j++) {
			if(j==1) {
				numbers[depth] = numbers[depth]*-1; 
			}
			if(depth == numbers.length-1) {
				for(int number : numbers) {
					sum += number;
				}
				if(sum==target) {
					result++;
				}
				sum = 0;
			}
			else {
				setNumbers(depth+1, numbers, target);
			}

		}
	}
	public static void main(String[] args) {
		int [] numbers = {4, 1, 2, 1};
		int target = 4;
		
		setNumbers(0, numbers, target);
		System.out.println(result);
		
	}
}
