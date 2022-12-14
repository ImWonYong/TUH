import java.io.*;
import java.util.StringTokenizer;

/*
    이것이 코딩 테스트다 p149 음료수 얼려먹기
 */

public class Main {
    static FastReader scan = new FastReader();

    // 정답은 sb에 append 를 사용해 출력
    // 만약 개행까지 출력하고 싶으면 append('\n')를 추가
    static StringBuilder sb = new StringBuilder();
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

    }

    static void input() {
        col = scan.nextInt();
        row = scan.nextInt();

        arr = new int[col][row];

        for (int i = 0; i < col; i++) {
            String s = scan.next();
            for (int j = 0; j < row; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
    }
    static  int col;
    static  int row;
    static int[][] arr;

    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean dfs(int n, int m) {
        if (n < 0 || n >= col || m < 0 || m >= row) {
            return false;
        }

        if (arr[n][m] == 1) {
            return false;
        }

        arr[n][m] = 1;

        for (int i = 0; i < 4; i++) {
            dfs(n + direction[i][0], m + direction[i][1]);
        }

        return true;
    }

    public static void main(String[] args) {
        input();
        int result = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (dfs(i, j) == true) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}