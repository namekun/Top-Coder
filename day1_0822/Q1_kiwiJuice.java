package day1_0822;

public class Q1_kiwiJuice {

	/**
	 * ���ǹ��� ���� �̿��� ���
	 * 
	 * @param capacities
	 *            2-50���� ��Ұ� �ִ� �迭, �� ��Ҵ� 1~1000000 ������ ���� ���´�.
	 * @param bottles
	 *            capacities�� ���� ���� ��Ұ� �ִ� �迭. bottles[i]�� capacities[i]�� �� �ִ� �ֽ���
	 *            �ǹ��մϴ�.
	 * @param fromId
	 *            1~50���� ��Ұ� �ִ� �迭�̴�.
	 * @param toId
	 *            fromId�� ���� ���� ��Ұ� �ִ� �迭�Դϴ�.
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
	 * Math�� �ּҰ� �Լ� min�� ����ϴ� ���
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
