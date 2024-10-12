package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3187_양치기꿍 {

    static int R, C, lambCnt, wolfCnt;
    static char[][] land;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalLamb = 0;
        int totalWolf = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        land = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            land[r] = br.readLine().toCharArray();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                // 울타리면 이동불가
                if (land[r][c] == '#') continue;
                // 방문 체크
                if (visited[r][c]) continue;

                lambCnt = 0;
                wolfCnt = 0;

                dfs(r, c);

                if (lambCnt > wolfCnt) totalLamb += lambCnt;
                else totalWolf += wolfCnt;
            }
        }

        System.out.println(totalLamb + " " + totalWolf);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static private void dfs(int r, int c) {
        if (land[r][c] == 'k') lambCnt++;
        if (land[r][c] == 'v') wolfCnt++;

        visited[r][c] = true;

        for (int d = 0; d < dx.length; d++) {
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (visited[nx][ny]) continue;
            if (land[nx][ny] == '#') continue;
            dfs(nx, ny);
        }

    }
}
