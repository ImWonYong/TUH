class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int m = 0;
        int n = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (n == mat[0].length) {
                    m++;
                    n = 0;
                }
                result[i][j] = mat[m][n];
                n++;
            }
        }

        return result;
    }
}