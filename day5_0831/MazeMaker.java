package day5_0831;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class MazeMaker {

	// 1. ���� ��ġ�� ĭ���� ����, �ٸ� ĭ���� �̵��� �� �ִ� ��� ��θ� ã�´�.
	// 2. �� ĭ�� ������� �̵��� �Դ����� ���´�.
	// 3. �ٸ� ĭ�������� �̵��� �� �ִ� ��� ��θ� ã�´�.
	// 4. �̶�, ĭ�� ���ִ� �̵�Ƚ���� �̹� �̵�Ƚ������ ũ�� �̵�Ƚ���� ���� ����� ��� �̵��Ѵ�.
	// 5. �׷��� �ʴٸ� �̹� �ּ� �̵��Ÿ��� ������ ���̹Ƿ�, �ٸ� ��θ� �˻��ϵ��� �Ѵ�.

	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {

		int max = 0;
		int width = maze[0].length();
		int height = maze.length;

		int[][] map = new int[width][height];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = -1;
			}
		}

		map[startRow][startCol] = 0;

		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();

		// ���������� �ʱ�ȭ
		queueX.add(startCol);
		queueY.add(startRow);

		while (!queueX.isEmpty()) {
			int x = queueX.poll(), y = queueY.poll(); // x, y�� ����

			for (int i = 0; i < moveRow.length; i++) {

				// �ٸ� ĭ���� �̵��� �� �ִ� ��� ����� �� �߰�.
				int nextX = x + moveCol[i];
				int nextY = y + moveRow[i];

				// if���ȿ� �ִ� ������ ������Ų�ٸ�?
				if (0 <= nextX && nextY < width && 0 <= nextY && nextY < height && map[nextY][nextX] == -1
						&& maze[nextY].charAt(nextX) == '.') {
					map[nextY][nextX] = map[y][x] + 1; // board���� nextX, nextY���� 0���� �ٲ��ش�. ������ �����ŵ�.

					// ť�� �����ش�.
					queueX.add(x);
					queueY.add(y);
				}
			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// maze�迭���� [i]��°���� [j]��° char�� . �̰�, board�� ���Ұ� -1�̸�
				if (maze[i].charAt(j) == '.' && map[i][j] == -1) {
					return -1; // -1�� �������ش�.
				}
				max = Math.max(max, map[i][j]); // �ƴ϶��, ���߿� ���� ū ���� max�� �־��ش�.
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] a = { "..." };

		int b = a[0].length();

		System.out.println(b);
	}
}
