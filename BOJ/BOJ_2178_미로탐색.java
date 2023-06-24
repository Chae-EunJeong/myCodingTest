package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요구사항 : N X M 크기의 미로가 있을 때, (1,1)에서 (N,M)로 이동할 때 지나야하는 최소 칸 수를 구해라
 *          1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
 * 입력 : 첫째줄 N, M
 *       다음N개줄 M개의 정수 미로
 * 출력 : 지나야하는 최소의 칸 수
 * 제약 : 2 ≤ N, M ≤ 100
 * 종류 : 너비우선탐색 bfs
 */
public class BOJ_2178_미로탐색 {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp[j - 1] - '0';
            }
        }
        bfs();
        System.out.println(answer);
    }
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];

        queue.offer(new int[] {1, 1, 1}); // {x, y, 지나온 칸 수}
        visited[1][1] = true;
        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                // N,M 위치면 stop
                if (current[0] == N && current[1] == M) {
                    answer = Math.min(answer, current[2]);
                }
                // 인접 좌표로 이동
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                queue.offer(new int[] {nx, ny, current[2] + 1});
                visited[nx][ny] = true;

            }
        }

    }
}
