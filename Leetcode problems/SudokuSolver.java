class Solution {
    public void solveSudoku(char[][] board) {
        // if rows[i][num] == true, it means that the i-th row have the num
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        
        // Initalizing default values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                
                int num = Character.getNumericValue(board[i][j]);
                rows[i][num] = true;
                columns[j][num] = true;
                boxes[getBoxID(i, j)][num] = true;
            }
        }
        
        solve(board, boxes, rows, columns);
    }
    
    private boolean solve(char[][] board, boolean[][] boxes, boolean[][] rows,  
            boolean[][] columns) {
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                
                for (char c = '1'; c <= '9'; c++) {
                    board[i][j] = c;
                    int num = Character.getNumericValue(c);
                    if (valid(boxes, rows, columns, i, j, num)) {
                        rows[i][num] = true;
                        columns[j][num] = true;
                        boxes[getBoxID(i, j)][num] = true;
                        if (solve(board, boxes, rows, columns)) return true;
                        else {
                            rows[i][num] = false;
                            columns[j][num] = false;
                            boxes[getBoxID(i, j)][num] = false;
                        }
                    }
                }
                
                board[i][j] = '.';
                return false;
            }
        }
        
        return true;
    }
    
    private boolean valid(boolean[][] boxes, boolean[][] rows, 
            boolean[][] columns, int row, int column, int num) {
        if (rows[row][num] || columns[column][num] ||
                boxes[getBoxID(row, column)][num])
            return false;
        return true;
    }
    
    private int getBoxID(int row, int column) {
        int boxRow = (row / 3) * 3;
        int boxColumn = (column / 3);
        
        return boxRow + boxColumn;
    }
}


