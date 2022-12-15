import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
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
                arr[i][j] = s.charAt(j) - '0';
            }
        }
    }
    static  int col;
    static  int row;
    static int[][] arr;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int bfs(int x, int y ) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }


        return arr[col - 1][row - 1];
    }

    public static void main(String[] args) {
        input();

        System.out.println(bfs(0, 0));

    }
}