class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][] edited = new boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !edited[i][j]) {
                    setColumnZeros(matrix, 0, j, edited);
                    setRowZeros(matrix, i, 0, edited);
                }
            }
        }
    }
    
    private static void setColumnZeros(int[][] matrix, int i, int j, boolean[][] edited) {
        if (i >= matrix.length) return;
        
        if (matrix[i][j] != 0) {
            edited[i][j] = true;
            matrix[i][j] = 0;
        }
        
        setColumnZeros(matrix, i + 1, j, edited);
    }
    
    private static void setRowZeros(int[][] matrix, int i, int j, boolean[][] edited) {
        if (j >= matrix[0].length) return;
        
        if (matrix[i][j] != 0) {
            edited[i][j] = true;
            matrix[i][j] = 0;
        }
        
        setRowZeros(matrix, i, j + 1, edited);
    }
}
