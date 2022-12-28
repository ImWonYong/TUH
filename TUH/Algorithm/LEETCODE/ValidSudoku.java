class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board[i])) {
                return false;
            }
        }

        if (!isValidCol(board)) {
            return false;
        }

        return isValidSubArray(board);
    }

    public boolean isValidSubArray(char[][] board) {
        int subArrIndex = 0;
        boolean[][] checkBoard = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int subRow = i / 3;
                int subCol = j / 3;

                int subArrayIndex = (subRow * 3) + subCol;
                if (checkBoard[subArrayIndex][num] == true) {
                    return false;
                } else {
                    checkBoard[subArrayIndex][num] = true;
                }

            }
        }

        return true;
    }

    public boolean isValidCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Boolean> map = new HashMap<>();

            for (int j= 0; j < 9; j++) {
                if (board[j][i] != '.' && map.containsKey(board[j][i])) {
                    return false;
                } else {
                    map.put(board[j][i], true);
                }
            }
        }

        return true;
    }

    public boolean isValidRow(char[] row) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            if (row[i] != '.' && map.containsKey(row[i])) {
                return false;
            } else {
                map.put(row[i], true);
            }
        }

        return true;
    }
}