package day4_0829;

public class Q8_CrazyBot {

	boolean[][] grid = new boolean[100][100];
	
	// east, west, south, north�� ���� ���� ��ǥ��ȭ.
	int vx[] = { 1, -1, 0, 0 }; 
	int vy[] = { 0, 0, 1, -1 };

	double[] prob = new double[4];

	public double getProbability(int n, int east, int west, int south, int north) {
		
		// �� �������� �� Ȯ���� �������ش�.
		prob[0] = east / 100;
		prob[1] = west / 100;
		prob[2] = south / 100;
		prob[3] = north / 100;

		// �� ����� (50, 50)���� �����Ѵ�.
		return dfs(50, 50, n); 
	}

	double dfs(int x, int y, int n) {
		if (grid[x][y])
			return 0; // grid[x][y]�� true�� �̹� Ž���� �� ���̴�.
		if (n == 0)
			return 1; // �����̴� Ƚ�� 0�̸� Ȯ���� ������ 1. ������ Ȯ���� �����ϱ�

		grid[x][y] = true; // �湮�� ������ true��
		double ret = 0; // ������ Ȯ�� �ʱ�ȭ
		for (int i = 0; i < 4; i++) {
			// east, west, south, north ������ �κ��� �����δ�. �׸��� ���� �켱 Ž���� �Ͽ�, �� Ȯ������ ��� �����ش�.
			ret += dfs(x + vx[i], y + vy[i], n - 1);
		}

		// grid[x][y] = false�� �ϴ� �κ��� ������ Ž���� �����ϸ� ������ �κ��̴�. 
		// ��, ���� Ž���� �ϰ��� ��ũ�ߴ� ���� �����ϰ� �ʱ���·� �ǵ����� ��.
		grid[x][y] = false;
		
		
		return ret;

	}

	public static void main(String[] args) {

	}

}
