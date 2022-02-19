/**
 * https://leetcode.com/problems/number-of-islands/
 */

class Solution {
    private final static int[][] DIRECTIONS = {  
        {-1, 0},   // up
        {0, 1},    // right
        {1, 0},    // down
        {0, -1}    //  left
    };
    
    private static void BFS(int i, int j, char[][] grid, boolean[][] seen) {
        int numberOfRaws = grid.length, 
            numberOfColumns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                int[] currentIndices = queue.remove();
                int rowIndex = currentIndices[0], columnIndex = currentIndices[1];
                
                for (int k = 0; k < DIRECTIONS.length; k++) {
                    int newRowIndex = rowIndex + DIRECTIONS[k][0],
                        newColumnIndex = columnIndex + DIRECTIONS[k][1];
                    
                    if (newRowIndex < 0 || newColumnIndex < 0 ||
                        newRowIndex >= numberOfRaws || 
                        newColumnIndex >= numberOfColumns ||
                        seen[newRowIndex][newColumnIndex] ||
                        grid[newRowIndex][newColumnIndex] == '0') continue;
                    
                    seen[newRowIndex][newColumnIndex] = true;
                    queue.add(new int[] {newRowIndex, newColumnIndex});
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int numberOfRaws = grid.length, 
            numberOfColumns = grid[0].length,
            numberOfIslands = 0;
        
        // This will hold which lands ('1') we have seen
        boolean[][] seen = new boolean[numberOfRaws][numberOfColumns];
        
        for (int i = 0; i < numberOfRaws; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    BFS(i, j, grid, seen);
                    numberOfIslands++;
                }
            }
        }
        
        return numberOfIslands;
    }
}
