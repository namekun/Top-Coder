package day4_0829;

public class Q8_CrazyBot {

	boolean[][] grid = new boolean[100][100];
	
	// east, west, south, north로 갔을 때의 좌표변화.
	int vx[] = { 1, -1, 0, 0 }; 
	int vy[] = { 0, 0, 1, -1 };

	double[] prob = new double[4];

	public double getProbability(int n, int east, int west, int south, int north) {
		
		// 각 방향으로 갈 확률을 저장해준다.
		prob[0] = east / 100;
		prob[1] = west / 100;
		prob[2] = south / 100;
		prob[3] = north / 100;

		// 한 가운데인 (50, 50)에서 시작한다.
		return dfs(50, 50, n); 
	}

	double dfs(int x, int y, int n) {
		if (grid[x][y])
			return 0; // grid[x][y]가 true면 이미 탐색이 된 것이다.
		if (n == 0)
			return 1; // 움직이는 횟수 0이면 확률은 무조건 1. 실패할 확률도 없으니까

		grid[x][y] = true; // 방문한 지점은 true로
		double ret = 0; // 성공할 확률 초기화
		for (int i = 0; i < 4; i++) {
			// east, west, south, north 순서로 로봇을 움직인다. 그리고 깊이 우선 탐색을 하여, 그 확률들을 모두 더해준다.
			ret += dfs(x + vx[i], y + vy[i], n - 1);
		}

		// grid[x][y] = false를 하는 부분은 현재의 탐색을 종료하며 나오는 부분이다. 
		// 즉, 다음 탐색을 하고자 마크했던 것을 제거하고 초기상태로 되돌리는 것.
		grid[x][y] = false;
		
		
		return ret;

	}

	public static void main(String[] args) {

	}

}
