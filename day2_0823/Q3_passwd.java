package day2_0823;

import java.util.Arrays;

public class Q3_passwd {
	
	// �� �ڵ� ������
	public long encrypt(int[] numbers) {
		long ans = 0;
		int[] gop = new int[] {1,1,1};

		for (int i = 0; i < numbers.length; i++) {
			int chNum = 0;
			chNum = numbers[i] + 1; // ������ ���� + 1�� ���ش�.

			for (int j = 0; j < numbers.length; j++) {
				gop[i] *= numbers[j];
			}
			
			gop[i] /= numbers[i];
			gop[i] *= chNum;
		}

		for (int i : gop) {
			ans = Math.max(ans, i);
		}

		return ans;
	}
	
	// Top Coder �ؼ�
	public long encryptAns1(int []numbers) {
		long ans = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			long temp = 1;
			for (int j = 0; j < numbers.length; j++) {
				if(i == j) {
					temp *= (numbers[j] + 1);
				} else {
					temp *= numbers[j];
				}
			}
			ans = Math.max(ans, temp);
		}
		return ans;
	}

	// Top Coder ���� ���
	// ��� �׳� ����ġ�� ���� ū���� �ּҰ��� + 1�ϴ°�.
	public long encryptAns2(int []numbers) {
		long ret = 0;
		Arrays.sort(numbers);
		numbers[0]++;
		for (int i : numbers) {
			ret *= i;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Q3_passwd pw = new Q3_passwd();
		int [] num = {2,4,6};
		System.out.println(pw.encrypt(num));
	}
}
