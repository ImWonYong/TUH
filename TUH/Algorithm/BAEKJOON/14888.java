import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int[] nums = new int[11];
    static ArrayList<Integer> operator = new ArrayList<>();
    static boolean[] checked;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        int result = 0;
        dfs(1, nums[0]);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    static void dfs(int count, int result) {
        if (count == n) {
            if (MAX < result) {
                MAX = result;
            }

            if (MIN > result) {
                MIN = result;
            }

            return;
        }

        for (int i = 0; i < n - 1; i++) {
            int o = operator.get(i);
            if (checked[i] != true) {
                checked[i] = true;
                int temp = calculate(o, result, nums[count]);
                dfs(count + 1, temp);
                checked[i] = false;
            }
        }
    }

    static int calculate(int o, int n, int m) {
        int result = 0;

        switch (o) {
            case 0:
                result = n + m;
                break;
            case 1:
                result = n - m;
                break;
            case 2:
                result = n * m;
                break;
            case 3:
                result = n / m;
                break;
        }

        return result;
    }
    static void input(){
        n = scan.nextInt();
        checked = new boolean[n - 1];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            int o = scan.nextInt();
            for (int j = 0; j < o; j++) {
                operator.add(i);
            }
        }
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
