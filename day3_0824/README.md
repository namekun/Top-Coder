# 180824-Topcoder-Day3

---

## Q6 Friend Score

* 생각한 것.
  * 첫번째 element를 charAt로 잘라서 새로운 배열에 넣는다.
  * 1번의 배열에서 Y에 해당하는 값에 index를 찾는다.
  * idx라는 2차원 배열에 map을 만들어준다.
  * 해당 행에서 1이 있다면 그 인덱스 번호에 해당하는 행으로 가서 1이 몇개 존재하는지 카운팅해준다.
  *  Math.max함수로 최대값을 비교해준다.
  * fin 값을 return

*Q6_FriendScore.java*

```java
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
					}// for end
				}
				fin = Math.max(fin, cnt);
			} // for_end

		}

		
		return fin;
	}

	public static void main(String[] args) {
		Q6_FriendScore fs = new Q6_FriendScore();

		String[] fr1 = { "NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN" };
		String[] fr2 = {"NYY", "YNY", "YYN"};
		System.out.println(fs.highestScore(fr2));
		System.out.println(fs.highestScore(fr1));
	}
}

```

* 잘못 생각했다.
* 전후의 1값을 카운트 해주면 안된다..

---

*Q6_FriendScore.java - 답안*

* 이 문제의 핵심은 아래의 경우로 표현이 가능하다
  * A-B가 직접 친구인 경우, 즉 friends\[A][B] == 'Y'인 경우 cnt ++
  * A-B가 직접 친구가 아닌 경우,
    * a. friends\[A][K] == 'Y' && friends\[B][K] == 'Y' 인 K가 1개라도 있으면 cnt ++

```java
package day3_0824;	

public class Q6_FriendScoreAns {
	
	public int highestScore(String[] friends) {
	int ans = 0;
	int n =  friends[0].length();
	
	for (int i = 0; i < n; i++) {
		int cnt = 0;
		
		for (int j = 0; j < n; j++) {
			if (i == j) continue;
			
			if(friends[i].charAt(j)=='Y') {
				cnt++;
			} else {
				for (int k = 0; k < n; k++) {
					if(friends[j].charAt(k)=='Y' && friends[k].charAt(i) == 'Y') {
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
		
		String [] as1 = {"NYY", "YNY","YYN"};
		System.out.println(sb.highestScore(as1));
	}
}
```

