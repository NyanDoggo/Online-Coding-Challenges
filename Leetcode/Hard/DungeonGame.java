public class DungeonGame { //Dynamic Programming
	public static int calculateMinimumHP(int [][] dungeon) {
		if (dungeon.length == 0 || dungeon[0].length == 0) {
			return 1;
		}
		int row = dungeon.length;
		int col = dungeon[0].length;
		int [][] matrix = new int [row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--){
				if (i == row - 1 && j == col - 1) {
					matrix[i][j] = -dungeon[i][j];
				}else if (j + 1 == col) {
					matrix[i][j] = -dungeon[i][j] + matrix[i + 1][j];
				}else if (i + 1 == row) {
					matrix[i][j] = -dungeon[i][j] + matrix[i][j + 1];
				}else {
					matrix[i][j] = -dungeon[i][j] + Math.min(matrix[i + 1][j], matrix[i][j + 1]);
				}
				if (matrix[i][j] < 0) {
					matrix[i][j] = 0;
				}
			}
		}			
		return matrix[0][0] + 1;
	}
	public static void main (String args[]) {
		int [][] grid = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		int res = calculateMinimumHP(grid);
		System.out.println(res);
	}
}
