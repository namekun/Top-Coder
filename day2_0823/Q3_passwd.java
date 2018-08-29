package day2_0823;

import java.util.Arrays;

public class Q3_passwd {
	
	// 내 코드 더럽넹
	public long encrypt(int[] numbers) {
		long ans = 0;
		int[] gop = new int[] {1,1,1};

		for (int i = 0; i < numbers.length; i++) {
			int chNum = 0;
			chNum = numbers[i] + 1; // 기존의 값에 + 1을 해준다.

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
	
	// Top Coder 해설
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

	// Top Coder 응용 기술
	// 사실 그냥 증가치가 가장 큰것은 최소값에 + 1하는것.
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
