import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 2D-arrays/matrices traversal
public class MatricesTraversal {
    // [row change, column change]
    private final static int[][] DIRECTIONS = {  
        {-1, 0},   // up
        {0, 1},    // right
        {1, 0},    // down
        {0, -1}    //  left
    };

    public static ArrayList<Integer> DFS(int[][] vals, int startRow,
            int startColumn) {
        int numberOfRaws = vals.length,
            numberOfColumns = vals[0].length;

        boolean[][] seen = new boolean[numberOfRaws][numberOfColumns];
        ArrayList<Integer> values = new ArrayList<>();

        DFSHelper(vals, seen, values, startRow, startColumn);
        return values;
    }

    private static void DFSHelper(int[][] vals, boolean[][] seen,
            ArrayList<Integer> values, int rowIndex, int columnIndex) {

        if (rowIndex < 0 || columnIndex < 0 || rowIndex >= vals.length
                || columnIndex >= vals[0].length ||
                seen[rowIndex][columnIndex]) return;

        seen[rowIndex][columnIndex] = true;
        values.add(vals[rowIndex][columnIndex]);

        // Traversaling
        for (int i = 0; i < DIRECTIONS.length; i++) {
            DFSHelper(vals, seen, values, rowIndex + DIRECTIONS[i][0],
                    columnIndex + DIRECTIONS[i][1]);
        }
    }

    public static ArrayList<Integer> BFS(int[][] vals, int startRow,
            int startColumn) {
        ArrayList<Integer> values = new ArrayList<>();
        Queue<Integer[]> queue = new LinkedList<>();  // {row, column}

        int numberOfRaws = vals.length,
            numberOfColumns = vals[0].length;
        boolean[][] seen = new boolean[numberOfRaws][numberOfColumns];

        queue.add(new Integer[]{startRow, startColumn});

        while (!queue.isEmpty()) {
            Integer[] currentIndices = queue.remove();
            int rowIndex = currentIndices[0], columnIndex = currentIndices[1];
            if (seen[rowIndex][columnIndex]) continue;

            seen[rowIndex][columnIndex] = true;
            values.add(vals[rowIndex][columnIndex]);

            // Traversaling
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int newRowIndex = rowIndex + DIRECTIONS[i][0],
                    newColumnIndex = columnIndex + DIRECTIONS[i][1];

                if (newRowIndex < 0 || newColumnIndex < 0 ||
                        newRowIndex >= numberOfRaws || 
                        newColumnIndex >= numberOfColumns ||
                        seen[newRowIndex][newColumnIndex]) continue;
                queue.add(new Integer[]{newRowIndex, newColumnIndex});
            }
        }

        return values;
    }
}
