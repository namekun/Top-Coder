package day2_0823;

import java.util.ArrayList;
import java.util.Vector;

public class Q4_InterestingDigits {
	public int[] digits(int base) {
		ArrayList<Integer> v = new ArrayList<Integer>();

		// 4�ڸ� �̸��� �� �̱⿡, 3���� for���� ������..
		for (int n = 2; n < base; n++) { // n�� ����� �´��� Ȯ���ϱ� ���� n�� ���Ѵ�.
			boolean ok = true; // arraylist�� n�� �߰��ϱ� ���� ���� ����
			for (int k1 = 0; k1 < base; k1++) { // ù��° �ڸ��� ��
				for (int k2 = 0; k2 < base; k2++) { // �ι�° �ڸ��� ��
					for (int k3 = 0; k3 < base; k3++) { // ����° �ڸ��� ��
						if ((k1 + k2 * base + k3 * base * base) % n == 0 && (k1 + k2 + k3) % n != 0) {
							// n�� ��� ���ڷ� �� ������ ���� n�� ����� �ƴϸ� n�� �����մϴ�.
							ok = false; // ok�� false�� �����.
							break; // �ݺ����� �׸� �����ϴ�.
						}
					}
					if (!ok)
						break;
				}
				if (!ok)
					break;
			}
			if (ok) // ������� �Դµ� ok �� true?
				v.add(n); // arraylist�� �߰����ݴϴ�.
		}

		int[] ans = new int[v.size()]; // arraylist v�� ����ִ� ��ü�� ����ŭ ũ�⸦ ���� �迭 ans�� ����ϴ�.
		for (int i = 0; i < v.size(); i++) {
			ans[i] = v.get(i); // �迭�� �ű�ϴ�.
		}

		return ans;
	}
	
		public int[] digitsSimplever(int base) {
			// vector����
			Vector<Integer> v = new Vector<Integer>();
			
			
			for (int i = 2; i < base; i++) {
				// ���� base-1�� i�� �����������ٸ�, i�� vector�� �����ش�.
				if(((base-1) % i) == 0) v.add(i);
			}
			
			int [] ans = new int [v.size()];
			for(int i = 0; i< v.size(); i++) ans[i] = v.get(i);
			
			return ans;
		}

}
