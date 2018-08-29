package day2_0823;

public class Q5_ThePalindrome {
	public int find(String s) {

		for (int i = s.length();; i++) {
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				// �ݴ��ʿ� ���ڰ� �����ϴµ�, �ٸ� ��� �÷��׸� �����Ѵ�.
				// ���� - j - 1�� s�� ���̺��� ����, j��° ���ڿ� i-j-1��° ���ڿ� �ٸ��ٸ� 
				if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			// ������ ��� �����ϸ� ���� �����մϴ�.
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
