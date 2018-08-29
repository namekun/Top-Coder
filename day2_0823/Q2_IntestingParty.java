package day2_0823;

import java.util.HashMap;

public class Q2_IntestingParty {
	public int bestInvitation(String[] first, String[] second) {
		int ans = 0;

		for (int i = 0; i < first.length; i++) {
			int fir = 0;
			int sec = 0;
			for (int j = 0; j < second.length; j++) {
				if (first[i].equals(first[j]))
					fir++;
				if (first[i].equals(second[j]))
					sec++;
				if (second[i].equals(first[j]))
					fir++;
				if (second[i].equals(second[j]))
					sec++;
			}

			ans = Math.max(ans, fir);
			ans = Math.max(ans, sec);
		}

		return ans;
	}
	
	public int bestInvitationUseHashMap(String[] first, String[] second) {
		
		//HashMap 선언
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//map에 값들을 집어넣는다. 값은 0으로 초기화
		for (int i = 0; i < first.length; i++) {
			map.put(first[i], 0);
			map.put(second[i], 0); 
		}
		
		// put(k, v) = k값에 해당하는 값을 찾아 해당하는 value값을 넣어준다.
		for (int i = 0; i < first.length; i++) {
			map.put(first[i], map.get(first[i]) + 1);
			map.put(second[i], map.get(second[i]) + 1);
		}
		
		int ans = 0;
		for (String key : map.keySet()) {
			ans = Math.max(ans, map.get(key));
		}
		
		return ans;
	}
}
