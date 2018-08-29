package day2_0823;

import java.util.ArrayList;
import java.util.Vector;

public class Q4_InterestingDigits {
	public int[] digits(int base) {
		ArrayList<Integer> v = new ArrayList<Integer>();

		// 4자리 미만의 수 이기에, 3번의 for문을 돌린다..
		for (int n = 2; n < base; n++) { // n의 배수가 맞는지 확인하기 위한 n을 정한다.
			boolean ok = true; // arraylist에 n을 추가하기 위해 만든 조건
			for (int k1 = 0; k1 < base; k1++) { // 첫번째 자리의 수
				for (int k2 = 0; k2 < base; k2++) { // 두번째 자리의 수
					for (int k3 = 0; k3 < base; k3++) { // 세번째 자리의 수
						if ((k1 + k2 * base + k3 * base * base) % n == 0 && (k1 + k2 + k3) % n != 0) {
							// n의 배수 숫자로 각 숫자의 합이 n의 배수가 아니면 n을 제외합니다.
							ok = false; // ok는 false로 만든다.
							break; // 반복문을 그만 돌립니다.
						}
					}
					if (!ok)
						break;
				}
				if (!ok)
					break;
			}
			if (ok) // 여기까지 왔는데 ok 가 true?
				v.add(n); // arraylist에 추가해줍니다.
		}

		int[] ans = new int[v.size()]; // arraylist v에 들어있는 객체의 수만큼 크기를 갖는 배열 ans를 만듭니다.
		for (int i = 0; i < v.size(); i++) {
			ans[i] = v.get(i); // 배열로 옮깁니다.
		}

		return ans;
	}
	
		public int[] digitsSimplever(int base) {
			// vector생성
			Vector<Integer> v = new Vector<Integer>();
			
			
			for (int i = 2; i < base; i++) {
				// 만약 base-1이 i로 나눠떨어진다면, i는 vector에 더해준다.
				if(((base-1) % i) == 0) v.add(i);
			}
			
			int [] ans = new int [v.size()];
			for(int i = 0; i< v.size(); i++) ans[i] = v.get(i);
			
			return ans;
		}

}
