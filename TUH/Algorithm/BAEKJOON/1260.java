import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static boolean[] check;
  static int[][] arr;

  static int node, line, start;

  static Queue<Integer> q = new LinkedList<>();
  
  static FastReader scan = new FastReader();
  //정답은 sb에 append 를 사용하여 출력
  //만약 개행까지 출력하고 싶으면 append('\n')을 추가
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
      input();

      dfs(start);

      bfs(start);
  }

  static void dfs(int start) {
    check[start] = true;

    sb.append(start + " ");

    for (int i = 0; i <= node; i++) {
      if (arr[start][i] == 1 && !check[i]) {
        dfs(i);
      }
    }
  }

  static void bfs(int start) {
    q.add(start);
    check[start] = true;

    while(!q.isEmpty()) {
      start = q.poll();
      sb.append(start + " ");

      for (int i = 1; i <= node; i++) {
        if (arr[start][i] == 1 && !check[i]) {
          q.add(i);
          check[i] = true;
        }
      }
    }
  }
  
  static void input(){
    node = scan.nextInt();
    line = scan.nextInt();
    start = scan.nextInt();

    arr = new int [node + 1][node + 1];
    check = new boolean[node + 1];

    for (int i = 0; i < line; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();

      arr[a][b] = 1;
      arr[b][a] = 1;
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
