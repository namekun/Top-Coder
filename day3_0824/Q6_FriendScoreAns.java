package day3_0824;

public class Q6_FriendScoreAns {

	public int highestScore(String[] friends) {
		int ans = 0;
		int n = friends[0].length();

		for (int i = 0; i < n; i++) {
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				// i �� j�� ������ ����� �� �ʿ䰡 ����.
				if (i == j)
					continue;
				// i��° ���Ҹ� charAt�� �߶��µ�, �װ��� Y���ٸ�
				// ���� ģ���� ����̴�.
				if (friends[i].charAt(j) == 'Y') {
					// ī����
					cnt++;
				}
				// ���� ģ���� �ƴ� ���
				else {
					for (int k = 0; k < n; k++) {
						// i�� j ���̿� ����Ǵ� ��� k�� 1���̶� �ִ��� �����Ѵ�.
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
