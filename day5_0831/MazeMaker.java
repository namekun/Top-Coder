package day5_0831;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class MazeMaker {

	// 1. 현재 위치한 칸으로 부터, 다른 칸으로 이동할 수 있는 모든 경로를 찾는다.
	// 2. 각 칸에 몇번만에 이동해 왔는지를 적는다.
	// 3. 다른 칸에서부터 이동할 수 있는 모든 경로를 찾는다.
	// 4. 이때, 칸에 써있는 이동횟수가 이번 이동횟수보다 크면 이동횟수를 덮어 씌우고 계속 이동한다.
	// 5. 그렇지 않다면 이미 최소 이동거리가 구해진 것이므로, 다른 경로를 검사하도록 한다.

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

		// 시작점으로 초기화
		queueX.add(startCol);
		queueY.add(startRow);

		while (!queueX.isEmpty()) {
			int x = queueX.poll(), y = queueY.poll(); // x, y값 추출

			for (int i = 0; i < moveRow.length; i++) {

				// 다른 칸으로 이동할 수 있는 모든 경우의 수 추가.
				int nextX = x + moveCol[i];
				int nextY = y + moveRow[i];

				// if문안에 있는 조건을 만족시킨다면?
				if (0 <= nextX && nextY < width && 0 <= nextY && nextY < height && map[nextY][nextX] == -1
						&& maze[nextY].charAt(nextX) == '.') {
					map[nextY][nextX] = map[y][x] + 1; // board에서 nextX, nextY값을 0으로 바꿔준다. 다음에 갈꺼거든.

					// 큐에 더해준다.
					queueX.add(x);
					queueY.add(y);
				}
			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// maze배열에서 [i]번째에서 [j]번째 char가 . 이고, board의 원소가 -1이면
				if (maze[i].charAt(j) == '.' && map[i][j] == -1) {
					return -1; // -1을 리턴해준다.
				}
				max = Math.max(max, map[i][j]); // 아니라면, 그중에 가장 큰 값을 max로 넣어준다.
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
