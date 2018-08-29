package day3_0824;

import java.util.ArrayList;

public class Q6_FriendScore {
	public int highestScore(String[] friends) {

		int[] ans = new int[friends.length];
		int fin = 0;
		// ArrayList<Character> ch = new ArrayList<Character>();
		int[][] idx = new int[friends[0].length()][friends[0].length()];

		for (int i = 0; i < friends.length; i++) {
			for (int j = 0; j < friends[0].length(); j++) {
				// ch.add(friends[i].charAt(j));
				if (i == j)
					continue;

				// Y�� ������ 1�� ����
				if (friends[i].charAt(j) == 'Y') {
					// System.out.println(friends[i].charAt(j));
					// System.out.println(i);
					// System.out.println(j);
					idx[i][j] = 1;
				}

			}
		} // for_end

		for (int i = 0; i < idx.length; i++) {
			for (int j = 0; j < idx.length; j++) {
				System.out.print(idx[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < friends.length; i++) {

			// ���� ģ���� ������� ������
			// �ε����� �յڹ�ȣ�� ���� ���̰� y�� � ������ ���ؼ�
			// �����ָ� ��� ���̰� ģ���� ������� �� �� �ִ���
			// Y�϶� ���ķ� ī��Ʈ�� ���ָ�Ǵ°� �ƴѰ�? -> X Ʋ�������̴�.

			for (int k = 0; k < idx[0].length; k++) {
				int cnt = 0;
				if (idx[i][k] == 1) { // �ش簪�� 1�̶��
					for (int j = 0; j < idx[0].length; j++) { // �ٽ� �� �ε��� ������ ���� ���� 1�� ������ �����ش�..
						if (idx[k][j] == 1) { // ���⼭ �źΰ� �Ǿ cnt�� �������� �ʴ´�.
							cnt++;
						}
					} // for end
				}
				fin = Math.max(fin, cnt);
			} // for_end

		}

		return fin;
	}

	public static void main(String[] args) {
		Q6_FriendScore fs = new Q6_FriendScore();

		String[] fr1 = { "NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN" };
		String[] fr2 = { "NYY", "YNY", "YYN" };
		System.out.println(fs.highestScore(fr2));
		System.out.println(fs.highestScore(fr1));
	}
}
