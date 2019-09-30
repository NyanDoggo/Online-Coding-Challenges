
public class Solution {
	//Search the board for coordinate of target
	public static int[] findTarget (char[][] grid, char target){
		int[] result = new int[2];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	
	public static int[] moveUp(int[] currPos){
		currPos[0] = currPos[0] - 1;
		return currPos;
	}
	
	public static int[] moveDown(int[] currPos){
		currPos[0] = currPos[0] + 1;
		return currPos;
	}
	
	public static int[] moveLeft(int[] currPos){
		currPos[1] = currPos[1] - 1;
		return currPos;
	}
	
	public static int[] moveRight(int[] currPos){
		currPos[1] = currPos[1] + 1;
		return currPos;
	}
	
	public static int findHorizontalDiff(int[] currPos, int[] destination) {
		//Negative number means to the right
		//Positive number means to the left
		int diff = currPos[1] - destination[1]; 
		return diff;
	}
	
	public static int findVerticalDiff(int[] currPos, int[] destination) {
		//Negative number means go down
		//Positive number means go up
		int diff = currPos[0] - destination[0];
		return diff;
	}
	//Move from currPos to destination, printing path/action taken
	public static void moveTo(int[] currPos, int[] destination) {
		int verticalDiff = findVerticalDiff(currPos, destination);
		int horizontalDiff = findHorizontalDiff(currPos, destination);
		
		while (currPos[0] != destination[0]) {
			if (verticalDiff > 0) {
				currPos = moveUp(currPos);
				System.out.println("UP");
			}
			if (verticalDiff < 0) {
				currPos = moveDown(currPos);
				System.out.println("DOWN");
			}
		}
		
		while (currPos[1] != destination[1]) {
			if (horizontalDiff > 0) {
				currPos = moveLeft(currPos);
				System.out.println("LEFT");
			}
			if (horizontalDiff < 0) {
				currPos = moveRight(currPos);
				System.out.println("RIGHT");
			}
		}
	}
	//Driver function
	//Find position of starting location and destination, then proceed to move
	public static void displayPath(char[][] grid){
		int[] curr = findTarget(grid, 'm');
		int[] dest = findTarget(grid, 'p');
		moveTo(curr, dest);
	}
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
		displayPath(grid);
	}
}	
