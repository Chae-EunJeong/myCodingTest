package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14716_현수막 {
    static int M, N;
    static int[][] banner;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        banner = new int[M][N];
        visited = new boolean[M][N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                banner[m][n] = Integer.parseInt(st.nextToken());
            }
        }
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (visited[m][n]) continue;
                if (banner[m][n] == 0) {
                    visited[m][n] = true;
                    continue;
                }
                dfs(m, n);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (banner[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny);
        }


    }
}
