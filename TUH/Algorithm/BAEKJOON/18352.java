import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int node, line, distance, start;

    static ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

    static int[] d;
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();

        d[start] = 0;

        bfs(start);

        boolean check = false;

        for (int i = 0; i < d.length; i++) {
            if (d[i] == distance) {
                System.out.println(i);
                check = true;
            }
        }

        if (check == false) {
            System.out.println(-1);
        }
    }

    static void input(){
        node = scan.nextInt();
        line = scan.nextInt();
        distance = scan.nextInt();
        start = scan.nextInt();

        for(int i = 0; i <= node; i++) {
            g.add(new ArrayList<>());
        }

        d = new int[node + 1];
        Arrays.fill(d, -1);

        for (int i = 0; i < line; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            g.get(a).add(b);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 0; i < g.get(now).size(); i++) {
                int next = g.get(now).get(i);

                if(d[next] == -1) {
                    d[next] = d[now] + 1;
                    queue.offer(next);
                }
            }

        }
    }

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
