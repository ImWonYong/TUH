class Solution {
    int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int col = click[0];
        int row = click[1];
        
        if (board[col][row] == 'M') {
            board[col][row] = 'X';
            return board;
        }
        
        dfs(row, col, board);
        
        return board;
    }
    
    public void dfs(int row, int col, char[][] board) {
        int num = countMine(row, col, board);
        
        if (num != 0) {
            board[col][row] = (char) ('0' + num);
        } else {
            board[col][row] = 'B';
            
            for (int i = 0; i < 8; i++) {
                int nRow = row + dir[i][0];
                int nCol = col + dir[i][1];
                
                if (nRow < 0 || nRow >= board[0].length || nCol < 0 || nCol >= board.length || board[nCol][nRow] != 'E') {
                    continue;
                }
                
                dfs(nRow, nCol, board);
            }
        }
    }
    
    public int countMine(int row, int col, char[][] board) {
        int num = 0;
        
        for (int i = 0; i < 8; i++) {
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];
            
            if (nRow < 0 || nRow >= board[0].length || nCol < 0 || nCol >= board.length) {
                    continue;
            }
            
            if (board[nCol][nRow] == 'M') {
                num++;
            }
        }
        
        return num;
    }
}