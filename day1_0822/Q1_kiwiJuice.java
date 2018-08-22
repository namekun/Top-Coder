package day1_0822;

public class Q1_kiwiJuice {

	/**
	 * 조건문을 많이 이용한 경우
	 * 
	 * @param capacities
	 *            2-50개의 요소가 있는 배열, 각 요소는 1~1000000 사이의 값을 갖는다.
	 * @param bottles
	 *            capacities와 같은 수의 요소가 있는 배열. bottles[i]는 capacities[i]에 들어가 있는 주스를
	 *            의미합니다.
	 * @param fromId
	 *            1~50개의 요소가 있는 배열이다.
	 * @param toId
	 *            fromId와 같은 수의 요소가 있는 배열입니다.
	 * @return
	 */
//	 public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[]
//	 toId) {
//	
//	 for (int i = 0; i < fromId.length; i++) {
//	 int f = fromId[i];
//	 int t = toId[i];
//	 int space = capacities[i] - bottles[i];
//	
//	 if(space>= f) {
//	 int tmp = bottles[f];
//	 bottles[t] += tmp;
//	 bottles[f] = 0;
//	 } else {
//	 int tmp = space;
//	 bottles[t] += tmp;
//	 bottles[f] -= tmp;
//	 }
//	 }
//	 return bottles;
//	
//	 }

	/**
	 * Math의 최소값 함수 min을 사용하는 경우
	 * 
	 * @param capacities
	 * @param bottles
	 * @param fromId
	 * @param toId
	 * @return
	 */
//	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
//
//		for (int i = 0; i < fromId.length; i++) {
//			int from = fromId[i];
//			int to = toId[i];
//
//			int tmp = Math.min(bottles[from], capacities[to] - bottles[to]);
//			
//			bottles[from] -= tmp;
//			bottles[to] += tmp;
//		}
//		return bottles;
//	}

	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		
		for (int i = 0; i < fromId.length; i++) {
			
			int sum = bottles[fromId[i]] + bottles[toId[i]];
			
			bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
			bottles[fromId[i]] = sum - bottles[toId[i]];
			
		}
		return bottles;
	}

}
