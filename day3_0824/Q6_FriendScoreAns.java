package day3_0824;

public class Q6_FriendScoreAns {

	public int highestScore(String[] friends) {
		int ans = 0;
		int n = friends[0].length();

		for (int i = 0; i < n; i++) {
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				// i 와 j가 같으면 계산해 줄 필요가 없다.
				if (i == j)
					continue;
				// i번째 원소를 charAt로 잘랐는데, 그것이 Y였다면
				// 직접 친구인 경우이다.
				if (friends[i].charAt(j) == 'Y') {
					// 카운팅
					cnt++;
				}
				// 직접 친구가 아닌 경우
				else {
					for (int k = 0; k < n; k++) {
						// i와 j 사이에 공통되는 사람 k가 1명이라도 있는지 조사한다.
						if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
							cnt++;
							break;
						}
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		return ans;
	}

	public static void main(String[] args) {
		Q6_FriendScoreAns sb = new Q6_FriendScoreAns();

		String[] as1 = { "NYY", "YNY", "YYN" };
		System.out.println(sb.highestScore(as1));
	}
}
