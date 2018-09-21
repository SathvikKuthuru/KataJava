public class Snail {

	public static int[] snail(int[][] array) {
		int[] s = new int[array.length * array[0].length];
		int index = 0;
		boolean[][] visited = new boolean[array.length][array[0].length];
		int a = array.length;
		int b = array[0].length;
		int c = 0, d = 0;
		int x = 0;
		int y = 0;
		while (!isTrue(visited)) {
			while (x < b && !visited[y][x]) {
				s[index] = array[y][x];
				visited[y][x] = true;
				if (x == b - 1)
					break;
				x++;
				index++;
			}
			index++;
			b = x;
			y++;
			while (y < a && !visited[y][x]) {
				s[index] = array[y][x];
				visited[y][x] = true;
				if (y == a - 1)
					break;
				y++;
				index++;
			}
			index++;
			a = y;
			x--;
			while (x >= d && !visited[y][x]) {
				s[index] = array[y][x];
				visited[y][x] = true;
				if (x == d)
					break;
				x--;
				index++;
			}
			index++;
			d = x+1;
			y--;
			while (y > c && !visited[y][x]) {
				s[index] = array[y][x];
				visited[y][x] = true;
				if (y == c + 1)
					break;
				y--;
				index++;
			}
			index++;
			c = y;
			x++;
		}
		return s;
	}

	static boolean isTrue(boolean[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (!b[i][j])
					return false;
			}
		}
		return true;
	}
}
