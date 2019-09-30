//Solution: Find MaxColumn and Max Row
//	  Create gridNew from MaxColumn and MaxRow
//	  Find Difference and sum.

class Solution {
	public static int maxIncreaseKeepingSkyline(int [][] grid) {
		List<List<Integer>> gridAr = new ArrayList<List<Integer>>();
		for(int i = 0; i < grid.length; i++) {
			List<Integer> tmp = new ArrayList<>();
			for(int j = 0; j < grid[i].length; j++) {
				tmp.add(grid[i][j]);
			}
			gridAr.add(tmp);
		}
		int row = 0;
		int col = 0;
		int inc = 0;
		int sum = 0;
		int ind = 0;
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		ar1 = maxCol(grid);
		ar2 = maxRow(grid);
		List<List<Integer>> gridNewAr = new ArrayList<List<Integer>>();
		for (int i = 0; i < ar2.size(); i++) {
			List<Integer> tmp = new ArrayList<>();
			for(int j = 0; j < ar1.size(); j++) {
				tmp.add((ar1.get(j) < ar2.get(i))? ar1.get(j):ar2.get(i));
			}
			gridNewAr.add(tmp);
		}
		
		for (int i = 0; i < gridNewAr.size(); i++) {
			for(int j = 0; j < gridNewAr.get(i).size(); j++) {
				sum += Math.abs((gridNewAr.get(i).get(j) - gridAr.get(i).get(j)));
			}
		}
		
		
		return sum;
	}
	public static ArrayList maxCol(int [][] grid) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int col = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (col < grid[j][i]) {
					col = grid[j][i];
				}
			}
			ar.add(col);
			col = 0;
		}
		return ar;
	}
	public static ArrayList maxRow(int [][] grid) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int row = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (row < grid[i][j]) {
					row = grid[i][j];
				}
			}
			ar.add(row);
			row = 0;
		}
		return ar;
	}
}
