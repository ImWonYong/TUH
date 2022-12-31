class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        int x = 0, y = 0;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        int[] count = {0};
        grid[x][y] = -1;
        dfs(grid, x, y, count);

        return count[0];
    }

    public void dfs(int[][] grid, int x, int y, int[] count) {

        if (grid[x][y] == 2) {
            grid[x][y] = -1;
            boolean isCountable = true;
            for (int i = 0; i < grid.length; i++) {
                if (isCountable) {
                    for (int j= 0; j < grid[0].length; j++) {
                        if (grid[i][j] != -1) {
                            isCountable = false;
                        }
                    }
                } else {
                    break;
                }
            }

            if (isCountable) count[0]++;
            grid[x][y] = 2;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }

            if (grid[nx][ny] == 2) {
                dfs(grid, nx, ny, count);
            }

            if (grid[nx][ny] == 0) {
                grid[nx][ny] = -1;
                dfs(grid, nx, ny, count);
                grid[nx][ny] = 0;
            }
        }
    }
}