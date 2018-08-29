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

				// Y가 있으면 1로 셋팅
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

			// 이제 친구가 몇명인지 세보자
			// 인덱스의 앞뒤번호를 갖는 아이가 y를 몇개 갖는지 구해서
			// 더해주면 가운데 아이가 친구가 몇명인지 알 수 있더라
			// Y일때 전후로 카운트만 해주면되는거 아닌가? -> X 틀린생각이다.

			for (int k = 0; k < idx[0].length; k++) {
				int cnt = 0;
				if (idx[i][k] == 1) { // 해당값이 1이라면
					for (int j = 0; j < idx[0].length; j++) { // 다시 그 인덱스 순서의 열로 가서 1의 개수를 세어준다..
						if (idx[k][j] == 1) { // 여기서 거부가 되어서 cnt가 세어지지 않는다.
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
