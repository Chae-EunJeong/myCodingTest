import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {

    static int N, M;    // 캠퍼스의 크기
    static char[][] campus;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];
        answer = 0;
        int a = 0 , b = 0; // I의 좌표
        for (int n = 0; n < N; n++) {
            char[] temp = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                campus[n][m] = temp[m];
                if (campus[n][m] == 'I') {
                    a = n; b = m;
                    visited[n][m] = true;
                } else if (campus[n][m] == 'X') {
                    visited[n][m] = true;
                }
            }
        }
        bfs(a, b);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {n, m});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (campus[nx][ny] == 'P') {
                    answer++;
                }
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}
