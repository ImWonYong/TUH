import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n;
    static char[][] map = new char[6][6];
    static char[][] temp = new char[6][6];
    static boolean isFind = true;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int students;
    static ArrayList<Teacher> teachers = new ArrayList<>();


    /*
        1. 장애물을 3개 설치해야 함.
        2. 장애물을 설치한 선생님이 넓어짐
        3. 만약 이 때 선생님이 학생을 만나면 No 가 출력된
     */
    public static void main(String[] args) {
        input();

        dfs(0);

        if (isFind == true) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    static void dfs(int count) {
        if (isFind == false) {
            return;
        }

        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < teachers.size(); i++) {
                Teacher t = teachers.get(i);
                findStudent(t.getX(), t.getY());
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(temp[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            isFind = checkMap();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(count + 1);
                    map[i][j] = 'X';
                }

            }
        }
    }

    static boolean checkMap() {
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 'S') {
                    s++;
                }
            }
        }
        if (s == students) {
            return false;
        }

        return true;
    }
    static void findStudent(int x, int y) {
        for(int i = 0; i < 4;  i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];

            while(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (temp[nx][ny] == 'X' || temp[nx][ny] == 'S') {
                    temp[nx][ny] = 'T';
                }
                if (temp[nx][ny] == 'O') {
                    break;
                }
                nx = nx + direction[i][0];
                ny = ny + direction[i][1];
            }
        }
    }

    static void input(){
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = scan.next();
                if (s.equals("T")) {
                    teachers.add(new Teacher(i, j));
                }

                if (s.equals("S")) {
                    students = students + 1;
                }
                map[i][j] = s.charAt(0);
            }
        }
    }

    static class Teacher {
        int x;
        int y;

        Teacher(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
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
