/**
 * https://www.lintcode.com/problem/663/ 
 */

public class Solution {

    private final static int[][] DIRECTIONS = {  
        {-1, 0},   // up
        {0, 1},    // right
        {1, 0},    // down
        {0, -1}    //  left
    };

    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final int INF = 2147483647;  // or a room
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        boolean[][] seen = new boolean[rooms.length][rooms[0].length];

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == GATE) DFS(rooms, i, j, seen, 0);
            }
        }
    }

    private void DFS(int[][] rooms, int row, int column, boolean[][] seen, int dis) {
        // Checking valid index
        if (row < 0 || column < 0 || row >= rooms.length || column >= rooms[0].length ||
            seen[row][column] || rooms[row][column] == WALL || rooms[row][column] < dis) return;

        seen[row][column] = true;
        rooms[row][column] = Math.min(dis, rooms[row][column]);

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = row + DIRECTIONS[i][0], 
                newColumn = column + DIRECTIONS[i][1];

            DFS(rooms, newRow, newColumn, seen, dis + 1);
        }

        seen[row][column] = false;
    }
}
