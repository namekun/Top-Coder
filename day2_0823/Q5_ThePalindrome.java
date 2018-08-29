package day2_0823;

public class Q5_ThePalindrome {
	public int find(String s) {

		for (int i = s.length();; i++) {
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				// 반대쪽에 문자가 존재하는데, 다를 경우 플래그를 변경한다.
				// 길이 - j - 1이 s의 길이보다 적고, j번째 문자와 i-j-1번째 문자와 다르다면 
				if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			// 조건을 모두 만족하면 답을 리턴합니다.
			if (flag)
				return i;
		}
	}

	public static void main(String[] args) {
		String s = "abba";
		Q5_ThePalindrome pa = new Q5_ThePalindrome();
		System.out.println(pa.find(s));
	}
}
