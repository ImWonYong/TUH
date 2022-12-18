import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus implements Comparable<Virus>{
    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSecond() {
        return this.second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Virus o) {
        if (this.index < o.index) {
            return -1;
        }

        return 1;
    }
}

class Main {

    static int n, k;
    static int s, x, y;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int[][] tube;

    static ArrayList<Virus> viruses = new ArrayList<>();

    public static void main(String[] args) {
        input();
        Collections.sort(viruses);

        Queue<Virus> q = new LinkedList<>();
        for (Virus virus : viruses) {
            q.offer(virus);
        }

        while (!q.isEmpty()) {
            Virus virus = q.poll();

            if (virus.getSecond() == s) break;

            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + direction[i][0];
                int ny = virus.getY() + direction[i][1];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (tube[nx][ny] == 0) {
                        tube[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(tube[x - 1][y - 1]);
    }

    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();

        tube = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tube[i][j] = scan.nextInt();

                if (tube[i][j] != 0) {
                    viruses.add(new Virus(tube[i][j], 0, i, j));
                }
            }
        }

        s = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
    }


    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
}
