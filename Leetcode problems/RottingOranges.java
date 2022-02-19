class Solution {
    private final static int[][] DIRECTIONS = {  
        {-1, 0},   // up
        {0, 1},    // right
        {1, 0},    // down
        {0, -1}    //  left
    };
    
    public int orangesRotting(int[][] grid) {
        int numberOfFresh = 0, time = 0;
        int numberOfRaws = grid.length, numberOfColumns = grid[0].length;
        
        Queue<int[]> indices = new LinkedList<>();
        
        // Finding all rotten and adding them to the queue
        for (int i = 0; i < numberOfRaws; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (grid[i][j] ==  1) numberOfFresh++;
                else if (grid[i][j] ==  2) indices.add(new int[]{i, j});
            }
        }
        
        while (!indices.isEmpty()) {
            time++;
            int size = indices.size();
            
            // Searching in all four directions for all rotten 
            // oragnes in the queue
            while (size > 0) {
                numberOfFresh = BFS(grid, indices, numberOfFresh); 
                size--;
            }
        }
        
        if (numberOfFresh == 0) return Math.max(0, time - 1);
        else return -1;
    }
    
    private static int BFS(int[][] grid, Queue<int[]> indices, int numberOfFresh) {
        int numberOfRaws = grid.length, numberOfColumns = grid[0].length;
        
        int[] currentRotten = indices.remove();
        int rowIndex = currentRotten[0], columnIndex = currentRotten[1];
                
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRowIndex = rowIndex + DIRECTIONS[i][0],
            newColumnIndex = columnIndex + DIRECTIONS[i][1];
                    
            // Checking if any of the four directions is fresh
            if (newRowIndex < 0 || newColumnIndex < 0 ||
                newRowIndex >= numberOfRaws || 
                newColumnIndex >= numberOfColumns) continue;
            else if (grid[newRowIndex][newColumnIndex] == 1) {
                numberOfFresh--;
                grid[newRowIndex][newColumnIndex] = 2;
                indices.add(new int[]{newRowIndex, newColumnIndex});
            }
        }
        
        return numberOfFresh;
    }
}
